package ejb;

import javax.ejb.Stateless;

@Stateless
public class InventoryProduct {

    public boolean productIsAvailable(String product) {
        // some business logic here
        return true;
    }

    public int productCost(String product) {
        // some business logic here
        return 120; // initial product cost is $120
    }
}
