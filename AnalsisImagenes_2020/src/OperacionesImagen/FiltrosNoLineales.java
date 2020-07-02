package OperacionesImagen;

import gui.JframeImagen;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import open.AbrirImagen;
import open.ImagePlus;

/**
 * @author Jose Nava
 */
public class FiltrosNoLineales {

    public static ImagePlus medianFilterW(ImagePlus ip){
        //Definimos el kernel
        int[][]k = {{1,2,1},
            {2,3,2},
            {1,2,1}};
        //Definimos el tamaño del array a ordenar
        int s = 0;
        for (int i = 0; i < k[0].length; i++) {
            for (int j = 0; j < k.length; j++) {
                s+= k[i][j];
            }
        }
        //Definimos la imagen original y la de referencia en bufer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        BufferedImage bir = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definimos el color
        Color color;
        //Recorremos la imagen
        for (int i = 1; i < bi.getWidth()-1; i++) {
            for (int j = 1; j < bi.getHeight()-1; j++) {
                //Definimos los arreglos por color y la pocision
                int[] R = new int[s];
                int[] G = new int[s];
                int[] B = new int[s];
                int p = 0;
                //Recorremos el kernel
                for (int l = -1; l <= 1; l++) {
                    for (int m = -1; m <= 1; m++) {
                        //Rellenamos los arreglos de cada color
                        color = new Color(bir.getRGB(i+l,j+m));
                        for (int n = 0; n < k[l+1][m+1]; n++) {
                            R[p] = color.getRed();
                            G[p] = color.getGreen();
                            B[p] = color.getBlue();
                            p++;
                        }
                    }
                }
                //Ordenamos los arreglos
                Arrays.sort(R);
                Arrays.sort(G);
                Arrays.sort(B);
                //Se crea el nuevo color con la media de cada color
                color = new Color(R[s/2],G[s/2],B[s/2]);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        //Se crea y regresa el Image Plus con el filtro aplicado
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }
    
    public static ImagePlus medianFilter(ImagePlus ip){
        //Definimos el kernel
        int[][]k = {{1,1,1},
            {1,1,1},
            {1,1,1}};
        //Definimos el tamaño del array a ordenar
        int s = k[0].length * k.length;
        //Definimos la imagen original y la de referencia en bufer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        BufferedImage bir = AbrirImagen.toBufferedImage(ip.getImagen());
        //Definimos el color
        Color color;
        //Recorremos la imagen
        for (int i = 1; i < bi.getWidth()-1; i++) {
            for (int j = 1; j < bi.getHeight()-1; j++) {
                //Definimos los arreglos por color y la pocision
                int[] R = new int[s];
                int[] G = new int[s];
                int[] B = new int[s];
                int p = 0;
                //Recorremos el kernel
                for (int l = -1; l <= 1; l++) {
                    for (int m = -1; m <= 1; m++) {
                        //Rellenamos los arreglos de cada color
                        color = new Color(bir.getRGB(i+l,j+m));
                        R[p] = color.getRed();
                        G[p] = color.getGreen();
                        B[p] = color.getBlue();
                        p++;
                    }
                }
                //Ordenamos los arreglos
                Arrays.sort(R);
                Arrays.sort(G);
                Arrays.sort(B);
                //Se crea el nuevo color con la media de cada color
                color = new Color(R[s/2],G[s/2],B[s/2]);
                bi.setRGB(i, j, color.getRGB());
            }
        }
        //Se crea y regresa el Image Plus con el filtro aplicado
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }
    
    public static void main(String ahg[]) {
        ImagePlus im = new ImagePlus(AbrirImagen.openImage());
        JframeImagen f1 = new JframeImagen(im.getImagen());
        Histogram.sacarHistograma(im.getImagen(), true);
        
//        ImagePlus media = medianFilter(im);
//        JframeImagen f2 = new JframeImagen(media.getImagen());
//        Histogram.sacarHistograma(media.getImagen(), true);
        
        ImagePlus mediaW = medianFilter(im);
        JframeImagen f3 = new JframeImagen(mediaW.getImagen());
        Histogram.sacarHistograma(mediaW.getImagen(), true);
        
    }
}
