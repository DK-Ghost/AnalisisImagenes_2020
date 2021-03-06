package filtrosFrecuencias;

import analisisenfrecuencias.FFT.Gestor;
import analisisenfrecuencias.FFT.NumeroComplejo;
import gui.JframeImagen;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import open.AbrirImagen;

/**
 * @author Jose Nava
 */

public class FiltroSelectivoFrame extends javax.swing.JFrame {
    
    private Image resultado;
    private Image frecuencias;
    private Image filtro;
    private FiltroSelectivo fs;
    private Point select;  
            
    public FiltroSelectivoFrame() {
        initComponents();       
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        repaint();
        fs = new FiltroSelectivo(new Dimension(512, 512));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PaneRes = new javax.swing.JPanel();
        PaneFrec = new javax.swing.JPanel();
        CalcularButton = new javax.swing.JButton();
        CrearButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        CargarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jPanel2.setBackground(new java.awt.Color(22, 17, 33));

        PaneRes.setPreferredSize(new java.awt.Dimension(256, 256));

        javax.swing.GroupLayout PaneResLayout = new javax.swing.GroupLayout(PaneRes);
        PaneRes.setLayout(PaneResLayout);
        PaneResLayout.setHorizontalGroup(
            PaneResLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        PaneResLayout.setVerticalGroup(
            PaneResLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        PaneFrec.setPreferredSize(new java.awt.Dimension(256, 256));
        PaneFrec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaneFrecMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PaneFrecMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PaneFrecLayout = new javax.swing.GroupLayout(PaneFrec);
        PaneFrec.setLayout(PaneFrecLayout);
        PaneFrecLayout.setHorizontalGroup(
            PaneFrecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        PaneFrecLayout.setVerticalGroup(
            PaneFrecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        CalcularButton.setText("Calcular");
        CalcularButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularButtonActionPerformed(evt);
            }
        });

        CrearButton.setText("Crear Filtro");
        CrearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(PaneFrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(PaneRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(CrearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CalcularButton)
                .addGap(141, 141, 141))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PaneRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PaneFrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CalcularButton)
                    .addComponent(CrearButton))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Marque los Puntos a Quitar");

        CargarButton.setText("Cargar");
        CargarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(CargarButton)
                .addGap(123, 123, 123)
                .addComponent(jLabel1)
                .addGap(41, 226, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CargarButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void CalcularButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularButtonActionPerformed
        Gestor gestor = new Gestor(AbrirImagen.toBufferedImage(this.resultado));
        BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);       
        NumeroComplejo [][] filtroS = fs.getFiltroEspacial();
        gestor.aplicarFiltro(filtroS);
        
        BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
        this.setFrecuencias(this.resultado);
        this.setResutado(AbrirImagen.toImage(imagenEspacial));
  
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(new Rectangle(dim.width / 2 - 687 / 2, dim.height / 2 - 435 / 2, 687, 435));
        repaint();
    }//GEN-LAST:event_CalcularButtonActionPerformed

    private void PaneFrecMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaneFrecMousePressed
        
    }//GEN-LAST:event_PaneFrecMousePressed

    private void CargarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarButtonActionPerformed
        
        resultado = AbrirImagen.openImage();
        Gestor gestor = new Gestor(AbrirImagen.toBufferedImage(resultado));
        BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);

        frecuencias = AbrirImagen.toImage(iFre);
        
        setFrecuencias(frecuencias);
        setResutado(resultado);
        fs.setImagen(resultado);
        setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(new Rectangle(dim.width / 2 - 687 / 2, dim.height / 2 - 435 / 2, 687, 435));
        repaint();
    }//GEN-LAST:event_CargarButtonActionPerformed

    private void CrearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearButtonActionPerformed
        this.fs.crearFiltro();
        this.filtro = fs.getFiltro();
        this.setResutado(filtro);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(new Rectangle(dim.width / 2 - 687 / 2, dim.height / 2 - 435 / 2, 687, 435));
        repaint();
    }//GEN-LAST:event_CrearButtonActionPerformed

    private void PaneFrecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaneFrecMouseClicked
        //Localizacion del frame de frecuencia 375, 278
        Point punto = MouseInfo.getPointerInfo().getLocation();
        int x = (int) punto.getX();
        int y = (int) punto.getY();
        
        select = new Point((x - 375),(y - 278));
        Point selectR = new Point(0,0);
        
        if (select.getX() >= 128 && select.getY() >= 128) {
            int x_1, y_1;
            x_1 = (int) (select.getX() - 128);
            y_1 = (int) (select.getY() - 128);
            selectR = new Point((128-x_1),(128-y_1));
        }
        if (select.getX() <= 128 && select.getY() <= 128) {
            int x_1, y_1;
            x_1 = (int) (128 - select.getX());
            y_1 = (int) (128 - select.getY());
            selectR = new Point((128+x_1),(128+y_1));
        }
        if (select.getX() >= 128 && select.getY() <= 128) {
            int x_1, y_1;
            x_1 = (int) (select.getX() - 128);
            y_1 = (int) (128 - select.getY());
            selectR = new Point((128-x_1),(128+y_1));
        }
        if (select.getX() <= 128 && select.getY() >= 128) {
            int x_1, y_1;
            x_1 = (int) (128 - select.getX());
            y_1 = (int) (select.getY() - 128);
            selectR = new Point((128+x_1),(128-y_1));
        }
        
        System.out.println(select.toString());
        System.out.println(selectR.toString());
        
        
        fs.modificarFiltro(select);
        this.filtro = fs.getFiltro();
        
        fs.modificarFiltro(selectR);
        this.filtro = fs.getFiltro();
        
        
        this.setResutado(filtro);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(new Rectangle(dim.width / 2 - 687 / 2, dim.height / 2 - 435 / 2, 687, 435));
        repaint();
        
    }//GEN-LAST:event_PaneFrecMouseClicked

 
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
            java.util.logging.Logger.getLogger(FiltroSelectivoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FiltroSelectivoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FiltroSelectivoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FiltroSelectivoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FiltroSelectivoFrame().setVisible(true);
            }
        });
    }

    public void setFrecuencias(Image frec){
        JLabel labelImagen;
        
        int ancho = this.PaneFrec.getWidth();
        int alto = this.PaneFrec.getHeight();
        setSize(ancho,alto);
        Image imagenEscalada = AbrirImagen.toBufferedImage(frec).getScaledInstance(ancho,alto, BufferedImage.TYPE_INT_RGB);
        
        this.PaneFrec.removeAll();
        
        this.PaneFrec.setLayout(new BorderLayout());
        labelImagen = new JLabel(new ImageIcon(imagenEscalada));
        
        this.PaneFrec.add(labelImagen, BorderLayout.CENTER);
    }
    
    public void setResutado(Image frec){
        JLabel labelImagen;
        
        int ancho = this.PaneRes.getWidth();
        int alto = this.PaneRes.getHeight();
        setSize(ancho,alto);
        Image imagenEscalada = AbrirImagen.toBufferedImage(frec).getScaledInstance(ancho,alto, BufferedImage.TYPE_INT_RGB);
        
        this.PaneRes.removeAll();
        
        this.PaneRes.setLayout(new BorderLayout());
        labelImagen = new JLabel(new ImageIcon(imagenEscalada));
        
        this.PaneRes.add(labelImagen, BorderLayout.CENTER);
    }  
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalcularButton;
    private javax.swing.JButton CargarButton;
    private javax.swing.JButton CrearButton;
    private javax.swing.JPanel PaneFrec;
    private javax.swing.JPanel PaneRes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

