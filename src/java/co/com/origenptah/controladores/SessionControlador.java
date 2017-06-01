/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.origenptah.controladores;

import co.com.origenptah.dao.PersonasFacadeLocal;
import co.com.origenptah.entidades.PermisosRol;
import co.com.origenptah.entidades.Personas;
import co.com.origenptah.utils.jsfUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danie
 */
@Named(value = "sessionControlador")
@ManagedBean
@RequestScoped
public class SessionControlador implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @EJB
   private PersonasFacadeLocal personasFacadeLocal;
   
   private Personas persona;
   List<String>menu;
    
   @PostConstruct
   public void init(){
       persona = new Personas();
   }

    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }
   
    public String inicioSession(){
        
        Personas usuarios = personasFacadeLocal.iniciarSesion(persona);
        if(usuarios != null){
            HttpSession session = jsfUtils.getSession();
            session.setAttribute("username", usuarios);
            return "/administracion/inicio";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "index";
        }
    }
    
    public String logout() {
      HttpSession session = jsfUtils.getSession();
      session.invalidate();
      return "/index";
   }
    
//   public String sesion(){
//        Personas u;
////        PermisosRol p;
//        String redireccion = null;
//        try{
//              u = personasFacadeLocal.iniciarSesion(persona);
//              u.getRol().getIdRol();
//            if(u != null){
//                HttpSession  session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
////                menu = (List<String>) persona;
//                session.setAttribute("usuario", u);
////                session.setAttribute("permiso", p);
//                redireccion = "/administracion/inicio?faces-redirect=true";
//            }else{
//               jsfUtils.addErrorMessage("Usuario o Contraseña Incorrectos"); 
//            }            
//        }catch(Exception e){
//            jsfUtils.addErrorMessage("Error al iniciar la sesión");
//        }
//        return redireccion;
//    }
   
   
    /**
     * Creates a new instance of SessionControlador
     */
    public SessionControlador() {
    }
    
}
