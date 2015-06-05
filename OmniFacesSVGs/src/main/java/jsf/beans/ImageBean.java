package jsf.beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;

import javax.faces.bean.ManagedBean;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Utils;

@ManagedBean
@ApplicationScoped
public class ImageBean {

    private final String IMAGE = "http://localhost:8080/OmniFacesSVGs/ByteServlet";

    public byte[] imageAsByteArrayFromServlet() {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(IMAGE);
            try (CloseableHttpResponse response = httpclient.execute(httpget)) {
                return Utils.toByteArray(response.getEntity().getContent());
            }
        } catch (IOException ex) {
            Logger.getLogger(ImageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public byte[] imageAsByteArrayFromResource() {
        try {            
            return Utils.toByteArray(Faces.getResourceAsStream("/resources/default/svgs/sample.svg"));
        } catch (IOException ex) {
            Logger.getLogger(ImageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
