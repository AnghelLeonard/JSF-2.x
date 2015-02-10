package pf.layout;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PageBean {

    private String page = "/WEB-INF/pages/pageA.xhtml";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void changePageAction(String page) {               
        this.page = page;
    }

}
