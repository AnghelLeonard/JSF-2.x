package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class FreeLinksBean {

    private String link;
    private List<String> freeLinks = new ArrayList<>();

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }    
    
    public List<String> getFreeLinks() {
        return freeLinks;
    }

    public void setFreeLinks(List<String> freeLinks) {
        this.freeLinks = freeLinks;
    }   

    public void addFreeLink() {
        if (!freeLinks.contains(link)) {
            freeLinks.add(link);
        }
    }

    public void removeFreeLink(String link) {
        if (freeLinks.contains(link)) {
            freeLinks.remove(link);
        }
    }
}
