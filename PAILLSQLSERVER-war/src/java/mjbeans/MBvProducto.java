/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mjbeans;


import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import jpa.Usuarios;

import com.rudy.ln.UsuariosLNLocal;


/**
 *
 * @author Rudy
 */
@ManagedBean(name="mBvProducto")
@SessionScoped
public class MBvProducto {
    @EJB
    private UsuariosLNLocal usuariosLN;
  
    
 
    
    
         private List<Usuarios> insumos; 
         

    /**
     * Creates a new instance of MBvProducto
     */
    public MBvProducto() {
    }
    
        public List<Usuarios> getInsumos() {
      /*  if(bandBusqueda){
              FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFORMACION DE SISTEMA", getTxtBuscar()); 
          FacesContext.getCurrentInstance().addMessage(null, message);
          insumos.clear();
          //PARA PRUEBA 1
         //  producto = productoLN.selectByCodigo();
         //   insumos.add(producto);
          
          insumos = productoLN.selectLike(getTxtBuscar());
        }else{
             insumos = productoLN.selectAll();
        }
       */
            insumos = usuariosLN.selectAll();
        return insumos;
    }

    public void setInsumos(List<Usuarios> insumos) {
        this.insumos = insumos;
    }
    
}
