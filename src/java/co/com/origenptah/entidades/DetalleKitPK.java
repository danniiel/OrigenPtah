/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author danie
 */
@Embeddable
public class DetalleKitPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "REFERENCIA_PRODUCTOKIT")
    private String referenciaProductokit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "REFERENCIA_PRODUCTO")
    private String referenciaProducto;

    public DetalleKitPK() {
    }

    public DetalleKitPK(String referenciaProductokit, String referenciaProducto) {
        this.referenciaProductokit = referenciaProductokit;
        this.referenciaProducto = referenciaProducto;
    }

    public String getReferenciaProductokit() {
        return referenciaProductokit;
    }

    public void setReferenciaProductokit(String referenciaProductokit) {
        this.referenciaProductokit = referenciaProductokit;
    }

    public String getReferenciaProducto() {
        return referenciaProducto;
    }

    public void setReferenciaProducto(String referenciaProducto) {
        this.referenciaProducto = referenciaProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referenciaProductokit != null ? referenciaProductokit.hashCode() : 0);
        hash += (referenciaProducto != null ? referenciaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleKitPK)) {
            return false;
        }
        DetalleKitPK other = (DetalleKitPK) object;
        if ((this.referenciaProductokit == null && other.referenciaProductokit != null) || (this.referenciaProductokit != null && !this.referenciaProductokit.equals(other.referenciaProductokit))) {
            return false;
        }
        if ((this.referenciaProducto == null && other.referenciaProducto != null) || (this.referenciaProducto != null && !this.referenciaProducto.equals(other.referenciaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenptah.entidades.DetalleKitPK[ referenciaProductokit=" + referenciaProductokit + ", referenciaProducto=" + referenciaProducto + " ]";
    }
    
}
