package beans;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
// import javax.faces.bean.ManagedBean;
// import javax.faces.bean.ApplicationScoped;

//@ManagedBean
//@ApplicationScoped
@Named
@ApplicationScoped
public class InitBean implements Serializable {

    private int init;

    public InitBean() {
        init = 5;
    }

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }

}
