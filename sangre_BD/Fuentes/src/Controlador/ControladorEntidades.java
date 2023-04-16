
package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorEntidades {
    private frmEntidades vista;
    
    private ConsultasEntidad modeloC = new ConsultasEntidad();
    
    DefaultTableModel modelotabla = new DefaultTableModel();
    public ControladorEntidades(frmEntidades vista) {
        this.vista = vista;
        
        
        this.vista.btnRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                String nombree=vista.txtnombreE.getText();
                String ruc=vista.txtruc.getText();
                String razon=vista.txtRazon.getText();
                
                if(nombree.isEmpty()||ruc.isEmpty()||razon.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {
                        
                        try {
                            Entidad en = new Entidad(nombree,ruc,razon);
                            modeloC.registrarEntidad(en);
                            
                            JOptionPane.showMessageDialog(null, "Entidad Agregada");
                            actualizarTabla();
                        } catch (NumberFormatException ex1) {
                            JOptionPane.showMessageDialog(null, "Dato invalido");
                        }
                    } catch (NumberFormatException ex2) {
                        JOptionPane.showMessageDialog(null, "Num. invalido");
                    }
                }

            }
        }      
        );
        
        this.vista.btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = vista.tblEntidadRepo.getSelectedRow();
                
                //eliminar
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una Entidad");
                } else {
                    int valor = Integer.parseInt(vista.tblEntidadRepo.getValueAt(fila, 0).toString());
                    modeloC.eliminarEntidad(valor);
                    JOptionPane.showMessageDialog(null, "Entidad Eliminada");
                }

            }
        }
        );
       
        this.vista.btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ControladorPrincipal controlador = new ControladorPrincipal(Repositorio.usuario_validado, new frmPrincipal());
                controlador.iniciar();
                vista.dispose();
                }
            }
        );
        
    }
    
    public void actualizarTabla(){
        this.vista.tblEntidadRepo.setModel(ConsultasEntidad.listar());
        this.vista.tblEntidadRepo.getTableHeader().setReorderingAllowed(false);
    }
    
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        
        actualizarTabla();
    }
}
