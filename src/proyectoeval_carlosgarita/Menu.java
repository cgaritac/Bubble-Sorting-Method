/*
Universidad: UNED
Curso:        Estructura de Datos 
Código:       00825
Tema:         Proyecto Evaluativo
Estudiante:   Carlos Garita Campos
Periodo:      II Cuatrimestre 2020
 */
package proyectoeval_carlosgarita;

import javax.swing.JOptionPane;

/**
 *
 * @author cgari
 */
public class Menu extends javax.swing.JFrame {

    //Declaración de variables globales
    private String elemento = "";
    private String[] palabras, ordenadas;
    private int cantidad = 0, contadorMov = 0;

    public Menu() {
        initComponents(); //Carga todo los objetos que halla en el JFrame    
        this.setLocationRelativeTo(null); //Posiciona el JFrame en el centro de la pantalla 

        this.txtEstado.setText("Ordenamiento no iniciado");
    }

    //Método para separar el String con las palabras en palabras individuales dentro del arreglo de Strings utilizando como marcador
    //para identificar la dividión entre palabras un "/"
    private void separarPalabras(String dato) {
        System.arraycopy(dato.split("/"), 0, this.palabras, 0, this.cantidad);
    }

    //Método para contar la cantidad de palabras que conforman el String que contiene las palabras que ingresa el usuario
    private void contarPalabras(String dato) {
        this.cantidad = 0;

        for (int i = 0; i < dato.length(); i++) {
            if (dato.charAt(i) == '/') {
                this.cantidad++;
            }
        }
    }

    //Mpetodo para ordenar las palabras mediante el algoritmo de Burbuja
    private void OrdenarBurbuja(String opcion, String[] arreglo) {
        //Declaración de variables locales
        String dato;
        boolean prueba = false;

        //Ciclo for para recorrer el arreglo en la posición "i"
        for (int i = 0; i < arreglo.length - 1; i++) {

            //Ciclo for para recorrer el arreglo en la posición "j"
            for (int j = 0; j < arreglo.length - 1; j++) {

                //Declaración de variables locales para referencia de cambios y determinación de si ya logró finalizar el ordenamiento
                String primera = arreglo[j];
                String Segunda = arreglo[j + 1];
                prueba = false;

                //Condicional para ordenar las palabras que poseen la misma letra inicial
                if (arreglo[j].charAt(0) == arreglo[j + 1].charAt(0)) {
                    if (arreglo[j].compareTo(arreglo[j + 1]) < 0) {

                        dato = arreglo[j + 1]; //Asigna el valor del arreglo en la posición "j+1" a la variable "num"
                        arreglo[j + 1] = arreglo[j]; //Asigna el valor del arreglo en la posición "j" al arreglo en la posición "j+1"
                        arreglo[j] = dato; //Asigna el valor de la variable "num" al arreglo en la posición "j"
                    }

                    if (arreglo[j].length() > arreglo[j + 1].length()) {
                        dato = arreglo[j + 1]; //Asigna el valor del arreglo en la posición "j+1" a la variable "num"
                        arreglo[j + 1] = arreglo[j]; //Asigna el valor del arreglo en la posición "j" al arreglo en la posición "j+1"
                        arreglo[j] = dato; //Asigna el valor de la variable "num" al arreglo en la posición "j"
                    }
                }

                //Condicional para ordenar las palabras cuyas letras iniciales son mayúsculas
                if (arreglo[j].charAt(0) < 91 && arreglo[j + 1].charAt(0) < 91) {
                    if (arreglo[j].charAt(0) > arreglo[j + 1].charAt(0)) {

                        dato = arreglo[j + 1]; //Asigna el valor del arreglo en la posición "j+1" a la variable "num"
                        arreglo[j + 1] = arreglo[j]; //Asigna el valor del arreglo en la posición "j" al arreglo en la posición "j+1"
                        arreglo[j] = dato; //Asigna el valor de la variable "num" al arreglo en la posición "j"
                    }
                }

                //Condicional para ordenar las palabras cuyas letras iniciales son minúsculas
                if (arreglo[j].charAt(0) > 96 && arreglo[j + 1].charAt(0) > 96) {
                    if (arreglo[j].charAt(0) > arreglo[j + 1].charAt(0)) {

                        dato = arreglo[j + 1]; //Asigna el valor del arreglo en la posición "j+1" a la variable "num"
                        arreglo[j + 1] = arreglo[j]; //Asigna el valor del arreglo en la posición "j" al arreglo en la posición "j+1"
                        arreglo[j] = dato; //Asigna el valor de la variable "num" al arreglo en la posición "j"
                    }
                }

                //Condicional para ordenar las palabras cuyas letras iniciales una es mayúscula y la otra es minúscula
                if ((arreglo[j].charAt(0) < 91 && arreglo[j + 1].charAt(0) > 96) || (arreglo[j].charAt(0) > 96 && arreglo[j + 1].charAt(0) < 91)) {
                    String mayuscula;
                    if (arreglo[j].charAt(0) < 91) {
                        mayuscula = arreglo[j].toLowerCase();

                        if (mayuscula.charAt(0) > arreglo[j + 1].charAt(0) || mayuscula.charAt(0) == arreglo[j + 1].charAt(0)) {

                            dato = arreglo[j + 1]; //Asigna el valor del arreglo en la posición "j+1" a la variable "num"
                            arreglo[j + 1] = arreglo[j]; //Asigna el valor del arreglo en la posición "j" al arreglo en la posición "j+1"
                            arreglo[j] = dato; //Asigna el valor de la variable "num" al arreglo en la posición "j"
                        }

                    } else {
                        mayuscula = arreglo[j + 1].toLowerCase();

                        if (arreglo[j].charAt(0) > mayuscula.charAt(0) || arreglo[j].charAt(0) > mayuscula.charAt(0)) {

                            dato = arreglo[j + 1]; //Asigna el valor del arreglo en la posición "j+1" a la variable "num"
                            arreglo[j + 1] = arreglo[j]; //Asigna el valor del arreglo en la posición "j" al arreglo en la posición "j+1"
                            arreglo[j] = dato; //Asigna el valor de la variable "num" al arreglo en la posición "j"
                        }
                    }
                }

                //Condicional que maneja el avance del algorítmo en caso de que se recorre el algorítmo con el botón play o por pasos
                if ((opcion.equals("Pasos"))) {
                    if (!primera.equals(arreglo[j]) || !Segunda.equals(arreglo[j + 1])) {
                        prueba = true;
                        break;
                    }
                } else {

                }
            }

            //Condicional que maneja el avance del algorítmo en caso de que se recorre el algorítmo con el botón play o por pasos
            if (opcion.equals("Pasos")) {
                break;
            }
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
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaVisualizadorTexto = new javax.swing.JTextArea();
        btnSalir = new javax.swing.JButton();
        txtTextoAOrdenar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnOrdenar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Ordenamiento por método Burbúja");

        txaVisualizadorTexto.setEditable(false);
        txaVisualizadorTexto.setColumns(20);
        txaVisualizadorTexto.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txaVisualizadorTexto.setRows(5);
        jScrollPane1.setViewportView(txaVisualizadorTexto);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtTextoAOrdenar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTextoAOrdenar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTextoAOrdenarKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Indique el texto a agregar:");

        btnOrdenar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnOrdenar.setText("Play");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Presione para ordenar");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Estado del ordenamiento:");

        txtEstado.setEditable(false);
        txtEstado.setBackground(new java.awt.Color(240, 240, 240));
        txtEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstadoKeyTyped(evt);
            }
        });

        btnReiniciar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReiniciar.setText("Limpiar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnOrdenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTextoAOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(57, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEstado)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(204, 204, 204))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTextoAOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrdenar)
                        .addGap(197, 197, 197)
                        .addComponent(btnReiniciar)
                        .addGap(227, 227, 227))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String dato = "";

        if (this.txtTextoAOrdenar.getText().equals("")) {

        } else {
            this.elemento += this.txtTextoAOrdenar.getText() + "/";

            //Llama al método contarPalabras
            contarPalabras(this.elemento);
            palabras = new String[this.cantidad];
            
            //Llama al método separarPalabras
            separarPalabras(this.elemento);

            //Ciclo para llenar el objeto de área de texto 
            for (String palabra : this.palabras) {
                dato += palabra + "\n";
                this.txaVisualizadorTexto.setText(dato);
            }

            this.txtTextoAOrdenar.setText("");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //Cierra la ventana y finaliza el programa
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        String dato = "";
        int pruebaIgualdad = 0;

        /*Condicional para desactivar la opción de agregar más palabras una vez que se activa el botón play por primera vez y para
        llamar al método de ordenarBurbuja que se ejecute de forma completa para que sirva de referencia para saber cuando la ejecución
        por pasos ha terminado.*/
        if (this.contadorMov == 0) {
            this.btnAgregar.setEnabled(false);
            this.ordenadas = new String[this.cantidad];
            System.arraycopy(this.palabras, 0, this.ordenadas, 0, this.cantidad);
            OrdenarBurbuja("Directo", this.ordenadas);
            this.contadorMov++;;
        }
        
        //Llama al método ordenarBurbuja para que se ejecute por pasos para ir viendo la secuencia del ordenamiento paso por paso
        OrdenarBurbuja("Pasos", this.palabras);

        //Condicional para llenar el objeto de área de texto con los cambios que se vayan realizando con el avance del algoritmo de ordenamiento
        for (String palabra : this.palabras) {
            dato += palabra + "\n";
            this.txaVisualizadorTexto.setText(dato);
        }

        /*Condicional para generar un contador que contabilice la cantidad de palabras que coincidan entre el arreglo de String que 
        va cambiando "palabras" y el de referencia del resultado del ordenamiento "ordenadas"*/
        for (int i = 0; i < this.palabras.length; i++) {
            if (this.palabras[i].equals(this.ordenadas[i])) {
                pruebaIgualdad++;
            }
        }

        /*Condicional que indica si el ordenamiento ya se completó con base en el contador de palabras coincidentes con respecto a
        la cantidad de palabras que tiene el arreglo en total*/ 
        if (pruebaIgualdad == this.cantidad) {
            this.txtEstado.setText("Finalizado, ya no hay más movimientos");
        } else {
            this.txtEstado.setText("En proceso, aún quedan movimientos");
        }
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void txtTextoAOrdenarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextoAOrdenarKeyTyped
        
        //Permite impedir que el usuario ingrese un caracter que no sean letras mayúsculas o minúsculas
        char validar = evt.getKeyChar();

        if ((validar < 'a' || validar > 'z') && (validar < 'A' || validar > 'Z')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTextoAOrdenarKeyTyped

    private void txtEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoKeyTyped

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        String dato = "";

        //Ciclo para limpiar el objeto de área de texto
        for (String palabra : this.palabras) {
            palabra = " ";
            dato += palabra + "\n";
            this.txaVisualizadorTexto.setText(dato);
        }

        //Limpia los arreglos de String
        this.palabras = new String[0];
        this.ordenadas = new String[0];

        //Reinicia los valores de varios objetos gráficos
        this.elemento = "";
        this.cantidad = 0;
        this.contadorMov = 0;
        this.txtEstado.setText("Ordenamiento no iniciado");
        this.btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btnReiniciarActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaVisualizadorTexto;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtTextoAOrdenar;
    // End of variables declaration//GEN-END:variables
}
