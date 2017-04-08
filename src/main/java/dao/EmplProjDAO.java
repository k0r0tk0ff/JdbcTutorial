package dao;

import entity.EmplProj;
import entity.Employee;
import entity.Project;

import java.sql.SQLException;
import java.util.List;

/**
 * For CRUD (SQL need)
 */
public interface EmplProjDAO {

    //create
    void add(EmplProj emplProj) throws SQLException;

    //read
    List<EmplProj> getAll() throws SQLException;

    Project getByEmployeeIdAndProjectId(long employeeId, long projectId) throws SQLException;

    //update
    void update(EmplProj emplProj) throws SQLException;

    //delete
    void remove(EmplProj emplProj) throws SQLException;
}
