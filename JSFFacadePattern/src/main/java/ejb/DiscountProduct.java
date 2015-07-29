package ejb;

import javax.ejb.Stateless;

@Stateless
public class DiscountProduct {

    public boolean discountPeriodOfTheYear(){
        // some business logic here
        return true;
    }

    public int applyDiscount(String product){
         // some business logic here
        return 100; // after the discount the product price is $100
    }
}
