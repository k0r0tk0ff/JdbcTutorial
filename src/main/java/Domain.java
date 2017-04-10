import Service.AddressService;
import Service.EmplProjService;
import Service.EmployeeService;
import Service.ProjectService;
import bl.Util;
import entity.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 4/8/2017.
 */
public class Domain {

    public static void main(String[] args) throws SQLException {

	    Util util = new Util();
        Connection connection = util.getConnection();

/*	    //test for connect fo db and get
        List<Address> listAsString;
        AddressService addressService = new AddressService();

	    try {
		    listAsString = addressService.getAll();
		    for (Address address : listAsString
		         ) {
			    System.out.println(address.toString());
		    }
	    } catch (SQLException sqlError) {
		    sqlError.printStackTrace();
	    }*/

        AddressService addressService = new AddressService();
        //EmployeeService employeeService = new EmployeeService();
        //EmplProjService emplProjService = new EmplProjService();
        //ProjectService projectService = new ProjectService();

        //Add Address
        Address address = new Address();
        address.setId(3);
        address.setCountry("DC");
        address.setCity("Gotham city");
        address.setStreet("Arkham street 1");
        address.setPostcode("350020");


       try {
            addressService.add(address);
        } catch (SQLException sqlError) {
            sqlError.printStackTrace();
        }


/*	    PreparedStatement preparedStatement = null;

	    String sql = "INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE) VALUES(?, ?, ?, ?, ?);";

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
	    }*/
    }
}
