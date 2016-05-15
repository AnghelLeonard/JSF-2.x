package beans;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class ShoppingCart implements Serializable {

    @Resource(name = "payara/Hazelcast")
    HazelcastInstance hazelcast;

    private static final Logger LOG = Logger.getLogger(ShoppingCart.class.getName());

    // the available items
    private static final List<Item> AVAILABLE_PRODUCTS = new ArrayList<Item>() {
        {
            add(new Item("product_1", 23));
            add(new Item("product_2", 53));
            add(new Item("product_3", 13));
            add(new Item("product_4", 58));
            add(new Item("product_5", 21));
        }
    };

    public void addItemToCart() {
        LOG.info("Adding a product to shopping cart ...");
        IList<Item> cartList = hazelcast.getList("cart");
        cartList.add(AVAILABLE_PRODUCTS.get(new Random().nextInt(5)));
        LOG.info("Product successfully added ...");
        viewCart();
    }

    public void removeItemFromCart(Item item) {
        LOG.info("Removing a product to shopping cart ...");
        IList<Item> cartList = hazelcast.getList("cart");
        cartList.remove(item);        
        LOG.info("Product successfully remove ...");
        viewCart();
    }

    public List<Item> viewCart() {
        List<Item> cart = new ArrayList<>();
        LOG.info("View cart ...");
        
        IList<Item> cartList = hazelcast.getList("cart");
        for (int i = 0; i < cartList.size(); i++) {
            cart.add(cartList.get(i));
        }
        return cart;
    }
}
