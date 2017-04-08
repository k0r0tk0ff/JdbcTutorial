package dao;

import entity.EmplProj;
import entity.Employee;
import entity.Project;

import java.util.List;

/**
 * For CRUD (SQL need)
 */
public interface EmplProjDAO {

    //create
    void add(EmplProj emplProj);

    //read
    List<EmplProj> getAll();

    Project getByEmployeeIdAndProjectId(long employeeId, long projectId);

    //update
    void update(EmplProj emplProj);

    //delete
    void remove(EmplProj emplProj);
}
