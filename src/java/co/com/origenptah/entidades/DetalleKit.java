/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "detalle_kit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleKit.findAll", query = "SELECT d FROM DetalleKit d")
    , @NamedQuery(name = "DetalleKit.findByReferenciaProductokit", query = "SELECT d FROM DetalleKit d WHERE d.detalleKitPK.referenciaProductokit = :referenciaProductokit")
    , @NamedQuery(name = "DetalleKit.findByReferenciaProducto", query = "SELECT d FROM DetalleKit d WHERE d.detalleKitPK.referenciaProducto = :referenciaProducto")
    , @NamedQuery(name = "DetalleKit.findByCantidadProducto", query = "SELECT d FROM DetalleKit d WHERE d.cantidadProducto = :cantidadProducto")
    , @NamedQuery(name = "DetalleKit.findByValorTotal", query = "SELECT d FROM DetalleKit d WHERE d.valorTotal = :valorTotal")})
public class DetalleKit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleKitPK detalleKitPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD_PRODUCTO")
    private int cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_TOTAL")
    private int valorTotal;
    @JoinColumn(name = "REFERENCIA_PRODUCTO", referencedColumnName = "REFERENCIA_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "REFERENCIA_PRODUCTOKIT", referencedColumnName = "REFERENCIA_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos1;

    public DetalleKit() {
    }

    public DetalleKit(DetalleKitPK detalleKitPK) {
        this.detalleKitPK = detalleKitPK;
    }

    public DetalleKit(DetalleKitPK detalleKitPK, int cantidadProducto, int valorTotal) {
        this.detalleKitPK = detalleKitPK;
        this.cantidadProducto = cantidadProducto;
        this.valorTotal = valorTotal;
    }

    public DetalleKit(String referenciaProductokit, String referenciaProducto) {
        this.detalleKitPK = new DetalleKitPK(referenciaProductokit, referenciaProducto);
    }

    public DetalleKitPK getDetalleKitPK() {
        return detalleKitPK;
    }

    public void setDetalleKitPK(DetalleKitPK detalleKitPK) {
        this.detalleKitPK = detalleKitPK;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Productos getProductos1() {
        return productos1;
    }

    public void setProductos1(Productos productos1) {
        this.productos1 = productos1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleKitPK != null ? detalleKitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleKit)) {
            return false;
        }
        DetalleKit other = (DetalleKit) object;
        if ((this.detalleKitPK == null && other.detalleKitPK != null) || (this.detalleKitPK != null && !this.detalleKitPK.equals(other.detalleKitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.origenptah.entidades.DetalleKit[ detalleKitPK=" + detalleKitPK + " ]";
    }
    
}
