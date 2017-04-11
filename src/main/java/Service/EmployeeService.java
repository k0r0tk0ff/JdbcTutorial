package Service;

import bl.Util;

import dao.EmployeeDAO;
import entity.Employee;

import java.sql.*;
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

        String sql = "INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID) VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,employee.getId());
            preparedStatement.setString(2,employee.getFirstName());
            preparedStatement.setString(3,employee.getLastName());
            preparedStatement.setDate(4,employee.getBirthday());
            preparedStatement.setLong(5,employee.getAddressId());

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

        Statement statement = null;

        String sql = "SELECT ID, ADDRESS_ID, FIRST_NAME, LAST_NAME, BIRTHDAY FROM public.employee";

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("ID"));
                employee.setFirstName(resultSet.getString("FIRST_NAME"));
                employee.setLastName(resultSet.getString("LAST_NAME"));
                employee.setBirthday(resultSet.getDate("BIRTHDAY"));

                employeeList.add(employee);
            }

        } catch (SQLException sqlError2) {
            sqlError2.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
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

        String sql = "SELECT ID, ADDRESS_ID, FIRST_NAME, LAST_NAME, BIRTHDAY FROM public.employee WHERE ID = ?";

        Employee employee = new Employee();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            employee.setId(resultSet.getLong("ID"));
            employee.setAddressId(resultSet.getLong("ADDRESS_ID"));
            employee.setFirstName(resultSet.getString("FIRST_NAME"));
            employee.setLastName(resultSet.getString("LAST_NAME"));
            employee.setBirthday(resultSet.getDate("BIRTHDAY"));

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
    public void update(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        // UPDATE employee SET ADDRESS_ID=1, FIRST_NAME='asdf', LAST_NAME='qwerty', BIRTHDAY='2012-12-12' WHERE ID = 1;
        String sql = "UPDATE employee SET ADDRESS_ID=?, FIRST_NAME=?, LAST_NAME=?, BIRTHDAY=? WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,employee.getAddressId());
            preparedStatement.setString(2,employee.getFirstName());
            preparedStatement.setString(3,employee.getLastName());
            preparedStatement.setDate(4,employee.getBirthday());
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

        String sql = "DELETE FROM EMPLOYEE WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
