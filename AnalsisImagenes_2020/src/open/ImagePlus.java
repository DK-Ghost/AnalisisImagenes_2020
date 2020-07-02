/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package open;

import java.awt.Image;

/**
 *
 * @author Sony
 */
public class ImagePlus {
    private Image imagen;
    private int x; 
    private int y;

    public ImagePlus(Image imagen) {
        this.imagen = imagen;
        int x = 0;
        int y = 0;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    } 
    
}
