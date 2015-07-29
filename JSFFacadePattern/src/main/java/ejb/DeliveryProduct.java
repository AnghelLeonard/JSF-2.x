package ejb;

import javax.ejb.Stateless;

@Stateless
public class DeliveryProduct {

    public boolean freeDeliveryPeriodOfTheYear() {
        // some business logic here
        return false;
    }

    public int taxDelivery(int price){
        // some business logic here
        return 103; // for $100 we add $3 delivery costs
    }
}
