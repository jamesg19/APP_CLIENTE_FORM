/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Analizadores.*;
import ComunicacionHTTP.EnviarHTTP;
import ComunicacionHTTP.ServidorRecibe;
import java.io.DataOutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author James
 */
public class Editor extends javax.swing.JFrame implements Runnable {

    NumeroLinea numeroLinea;
    String fichero = null;
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    ArrayList al = new ArrayList();
    ServidorRecibe recibe;
        //recibe.startServer();
    public Editor() {
        initComponents();
        numeroLinea = new NumeroLinea(jTextArea);
        jScrollPane2.setRowHeaderView(numeroLinea);

            Thread mihilo= new Thread(this);
            mihilo.start();
        
    }
    public void espera() 
    {
        
        try {
            ServidorRecibe recibe2 = new ServidorRecibe();
            recibe=recibe2;
            recibe2.startServer(ErroresArea);
        } catch (IOException ex) {
            System.out.println("error "+ex);
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //recibe2.startServer();
       
        //recibe.startServer();
    }
        public String AbrirArchivo(File fichero) {
        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int a;
            while ((a = entrada.read()) != -1) {
                char caracter = (char) a;
                documento += caracter;
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        //jTextArea.setText(documento);
        return documento;
    }

    public String GuardarArchivo(File archivo, String documento) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "Archivo Guardado";
            salida.close();
        } catch (Exception e) {

        }
        return mensaje;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        ErroresArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        GuardarCOmo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Compilar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ImportatForm = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        Limpiar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jTextArea.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jTextAreaAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTextArea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextAreaMouseMoved(evt);
            }
        });
        jTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextAreaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea);

        ErroresArea.setColumns(20);
        ErroresArea.setRows(5);
        jScrollPane1.setViewportView(ErroresArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jMenu1.add(abrir);

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jMenu1.add(Guardar);

        GuardarCOmo.setText("Guardar Como");
        GuardarCOmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCOmoActionPerformed(evt);
            }
        });
        jMenu1.add(GuardarCOmo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Compilar");

        Compilar.setText("Compilar");
        Compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompilarActionPerformed(evt);
            }
        });
        jMenu2.add(Compilar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Importar");

        ImportatForm.setText("Importar Formulario");
        jMenu3.add(ImportatForm);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Limpiar");

        Limpiar.setText("Limpiar Consola");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        jMenu4.add(Limpiar);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        // TODO add your handling code here:
          if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.canRead()) {
                    String documento = AbrirArchivo(archivo);
                    fichero = seleccionar.getSelectedFile() + "";
                    jTextArea.setText("");
                    jTextArea.setText(documento); 
            }
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        //guardar
        if (fichero == null) {
            if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
                archivo = seleccionar.getSelectedFile();
                fichero = seleccionar.getSelectedFile() + "";
                if (archivo.getName().endsWith("form|jam")) {
                    String documento = jTextArea.getText();
                    String mensaje = GuardarArchivo(archivo, documento);
                    if (mensaje != null) {
                        JOptionPane.showMessageDialog(null, mensaje);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Guardar documento de texto");
                }
            }
        } else {
            String documento = jTextArea.getText();
            String mensaje = GuardarArchivo(archivo, documento);
        }
    }//GEN-LAST:event_GuardarActionPerformed
    private void GuardarCOmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCOmoActionPerformed
        // TODO add your handling code here:
        //GUARDAR COMO
        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            fichero = seleccionar.getSelectedFile() + "";
            if (archivo.getName().endsWith("txt|form")) {
                String documento = jTextArea.getText();
                String mensaje = GuardarArchivo(archivo, documento);
                if (mensaje != null) {
                    JOptionPane.showMessageDialog(null, mensaje);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Archivo Guardado exitosamente");
            }
        }
    }//GEN-LAST:event_GuardarCOmoActionPerformed

    private void CompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompilarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ErroresArea.setText("");
            ErroresArea.setText("**************Inicianco Ejecucionn********************");
            String entrada = jTextArea.getText();
            //ENVIAR DATOS DEL USUARIO Y CODIGO
            EnviarHTTP send = new EnviarHTTP(entrada);
  
            //send.EnviarDatosServidor(entrada);
            send.EnviarCodigo(entrada);
        } catch (IOException ex) {
            System.out.println("SERVIDOR NO INICIALIZADO...\n");
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CompilarActionPerformed

    private void jTextAreaAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTextAreaAncestorMoved
        // TODO add your handling code here:
        jScrollPane2.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_jTextAreaAncestorMoved

    private void jTextAreaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaMouseMoved
        // TODO add your handling code here:
        jScrollPane2.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_jTextAreaMouseMoved

    private void jTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaKeyPressed
        // TODO add your handling code here:
        jScrollPane2.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_jTextAreaKeyPressed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        // TODO add your handling code here:
        ErroresArea.setText("");
    }//GEN-LAST:event_LimpiarActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Editorr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Editorr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Editorr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Editorr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Editorr().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Compilar;
    private javax.swing.JTextArea ErroresArea;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuItem GuardarCOmo;
    private javax.swing.JMenuItem ImportatForm;
    private javax.swing.JMenuItem Limpiar;
    private javax.swing.JMenuItem abrir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        espera();
        ErroresArea.append(recibe.getMensajeServidor2());
    }
}
