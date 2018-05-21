/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectos.umg.tresenlinea;

import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.ArduinoException;
import static java.lang.Boolean.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author VictorM
 */
public class Totito extends javax.swing.JFrame {

    String Cadena, respuestaTotito, CadenaTmp = "";
    boolean hayCadena, alguienGano;
    String DEFAULT = "000000000";
    String GanoP1 = "GanoP1", GanoP2 = "GanoP2", Empate = "Empate";
    int X = 1, O = 2, columna, fila;
    int[][] totito = new int[3][3];
    int[] tablero = new int[9];

    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    //SerialPortEventListener listener = new Seria
    SerialPortEventListener listener = new SerialPortEventListener() {

        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ino.isMessageAvailable()) {
                    Cadena = ino.printMessage();
                    verificaDatos(Cadena);

                    if (hayCadena == TRUE) {
                        if (rbBusqueda.isSelected()) {
                            log("Se busca resultado por Algoritmo de Busqueda");
                            AlgoritmoBusqueda();

                        } else {
                            log("Se busca resultado por Sistema Experto");
                            SistemaExperto();
                        }
                    }
                }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(Totito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    private void SistemaExperto() {
        respuestaTotito = "";
        //Si es el primer turno y le toca a la máquina escoger  
        //log("Esta es la cadena recibida: " + Cadena.trim());       
        int espaciosDisponibles = 9;
        if (Cadena.trim().equals(DEFAULT)) {
        } else {
            int k = 0;
            int l = 1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    totito[i][j] = Integer.parseInt(Cadena.trim().substring(k++, l++));
                    log("Posición: " + i + j + " Contiene: " + totito[i][j]);
                    if (totito[i][j] != 0) {
                        espaciosDisponibles--;
                    }
                }
            }
        }
        //log("Espacios disponibles: " + espaciosDisponibles);
        if (espaciosDisponibles > 0) {
            SistemaExperto se = new SistemaExperto();
            se.Busqueda(espaciosDisponibles, this);
            respuestaTotito = String.valueOf(se.valor);
        }
        enviaRespuesta();
    }

    private void enviaRespuesta() {
        try {
            ino.sendData(respuestaTotito);
            log("Respuesta del Algoritmo: " + respuestaTotito);
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(Totito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verificaEstadoFinal(SistemaExperto se) {

        if (se.quienGana(this) == 1) {
            respuestaTotito = GanoP2;
            hayCadena = FALSE;
            enviaRespuesta();
            JOptionPane.showMessageDialog(this, "Te ganó la máquina.. jajajaja", "RESULTADO DEL JUEGO", INFORMATION_MESSAGE);
        } else if (se.quienGana(this) == -1) {
            respuestaTotito = GanoP1;
            hayCadena = FALSE;
            enviaRespuesta();
            JOptionPane.showMessageDialog(this, "Bueno, ganaste... ", "RESULTADO DEL JUEGO", INFORMATION_MESSAGE);
        } else if (se.quienGana(this) == 0) {
            respuestaTotito = Empate;
            hayCadena = FALSE;
            enviaRespuesta();
            JOptionPane.showMessageDialog(this, "bahhhh empatamos...", "RESULTADO DEL JUEGO", INFORMATION_MESSAGE);
        }
    }
    
        private void verificaEstadoFinalSB(SistemaBusqueda sb) {

        if (sb.quienGana(this) == 1) {
            respuestaTotito = GanoP2;
            hayCadena = FALSE;
            enviaRespuesta();
            JOptionPane.showMessageDialog(this, "Te ganó la máquina.. jajajaja", "RESULTADO DEL JUEGO", INFORMATION_MESSAGE);
        } else if (sb.quienGana(this) == -1) {
            respuestaTotito = GanoP1;
            hayCadena = FALSE;
            enviaRespuesta();
            JOptionPane.showMessageDialog(this, "Bueno, ganaste... ", "RESULTADO DEL JUEGO", INFORMATION_MESSAGE);
        } else if (sb.quienGana(this) == 0) {
            respuestaTotito = Empate;
            hayCadena = FALSE;
            enviaRespuesta();
            JOptionPane.showMessageDialog(this, "bahhhh empatamos...", "RESULTADO DEL JUEGO", INFORMATION_MESSAGE);
        }
    }

    private void AlgoritmoBusqueda() {
        SistemaBusqueda sb = new SistemaBusqueda();
        System.out.println("Entro SB");
        respuestaTotito = "";
        int espaciosDisponibles = 9;

        int k = 0;
        int l = 1;
        for (int i = 0; i < 9; i++) {
            tablero[i] = Integer.parseInt(Cadena.trim().substring(k++, l++));
            log("Posición: " + i + " Contiene: " + tablero[i]);
            if (tablero[i] != 0) {
                espaciosDisponibles--;
            }
        }

        if (espaciosDisponibles > 0) {
            sb.movimiento(this.tablero);
            respuestaTotito = String.valueOf(sb.arbol.mejorMovimiento);
        }
        enviaRespuesta();
    }

    private void verificaDatos(String string) {
        hayCadena = FALSE;

        int pos = string.indexOf("|");
        if (pos != -1) {
            Cadena = string.substring(0, 9);
            log("Cadena Recibida: " + Cadena.trim());
            hayCadena = TRUE;
            int k = 0;
            int l = 1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    totito[i][j] = Integer.parseInt(Cadena.trim().substring(k++, l++));
                }
            }

            if (!CadenaTmp.trim().equals(Cadena.trim())) {
                CadenaTmp = Cadena;
                respuestaTotito = "";
                if (rbBusqueda.isSelected()) {
                SistemaBusqueda sb = new SistemaBusqueda();
                verificaEstadoFinalSB(sb);
                 } else {
                    SistemaExperto se = new SistemaExperto();
                verificaEstadoFinal(se);
                }
            } else {
                hayCadena = FALSE;
            }
        }
    }

    public Totito() {
        initComponents();
        InicializarMatriz();
        rbGroupTipoJuego.add(rbBusqueda);
        rbGroupTipoJuego.add(rbExperto);
        rbExperto.setSelected(true);

        rbGroupTurno.add(rbMaquina);
        rbGroupTurno.add(rbUsuario);
        rbMaquina.setSelected(true);

        try {
            ino.arduinoRXTX("COM4", 9600, listener);
        } catch (ArduinoException ex) {
            Logger.getLogger(Totito.class.getName()).log(Level.SEVERE, null, ex);
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

        rbGroupTipoJuego = new javax.swing.ButtonGroup();
        rbGroupTurno = new javax.swing.ButtonGroup();
        rbBusqueda = new javax.swing.JRadioButton();
        rbExperto = new javax.swing.JRadioButton();
        btnEmpezar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        rbUsuario = new javax.swing.JRadioButton();
        rbMaquina = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rbBusqueda.setText("Sistema por Búsqueda");

        rbExperto.setText("Sistema Experto ");

        btnEmpezar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnEmpezar.setText("Empezar Juego");
        btnEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpezarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setText("Tres en Línea");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Tipo de Inteligencia:");

        rbUsuario.setText("Usuario");

        rbMaquina.setText("Máquina");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Quién Empieza el Juego");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbMaquina)
                    .addComponent(rbUsuario)
                    .addComponent(jLabel3)
                    .addComponent(rbExperto)
                    .addComponent(rbBusqueda)
                    .addComponent(jLabel2))
                .addGap(253, 253, 253))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(btnEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbExperto)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbMaquina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpezarActionPerformed
        try {
            if (rbUsuario.isSelected()) {
                ino.sendData("1");
            } else {
                ino.sendData("2");
            }

        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(Totito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEmpezarActionPerformed

    private void InicializarMatriz() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                totito[i][j] = 0;
            }
        }
    }

    public static void log(Object aObject) {
        System.out.println(String.valueOf(aObject));
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Totito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Totito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmpezar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbBusqueda;
    private javax.swing.JRadioButton rbExperto;
    private javax.swing.ButtonGroup rbGroupTipoJuego;
    private javax.swing.ButtonGroup rbGroupTurno;
    private javax.swing.JRadioButton rbMaquina;
    private javax.swing.JRadioButton rbUsuario;
    // End of variables declaration//GEN-END:variables

}
