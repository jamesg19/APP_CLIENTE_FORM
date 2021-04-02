/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import File.ReadFormSaved;
import GestorLogin.GestorLogin;
import Objetos.ErrorLexico;
import Objetos.ErrorSintactico;
import java.util.ArrayList;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Login extends javax.swing.JFrame {
ArrayList<ErrorSintactico> sintactico = new ArrayList<ErrorSintactico>();
    ArrayList<ErrorLexico> lexicoLST = new ArrayList<ErrorLexico>();
     NumeroLinea numeroLinea;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        numeroLinea = new NumeroLinea(jTextArea1);
        jScrollPane1.setRowHeaderView(numeroLinea);
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
        jLabel1 = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(142, 215, 187));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido a James Forms");

        Login.setForeground(new java.awt.Color(102, 204, 255));
        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTextArea1MouseMoved(evt);
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        jTextArea2.setText("");
        String entrada=jTextArea1.getText();
        GestorLogin gst = new GestorLogin(entrada);
                ReadFormSaved leer = new ReadFormSaved("");
                leer.mostrarUsuarios();
                gst.consulta_Login();
                
                //OBTENGO LOS ERRORES
                lexicoLST = gst.getLexicoLST();
                sintactico = gst.getSintactico();
        
                if (sintactico.isEmpty() && lexicoLST.isEmpty()) {
                    
                    if (gst.buscarUsuario()) {
                        Editor home= new Editor();
                        setVisible(false);
                        home.setVisible(true);
                        
                    }else{
                        jTextArea2.setText("EL USUARIO Y/O PASSWORD INGRESADO NO EXISTE");
                    }
                }else{
                    
                    
                    String error = " ";
                    for (int i = 0; i < sintactico.size(); i++) {
                        error += "ERROR SINTACTICO\n";
                        error += "TOKEN ESPERADO: " + sintactico.get(i).getTokenEsperado() + " LINEA: " + sintactico.get(i).getValor() + " COLUMNA: " + sintactico.get(i).getColumna() + " CONFLICTO EN: " + sintactico.get(i).getLinea() + "\n";
                    }
                    for (int j = 0; j < lexicoLST.size(); j++) {
                        error += "ERROR LEXICO\n";
                        error += "TOKEN: " + lexicoLST.get(j).getToken() + " LINEA: " + lexicoLST.get(j).getLinea() + " COLUMNA: " + lexicoLST.get(j).getColumna()+"\n";
                    }
                    jTextArea2.append(error);
                    
                    
                    
                }
        
        
    }//GEN-LAST:event_LoginActionPerformed

    private void jTextArea1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseMoved
        // TODO add your handling code here:
        jScrollPane1.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_jTextArea1MouseMoved

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        // TODO add your handling code here:
         jScrollPane1.setRowHeaderView(numeroLinea);
    }//GEN-LAST:event_jTextArea1KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}