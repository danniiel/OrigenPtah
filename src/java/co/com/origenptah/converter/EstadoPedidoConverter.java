/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.converter;

import co.com.origenptah.dao.EstadoPedidoFacadeLocal;
import co.com.origenptah.entidades.EstadoPedido;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author danie
 */
@Named(value = "estadoPedidoConverter")
@RequestScoped
public class EstadoPedidoConverter implements Converter {

    /**
     * Creates a new instance of EstadoPedidoConverter
     */
    public EstadoPedidoConverter() {
    }
    @EJB
    EstadoPedidoFacadeLocal estadoPedidoFacadeLocal;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return estadoPedidoFacadeLocal.find(Integer.valueOf(value));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s no es un valor valido", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof EstadoPedido) {
            return String.valueOf(((EstadoPedido) value).getIdEstadoPedido());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s no es una persona valida", value)));
        }
    }

}
