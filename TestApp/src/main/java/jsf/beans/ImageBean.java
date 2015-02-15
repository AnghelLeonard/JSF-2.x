package jsf.beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.ManagedBean;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Utils;

@ManagedBean
@ApplicationScoped
public class ImageBean {   

    public byte[] imageAsByteArrayFromResource() {
        try {                 
            return Utils.toByteArray(Faces.getResourceAsStream("/resources/default/pngs/rustymetal.png"));
        } catch (IOException ex) {
            Logger.getLogger(ImageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
