package OperacionesImagen;

import static OperacionesImagen.FiltrosLineales.filtroKernel;
import gui.JframeImagen;
import java.awt.Color;
import java.awt.image.BufferedImage;
import open.AbrirImagen;
import open.ImagePlus;

/**
 * @author Jose Nava
 */
public class DeteccionBordes {
    
    public static ImagePlus Roberts(ImagePlus ip,boolean f){
        //Definimos los kernel de las primeras derivadas de x y y
        double[][] Hr1 = {{-1,0},
            {0, 1}};
        
        double[][] Hr2 = {{0,1},
            {-1, 0}};
        //Creamos la imagen en buffer asi como la referencia
        BufferedImage bix = AbrirImagen.toBufferedImage(ip.getImagen());
        BufferedImage bir = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definimos la variable color
        Color color;
        //Recorremos la imagen
        for (int i = 1; i < bix.getWidth()-1; i++) {
            for (int j = 1; j < bix.getHeight()-1; j++) {
                //Definimos las variables de componentes a utilizar para cada
                //kernel
                double valorRx = 0;
                double valorGx = 0;
                double valorBx = 0;
                double valorRy = 0;
                double valorGy = 0;
                double valorBy = 0;
                //Recorremos los kernel
                for (int k = -1;k <= 0; k++) {
                    for (int l = 0; l <= 1; l++) {
                        //obtenemos los componentes del pixel
                        color = new Color(bir.getRGB(i + k, j + l));
                        double r = color.getRed();
                        double g = color.getGreen();
                        double b = color.getBlue();
                        //Aplicamos los kernel a los componentes
                        valorRx += r * Hr1[k + 1][l];
                        valorGx += g * Hr1[k + 1][l];
                        valorBx += b * Hr1[k + 1][l];
                    }
                }
                for (int k = -1;k <= 0; k++) {
                    for (int l = -1; l <= 0; l++) {
                        //obtenemos los componentes del pixel
                        color = new Color(bir.getRGB(i + k, j + l));
                        double r = color.getRed();
                        double g = color.getGreen();
                        double b = color.getBlue();
                        //Aplicamos los kernel a los componentes
                        valorRy += r * Hr2[k + 1][l + 1];
                        valorGy += g * Hr2[k + 1][l + 1];
                        valorBy += b * Hr2[k + 1][l + 1];
                    }
                }
                //Convertimos las derivadas al gradiente (i,j)
                valorRx = valorRx + valorRy;
                valorGx = valorGx + valorGy;
                valorBx = valorBx + valorBy;
                valorRx = valorRx/2;
                valorGx = valorGx/2;
                valorBx = valorBx/2;
                //Si la bandera esta activa se calcula la fuerza del borde
                if (f) {
                    valorRx = Math.sqrt((valorRx*valorRx)+(valorRy*valorRy));
                    valorGx = Math.sqrt((valorGx*valorGx)+(valorGy*valorGy));
                    valorBx = Math.sqrt((valorBx*valorBx)+(valorBy*valorBy));
                }
                //Hacemos clamping
                valorRx = clamping(valorRx);
                valorGx = clamping(valorGx);
                valorBx = clamping(valorBx);
                //Agregamos el pixel a la imagen
                color = new Color((int) (valorRx), (int) (valorGx), (int) (valorBx));
                bix.setRGB(i, j, color.getRGB());
            }
        }
        //Creamos y regresamos el ImagePlus con el objeto modificado
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bix));
        return res;
    } 
    
    public static ImagePlus Sobel(ImagePlus ip, boolean f){
        //Definimos los kernel de las primeras derivadas de x y y
        double[][] Hsx = {{-1,0,1},
            {-2, 0, 2},
            {-1,0,1}};
        
        double[][] Hsy = {{-1,-2,-1},
            {0, 0, 0},
            {1,2,1}};
        //Creamos la imagen en buffer asi como la referencia
        BufferedImage bix = AbrirImagen.toBufferedImage(ip.getImagen());
        BufferedImage bir = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definimos la variable color
        Color color;
        //Recorremos la imagen
        for (int i = 1; i < bix.getWidth()-1; i++) {
            for (int j = 1; j < bix.getHeight()-1; j++) {
                //Definimos las variables de componentes a utilizar para cada
                //kernel
                double valorRx = 0;
                double valorGx = 0;
                double valorBx = 0;
                double valorRy = 0;
                double valorGy = 0;
                double valorBy = 0;
                //Recorremos los kernel
                for (int k = -1;k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        //obtenemos los componentes del pixel
                        color = new Color(bir.getRGB(i + k, j + l));
                        double r = color.getRed();
                        double g = color.getGreen();
                        double b = color.getBlue();
                        //Aplicamos los kernel a los componentes
                        valorRx += r * Hsx[k + 1][l + 1];
                        valorGx += g * Hsx[k + 1][l + 1];
                        valorBx += b * Hsx[k + 1][l + 1];
                        valorRy += r * Hsy[k + 1][l + 1];
                        valorGy += g * Hsy[k + 1][l + 1];
                        valorBy += b * Hsy[k + 1][l + 1];
                    }
                }
                //Convertimos las derivadas al gradiente (i,j)
                valorRx = valorRx + valorRy;
                valorGx = valorGx + valorGy;
                valorBx = valorBx + valorBy;
                valorRx = valorRx/8;
                valorGx = valorGx/8;
                valorBx = valorBx/8;
                //Si la bandera esta activa se calcula la fuerza del borde
                if (f) {
                    valorRx = Math.sqrt((valorRx*valorRx)+(valorRy*valorRy));
                    valorGx = Math.sqrt((valorGx*valorGx)+(valorGy*valorGy));
                    valorBx = Math.sqrt((valorBx*valorBx)+(valorBy*valorBy));
                }
                //Hacemos clamping
                valorRx = clamping(valorRx);
                valorGx = clamping(valorGx);
                valorBx = clamping(valorBx);
                //Agregamos el pixel a la imagen
                color = new Color((int) (valorRx), (int) (valorGx), (int) (valorBx));
                bix.setRGB(i, j, color.getRGB());
            }
        }
        //Creamos y regresamos el ImagePlus con el objeto modificado
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bix));
        return res;
    }
    
    public static ImagePlus Prewitt(ImagePlus ip,boolean f){
        //Definimos los kernel de las primeras derivadas de x y y
        double[][] Hpx = {{-1,0,1},
            {-1, 0, 1},
            {-1,0,1}};
        
        double[][] Hpy = {{-1,-1,-1},
            {0, 0, 0},
            {1,1,1}};
        //Creamos la imagen en buffer asi como la referencia
        BufferedImage bix = AbrirImagen.toBufferedImage(ip.getImagen());
        BufferedImage bir = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definimos la variable color
        Color color;
        //Recorremos la imagen
        for (int i = 1; i < bix.getWidth()-1; i++) {
            for (int j = 1; j < bix.getHeight()-1; j++) {
                //Definimos las variables de componentes a utilizar para cada
                //kernel
                double valorRx = 0;
                double valorGx = 0;
                double valorBx = 0;
                double valorRy = 0;
                double valorGy = 0;
                double valorBy = 0;
                //Recorremos los kernel
                for (int k = -1;k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        //obtenemos los componentes del pixel
                        color = new Color(bir.getRGB(i + k, j + l));
                        double r = color.getRed();
                        double g = color.getGreen();
                        double b = color.getBlue();
                        //Aplicamos los kernel a los componentes
                        valorRx += r * Hpx[k + 1][l + 1];
                        valorGx += g * Hpx[k + 1][l + 1];
                        valorBx += b * Hpx[k + 1][l + 1];
                        valorRy += r * Hpy[k + 1][l + 1];
                        valorGy += g * Hpy[k + 1][l + 1];
                        valorBy += b * Hpy[k + 1][l + 1];
                    }
                }
                //Convertimos las derivadas al gradiente (i,j)
                valorRx = valorRx + valorRy;
                valorGx = valorGx + valorGy;
                valorBx = valorBx + valorBy;
                valorRx = valorRx/6;
                valorGx = valorGx/6;
                valorBx = valorBx/6;
                //Si la bandera esta activa se calcula la fuerza del borde
                if (f) {
                    valorRx = Math.sqrt((valorRx*valorRx)+(valorRy*valorRy));
                    valorGx = Math.sqrt((valorGx*valorGx)+(valorGy*valorGy));
                    valorBx = Math.sqrt((valorBx*valorBx)+(valorBy*valorBy));
                }
                //Hacemos clamping
                valorRx = clamping(valorRx);
                valorGx = clamping(valorGx);
                valorBx = clamping(valorBx);
                //Agregamos el pixel a la imagen
                color = new Color((int) (valorRx), (int) (valorGx), (int) (valorBx));
                bix.setRGB(i, j, color.getRGB());
            }
        }
        //Creamos y regresamos el ImagePlus con el objeto modificado
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bix));
        return res;
    }
    
    private static double clamping(double d) {
        if (d > 255) {
            return 255;
        }
        if (d < 0) {
            return 0;
        }
        return d;
    }
    
    public static void main(String ahg[]) {
        ImagePlus im = new ImagePlus(AbrirImagen.openImage());
//        JframeImagen f1 = new JframeImagen(im.getImagen());
//        Histogram.sacarHistograma(im.getImagen(), true);
        
//        ImagePlus prewit = Prewitt(im,true);
//        JframeImagen f2 = new JframeImagen(prewit.getImagen());
//        Histogram.sacarHistograma(prewit.getImagen(), true);
        
//        ImagePlus sobel = Sobel(im,true);
//        JframeImagen f3 = new JframeImagen(sobel.getImagen());
//        Histogram.sacarHistograma(sobel.getImagen(), true);
//        
        ImagePlus roberts = Roberts(im,true);
        JframeImagen f4 = new JframeImagen(roberts.getImagen());
        Histogram.sacarHistograma(roberts.getImagen(), true);
        

    }
   
}
