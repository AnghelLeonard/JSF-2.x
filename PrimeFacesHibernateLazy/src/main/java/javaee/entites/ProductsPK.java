/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Leonard
 */
@Embeddable
public class ProductsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idproducts")
    private int idproducts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categories_idcategories")
    private int categoriesIdcategories;

    public ProductsPK() {
    }

    public ProductsPK(int idproducts, int categoriesIdcategories) {
        this.idproducts = idproducts;
        this.categoriesIdcategories = categoriesIdcategories;
    }

    public int getIdproducts() {
        return idproducts;
    }

    public void setIdproducts(int idproducts) {
        this.idproducts = idproducts;
    }

    public int getCategoriesIdcategories() {
        return categoriesIdcategories;
    }

    public void setCategoriesIdcategories(int categoriesIdcategories) {
        this.categoriesIdcategories = categoriesIdcategories;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproducts;
        hash += (int) categoriesIdcategories;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsPK)) {
            return false;
        }
        ProductsPK other = (ProductsPK) object;
        if (this.idproducts != other.idproducts) {
            return false;
        }
        if (this.categoriesIdcategories != other.categoriesIdcategories) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaee.entites.ProductsPK[ idproducts=" + idproducts + ", categoriesIdcategories=" + categoriesIdcategories + " ]";
    }
    
}
