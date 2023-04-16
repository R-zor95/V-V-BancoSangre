
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import Datos.*;


public class ControladorPrincipal {
    private frmPrincipal vista;
    private Usuario modelo;
    
    
    public ControladorPrincipal(Usuario modelo, frmPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        this.vista.btnDonantes.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorRegistrarDonantes controlador = new ControladorRegistrarDonantes (new frmDonantes());
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
        this.vista.btnSolicitante.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorRegistrarSolicitantes controlador = new ControladorRegistrarSolicitantes (new frmSolicitante());
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
        this.vista.btnEntidad.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorEntidades controlador = new ControladorEntidades (new frmEntidades());
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
        this.vista.btnSolicitud.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorSolicitud controlador = new ControladorSolicitud (new frmSolicitud());
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
        this.vista.btnExtraccion.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorExtraccion controlador = new ControladorExtraccion (new frmExtraccion());
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
        this.vista.btnInventario.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ControladorInventario controlador = new ControladorInventario(new frmInventario());
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
        
        this.vista.btnSalir.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    modelo.salir();
                    ControladorSistema controlador = new ControladorSistema( Repositorio.usuarios, new frmSistema() );
                    controlador.iniciar();
                    vista.dispose();
                }
            }
        );

    } 
    
    public void iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        //traer usuario validado y ponerlo en el label
        this.vista.lblUsuario.setText(modelo.getUsuario());
    }

    
}
