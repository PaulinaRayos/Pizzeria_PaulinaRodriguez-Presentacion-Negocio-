/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dao.Conexion;
import interfaces.IConexion;
import interfaces.IProductoNegocio;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;
import negocio.ProductoNegocio;
import objetos.Producto;

/**
 * Clase de presentación que muestra una interfaz gráfica para gestionar productos.
 * Permite agregar, actualizar, eliminar y consultar productos.
 * @author pauli
 */
public class Presentacion extends javax.swing.JFrame {

    DefaultTableModel modelo; // Modelo de tabla para gestionar la visualización de productos
    public IProductoNegocio productoNegocio; // Interfaz de negocio para gestionar operaciones de producto

    /**
     * Creates new form Presentacion
     */
    public Presentacion() {
        initComponents();
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripción");
        this.tblProducto.setModel(modelo);  // Asigna el modelo a la tabla tblProducto

        //Inicializa la conexión y el negocio del producto
        IConexion conexion = new Conexion();
        productoNegocio = new ProductoNegocio(conexion); // Pasa la conexión al constructor

        consultarTodos(); // Consulta todos los productos y los muestra en la tabla
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnCancelarEliminar = new javax.swing.JButton();
        btnAgregarActualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Descripción");

        jLabel3.setText("Precio");

        btnCancelarEliminar.setText("Cancelar");
        btnCancelarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEliminarActionPerformed(evt);
            }
        });

        btnAgregarActualizar.setText("Agregar");
        btnAgregarActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActualizarActionPerformed(evt);
            }
        });

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProducto);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setText("Productos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelarEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarActualizar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescripcion)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarActualizar)
                            .addComponent(btnCancelarEliminar)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        // TODO add your handling code here:
        // Obtiene los datos del producto seleccionado y los muestra en los campos de texto
        DefaultTableModel model = (DefaultTableModel) tblProducto.getModel();

        String nombre = model.getValueAt(tblProducto.getSelectedRow(), 1).toString();
        String precio = model.getValueAt(tblProducto.getSelectedRow(), 2).toString();
        String descripcion = model.getValueAt(tblProducto.getSelectedRow(), 3).toString();
        txtNombre.setText(nombre);
        txtPrecio.setText(precio);
        txtDescripcion.setText(descripcion);

        //Cambia el texto de los botones
        btnCancelarEliminar.setText("Eliminar");
        btnAgregarActualizar.setText("Actualizar");

    }//GEN-LAST:event_tblProductoMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        //Cambia los botones cuando deja de seleccionar la tabla y selecciona el form
        btnCancelarEliminar.setText("Cancelar");
        btnAgregarActualizar.setText("Agregar");
        limpiarTextbox();
    }//GEN-LAST:event_formMouseClicked

    private void btnAgregarActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActualizarActionPerformed
        // TODO add your handling code here:
        if (btnAgregarActualizar.getText().equalsIgnoreCase("Actualizar")) {
            //actualizar
            Producto producto = new Producto();

            DefaultTableModel model = (DefaultTableModel) tblProducto.getModel();
            String id = model.getValueAt(tblProducto.getSelectedRow(), 0).toString();

            producto.setNombre(txtNombre.getText());
            producto.setPrecio(Float.parseFloat(txtPrecio.getText()));
            producto.setDescripcion(txtDescripcion.getText());
            producto.setId(Integer.parseInt(id));

            if (productoNegocio.actualizar(producto)) {
                JOptionPane.showMessageDialog(null, "Se actualizo con exito", "Producto", INFORMATION_MESSAGE);
                limpiarTextbox();
            } else {
                JOptionPane.showMessageDialog(null, "Fallo al actualizar Producto", "Producto", INFORMATION_MESSAGE);
            }
            consultarTodos();

        } else {
            //agregar
            Producto producto = new Producto();
            producto.setNombre(txtNombre.getText());
            producto.setPrecio(Float.parseFloat(txtPrecio.getText()));
            producto.setDescripcion(txtDescripcion.getText());
            if (productoNegocio.agregar(producto)) {
                JOptionPane.showMessageDialog(null, "Se agrego con exito", "Producto", INFORMATION_MESSAGE);
                limpiarTextbox();
            } else {
                JOptionPane.showMessageDialog(null, "Fallo al guardar Producto", "Producto", INFORMATION_MESSAGE);
            }
            consultarTodos();
        }

    }//GEN-LAST:event_btnAgregarActualizarActionPerformed

    private void btnCancelarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEliminarActionPerformed
        // TODO add your handling code here:}
        if (btnCancelarEliminar.getText().equalsIgnoreCase("Cancelar")) {
            limpiarTextbox();
        } else {
            //eliminar
            Producto producto = new Producto();
            DefaultTableModel model = (DefaultTableModel) tblProducto.getModel();
            String id = model.getValueAt(tblProducto.getSelectedRow(), 0).toString();

            if (productoNegocio.eliminar(Integer.parseInt(id))) {
                JOptionPane.showMessageDialog(null, "Se elimino con exito", "Producto", INFORMATION_MESSAGE);
                limpiarTextbox();
                btnCancelarEliminar.setText("Cancelar");
                btnAgregarActualizar.setText("Agregar");
            } else {
                JOptionPane.showMessageDialog(null, "Fallo al eliminar Producto", "Producto", INFORMATION_MESSAGE);
            }

        }
        consultarTodos();
    }//GEN-LAST:event_btnCancelarEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Presentacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Presentacion().setVisible(true);
            }
        });
    }
    
    /**
     * Consulta todos los productos de la base de datos y los muestra en la tabla.
     */
    public void consultarTodos() {
        List<Producto> list = productoNegocio.consultar();
        DefaultTableModel model = (DefaultTableModel) tblProducto.getModel();
        int rowCount = model.getRowCount();
        //Elimina filas una por una del final de la tabla
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        // Añade los productos consultados a la tabla
        Object rowData[] = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getId();
            rowData[1] = list.get(i).getNombre();
            rowData[2] = list.get(i).getPrecio();
            rowData[3] = list.get(i).getDescripcion();
            model.addRow(rowData);
        }
    }
    
    /**
     * Limpia los campos de texto.
     */
    public void limpiarTextbox() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtDescripcion.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarActualizar;
    private javax.swing.JButton btnCancelarEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}