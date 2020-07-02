package OperacionesImagen;

import gui.JframeImagen;
import java.awt.Color;
import java.awt.image.BufferedImage;
import open.AbrirImagen;
import open.ImagePlus;

/**
 * @author Jose Nava
 */
public class PointOperations {
    
    public static ImagePlus controlTemperatura(ImagePlus ip, int t){
        //creamos la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definimos el objeto color
        Color color;
        //Recorremos la imagen
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                //obtenemos el color del pixel en rgb
                color = new Color(bi.getRGB(i, j));
                //obtenemos los componentes de color
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                //segun el valor de t aumentaremos el componente rojo
                // el componente azul
                if (t>=0) {
                    r = r + t;
                    //clamping
                    if (r > 255) {
                        r = 255;
                    }
                }
                if (t<0) {
                    b = b - t;
                    //clamping
                    if (b > 255) {
                        b = 255;
                    }
                }
                //Creamos el nuevo color y lo agregamos al pixel
                color = new Color(r,g,b);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        //Creamos el objeto ImagePlus con la imagen modificada y la regresamos
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }
    
    public static ImagePlus dividir2Umbrales(ImagePlus ip, int tlo, int thi, int c1, int c2){
        //imagen objetivo, umbral alto, umbral bajo, color 1, color 2
        //crear la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definir la variable color
        Color color;
        //hacer la clasificacion segun el umbral en cada pixel
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                color = new Color(bi.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int p = (r+g+b)/3;
                if (p < tlo) {
                    p = c1;
                }
                if (p > thi) {
                    p = c2;
                }
                color = new Color(p,p,p);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        //Crear y retornar el ImagenPlus con la imagen dividida por los umbrales
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }
    
    public static ImagePlus dividirUmbral(ImagePlus ip,int th,int c){
        //crear la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definir la variable color
        Color color;
        //hacer la clasificacion segun el umbral en cada pixel
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                color = new Color(bi.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int p = (r+g+b)/3;
                if (p < th) {
                    p = c;
                }
                color = new Color(p,p,p);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        //Crear y retornar el ImagenPlus con la imagen dividida por los umbrales
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }
    
    public static ImagePlus sacarGradiente(ImagePlus ip){
        //crear la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definir la variable color
        Color color;
        //hacer el gradiente en cada pixel
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                color = new Color(bi.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int p = (r+g+b)/3;
                color = new Color(p,p,p);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        //Crear y retornar el ImagenPlus con la imagen en gradiente
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }
    
    public static ImagePlus invertir(ImagePlus ip){
        //crear la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definir la variable color
        Color color;
        //hacer la inversion en cada pixel
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                color = new Color(bi.getRGB(i, j));
                int r = 255-color.getRed();
                int g = 255-color.getGreen();
                int b = 255-color.getBlue();
                color = new Color((int)r,(int)g,(int)b);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        //Crear y retornar el ImagenPlus con la imagen invertida
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }
    
    public static ImagePlus controlContraste(ImagePlus ip ,double v){
        //crear la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definir la variable color
        Color color;
        //hacer el cambio de contraste en cada pixel
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                color = new Color(bi.getRGB(i, j));
                double r = color.getRed()*v;
                if (r > 255) {
                    r = 255;
                }
                if (r < 0) {
                    r = 0;
                }
                double g = color.getGreen()*v;
                if (g > 255) {
                    g = 255;
                }
                if (g < 0) {
                    g = 0;
                }
                double b = color.getBlue()*v;
                if (b > 255) {
                    b = 255;
                }
                if (b < 0) {
                    b = 0;
                }
                color = new Color((int)r,(int)g,(int)b);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        //Crear y retornar el ImagenPlus con contraste modificado
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }
    
    public static ImagePlus controlBrillo(ImagePlus ip,int v){
        //crear la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definir la variable color
        Color color;
        //hacer el aumento de brillo en cada pixel
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                color = new Color(bi.getRGB(i, j));
                int r = color.getRed()+v;
                if (r > 255) {
                    r = 255;
                }
                if (r < 0) {
                    r = 0;
                }
                int g = color.getGreen()+v;
                if (g > 255) {
                    g = 255;
                }
                if (g < 0) {
                    g = 0;
                }
                int b = color.getBlue()+v;
                if (b > 255) {
                    b = 255;
                }
                if (b < 0) {
                    b = 0;
                }
                color = new Color(r,g,b);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        //Crear y retornar el ImagenPlus con brillo modificado
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }
    
    public static void main(String arg[]){
        ImagePlus im = new ImagePlus(AbrirImagen.openImage());
        JframeImagen f = new JframeImagen(im.getImagen(),"Original");
        Histogram.sacarHistogramaAzul(im.getImagen(), true);
        
//        ImagePlus brillo = controlBrillo(im,30);
//        JframeImagen f1 = new JframeImagen(brillo.getImagen(),"Aumento de Brillo");
//        Histogram.sacarHistograma(brillo.getImagen(), true);
//        
//        brillo = controlBrillo(im,-30);
//        JframeImagen f2 = new JframeImagen(brillo.getImagen(),"Disminusion de Brillo");
//        Histogram.sacarHistograma(brillo.getImagen(), true);
        
//        ImagePlus contrast = controlContraste(im,1.5);
//        JframeImagen f3 = new JframeImagen(contrast.getImagen(),"Aumento de Contraste");
//        Histogram.sacarHistograma(contrast.getImagen(), true);
//        
//        contrast = controlContraste(im,0.5);
//        JframeImagen f4 = new JframeImagen(contrast.getImagen(),"Disminusion de Contraste");
//        Histogram.sacarHistograma(contrast.getImagen(), true);
        
//        ImagePlus invertida = invertir(im);
//        JframeImagen f5 = new JframeImagen(invertida.getImagen(),"Imagen Invertida");
//        Histogram.sacarHistograma(invertida.getImagen(), true);
        
//        ImagePlus gradiente = sacarGradiente(im);
//        JframeImagen f6 = new JframeImagen(gradiente.getImagen(),"Imagen en Gradiente");
//        Histogram.sacarHistograma(gradiente.getImagen(), true);
        
//        ImagePlus umbral = dividirUmbral(im,35,1);
//        JframeImagen f7 = new JframeImagen(umbral.getImagen(),"Imagen dividida con umbral");
//        Histogram.sacarHistograma(umbral.getImagen(), true);
        
//        ImagePlus umbrales = dividir2Umbrales(im,10,150,0,255);
//        JframeImagen f8 = new JframeImagen(umbrales.getImagen(),"Imagen dividida con umbrales");
//        Histogram.sacarHistograma(umbrales.getImagen(), true);
        
        ImagePlus temp = controlTemperatura(im,-15);
        JframeImagen f9 = new JframeImagen(temp.getImagen(),"Imagen con Temperatura Modificada");
        Histogram.sacarHistogramaAzul(temp.getImagen(), true);
        
        
    }
}
