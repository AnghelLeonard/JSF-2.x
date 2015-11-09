package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CommandScriptBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<String> countries;
   
    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public void lazyLoadCountries(){
        countries = new ArrayList<>();
        countries.add("Estonia");
        countries.add("Bulgaria");        
        countries.add("Romania");        
        countries.add("France");        
        countries.add("Germany");        
    }            
}
