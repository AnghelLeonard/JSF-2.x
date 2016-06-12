package javaee.beans;

import java.util.ArrayList;
import java.util.List;
import javaee.entites.Categories;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class DataBean {

    @Inject
    private CategoriesAndProducts cp;

    public List<Categories> getAllCategories() {
        List<Categories> categories = new ArrayList<>();
        categories = cp.getCategoriesAction();
        return categories;
    }
}
