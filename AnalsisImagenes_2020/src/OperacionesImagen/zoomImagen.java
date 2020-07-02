package OperacionesImagen;

import gui.JframeImagen;
import java.awt.Color;
import java.awt.Image;
import open.AbrirImagen;
import java.awt.image.BufferedImage;
import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import open.ImagePlus;

public class zoomImagen {
    
    public static ImagePlus rotarIzquierda(ImagePlus zoom){
        //Creamos la imagen en buffered
        BufferedImage bi = AbrirImagen.toBufferedImage(zoom.getImagen());
        int n = bi.getHeight();
        //Rotamos la imagen
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-1-i; j++) {
                Color color = new Color(bi.getRGB(i, j));
                bi.setRGB(i, j, bi.getRGB(n-1-j, i));
                bi.setRGB(n-1-j, i, bi.getRGB(n-1-i, n-1-j));
                bi.setRGB(n-1-i, n-1-j, bi.getRGB(j, n-1-i));  
                bi.setRGB(j, n-1-i,color.getRGB());
            }
        }
        //Creamos la imagen plus que vamos a regresar
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        res.setX(zoom.getX());
        res.setY(zoom.getY());
        
        return res;
    }
    
    public static ImagePlus rotarDerecha(ImagePlus zoom){
        //Creamos la imagen en buffered
        BufferedImage bi = AbrirImagen.toBufferedImage(zoom.getImagen());
        int n = bi.getHeight();
        //Rotamos la imagen
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-1-i; j++) {
                Color color = new Color(bi.getRGB(i, j));
                bi.setRGB(i, j, bi.getRGB(j, n-1-i));
                bi.setRGB(j, n-1-i, bi.getRGB(n-1-i, n-1-j));
                bi.setRGB(n-1-i, n-1-j, bi.getRGB(n-1-j, i));
                bi.setRGB(n-1-j, i,color.getRGB());                
                        
//                bi.setRGB(i, j, bi.getRGB(n-1-j, i));
//                bi.setRGB(n-1-j, i, bi.getRGB(n-1-i, n-1-j));
//                bi.setRGB(n-1-i, n-1-j, bi.getRGB(j, n-1-i));  
//                bi.setRGB(j, n-1-i,color.getRGB());
            }
        }
        //Creamos la imagen plus que vamos a regresar
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        res.setX(zoom.getX());
        res.setY(zoom.getY());
        
        return res;
    }
    

    public static ImagePlus transladar(ImagePlus zoom, ImagePlus imagen, int d, int t) {
        //Creamos las Imagenes en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(zoom.getImagen());
        BufferedImage aux = AbrirImagen.toBufferedImage(imagen.getImagen());       
        //Conseguimos las coordenadas relativas
        int xOff = zoom.getX();
        int yOff = zoom.getY();
        
        int x2 = 0;
        int y2 = 0;
        
        if (d == 2) {
            x2 = t;
        }
        if (d == 4) {
            x2 = -t;
        }
        if (d == 1) {
            y2 = t;
        }
        if (d == 3) {
            y2 = -t;
        }
        
        Color color;
        color  = new Color(0,0,255);
        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
                try{
                    bi.setRGB(x, y, aux.getRGB(x+xOff+x2, y+yOff+y2));
                }catch(Exception e){
                    bi.setRGB(x, y, color.getRGB());
                }       
            }
        }
        //Creamos el objeto a retornar, con las nuevas coordenadas relativas
        ImagePlus aux2 = new ImagePlus(AbrirImagen.toImage(bi));
        int newX = zoom.getX()+x2;
        int newY = zoom.getY()+y2;
        aux2.setX(newX);
        aux2.setY(newY);
        
        return aux2;
    }
    
    public static ImagePlus transladar(ImagePlus zoom, ImagePlus imagen, int d) {
        //Creamos las Imagenes en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(zoom.getImagen());
        BufferedImage aux = AbrirImagen.toBufferedImage(imagen.getImagen());       
        //Conseguimos las coordenadas relativas
        int xOff = zoom.getX();
        int yOff = zoom.getY();
        
        int x2 = 0;
        int y2 = 0;
        
        if (d == 2) {
            x2 = 50;
        }
        if (d == 4) {
            x2 = -50;
        }
        if (d == 1) {
            y2 = 50;
        }
        if (d == 3) {
            y2 = -50;
        }
        
        Color color;
        color  = new Color(0,0,255);
        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
                try{
                    bi.setRGB(x, y, aux.getRGB(x+xOff+x2, y+yOff+y2));
                }catch(Exception e){
                    bi.setRGB(x, y, color.getRGB());
                }       
            }
        }
        //Creamos el objeto a retornar, con las nuevas coordenadas relativas
        ImagePlus aux2 = new ImagePlus(AbrirImagen.toImage(bi));
        aux2.setX(zoom.getX()+x2);
        aux2.setX(zoom.getY()+y2);
        
        System.out.println(aux2.getX()+"  "+aux2.getY());
        
        return aux2;
    }
    
    public static ImagePlus zoomIn(ImagePlus io, float r) {
        //Pasamos la imagen original a Buffered y creamos una buffered vacia con el tamaño deseado
        BufferedImage bio = AbrirImagen.toBufferedImage(io.getImagen());
        int w = (int) (io.getImagen().getWidth(null)/r);
        int h = (int) (io.getImagen().getHeight(null)/r);
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);  
        //Definimos el offset para la buffered resultante
        int w2 = (io.getImagen().getWidth(null)-w)/2;
        int h2 = (io.getImagen().getHeight(null)-h)/2;
        Color color;
        

        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
//                System.out.println(x+" "+y+"___"+(x+w2)+" "+( y+h2));
                try{
                    color = new Color(bio.getRGB(x+(w2), y+(h2)));
                }catch(Exception e){
                    color = new Color(1,1,1);
                }
                bi.setRGB(x, y, color.getRGB());
            }
        }
        //Convertimos la imagen aun objeto ImagePlus y le agregamos el inicio 
        //relativo
        ImagePlus aux = new ImagePlus(AbrirImagen.toImage(bi));
        aux.setX(w2);
        aux.setY(h2);
        
        return aux;
    }

    public static Image zoomIn2(Image io, float r) {
        //Pasamos la imagen original a Buffered y creamos una buffered vacia con el tamaño deseado
        BufferedImage bio = AbrirImagen.toBufferedImage(io);
        int w = (int) (io.getWidth(null)/r);
        int h = (int) (io.getHeight(null)/r);
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);  
        //Definimos el offset para la buffered resultante
        int w2 = (io.getWidth(null)-w)/2;
        int h2 = (io.getHeight(null)-h)/2;
        Color color;

        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
//                System.out.println(x+" "+y+"___"+(x+w2)+" "+( y+h2));
                try{
                    color = new Color(bio.getRGB(x+(w2), y+(h2)));
                }catch(Exception e){
                    color = new Color(1,1,1);
                }
                bi.setRGB(x, y, color.getRGB());
            }
        }
        return AbrirImagen.toImage(bi);
    }

    public static void main(String arg[]) {
        Image image = AbrirImagen.openImage();
        ImagePlus imagen = new ImagePlus(image);
        JframeImagen f1 =  new JframeImagen(imagen.getImagen());
        
        ImagePlus zoom = zoomIn(imagen, (float) 1.5);
        JframeImagen f2 =  new JframeImagen(zoom.getImagen());
        
//        zoom = (transladar(zoom, imagen, 2,20));   
//        JframeImagen f3 =  new JframeImagen(zoom.getImagen());

        zoom = rotarIzquierda(zoom);
        zoom = rotarDerecha(zoom);
        JframeImagen f3 =  new JframeImagen(zoom.getImagen());
        
    }


}
