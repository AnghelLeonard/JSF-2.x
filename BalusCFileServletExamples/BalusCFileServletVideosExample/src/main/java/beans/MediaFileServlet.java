package beans;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.servlet.FileServlet;

/**
 *
 * @author Anghel Leonard
 */
@WebServlet("/media/*")
public class MediaFileServlet extends FileServlet {
    
    private static final Logger LOG = Logger.getLogger(MediaFileServlet.class.getName());
      
    private File folder;

    @Override
    public void init() throws ServletException {
        LOG.info("MediaFileServlet#init() ...");
                
        folder = new File("D:\\media\\");
    }

    @Override
    protected boolean isAttachment(HttpServletRequest request, String contentType) {
        
        LOG.log(Level.INFO, "MediaFileServlet#isAttachment() ...");           
        
        return false;
    }
       
    @Override
    protected File getFile(HttpServletRequest request) throws IllegalArgumentException {
        
        String pathInfo = request.getPathInfo();
        
        LOG.log(Level.INFO, "MediaFileServlet#getFile() ...{0}", pathInfo);               

        if (pathInfo == null || pathInfo.isEmpty() || "/".equals(pathInfo)) {
            throw new IllegalArgumentException();
        }
        return new File(folder, pathInfo);
    }

}
