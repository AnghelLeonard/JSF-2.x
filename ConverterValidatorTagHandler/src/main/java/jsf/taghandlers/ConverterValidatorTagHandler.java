package jsf.taghandlers;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

public class ConverterValidatorTagHandler extends TagHandler {

    public ConverterValidatorTagHandler(TagConfig config) {
        super(config);
    }

    @Override
    public void apply(FaceletContext ctx, UIComponent parent) throws IOException {
        if (parent instanceof HtmlInputText) {
            HtmlInputText inputText = (HtmlInputText) parent;

            inputText.addValidator(new MyValidator());
            inputText.setConverter(new MyConverter());            
        }
    }
}
