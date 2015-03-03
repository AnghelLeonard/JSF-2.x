package jsf.taghandlers;

import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "myConverter")
public class MyConverter implements Converter {

    private static final Logger LOG = Logger.getLogger(MyConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        LOG.info("MyConverter is action (getAsObject) ...");
        return ((String) value).toUpperCase();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        LOG.info("MyConverter is action (getAsString) ...");
        return ((String) value).toLowerCase();
    }

}
