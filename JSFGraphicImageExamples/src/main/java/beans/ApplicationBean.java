package beans;

import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import org.omnifaces.util.Faces;

@Named(value = "app")
@ApplicationScoped
public class ApplicationBean {

    public ApplicationBean() {
    }

    public InputStream getInputStreamImage() {
        return Faces.getResourceAsStream("/resources/imgs/OmniFaces.png");
    }

    public InputStream getSvgInputStreamImage() {
        return Faces.getResourceAsStream("/resources/imgs/OmniFaces.svg");
    }
}
