import Service.AddressService;
import Service.EmplProjService;
import Service.EmployeeService;
import Service.ProjectService;

import entity.Address;
import entity.EmplProj;
import entity.Employee;
import entity.Project;

import java.sql.SQLException;
import java.util.Calendar;


/**
 * Created by user on 4/8/2017.
 */
public class Domain {

    public static void main(String[] args) throws SQLException {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        EmplProjService emplProjService = new EmplProjService();
        ProjectService projectService = new ProjectService();

        //Add Address
        Address address = new Address();
        address.setId(1);
        address.setCountry("DC");
        address.setCity("Gotham city");
        address.setStreet("Arkham street 1");
        address.setPostcode("350020");

	    //Add Employee
	    Employee employee = new Employee();
	    employee.setId(1);
	    employee.setFirstName("James");
	    employee.setLastName("Gordon");
	    employee.setAddressId(address.getId());
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(1939, Calendar.MAY, 1);
	    employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));

	    //Add Project
	    Project project = new Project();
	    project.setId(1);
	    project.setTitle("TITLE TITLE TITLE");

	    //Add EmplProj
	    EmplProj emplProj = new EmplProj();
	    emplProj.setEmlployeeId(employee.getId());
	    emplProj.setProjectId(project.getId());

	    //Insert in to DB
        try {
           addressService.add(address);
	       employeeService.add(employee);
	       projectService.add(project);
	       emplProjService.add(emplProj);
        } catch (SQLException sqlError) {
            sqlError.printStackTrace();
        }
    }
}
