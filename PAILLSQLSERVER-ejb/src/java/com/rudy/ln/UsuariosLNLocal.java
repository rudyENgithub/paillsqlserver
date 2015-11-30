/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rudy.ln;

import java.util.List;
import javax.ejb.Local;
import jpa.Usuarios;

/**
 *
 * @author Rudy
 */
@Local
public interface UsuariosLNLocal {

    public List<Usuarios> selectAll();
    
}
