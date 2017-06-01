/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.controladores;

import co.com.origenptah.dao.DetallePedidoFacadeLocal;
import co.com.origenptah.dao.EstadoPedidoFacadeLocal;
import co.com.origenptah.dao.FacturasFacadeLocal;
import co.com.origenptah.dao.PedidosFacadeLocal;
import co.com.origenptah.dao.PersonasFacadeLocal;
import co.com.origenptah.dao.ProductosFacadeLocal;
import co.com.origenptah.entidades.DetallePedido;
import co.com.origenptah.entidades.EstadoPedido;
import co.com.origenptah.entidades.Facturas;
import co.com.origenptah.entidades.Pedidos;
import co.com.origenptah.entidades.Personas;
import co.com.origenptah.entidades.Productos;
import co.com.origenptah.utils.jsfUtils;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author daniel
 */
@ManagedBean
@SessionScoped
public class PedidosControlador implements Serializable {

    /**
     * Creates a new instance of PedidosControlador
     */
    @EJB
    PedidosFacadeLocal pedidosFacadeLocal;
    @EJB
    DetallePedidoFacadeLocal detallePedidoFacadeLocal;
    @EJB
    ProductosFacadeLocal productosFacadeLocal;
    @EJB
    FacturasFacadeLocal facturasFacadeLocal;
    @EJB
    PersonasFacadeLocal personasFacadeLocal;
    @EJB
    EstadoPedidoFacadeLocal estadoPedidoFacadeLocal;

    private Pedidos pedidos;
    private Productos productos;
    private DetallePedido detallePedido;
    private List<DetallePedido> listaDetalle = new ArrayList<>();
    private Facturas facturas;
    private List<Personas> personas;
    private List<EstadoPedido> estadoPedido;
    private int total;

    java.util.Date FecahActual = new java.util.Date();
    java.util.Date FecahActual2 = new java.util.Date();

    
    @PostConstruct
    public void init() {
        pedidos = new Pedidos();
        pedidos.setCodigoPedido(codigoPedidoCons());
        pedidos.setFechaPedido(FecahActual2);
        productos = new Productos();
        detallePedido = new DetallePedido();
        facturas = new Facturas("1112", FecahActual, 1000);
        personas = listarPersonas();
        estadoPedido = listarEstadosPedidos();

    }

    public PedidosControlador() {

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    public List<DetallePedido> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetallePedido> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }

    public List<Personas> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Personas> personas) {
        this.personas = personas;
    }

    public List<Personas> getListPersonas() {
        return personas;
    }

    public void setListPersonas(List<Personas> listPersonas) {
        this.personas = listPersonas;
    }

    public List<EstadoPedido> getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(List<EstadoPedido> estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void agregar() {

        DetallePedido detpedido = new DetallePedido();
        detpedido.setCodigoPedido(pedidos);
        detpedido.setCodigoProducto(productos);
        detpedido.setCantidadProducto(detallePedido.getCantidadProducto());

        total += totalPedido(detpedido);
        this.listaDetalle.add(detpedido);

    }

    public void guardarPedido() {
        HttpSession session = jsfUtils.getSession();
        Pedidos p = new Pedidos();
        p.setCodigoPedido(pedidos.getCodigoPedido());
        p.setVendedorPedido((Personas) session.getAttribute("username"));
        p.setFechaPedido(pedidos.getFechaPedido());
        p.setEstadoPedido(pedidos.getEstadoPedido());
        p.setValorTotalPedido(total);
        pedidosFacadeLocal.create(p);
        facturasFacadeLocal.create(facturas);
        for (DetallePedido depred : listaDetalle) {
            DetallePedido pedidoList = new DetallePedido();
            pedidoList.setCodigoPedido(pedidos);
            pedidoList.setCodigoProducto(depred.getCodigoProducto());
            pedidoList.setCodigoFactura(facturas);
            pedidoList.setCantidadProducto(depred.getCantidadProducto());
            pedidoList.setCantidadDespachada(1);
            detallePedidoFacadeLocal.create(pedidoList);
        }

    }

    public int totalPedido(DetallePedido detalle) {
        int cant = detalle.getCantidadProducto();
        Productos p = detalle.getCodigoProducto();
        return cant * p.getPrecioVenta();
    }

    public List<Productos> completeString(String query) {
        List<Productos> resultado = productosFacadeLocal.findByRef(query);
        return resultado;
    }

    public String codigoPedidoCons() {
        String id = String.valueOf(pedidosFacadeLocal.count() + 1);
        return id;
    }

    private List<Personas> listarPersonas() {
        return personasFacadeLocal.findAll();
    }

    private List<EstadoPedido> listarEstadosPedidos() {
        return estadoPedidoFacadeLocal.findAll();
    }
    
        public void onRowEdit(RowEditEvent event) {
        jsfUtils.addSuccessMessage("Cantidad Modificada Con Exito");
    }
     
    public void onRowCancel(RowEditEvent event) {
        jsfUtils.addSuccessMessage("Cantidad No Modificada");
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
