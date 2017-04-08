package Service;

import bl.Util;
import dao.employeeDAO;
import dao.EmployeeDAO;
import entity.employee;
import entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *     Class for manipulation table "Employee"
 * Realize relation "table Employee (DB) <-> Java object"
 * @author Виталий Сердюк
 * @since 4/8/2017.
 */

/*      "ID" BIGINT NOT NULL,
                "employee_ID" BIGINT NOT NULL,
                "FIRST_NAME" VARCHAR(255) NOT NULL,
        "LAST_NAME" VARCHAR(255) NOT NULL,
        "BIRTHDAY" DATE NOT NULL,
                -- ID must be Primary KEY
        CONSTRAINT "EMPLOYEE_PKEY" PRIMARY KEY ("ID"),
                -- employee_ID must be Foreign KEY
        CONSTRAINT "EMPLOYEE_FKEY" FOREIGN KEY ("ID") REFERENCES "employee" ("ID")*/

public class EmployeeService extends Util implements EmployeeDAO {

    private Connection connection = getConnection();

    @Override
    public void add(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, BIRTHDAY) VALUES(?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,employee.getId());
            preparedStatement.setString(2,employee.getFirstName());
            preparedStatement.setString(3,employee.getLastName());
            preparedStatement.setDate(4,employee.getBirthday());

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

    /**
     * Work query
     * INSERT INTO EMPLOYEE (ID, ADDRESS_ID, FIRST_NAME, LAST_NAME, BIRTHDAY) VALUES('1', '1', 'aaa', 'bbb', '2099-12-30');
     */

    @Override
    public List<Employee> getAll() throws SQLException {

        List <Employee> employeeList = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, ADDRESS_ID, FIRST_NAME, LAST_NAME, BIRTHDAY FROM public.employee";

        try {
            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new employee();
                employee.setId(resultSet.getLong("ID"));
                employee.setFirstName(resultSet.getString("FIRST_NAME"));
                employee.setLastName(resultSet.getString("LAST_NAME"));
                employee.setBirthday(resultSet.getDate("BIRTHDAY"));

                employeeList.add(employee);
            }

        } catch (SQLException sqlError2) {
            sqlError2.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null ) {
                connection.close();
            }
        }

        return employeeList;
    }

    @Override
    public Employee getById(long id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM  employee WHERE ID = ?";

        Employee employee = new employee();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            employee.setId(resultSet.getLong("ID"));
            employee.setCountry(resultSet.getString("COUNTRY"));
            employee.setCity(resultSet.getString("CITY"));
            employee.setStreet(resultSet.getString("STREET"));
            employee.setPostcode(resultSet.getString("POST_CODE"));

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

        return employee;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void remove(Employee employee) {

    }

    @Override
    public void update(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE employee SET COUNTRY=?, CITY=?, STREET=?, POST_CODE=? WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,employee.getCountry());
            preparedStatement.setString(2,employee.getCity());
            preparedStatement.setString(3,employee.getStreet());
            preparedStatement.setString(4,employee.getPostcode());
            preparedStatement.setLong(5,employee.getId());

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
    public void remove(Employee employee) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM employee WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,employee.getId());

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
}
