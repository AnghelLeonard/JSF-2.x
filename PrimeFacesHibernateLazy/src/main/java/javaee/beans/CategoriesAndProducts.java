package javaee.beans;

import java.util.List;
import javaee.entites.Categories;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

/**
 *
 * @author Anghel Leonard
 */
@Stateful
public class CategoriesAndProducts {

    @PersistenceContext(unitName = "javaee_PrimeFacesHibernateLazy_war_1.0PU", type=PersistenceContextType.EXTENDED)
    private EntityManager em;

    public List<Categories> getCategoriesAction() {
        TypedQuery<Categories> query = em.createNamedQuery("Categories.findAll", Categories.class);
        List<Categories> results = query.getResultList();

        return results;
    }

}
