
package Controlador;

import Datos.Repositorio;
import Modelo.ConsultasUnidadS;
import Vista.frmInventario;
import Vista.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInventario {
    private frmInventario vista;
    
    public ControladorInventario(frmInventario vista){
        this.vista = vista;
        
        this.vista.btnRegresar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorPrincipal controlador = new ControladorPrincipal(Repositorio.usuario_validado, new frmPrincipal());
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
    }
    
    public void actualizarTabla() {
          this.vista.tbl_Inventario.setModel(ConsultasUnidadS.listar());
          this.vista.tbl_Inventario.getTableHeader().setReorderingAllowed(false);
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        actualizarTabla();
    }
}
