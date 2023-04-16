
package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorRegistrarSolicitantes {
    private frmSolicitante vista;
    
    private ConsultasSolicitante modeloC = new ConsultasSolicitante();
    private ConsultasEntidad modeloE = new ConsultasEntidad();
    
    DefaultTableModel modelotabla = new DefaultTableModel();
    
    public ControladorRegistrarSolicitantes(frmSolicitante vista) {
        this.vista = vista;
        
        
        this.vista.btnRegistrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int id_entidad=-100;
                String entidad=vista.cmbEntidad.getSelectedItem().toString();
                String nombre=vista.txtNombre.getText();
                String apellido1=vista.txtApellido1.getText();
                String apellido2=vista.txtApellido2.getText();
                String telefono=vista.txtTelefono.getText();
                String correo=vista.txtCorreo.getText();
                
                if(entidad.isEmpty()||nombre.isEmpty()||apellido1.isEmpty()||apellido2.isEmpty()||telefono.isEmpty()||correo.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {
                        id_entidad=modeloE.idEntidad(vista.cmbEntidad.getSelectedItem().toString());
                        if(telefono.length()==9){
                            try {
                            Solicitante s = new Solicitante(id_entidad,nombre,apellido1,apellido2,telefono,correo);
                            modeloC.registrarSolicitante(s);
                            System.out.println("Solicitante AGREGADO");
                            JOptionPane.showMessageDialog(null, "Solicitante Agregado");
                            actualizarTabla();
                            } catch (NumberFormatException ex1) {
                            JOptionPane.showMessageDialog(null, "Dato invalido");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El telefono debe tener 9 digitos");
                        }
                        
                    } catch (NumberFormatException ex2) {
                        JOptionPane.showMessageDialog(null, "Num. celular invalido");
                    }
                }

            }
        }      
        );
        
        this.vista.btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = vista.tblSolicitanteRepo.getSelectedRow();
                
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un solicitante");
                } else {
                    int valor = Integer.parseInt(vista.tblSolicitanteRepo.getValueAt(fila, 0).toString());
                    modeloC.eliminarSolicitante(valor);
                    actualizarTabla();
                    System.out.println("Solicitante Eliminado");
                    JOptionPane.showMessageDialog(null, "Solicitante Eliminado");
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
        this.vista.tblSolicitanteRepo.setModel(ConsultasSolicitante.listar());
        this.vista.tblSolicitanteRepo.getTableHeader().setReorderingAllowed(false);
    }
    
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        
        
        DefaultComboBoxModel modeloCboEntidad = new DefaultComboBoxModel();
        modeloE.comboEntidades(modeloCboEntidad);
        this.vista.cmbEntidad.setModel(modeloCboEntidad);
        
        actualizarTabla();
    }
}
