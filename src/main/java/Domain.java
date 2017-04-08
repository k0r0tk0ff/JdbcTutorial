import bl.Util;
import entity.Address;

/**
 * Created by user on 4/8/2017.
 */
public class Domain {

    public static void main(String[] args) {
        Util util = new Util();
        util.getConnection();

        //Add Address
        Address address = new Address();
        address.setId(1);

    }
}
