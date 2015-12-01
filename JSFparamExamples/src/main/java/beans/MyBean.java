package beans;

import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class MyBean {

    private Article article;

    public MyBean() {
        this.article = new Article("http://blog.primefaces.org/", 3639);
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void saveAndParam() {
        System.out.println("Saving data [saveAndParam()] ...");
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();

        String code = params.get("countryCode");
        String webURL = params.get("homepage");

        System.out.println("Country code: " + code + " ; web url: " + webURL);
    }

}
