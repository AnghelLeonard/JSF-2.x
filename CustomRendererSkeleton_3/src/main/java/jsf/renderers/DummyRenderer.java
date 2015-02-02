package jsf.renderers;

import com.sun.faces.renderkit.html_basic.TextRenderer;
import java.io.IOException;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public class DummyRenderer extends TextRenderer {

     private static final Logger LOG = Logger.getLogger(DummyRenderer.class.getName());
     public static final String RENDERER_TYPE = "jsf.renderers.DummyRenderer";

    public DummyRenderer(){            
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        LOG.info("--- Rendering DummyComponent - encodeChildren() method ---");
        super.encodeChildren(context, component); // calls the TextRenderer#encodeChildren()
    }

    @Override
    public boolean getRendersChildren() {
        LOG.info("--- Rendering DummyComponent - getRendersChildren() method ---");
        return super.getRendersChildren(); // calls the TextRenderer#getRendersChildren()
    }

    @Override
    protected void getEndTextToRender(FacesContext context, UIComponent component, String currentValue) throws IOException {
        LOG.info("--- Rendering DummyComponent - getEndTextToRender() method ---");
        super.getEndTextToRender(context, component, currentValue); // calls the TextRenderer#getEndTextToRender()
    }

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        LOG.info("--- Rendering DummyComponent - encodeBegin() method ---");
        super.encodeBegin(context, component); // calls the TextRenderer#encodeBegin()
    }        
}
