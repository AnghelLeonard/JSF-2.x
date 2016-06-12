/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonard
 */
@Entity
@Table(name = "categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c"),
    @NamedQuery(name = "Categories.findByIdcategories", query = "SELECT c FROM Categories c WHERE c.idcategories = :idcategories"),
    @NamedQuery(name = "Categories.findByName", query = "SELECT c FROM Categories c WHERE c.name = :name")})
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcategories")
    private Integer idcategories;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<Products> productsCollection;

    public Categories() {
    }

    public Categories(Integer idcategories) {
        this.idcategories = idcategories;
    }

    public Integer getIdcategories() {
        return idcategories;
    }

    public void setIdcategories(Integer idcategories) {
        this.idcategories = idcategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Set<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategories != null ? idcategories.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categories)) {
            return false;
        }
        Categories other = (Categories) object;
        if ((this.idcategories == null && other.idcategories != null) || (this.idcategories != null && !this.idcategories.equals(other.idcategories))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaee.entites.Categories[ idcategories=" + idcategories + " ]";
    }
    
}
