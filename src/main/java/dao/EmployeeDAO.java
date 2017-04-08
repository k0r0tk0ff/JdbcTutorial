package dao;

import entity.Address;
import entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * For CRUD (SQL need)
 */
public interface EmployeeDAO {

    //create
    void add(Employee employee) throws SQLException;

    //read
    List<Employee> getAll() throws SQLException;

    Employee getById(long id) throws SQLException;

    //update
    void update(Employee employee) throws SQLException;

    //delete
    void remove(Employee employee) throws SQLException;
}
