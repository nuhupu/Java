/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sirac
 */
@Entity
@Table(name = "cd", catalog = "CDShop", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cd.findAll", query = "SELECT c FROM Cd c")
    , @NamedQuery(name = "Cd.findByCdId", query = "SELECT c FROM Cd c WHERE c.cdId = :cdId")
    , @NamedQuery(name = "Cd.findByTitle", query = "SELECT c FROM Cd c WHERE c.title = :title")
    , @NamedQuery(name = "Cd.findByPrice", query = "SELECT c FROM Cd c WHERE c.price = :price")})
public class Cd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cdId", nullable = false, length = 10)
    private String cdId;
    @Size(max = 50)
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "price")
    private Integer price;

    public Cd() {
    }

    public Cd(String cdId, String title, Integer price) {
        this.cdId = cdId;
        this.title = title;
        this.price = price;
    }

    public Cd(String cdId) {
        this.cdId = cdId;
    }

    public String getCdId() {
        return cdId;
    }

    public void setCdId(String cdId) {
        this.cdId = cdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdId != null ? cdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cd)) {
            return false;
        }
        Cd other = (Cd) object;
        if ((this.cdId == null && other.cdId != null) || (this.cdId != null && !this.cdId.equals(other.cdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cd[ cdId=" + cdId + " ]";
    }
    
}
