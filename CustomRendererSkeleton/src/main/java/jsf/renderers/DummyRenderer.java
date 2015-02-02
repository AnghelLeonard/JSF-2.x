package jsf.renderers;

import java.io.IOException;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import jsf.components.DummyComponent;

@FacesRenderer(componentFamily = DummyComponent.COMPONENT_FAMILY, rendererType = DummyRenderer.RENDERER_TYPE)
public class DummyRenderer extends Renderer {

    public static final String RENDERER_TYPE = "jsf.renderers.DummyRenderer";
    private static final Logger LOG = Logger.getLogger(DummyRenderer.class.getName());

    public DummyRenderer(){        
    }
    
    @Override
    public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
        return super.getConvertedValue(context, component, submittedValue);
    }

    @Override
    public boolean getRendersChildren() {
        return super.getRendersChildren();
    }

    @Override
    public String convertClientId(FacesContext context, String clientId) {
        return super.convertClientId(context, clientId);
    }    

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        LOG.info("--- Rendering DummyComponent - encodeBegin() method ---");
        super.encodeBegin(context, component);
    }
    
    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        LOG.info("--- Rendering DummyComponent - encodeChildren() method ---");
        super.encodeChildren(context, component); 
    }
    
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        LOG.info("--- Rendering DummyComponent - encodeEnd() method ---");
        super.encodeEnd(context, component);
    }  

    @Override
    public void decode(FacesContext context, UIComponent component) {
        LOG.info("--- Rendering DummyComponent - decode() method ---");
        super.decode(context, component);
    }
}
