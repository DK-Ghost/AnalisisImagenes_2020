package filtrosFrecuencias;

import analisisenfrecuencias.FFT.Gestor;
import analisisenfrecuencias.FFT.NumeroComplejo;
import gui.JframeImagen;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import open.AbrirImagen;

/**
 * @author Jose Nava
 */
public class FiltroSelectivo extends FiltroFrecuencia {

    private Image imagen;
    private Image filtro;
    private Dimension dim;

    FiltroSelectivo(Dimension dime) {
        super((int) dime.getWidth(), (int) dime.getHeight());
        this.dim = dime;
    }

    public void crearFiltro() {
        int tamanoImagen = (int) dim.getWidth();
        for (int i = 0; i < tamanoImagen; i++) {         
            for (int j = 0; j < tamanoImagen; j++) {      
                int u = -1 * (tamanoImagen / 2) + i;
                int v = (tamanoImagen / 2) - j;
                double r = Math.sqrt(Math.pow(u, 2) + Math.pow(v, 2));
                // verificamos con respecto al  radio              
                getFiltroEspacial()[i][j] = new NumeroComplejo(1, 1);              
            }
        }  
        this.filtro = FiltroFrecuencia.toImageDeComplejo(super.getFiltroEspacial());        
    }

    public Image getFiltro() {
        return filtro;
    }

    public void setFiltro(Image filtro) {
        this.filtro = filtro;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
       
    public void modificarFiltro(Point select){  
      int tamanoImagen = (int) dim.getWidth();
      int n = 5;
        for (int i = 0; i < tamanoImagen; i++) {         
            for (int j = 0; j < tamanoImagen; j++) {            
                int u = -1 * (tamanoImagen / 2) + i;
                int v = (tamanoImagen / 2) - j;
                double r = Math.sqrt(Math.pow(u, 2) + Math.pow(v, 2));
                // verificamos con respecto al  radio
                if (i > (select.getX()*2)-n && i < (select.getX()*2)+n) {
                    if (j > (select.getY()*2)-n && j < (select.getY()*2)+n) {
                        getFiltroEspacial()[i][j] = new NumeroComplejo(0, 0);
                    }                    
                }else{  
                }    
            }
        }  
        this.filtro = FiltroFrecuencia.toImageDeComplejo(super.getFiltroEspacial()); 
    }

}
