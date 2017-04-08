package dao;

import entity.Employee;
import entity.Project;

import java.util.List;

/**
 * For CRUD (SQL need)
 */
public interface ProjectDAO {

    //create
    void add(Project project);

    //read
    List<Employee> getAll();

    Project getById(long id);

    //update
    void update(Project project);

    //delete
    void remove(Project project);
}
