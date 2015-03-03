package jsf.taghandlers;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagAttribute;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

public class TextRepeatTagHandler extends TagHandler {

    protected final TagAttribute text;
    protected final TagAttribute repeat;
    protected final TagAttribute uppercase;

    public TextRepeatTagHandler(TagConfig config) {
        super(config);
        this.text = this.getRequiredAttribute("text");
        this.repeat = this.getRequiredAttribute("repeat");
        this.uppercase = this.getAttribute("uppercase");
    }

    @Override
    public void apply(FaceletContext ctx, UIComponent parent) throws IOException {
        String s = "";
        UIOutput child = new HtmlOutputText();
        for (int i = 0; i < Integer.valueOf(repeat.getValue()); i++) {
            s = s + text.getValue() + " ";
        }

        if (uppercase != null) {
            if (uppercase.getValue().equals("yes")) {
                s = s.toUpperCase();
            } else {
                s = s.toLowerCase();
            }
        }

        child.setValue(s);
        parent.getChildren().add(child);
    }
}
