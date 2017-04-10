import Service.AddressService;
import Service.EmplProjService;
import Service.EmployeeService;
import Service.ProjectService;
import bl.Util;
import entity.Address;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 4/8/2017.
 */
public class Domain {

    public static void main(String[] args) {

	    //Util util = new Util();
        //util.getConnection();

/*        List<Address> listAsString;
        AddressService addressService = new AddressService();

	    try {
		    listAsString = addressService.getAll();
		    for (Address address : listAsString
		         ) {
			    System.out.println(address.toString());
		    }
	    } catch (SQLException sqlError) {
		    sqlError.printStackTrace();
	    }*/




        AddressService addressService = new AddressService();
        //EmployeeService employeeService = new EmployeeService();
        //EmplProjService emplProjService = new EmplProjService();
        //ProjectService projectService = new ProjectService();

        //Add Address
        Address address = new Address();
        address.setId(1);
        address.setCountry("DC");
        address.setCity("Gotham city");
        address.setStreet("Arkham street 1");
        address.setPostcode("350020");


        try {
            addressService.add(address);
        } catch (SQLException sqlError) {
            sqlError.printStackTrace();
        }
    }
}
