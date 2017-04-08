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

    /*
    CREATE TABLE "EMPL_PROJ"
    (
    "EMPLOYEE_ID" BIGINT NOT NULL,
    "PROJECT_ID" BIGINT NOT NULL,
            -- ID must be Primary KEY
    CONSTRAINT "EMPL_PROJ_EMPLOYEE_ID_FKEY" FOREIGN KEY ("EMPLOYEE_ID")
    REFERENCES public."EMPLOYEE" ("ID"),
            -- PROJECT_ID must be Foreign KEY
    CONSTRAINT "EMPL_PROJ_PROJ_ID_FKEY" FOREIGN KEY ("PROJECT_ID")
    REFERENCES "PROJECT" ("ID")
    )
    */

    private Connection connection = getConnection();

    @Override
    public void add(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO EMPL_PROJ (EMPLOYEE_ID, PROJECT_ID) VALUES(?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,emplProj.getEmlployeeId());
            preparedStatement.setLong(2,emplProj.getProjectId());

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
    public List<EmplProj> getAll() throws SQLException {
        List<EmplProj> emplProjList = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ";

        try {
            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmlployeeId(resultSet.getLong("EMPLOYEE_ID"));
                emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

                emplProjList.add(emplProj);
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

        return emplProjList;
    }

    @Override
    public EmplProj getByEmployeeIdAndProjectId(long employeeId, long projectId) throws SQLException {
        PreparedStatement preparedStatement = null;
        EmplProj emplProj = new EmplProj();

        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ WHERE EMPLOYEE_ID=? and PROJECT_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(2, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            emplProj.setEmlployeeId(resultSet.getLong("EMPLOYEE_ID"));
            emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

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

        return emplProj;
    }

    @Override
    public void update(EmplProj emplProj) throws SQLException {

    }

    @Override
    public void remove(EmplProj emplProj) throws SQLException {

    }
}
