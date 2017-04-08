package Service;

import bl.Util;
import dao.AddressDAO;
import entity.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 4/8/2017.
 */
public class AddressService extends Util implements AddressDAO {

    Connection connection = getConnection();

    @Override
    public void add(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE) VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,address.getId());
            preparedStatement.setString(2,address.getCountry());
            preparedStatement.setString(3,address.getCity());
            preparedStatement.setString(4,address.getStreet());
            preparedStatement.setString(5,address.getPostcode());

            preparedStatement.executeUpdate();

        } catch (SQLException sqlError) {
            sqlError.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null ) {
                connection.close();
            }
        }

    }

    @Override
    public List<Address> getAll() {

        List <Address> addressList = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM ADDRESS";

        try {
            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
            Address address = new Address();
            address.setId(resultSet.getLong("ID"));


            addressList.add(address)

        } catch (SQLException sqlError) {
            sqlError.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null ) {
                connection.close();
            }
        }

        return null;
    }

    @Override
    public Address getById(long id) {
        return null;
    }

    @Override
    public void update(Address address) {

    }

    @Override
    public void remove(Address address) {

    }
}
