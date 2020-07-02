package OperacionesImagen;

import gui.JframeImagen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import open.AbrirImagen;
import open.ImagePlus;

public class HerramientasFrame extends javax.swing.JFrame {

    private boolean zoomFlag;
    private boolean abiertaFlag;
    private float value;
    private ImagePlus imagen;
    private ImagePlus imagenZ;

    public HerramientasFrame() {
        initComponents();
        zoomKlistener();
        rotarKlistener();
        zoomFlag = false;
        abiertaFlag = false;
        value = 1;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imagePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        zoomBoton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cargarBoton = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(512, 512));
        jPanel1.setPreferredSize(new java.awt.Dimension(512, 512));

        imagePanel.setBackground(new java.awt.Color(204, 204, 204));
        imagePanel.setMinimumSize(new java.awt.Dimension(512, 512));
        imagePanel.setPreferredSize(new java.awt.Dimension(512, 512));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );

        zoomBoton.setBackground(new java.awt.Color(0, 153, 153));
        zoomBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zoomBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                zoomBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                zoomBotonMouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Zoom");

        javax.swing.GroupLayout zoomBotonLayout = new javax.swing.GroupLayout(zoomBoton);
        zoomBoton.setLayout(zoomBotonLayout);
        zoomBotonLayout.setHorizontalGroup(
            zoomBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zoomBotonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );
        zoomBotonLayout.setVerticalGroup(
            zoomBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zoomBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cargarBoton.setBackground(new java.awt.Color(0, 153, 153));
        cargarBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarBotonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cargarBotonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cargarBotonMouseExited(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Cargar");

        javax.swing.GroupLayout cargarBotonLayout = new javax.swing.GroupLayout(cargarBoton);
        cargarBoton.setLayout(cargarBotonLayout);
        cargarBotonLayout.setHorizontalGroup(
            cargarBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargarBotonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        cargarBotonLayout.setVerticalGroup(
            cargarBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cargarBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cargarBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zoomBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(170, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cargarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(zoomBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zoomBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoomBotonMouseEntered
        zoomBoton.setBackground(new Color(102, 102, 255));
    }//GEN-LAST:event_zoomBotonMouseEntered

    private void zoomBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoomBotonMouseExited
        if (zoomFlag) {
            zoomBoton.setBackground(new Color(0, 51, 51));
        } else {
            zoomBoton.setBackground(new Color(0, 153, 153));
        }
    }//GEN-LAST:event_zoomBotonMouseExited

    private void zoomBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoomBotonMouseClicked
        if (!zoomFlag) {
            zoomBoton.setBackground(new Color(0, 51, 51));
            zoomFlag = true;
        } else {
            zoomBoton.setBackground(new Color(0, 153, 153));
            zoomFlag = false;
        }

    }//GEN-LAST:event_zoomBotonMouseClicked

    private void cargarBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarBotonMouseClicked
        cargarBoton.setBackground(new Color(0, 51, 51));
        cargarImagen();
    }//GEN-LAST:event_cargarBotonMouseClicked

    private void cargarBotonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarBotonMouseEntered
        cargarBoton.setBackground(new Color(102, 102, 255));
    }//GEN-LAST:event_cargarBotonMouseEntered

    private void cargarBotonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarBotonMouseExited
        cargarBoton.setBackground(new Color(0, 153, 153));
    }//GEN-LAST:event_cargarBotonMouseExited

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
            java.util.logging.Logger.getLogger(HerramientasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HerramientasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HerramientasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HerramientasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HerramientasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cargarBoton;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel zoomBoton;
    // End of variables declaration//GEN-END:variables

    private void cargarImagen() {
        //Abrimos la Imagen
        imagen = new ImagePlus(AbrirImagen.openImage());
        imagenZ = new ImagePlus(AbrirImagen.copia(imagen.getImagen()));
        //Ponemos la imagen en el panel
        setImagenPanel(imagen.getImagen());
        setVisible(true);
        abiertaFlag = true;
    }

    private void setImagenPanel(Image imagen) {
        JLabel labelImagen;

        int ancho = this.imagePanel.getWidth();
        int alto = this.imagePanel.getHeight();
        setSize(ancho, alto);
        Image imagenEscalada = AbrirImagen.toBufferedImage(imagen).getScaledInstance(ancho, alto, BufferedImage.TYPE_INT_RGB);

        this.imagePanel.removeAll();

        this.imagePanel.setLayout(new BorderLayout());
        labelImagen = new JLabel(new ImageIcon(imagenEscalada));

        this.imagePanel.add(labelImagen, BorderLayout.CENTER);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(new Rectangle(dim.width / 2 - 931 / 2, dim.height / 2 - 674 / 2, 931, 674));
//        repaint();
    }

    private void rotarKlistener() {
        KeyListener teclado = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //Agregamos los controles para rotar
                if (e.getKeyCode() == 45) {
                    rotarImagen(1);
                }
                if (e.getKeyCode() == 521) {
                    rotarImagen(2);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        this.addKeyListener(teclado);
    }

    private void zoomKlistener() {
        KeyListener teclado = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 90) {
                    if (!zoomFlag) {
                        zoomBoton.setBackground(new Color(0, 51, 51));
                        zoomFlag = true;
                    } else {
                        zoomBoton.setBackground(new Color(0, 153, 153));
                        zoomFlag = false;
                    }
                }
                if (zoomFlag == true) {
                    //Agregamos los controles para acercar, alejar y para transladar
                    if (e.getKeyCode() == 46) {
                        zoomIn();
                    }
                    if (e.getKeyCode() == 44) {
                        zoomOut();
                    }
                    if (e.getKeyCode() == 39) {
                        if ((imagenZ.getX() + imagenZ.getImagen().getWidth(null)) < 492) {
                            translado(2);
                        }
                    }
                    if (e.getKeyCode() == 37) {
                        if (imagenZ.getX() >= 20) {
                            translado(4);
                        }
                    }
                    if (e.getKeyCode() == 40) {
                        if ((imagenZ.getY() + imagenZ.getImagen().getHeight(null)) < 492) {
                            translado(1);
                        }
                    }
                    if (e.getKeyCode() == 38) {
                        if (imagenZ.getY() >= 20) {
                            translado(3);
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        this.addKeyListener(teclado);
    }

    public void zoomIn() {
        if (value <= 4) {
            if (abiertaFlag) {
                value += 0.1;
                ImagePlus aux = zoomImagen.zoomIn(imagen, value);
                imagenZ = aux;
                setImagenPanel(imagenZ.getImagen());
            } else {
                JOptionPane.showMessageDialog(null, "No hay Imagen", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void zoomOut() {
        if (value >= 1.1) {
            if (abiertaFlag) {
                value -= 0.1;
                ImagePlus aux = zoomImagen.zoomIn(imagen, value);
                imagenZ = aux;
                setImagenPanel(imagenZ.getImagen());
            } else {
                JOptionPane.showMessageDialog(null, "No hay Imagen", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void translado(int d) {
        if (abiertaFlag) {
            ImagePlus aux = (zoomImagen.transladar(imagenZ, imagen, d, 20));
            imagenZ = aux;
            setImagenPanel(imagenZ.getImagen());
        } else {
            JOptionPane.showMessageDialog(null, "No hay Imagen", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void rotarImagen(int d) {
        if (abiertaFlag) {
            if (d == 1) {
                ImagePlus aux = zoomImagen.rotarIzquierda(imagen);
                imagen = aux;
                aux = zoomImagen.zoomIn(imagen, value);
                imagenZ = aux;
                setImagenPanel(imagenZ.getImagen());
            }
            if (d == 2) {
                ImagePlus aux = zoomImagen.rotarDerecha(imagen);
                imagen = aux;
                aux = zoomImagen.zoomIn(imagen, value);
                imagenZ = aux;
                setImagenPanel(imagenZ.getImagen());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay Imagen", "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
