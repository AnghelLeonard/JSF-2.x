package beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="myConverter")
public class MyConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return ((String)value).toUpperCase();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((String)value).toLowerCase();
    }      
}
