/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rudy.ln;

import dao.UsuariosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jpa.Usuarios;

/**
 *
 * @author Rudy
 */
@Stateless
public class UsuariosLN implements UsuariosLNLocal {
    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    
    

    @Override
    public List<Usuarios> selectAll() {

        return usuariosFacade.findAll();
        
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
