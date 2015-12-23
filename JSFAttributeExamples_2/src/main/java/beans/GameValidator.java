package beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Leonard
 */
@FacesValidator
public class GameValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String player = value.toString().replaceAll("\\s+", "");
        throw new ValidatorException(new FacesMessage("Response:" + (String) component.getAttributes().get("msgAttr" + player)));
    }
}
