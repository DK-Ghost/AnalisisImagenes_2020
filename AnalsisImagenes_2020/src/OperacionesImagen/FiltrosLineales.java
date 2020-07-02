package OperacionesImagen;

import gui.JframeImagen;
import java.awt.Color;
import java.awt.image.BufferedImage;
import open.AbrirImagen;
import open.ImagePlus;

/**
 * @author Jose Nava
 */
public class FiltrosLineales {

    public static ImagePlus filtroKernel(ImagePlus ip, int[][] k) {
        //creamos la imagen original y la de referencia en el buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        BufferedImage bir = AbrirImagen.toBufferedImage(ip.getImagen());
        Color color;
        //definimos la mitada de los tamaños del kernel
        int K = k[0].length / 2;
        int L = k.length / 2;
        //hacemos la suma de los coeficientes del kernel
        double s = 0;
        for (int i = 0; i < k[0].length; i++) {
            for (int j = 0; j < k.length; j++) {
                s += k[j][i];
            }
        }
        //recorremos la imagen aplicando el filtro
        for (int u = K; u < bi.getWidth() - K - 1; u++) {
            for (int v = L; v < bi.getHeight() - L - 1; v++) {
                //Recorremos el kernel para sacar el bvalor fe I'(u,v)
                double valorR = 0;
                double valorG = 0;
                double valorB = 0;
                for (int i = -K; i <= K; i++) {
                    for (int j = -L; j <= L; j++) {
                        color = new Color(bir.getRGB(u + i, v + j));
                        double r = color.getRed();
                        double g = color.getGreen();
                        double b = color.getBlue();
                        valorR += r * k[j + L][i + K];
                        valorG += g * k[j + L][i + K];
                        valorB += b * k[j + L][i + K];
                    }
                }
                color = new Color((int) (valorR / s), (int) (valorG / s), (int) (valorB / s));
                bi.setRGB(u, v, color.getRGB());
            }
        }
        //Creamos y regresamos el ImagePlus con la imagen suavisada
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }

    public static ImagePlus filtroKernel3x3(ImagePlus ip) {
        //definimos y creamos el filtro kernel
        double[][] k = {{0.075, 0.125, 0.075},
        {0.125, 0.200, 0.125},
        {0.075, 0.125, 0.075}};

        //creamos la imagen original y la de referencia en el buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(ip.getImagen());
        BufferedImage bir = AbrirImagen.toBufferedImage(ip.getImagen());
        Color color;
        //recorremos la imagen aplicando el filtro
        for (int u = 1; u < bi.getWidth() - 1; u++) {
            for (int v = 1; v < bi.getHeight() - 1; v++) {
                //Recorremos el kernel para sacar el bvalor fe I'(u,v)
                double valorR = 0;
                double valorG = 0;
                double valorB = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        color = new Color(bir.getRGB(u + i, v + j));
                        double r = color.getRed();
                        double g = color.getGreen();
                        double b = color.getBlue();
                        valorR += r * k[i + 1][j + 1];
                        valorG += g * k[i + 1][j + 1];
                        valorB += b * k[i + 1][j + 1];
                    }
                }
                color = new Color((int) (valorR), (int) (valorG), (int) (valorB));
                bi.setRGB(u, v, color.getRGB());
            }
        }
        //Creamos y regresamos el ImagePlus con la imagen suavisada
        ImagePlus res = new ImagePlus(AbrirImagen.toImage(bi));
        return res;
    }

    public static void main(String ahg[]) {
        ImagePlus im = new ImagePlus(AbrirImagen.openImage());
        JframeImagen f1 = new JframeImagen(im.getImagen());
        Histogram.sacarHistograma(im.getImagen(), true);

//        ImagePlus kernel = filtroKernel3x3(im);
//        JframeImagen f2 = new JframeImagen(kernel.getImagen());
//        Histogram.sacarHistograma(kernel.getImagen(), true);
        int[][] k = {{0, 0, 1, 1, 1, 0, 0},
        {0, 1, 1, 2, 1, 1, 0},
        {1, 2, 1, 1, 1, 2, 1},
        {0, 1, 1, 2, 1, 1, 0},
        {0, 0, 1, 1, 1, 0, 0}};

        ImagePlus kernel = filtroKernel(im, k);
        JframeImagen f3 = new JframeImagen(kernel.getImagen());
        Histogram.sacarHistograma(kernel.getImagen(), true);

    }
}
