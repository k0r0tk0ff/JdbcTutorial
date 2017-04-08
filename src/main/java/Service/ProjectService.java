package Service;

import bl.Util;
import dao.ProjectDAO;
import entity.Employee;
import entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *     Class for manipulation table "project"
 * Realize relation "table project (DB) <-> Java object"
 * @author Виталий Сердюк
 * @since 4/8/2017.
 */

/**
 "ID" BIGINT NOT NULL,
 "TITLE" VARCHAR(255) NOT NULL,
 -- id must be Primary KEY
 CONSTRAINT "PROJECT_PKEY" PRIMARY KEY ("ID")
 */

public class ProjectService extends Util implements ProjectDAO {

    private Connection connection = getConnection();

    @Override
    public void add(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO project (ID, TITLE) VALUES(?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,project.getId());
            preparedStatement.setString(2,project.getTitle());

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
     * INSERT INTO project (ID, TITLE) VALUES('1', 'EAH');
     */

    @Override
    public List<Project> getAll() throws SQLException {

        List <Project> projectList = new ArrayList<>();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, TITLE FROM project";

        try {
            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("ID"));
                project.setTitle(resultSet.getString("TITLE"));

                projectList.add(project);
            }

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

        return projectList;
    }

    @Override
    public Project getById(long id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, TITLE FROM project WHERE ID = ?";

        Project project = new Project();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            project.setId(resultSet.getLong("ID"));
            project.setTitle(resultSet.getString("TITLE"));

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

        return project;
    }

    @Override
    public void update(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE project SET TITLE=? WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,project.getTitle());
            preparedStatement.setLong(2,project.getId());

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
    public void remove(Project project) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM project WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,project.getId());
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
