package beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Leonard
 */
@FacesValidator
public class BankValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String bankAccount = value.toString();

        UIInput uiInputBankAccount = (UIInput) component.getAttributes().get("confirmBankAccountAttr");
        String bankAccountC = uiInputBankAccount.getSubmittedValue().toString();

        if ((bankAccount != null) && (bankAccountC != null)) {
            if (!bankAccount.equals(bankAccountC)) {
                uiInputBankAccount.setValid(false);
                throw new ValidatorException(new FacesMessage("Bank account must match bank account confirmation!"));
            }
        }
    }
}
