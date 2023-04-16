package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
public class ControladorExtraccion {
    private ConsultasExtraccion modeloC = new ConsultasExtraccion();
    private ConsultasSangre modeloS = new ConsultasSangre();
    private ConsultasDonante modeloD = new ConsultasDonante();
    private ConsultasUnidadS modeloU = new ConsultasUnidadS();
    private frmExtraccion vista;
    
    public ControladorExtraccion(frmExtraccion vista) {
        this.vista = vista;
        
        this.vista.botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idsangre=modeloS.idSangre(vista.comboGrupoSang.getSelectedItem().toString(), vista.comboRH.getSelectedItem().toString());
                String idUnidad=modeloU.idUnidad(idsangre);
                int iddonante=modeloD.idDonante(vista.comboDonantes.getSelectedItem().toString());
                
                if (vista.jfecha.getDate() == null || vista.txtCantidad.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {
                        
                        int cantidad = Integer.parseInt(vista.txtCantidad.getText());
                        try {
                            Date date = vista.jfecha.getDate();
                            long d = date.getTime();
                            java.sql.Date fecha = new java.sql.Date(d);
                            
                            if (cantidad > 0 ) {
                            ExtraccionSangre ex = new ExtraccionSangre(idUnidad,iddonante,cantidad,fecha);
                            modeloC.registrarExtraccion(ex);
                            modeloU.añadir(idUnidad, cantidad);
                            
                            
                            JOptionPane.showMessageDialog(null, "Extraccion Registrada");
                            actualizarTabla();
                        } else {
                            JOptionPane.showMessageDialog(null, "Digite datos validos");
                        }
                            
                        } catch (Exception ex1) {
                            JOptionPane.showMessageDialog(null, "Fecha invalida");
                        }

                        

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Solo se pueden digitar numeros en Volumen");

                    }

                }
            }
        }
        );
        
        this.vista.botonRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ControladorPrincipal controlador = new ControladorPrincipal(Repositorio.usuario_validado, new frmPrincipal());
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
        
        this.vista.botonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = vista.tblExtRepo.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar alguna Extraccion");
                } else {
                    int valor = Integer.parseInt(vista.tblExtRepo.getValueAt(fila, 0).toString());
                    String tipo = vista.tblExtRepo.getValueAt(fila, 3).toString();
                    String rh = vista.tblExtRepo.getValueAt(fila, 4).toString();
                    int idSangre = modeloS.idSangre(tipo, rh);
                    String idUnidad=modeloU.idUnidad(idSangre);
                    int cantidadregresa =Integer.parseInt(vista.tblExtRepo.getValueAt(fila, 2).toString());//codigo de la solicitud
                    modeloU.disminuir(idUnidad, cantidadregresa);
                    modeloC.eliminarExtraccion(valor);
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Extraccion eliminada");
                }
            }
        }
        );
    }
        

    
    
    public void actualizarTabla(){
        this.vista.tblExtRepo.setModel(ConsultasExtraccion.listar());
        this.vista.tblExtRepo.getTableHeader().setReorderingAllowed(false);
    }
    
    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.tblExtRepo.setEditingColumn(2);
        DefaultComboBoxModel modeloCboEmpleados = new DefaultComboBoxModel();
        modeloD.comboDonante(modeloCboEmpleados);
        this.vista.comboDonantes.setModel(modeloCboEmpleados);
        actualizarTabla();
    }
}
