/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author danie
 */
@FacesValidator("primeDateRangeValidator")
public class PrimeDateRangeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }

        Date fecha = new Date();
//        String formato2 = "yyyy";
//        SimpleDateFormat format2 = new SimpleDateFormat(formato2);
//        int anio2 = Integer.parseInt(format2.format(fecha));
//
        Date fechaNac = (Date) value;
//        String formato = "yyyy";
//        SimpleDateFormat format = new SimpleDateFormat(formato);
//        int anio1 = Integer.parseInt(format.format(fechaNac));

        int anio2 = obtenerAnio(fecha);
        int anio1 = obtenerAnio(fechaNac);

        int dif = (anio2 - anio1);

        if (dif < 18) {
            FacesMessage message = new FacesMessage("El usuario debe ser mayor a 18 años");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

    }

    public int obtenerAnio(Date date) {

        if (null == date) {

            return 0;

        } else {

            String formato = "yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return Integer.parseInt(dateFormat.format(date));

        }

    }

}
