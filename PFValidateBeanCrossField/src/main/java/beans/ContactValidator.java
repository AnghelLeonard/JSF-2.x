package beans;

/**
 *
 * @author Anghel Leonard
 */
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.omnifaces.util.Faces;

public class ContactValidator implements ConstraintValidator<ValidContact, String> {

    @Override
    public void initialize(ValidContact constraintAnnotation) {
        // NOOP
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Faces.getContextAttribute("NAME_VALUE") == null) {
            Faces.setContextAttribute("NAME_VALUE", value);
        } else {
            return value.startsWith(String.valueOf(Faces.getContextAttribute("NAME_VALUE")));
        }
        return true;
    }
}
