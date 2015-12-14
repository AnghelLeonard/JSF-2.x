package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Leonard
 */
@ManagedBean
@CustomScoped("#{CUSTOM_SCOPE}")
public class SponsoredLinksBean {

    private String link;
    private List<String> sponsoredLinks = new ArrayList<>();

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getSponsoredLinks() {
        return sponsoredLinks;
    }

    public void setSponsoredLinks(List<String> sponsoredLinks) {
        this.sponsoredLinks = sponsoredLinks;
    }
    
     public void addSponsoredLink() {
        if (!sponsoredLinks.contains(link)) {
            sponsoredLinks.add(link);
        }
    }

    public void removeSponsoredLink(String link) {
        if (sponsoredLinks.contains(link)) {
            sponsoredLinks.remove(link);
        }
    }
}
