package beans;

import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "phoneNumberConverter")
public class PhoneNumberConverter implements Converter {
   
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.startsWith("0721")) {
            return "343-" + value;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return (String) value;
    }

}
