package ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FacadeProduct {

    @Inject
    private InventoryProduct inventoryProduct;

    @Inject
    private DeliveryProduct deliveryProduct;

    @Inject
    private DiscountProduct discountProduct;

    public int orderProduct(String product) {
        if (inventoryProduct.productIsAvailable(product)) {
            int price = inventoryProduct.productCost(product);
            int discount_price = discountProduct.discountPeriodOfTheYear() ? discountProduct.applyDiscount(product) : price;
            int final_price = deliveryProduct.freeDeliveryPeriodOfTheYear() ? discount_price : deliveryProduct.taxDelivery(discount_price);

            return final_price;
        }
        return -1;
    }
}
