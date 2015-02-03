package jsf.renderers;

import java.io.IOException;
import java.util.logging.Logger;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import javax.faces.render.RendererWrapper;

@ResourceDependencies({
    @ResourceDependency(name = "css/styles.css", library = "default", target = "head")
})
@FacesRenderer(componentFamily = "javax.faces.all.Input", rendererType = DummyRenderer.RENDERER_TYPE)
public class DummyRenderer extends RendererWrapper {

    private static final Logger LOG = Logger.getLogger(DummyRenderer.class.getName());
    public static final String RENDERER_TYPE = "javax.faces.all";
    private Renderer renderer;

    public DummyRenderer() {
    }

    public DummyRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public boolean getRendersChildren() {
        LOG.info("--- Rendering DummyComponent - getRendersChildren() method ---");
        return getWrapped().getRendersChildren(); // calls the wrapped#getRendersChildren()
    }

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        LOG.info("--- Rendering DummyComponent - encodeBegin() method ---");
        getWrapped().encodeBegin(context, component); // calls the wrapped#encodeBegin()         
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        LOG.info("--- Rendering DummyComponent - encodeChildren() method ---");
        getWrapped().encodeChildren(context, component); // calls the wrapped#encodeChildren()
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        LOG.info("--- Rendering DummyComponent - encodeEnd() method [adding the common CSS style] ---");
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.writeAttribute("class", "inputs", "class");
        getWrapped().encodeEnd(context, component); // calls the wrapped#encodeChildren()
    }

    @Override
    public Renderer getWrapped() {
        return renderer;
    }
}
