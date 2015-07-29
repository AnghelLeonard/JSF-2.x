package beans;

import ejb.FacadeProduct;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ProductBean implements Serializable {

    private int price;

    @Inject
    FacadeProduct facadeProduct;

    public int getPrice() {
        return price;
    }

    public void orderProductAction(String product) {
        price = facadeProduct.orderProduct(product);
    }

}
