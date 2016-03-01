package beans;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.omnifaces.validator.MultiFieldValidator;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Anghel Leonard
 */
@Named
@ApplicationScoped
public class ValidatePlayers implements MultiFieldValidator {

    @Override
    public boolean validateValues(FacesContext fc, List<UIInput> components, List<Object> values) {

        List<Player> fromModel;
        
        if (values.get(0) instanceof DualListModel) {
            fromModel = ((DualListModel) values.get(0)).getTarget();
            return fromModel.containsAll((List) values.get(1));
        } else {
            fromModel = ((DualListModel) values.get(1)).getTarget();
            return fromModel.containsAll((List) values.get(0));
        }
    }

}
