/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.VHabitacion;
import Datos.VReserva;
import Datos.Vpago;
import Logica.Conexion;
import Logica.FHabitacion;
import Logica.FPago;
import Logica.FProducto;
import Logica.FReserva;
import Logica.Fconsumo;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Emilio
 */
public class frmPago extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPago
     */
    public frmPago() {
        initComponents();
        
        Mostrar(idReserva);
        Inhabilitar();
        
        txtIdReserva.setText(idReserva);
        txtCliente.setText(Cliente);
        txtHabitacion.setText(Habitacion);
        txtIdHabitacion.setText(idHabitacion);
        txtTotalReserva.setText(Double.toString(totalReserva));
        
        Fconsumo funcion = new Fconsumo();
        funcion.Mostrar(idReserva);
        
        txtTotalPago.setText(Double.toString( totalReserva + funcion.totalConsumo));
    }
    
    private  String accion = "guardar";
    
    public static  String idReserva;
    public static  String Cliente;
    public static  String idHabitacion;
    public static  String Habitacion;
    public static  Double totalReserva;
    
    //método Ocultar Culumnas de la tabla:
    void OcultarColumnassPago()
    {
        tablalistadoPago.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoPago.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoPago.getColumnModel().getColumn(0).setPreferredWidth(0);   
        
        tablalistadoPago.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoPago.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoPago.getColumnModel().getColumn(1).setPreferredWidth(0); 
        
    }
    
    void OcultarColumnassConsumo()
    {
        tablaListadoConsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(0).setPreferredWidth(0);   
        
        tablaListadoConsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(1).setPreferredWidth(0); 
        
        tablaListadoConsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
        
    }
    
    void Inhabilitar()
    {
       txtIdPago.setVisible(false);   
       
       txtIdReserva.setVisible(true);
       txtCliente.setEnabled(true);
       txtNumeroComprobante.setEnabled(false);
       cboTipoComprobante.setEnabled(false);
       txtIgv.setEnabled(false);
       txtTotalPago.setEnabled(false);
       txtTotalReserva.setEnabled(false);
       dcFechaEmision.setEnabled(false);
       dcFechaPago.setEnabled(false);
       
       txtIdHabitacion.setVisible(false);
       txtHabitacion.setEnabled(false);
       
       btnGuardar.setEnabled(false);
       btnCancelar.setEnabled(false);
       btnEliminar.setEnabled(false);
       
       txtIdPago.setText("");       
       txtCliente.setText("");
       txtNumeroComprobante.setText("");
       txtIgv.setText("");
       
       
    }
    
    void habilitar()
    {
        txtIdPago.setVisible(false);   
       
       txtIdReserva.setVisible(true);
       txtCliente.setEnabled(true);
       txtNumeroComprobante.setEnabled(true);
       cboTipoComprobante.setEnabled(true);
       txtIgv.setEnabled(true);
       txtTotalPago.setEnabled(true);
       txtTotalReserva.setEnabled(true);
       dcFechaEmision.setEnabled(true);
       dcFechaPago.setEnabled(true);
       
       txtIdHabitacion.setVisible(true);
       txtHabitacion.setEnabled(true);
       
       btnGuardar.setEnabled(true);
       btnCancelar.setEnabled(true);
       btnEliminar.setEnabled(true);
       
      // txtIdPago.setText("");       
       txtIdPago.setText("");
       txtNumeroComprobante.setText("");
       txtIgv.setText("");
       
    }
    
    void Mostrar(String txtBuscar)
    {
        try 
        {
           DefaultTableModel modelo;
            FPago funcion = new FPago();
            modelo = funcion.Mostrar(txtBuscar);
            
            tablalistadoPago.setModel(modelo);
            OcultarColumnassPago();
            lblTotalRegistros.setText("Total Registros: " + Integer.toString(funcion.TotalRegistros));
            
            
            //Mostar los datos del consumo:
            Fconsumo funciones2 = new Fconsumo();
            modelo = funciones2.Mostrar(txtBuscar);
            tablaListadoConsumo.setModel(modelo);
            OcultarColumnassConsumo();
            
            lblTotalRegistroConsumos.setText("Total Consumo: " + funciones2.totalConsumo);
            lblTotalConsumo.setText("Consumo Total: $. " + funciones2.totalConsumo);
            
        } 
        catch (Exception e)
        {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIdReserva = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdPago = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumeroComprobante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboTipoComprobante = new javax.swing.JComboBox();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTotalReserva = new javax.swing.JTextField();
        txtIdHabitacion = new javax.swing.JTextField();
        txtHabitacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIgv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotalPago = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dcFechaEmision = new com.toedter.calendar.JDateChooser();
        dcFechaPago = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistadoPago = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        btnImpromirComprbante = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaListadoConsumo = new javax.swing.JTable();
        lblTotalRegistroConsumos = new javax.swing.JLabel();
        lblTotalConsumo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Pagos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        txtIdReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdReservaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Reserva:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Total Reserva:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Número de Comprobante:");

        txtNumeroComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroComprobanteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tipo de Comprobante:");

        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Boleta", "Factura", "Ticket", "Otro" }));
        cboTipoComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoComprobanteActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(51, 51, 51));
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/1446577060_new doc.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancel-error.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/1446577084_Save-as.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Habitación:");

        txtIdHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdHabitacionActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("IGV:");

        txtIgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgvActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Total Pago:");

        txtTotalPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Facha de emisión:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Fecha de Pago:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Busca por Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(txtIdPago, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(87, 87, 87)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboTipoComprobante, 0, 228, Short.MAX_VALUE)
                                    .addComponent(txtNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dcFechaEmision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dcFechaPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnNuevo)
                                .addGap(108, 108, 108)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar)
                                .addGap(28, 28, 28)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtIdPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(dcFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dcFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar))
                        .addGap(56, 56, 56))))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pagos:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Pagos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tablalistadoPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistadoPago.setName("tablalistadoPago"); // NOI18N
        tablalistadoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoPagoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistadoPago);

        btnEliminar.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/1446577801_DeleteRed.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(51, 51, 51));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/Exit-32.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblTotalRegistros.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTotalRegistros.setText("Regisros: ");

        btnImpromirComprbante.setBackground(new java.awt.Color(0, 0, 51));
        btnImpromirComprbante.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImpromirComprbante.setForeground(new java.awt.Color(255, 255, 255));
        btnImpromirComprbante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/imprimir.png"))); // NOI18N
        btnImpromirComprbante.setText("Imprimir");
        btnImpromirComprbante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpromirComprbanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnImpromirComprbante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(466, 466, 466)
                        .addComponent(btnEliminar)
                        .addGap(39, 39, 39)
                        .addComponent(btnSalir)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir)
                    .addComponent(btnImpromirComprbante, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Consumo:"));
        jPanel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        tablaListadoConsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaListadoConsumo.setName("tablalistado"); // NOI18N
        tablaListadoConsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListadoConsumoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaListadoConsumo);

        lblTotalRegistroConsumos.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTotalRegistroConsumos.setText("Regisros: ");

        lblTotalConsumo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTotalConsumo.setText("Regisros: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(lblTotalRegistroConsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRegistroConsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdReservaActionPerformed
        // TODO add your handling code here:
        txtIdReserva.transferFocus();
    }//GEN-LAST:event_txtIdReservaActionPerformed

    private void txtNumeroComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroComprobanteActionPerformed
        // TODO add your handling code here:
        txtNumeroComprobante.transferFocus();
    }//GEN-LAST:event_txtNumeroComprobanteActionPerformed

    private void cboTipoComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoComprobanteActionPerformed
        // TODO add your handling code here:
        cboTipoComprobante.transferFocus();
    }//GEN-LAST:event_cboTipoComprobanteActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnGuardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Inhabilitar();
        OcultarColumnassConsumo();
        OcultarColumnassPago();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        //valido los campos:
        if (txtIgv.getText().length() == 0)
        {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el IGV del conprobante general.");
            txtIgv.requestFocus();
            return;

        }

        if (txtTotalPago.getText().length() == 0)
        {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el total de pago del comprobante.");
            txtTotalPago.requestFocus();
            return;

        }

        if (txtNumeroComprobante.getText().length() == 0)
        {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Número de comprobante del pago.");
            txtNumeroComprobante.requestFocus();
            return;

        }

        Vpago datos = new Vpago();
        FPago  funcion = new FPago();

        datos.setIdReserva(Integer.parseInt(txtIdReserva.getText()));
        
        int seleccionado = cboTipoComprobante.getSelectedIndex();
        datos.setTipoComprobante(cboTipoComprobante.getItemAt(seleccionado).toString());
        
        datos.setNumeroComprobante(txtNumeroComprobante.getText());
        datos.setIgv(Double.parseDouble(txtIgv.getText()));
        datos.setTotalPago(Double.parseDouble(txtTotalPago.getText()));
        
        
        
        Calendar cal;
        int d,m,a;
        
        cal = dcFechaPago.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR);
        
        datos.setFechaPago(new Date(a,m,d));
        
        cal = dcFechaEmision.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR);
        
        datos.setFechaEmision(new Date(a,m,d));

        if (accion.equals("guardar"))
        {
            if (funcion.Insertar(datos))
            {
                JOptionPane.showConfirmDialog(rootPane, " El pago po $. " +
                                              txtTotalPago.getText()      + 
                                              " de la Sr(a) " + txtCliente.getText() + 
                                              " ha sido realizado con Éxito");
                Mostrar(idReserva);
                Inhabilitar();
                
                //Desocupar la Habicatación:
                FHabitacion funcion2 = new FHabitacion();
                VHabitacion datos2 = new VHabitacion();
                
                datos2.setIdHabitacion(Integer.parseInt(txtIdHabitacion.getText()));
                funcion2.Desocupar(datos2);
                
                //CAncelar o Pagar la Reserva:
                FReserva funcion3 = new FReserva();
                VReserva datos3 = new VReserva();
                
                datos3.setIdReserva(Integer.parseInt(txtIdReserva.getText()));
                funcion3.Pagar(datos3);
                
            }
        }
        else if(accion.equals("editar"))
        {
            datos.setIdPago(Integer.parseInt(txtIdPago.getText()));

            if (funcion.Editar(datos))
            {
                JOptionPane.showConfirmDialog(rootPane, "El Pago del Sr(a). " + txtCliente.getText() + " Ha sido Modificado Correctamente.");
                Mostrar(idReserva);
                Inhabilitar();
                
                
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdHabitacionActionPerformed

    private void txtIgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgvActionPerformed

    private void txtTotalPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPagoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //valido texto:
        if (!txtIdPago.getText().equals(""))
        {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Pago seleccionado?", "Confirmar", 2);

            if (confirmacion == 0)
            {
                FPago funcion = new FPago();
                Vpago datos = new Vpago();

                datos.setIdPago(Integer.parseInt(txtIdPago.getText()));
                funcion.Eliminar(datos);
                Mostrar(idReserva);
                Inhabilitar();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablalistadoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoPagoMouseClicked
        // TODO add your handling code here:
        btnGuardar.setText("Editar");
        habilitar();
        btnEliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistadoPago.rowAtPoint(evt.getPoint());

        txtIdPago.setText(tablalistadoPago.getValueAt(fila, 0).toString());
        
        cboTipoComprobante.setSelectedItem(tablalistadoPago.getValueAt(fila, 2).toString());
        txtNumeroComprobante.setText(tablalistadoPago.getValueAt(fila, 3).toString());
        txtIgv.setText(tablalistadoPago.getValueAt(fila, 4).toString());
        txtTotalPago.setText(tablalistadoPago.getValueAt(fila, 5).toString());
        
        dcFechaPago.setDate(Date.valueOf(tablalistadoPago.getValueAt(fila, 6).toString()));
        dcFechaPago.setDate(Date.valueOf(tablalistadoPago.getValueAt(fila, 7).toString()));
        
    }//GEN-LAST:event_tablalistadoPagoMouseClicked

    private void tablaListadoConsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListadoConsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaListadoConsumoMouseClicked

    private  Connection connection = new Conexion().conectar();

    private void btnImpromirComprbanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpromirComprbanteActionPerformed
      
        if (!txtIdPago.getText().equals(""))
        {

            Map p = new HashMap();
            p.put("idpago", txtIdPago.getText());

            JasperReport report;
            JasperPrint print;

            try 
            {
               report = JasperCompileManager.compileReport(new File("").getAbsolutePath() + "/src/Reportes/rptComprobante.jrxml");

               print = JasperFillManager.fillReport(report, p, connection);

               JasperViewer view = new JasperViewer(print, false);

               view.setTitle("Comprobante......");
               view.setVisible(true);
            } 
            catch (Exception e) 
            {
             e.printStackTrace();
            }
        
       }
    }//GEN-LAST:event_btnImpromirComprbanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImpromirComprbante;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboTipoComprobante;
    private com.toedter.calendar.JDateChooser dcFechaEmision;
    private com.toedter.calendar.JDateChooser dcFechaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblTotalConsumo;
    private javax.swing.JLabel lblTotalRegistroConsumos;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTable tablaListadoConsumo;
    private javax.swing.JTable tablalistadoPago;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtHabitacion;
    private javax.swing.JTextField txtIdHabitacion;
    private javax.swing.JTextField txtIdPago;
    private javax.swing.JTextField txtIdReserva;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNumeroComprobante;
    private javax.swing.JTextField txtTotalPago;
    private javax.swing.JTextField txtTotalReserva;
    // End of variables declaration//GEN-END:variables
}
