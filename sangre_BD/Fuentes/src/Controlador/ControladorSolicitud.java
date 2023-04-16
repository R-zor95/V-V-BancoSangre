package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
public class ControladorSolicitud {
    private ConsultasSolicitud modeloC = new ConsultasSolicitud();
    private ConsultasSangre modeloS = new ConsultasSangre();
    private ConsultasSolicitante modeloD = new ConsultasSolicitante();
    private ConsultasUnidadS modeloU = new ConsultasUnidadS();
    private frmSolicitud vista;

    public ControladorSolicitud(frmSolicitud vista) {
        this.vista = vista;
        
        this.vista.botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int idsangre=modeloS.idSangre(vista.comboGrupoSang.getSelectedItem().toString(), vista.comboRH.getSelectedItem().toString());
                String idUnidad=modeloU.idUnidad(idsangre);
                int idsolicitante=modeloD.idSolicitante(vista.comboSolicitante.getSelectedItem().toString());
                String motivo=vista.txtMotivo.getText();
                
                if (vista.jfecha.getDate() == null || vista.txtCantidad.getText().isEmpty()||motivo.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {
                        
                        int cantidad = Integer.parseInt(vista.txtCantidad.getText());
                        try {
                            Date date = vista.jfecha.getDate();
                            long d = date.getTime();
                            java.sql.Date fecha = new java.sql.Date(d);
                            
                            if (cantidad > 0 ) {
                            SolicitudSangre sl = new SolicitudSangre(idUnidad,idsolicitante,motivo,cantidad,fecha);
                  
                            modeloC.registrarSolicitud(sl);
                            modeloU.disminuir(idUnidad, cantidad);
                            
                            JOptionPane.showMessageDialog(null, "Solicitud Registrada");
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
                int fila = vista.tblSolRepo.getSelectedRow();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar alguna Extraccion");
                } else {
                    int valor = Integer.parseInt(vista.tblSolRepo.getValueAt(fila, 0).toString());
                    String tipo = vista.tblSolRepo.getValueAt(fila, 3).toString();
                    String rh = vista.tblSolRepo.getValueAt(fila, 4).toString();
                    int idSangre = modeloS.idSangre(tipo, rh);
                    String idUnidad=modeloU.idUnidad(idSangre);
                    int cantidadregresa =Integer.parseInt(vista.tblSolRepo.getValueAt(fila, 2).toString());//codigo de la solicitud
                    modeloU.disminuir(idUnidad, cantidadregresa);
                    modeloC.eliminarSolicitud(valor);
                    
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Solicitud eliminada");
                }
            }
        }
        );
    }
    
    public void actualizarTabla(){
        this.vista.tblSolRepo.setModel(ConsultasSolicitud.listar());
        this.vista.tblSolRepo.getTableHeader().setReorderingAllowed(false);
    }

    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.tblSolRepo.setEditingColumn(2);
        DefaultComboBoxModel modeloCboSolicitantes = new DefaultComboBoxModel();
        modeloD.comboSolicitante(modeloCboSolicitantes);
        this.vista.comboSolicitante.setModel(modeloCboSolicitantes);
        actualizarTabla();
    }
}
