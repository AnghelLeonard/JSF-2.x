package jsf.taghandlers;

import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "myValidator")
public class MyValidator implements Validator {
    
    private static final Logger LOG = Logger.getLogger(MyValidator.class.getName());        

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        LOG.info("MyValidator is action ...");
        // nothing here
    }

}
