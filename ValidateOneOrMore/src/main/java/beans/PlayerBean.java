package beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Anghel Leonard
 */
@Named
@RequestScoped
public class PlayerBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer serve;
    private Integer forehand;
    private Integer backhand;

    public Integer getServe() {
        return serve;
    }

    public void setServe(Integer serve) {
        this.serve = serve;
    }

    public Integer getForehand() {
        return forehand;
    }

    public void setForehand(Integer forehand) {
        this.forehand = forehand;
    }

    public Integer getBackhand() {
        return backhand;
    }

    public void setBackhand(Integer backhand) {
        this.backhand = backhand;
    }        
}
