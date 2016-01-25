package beans;

import java.util.HashMap;
import java.util.Map;
import javax.validation.metadata.ConstraintDescriptor;
import org.primefaces.validate.bean.ClientValidationConstraint;

/**
 *
 * @author Leonard
 */
public class ValidContactClientConstraint implements ClientValidationConstraint {

    public static final String MESSAGE_METADATA = "data-p-contact-msg";

    public Map<String, Object> getMetadata(ConstraintDescriptor constraintDescriptor) {
        Map<String, Object> metadata = new HashMap<String, Object>();
        Map attrs = constraintDescriptor.getAttributes();
        Object message = attrs.get("message");
        if (message != null) {
            metadata.put(MESSAGE_METADATA, message);
        }

        return metadata;
    }

    public String getValidatorId() {
        return ValidContact.class.getSimpleName();
    }

}
