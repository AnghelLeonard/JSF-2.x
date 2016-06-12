/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonard
 */
@Entity
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByIdproducts", query = "SELECT p FROM Products p WHERE p.productsPK.idproducts = :idproducts"),
    @NamedQuery(name = "Products.findByProduct", query = "SELECT p FROM Products p WHERE p.product = :product"),
    @NamedQuery(name = "Products.findByCategoriesIdcategories", query = "SELECT p FROM Products p WHERE p.productsPK.categoriesIdcategories = :categoriesIdcategories")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductsPK productsPK;
    @Size(max = 200)
    @Column(name = "product")
    private String product;
    @JoinColumn(name = "categories_idcategories", referencedColumnName = "idcategories", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categories categories;

    public Products() {
    }

    public Products(ProductsPK productsPK) {
        this.productsPK = productsPK;
    }

    public Products(int idproducts, int categoriesIdcategories) {
        this.productsPK = new ProductsPK(idproducts, categoriesIdcategories);
    }

    public ProductsPK getProductsPK() {
        return productsPK;
    }

    public void setProductsPK(ProductsPK productsPK) {
        this.productsPK = productsPK;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productsPK != null ? productsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productsPK == null && other.productsPK != null) || (this.productsPK != null && !this.productsPK.equals(other.productsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaee.entites.Products[ productsPK=" + productsPK + " ]";
    }
    
}
