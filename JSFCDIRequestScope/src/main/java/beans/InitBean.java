package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
// import javax.faces.bean.ManagedBean;
// import javax.faces.bean.RequestScoped;

//@ManagedBean
//@RequestScoped
@Named
@RequestScoped
public class InitBean {

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
