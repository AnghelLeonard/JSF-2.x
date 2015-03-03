package jsf.taghandlers;

import java.io.IOException;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

public class DummyTagHandler extends TagHandler {
    
    private static final Logger LOG = Logger.getLogger(DummyTagHandler.class.getName());       

    public DummyTagHandler(TagConfig config) {
        super(config);
    }

    @Override
    public void apply(FaceletContext ctx, UIComponent parent) throws IOException {
        LOG.info("I'm a dummy TagHandler for the <dummy> tag!");
        // your job here       
    }
}
