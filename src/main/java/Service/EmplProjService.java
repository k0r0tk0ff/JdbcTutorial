package Service;

import bl.Util;
import dao.EmplProjDAO;
import dao.EmployeeDAO;
import entity.Address;
import entity.EmplProj;
import entity.Employee;
import entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *     Class for manipulation table "EmplProj"
 * Realize relation "table EmplProj (DB) <-> Java object"
 * @author Виталий Сердюк
 * @since 4/8/2017.
 */



public class EmplProjService extends Util implements EmplProjDAO {

    private Connection connection = getConnection();

    //Add Address
    Address address = new Address();


    @Override
    public void add(EmplProj emplProj) throws SQLException {

    }

    @Override
    public List<EmplProj> getAll() throws SQLException {
        return null;
    }

    @Override
    public Project getByEmployeeIdAndProjectId(long employeeId, long projectId) throws SQLException {
        return null;
    }

    @Override
    public void update(EmplProj emplProj) throws SQLException {

    }

    @Override
    public void remove(EmplProj emplProj) throws SQLException {

    }
}
