package jsf.renderkitfactories;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitFactory;
import jsf.renderkits.DummyRenderKit;

public class DummyRenderKitFactory extends RenderKitFactory {

    private static final Logger LOG = Logger.getLogger(DummyRenderKitFactory.class.getName());
    private RenderKitFactory renderKitFactory;

    public DummyRenderKitFactory() {
    }

    public DummyRenderKitFactory(RenderKitFactory renderKitFactory) {
        this.renderKitFactory = renderKitFactory;
    }

    @Override
    public void addRenderKit(String renderKitId, RenderKit renderKit) {
        LOG.log(Level.INFO, "Register RenderKit with ID: {0}", renderKitId);
        getWrapped().addRenderKit(renderKitId, renderKit);
    }

    @Override
    public RenderKit getRenderKit(FacesContext context, String renderKitId) {
        LOG.log(Level.INFO, "Delegate DummyRenderKit instead of RenderKit with ID: {0}", renderKitId);
        RenderKit renderKit = getWrapped().getRenderKit(context, renderKitId);
        return (HTML_BASIC_RENDER_KIT.equals(renderKitId)) ? new DummyRenderKit(renderKit) : renderKit;
    }

    @Override
    public Iterator<String> getRenderKitIds() {
        return getWrapped().getRenderKitIds();
    }

    @Override
    public RenderKitFactory getWrapped() {
        return renderKitFactory;
    }

}
