package OperacionesImagen;

import gui.JframeImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import open.AbrirImagen;
import open.ImagePlus;

/**
 * @author Jose Nava
 */
public class Histogram {

    public static double calcularVariance(Image io) {
        //obtenemos el histograma
        int[] h = sacarHistograma(io, false);
        //Calculamos el A
        double A = 0;
        for (int i = 0; i < h.length; i++) {
            A += i * h[i];
        }
        A = A * A;
        //Calculamos el B
        double B = 0;
        for (int i = 0; i < h.length; i++) {
            B += (i * i) * h[i];
        }
        //Definimos la variable C asi como M y N 
        double M = io.getWidth(null);
        double N = io.getHeight(null);
        double C;
        C = B - ((1 / (M * N)) * A);
        //Calculamos la varianza
        double variance;
        variance = (1 / (M * N)) * C;
        return variance;
    }

    public static double calcularMean(Image io) {
        //obtenemos el histograma
        int[] h = sacarHistograma(io, false);
        //Calculamos el A
        double A = 0;
        for (int i = 0; i < h.length; i++) {
            A += i * h[i];
        }
        //Definimos la variable mean asi como M y N 
        double mean;
        double M = io.getWidth(null);
        double N = io.getHeight(null);
        //Calculamos el mean
        mean = (1 / (M * N)) * A;
        return mean;
    }

    public static int sacarMinimo(int[] h) {
        //comenzamos la variable minimo
        int minimo = 9999;
        int minValue = 0;
        //buscamos el valor minimo
        for (int i = 0; i < h.length; i++) {
            if (h[i] != 0) {
                if (h[i] < minimo) {
                    minimo = h[i];
                    minValue = i;
                }
            }
        }
        //regresamos el minimo
        return minValue;
    }

    public static int sacarMaximo(int[] h) {
        //comenzamos la variable maximo
        int maximo = 0;
        int maxValue = 0;
        //buscamos el valor maximo
        for (int i = 0; i < h.length; i++) {
            if (h[i] != 0) {
                if (h[i] > maximo) {
                    maximo = h[i];
                    maxValue = i;
                }
            }
        }
        //regresamos el maximo
        return maxValue;
    }

    public static int[] sacarHistogramaCumulativo(Image io, boolean f) {
        //obtenemos el histograma de la imagen
        int[] H = sacarHistograma(io, false);
        //obtenemos el histograma cumulativo de la imagen
        for (int i = 1; i < H.length; i++) {
            H[i] = H[i] + H[i - 1];
        }
        if (f) {
            //Crear la imagen en bufer del tamaño deseado
            BufferedImage hist = new BufferedImage(256 * 2, 200 * 2, BufferedImage.TYPE_INT_RGB);
            //declarar el color que usaremos para llenar el histograma
            Color color = new Color(255, 255, 255);
            //Conseguir el valor maximo del histograma para poder realizar el clamping en la imagen
            double maximo = 0;
            for (int i = 0; i < H.length; i++) {
                maximo = Math.max(maximo, H[i]);
            }
            //Definimos la constante de aumento para duplicar el ancho del histograma
            int c = 1;
            //rellenamos el histograma
            for (int i = 0; i < H.length; i++) {
                for (int j = hist.getHeight() - 1; j >= hist.getHeight() - ((H[i] / maximo) * hist.getHeight()); j--) {
                    hist.setRGB(i + c, j, color.getRGB());
                    if (i != H.length - 1) {
                        hist.setRGB(i + c + 1, j, color.getRGB());
                    }
                }
                c += 1;
            }
            //mostramos el histograma
            JframeImagen f1 = new JframeImagen(hist, "Histograma Cumulativo");
        }
        return H;
    }

    public static int[] sacarHistogramaAzul(Image io, boolean f) {
        //Definir el histograma
        double[] h = new double[256];
        //Definir la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        //Definir el color
        Color color;
        //Recorrer la imagen y llenar el arreglo de histograma
        for (int u = 0; u < bi.getWidth(); u++) {
            for (int v = 0; v < bi.getHeight(); v++) {
                //obtenemos el rgb del pixel y sacamos su valor segun sus componentes
                color = new Color(bi.getRGB(u, v));
                int r = color.getBlue();
                h[r] += 1;
            }
        }
        if (f) {
            //Crear la imagen en bufer del tamaño deseado
            BufferedImage hist = new BufferedImage(256 * 2, 200 * 2, BufferedImage.TYPE_INT_RGB);
            //declarar el color que usaremos para llenar el histograma
            color = new Color(0, 0, 255);
            //Conseguir el valor maximo del histograma para poder realizar el clamping en la imagen
            double maximo = 0;
            for (int i = 0; i < h.length; i++) {
                maximo = Math.max(maximo, h[i]);
            }
            //Definimos la constante de aumento para duplicar el ancho del histograma
            int c = 1;
            //rellenamos el histograma
            for (int i = 0; i < h.length; i++) {
                for (int j = hist.getHeight() - 1; j >= hist.getHeight() - ((h[i] / maximo) * hist.getHeight()); j--) {
                    hist.setRGB(i + c, j, color.getRGB());
                    if (i != h.length - 1) {
                        hist.setRGB(i + c + 1, j, color.getRGB());
                    }
                }
                c += 1;
            }
            //mostramos el histograma
            JframeImagen f1 = new JframeImagen(hist, "Histograma Azul");
        }
        //convertimos el arreglo del histograma a un arreglo de enteros
        int[] h2 = new int[256];
        for (int i = 0; i < h2.length; i++) {
            h2[i] = (int) h[i];
        }
        return h2;
    }

    public static int[] sacarHistogramaVerde(Image io, boolean f) {
        //Definir el histograma
        double[] h = new double[256];
        //Definir la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        //Definir el color
        Color color;
        //Recorrer la imagen y llenar el arreglo de histograma
        for (int u = 0; u < bi.getWidth(); u++) {
            for (int v = 0; v < bi.getHeight(); v++) {
                //obtenemos el rgb del pixel y sacamos su valor segun sus componentes
                color = new Color(bi.getRGB(u, v));
                int r = color.getGreen();
                h[r] += 1;
            }
        }
        if (f) {
            //Crear la imagen en bufer del tamaño deseado
            BufferedImage hist = new BufferedImage(256 * 2, 200 * 2, BufferedImage.TYPE_INT_RGB);
            //declarar el color que usaremos para llenar el histograma
            color = new Color(0, 255, 0);
            //Conseguir el valor maximo del histograma para poder realizar el clamping en la imagen
            double maximo = 0;
            for (int i = 0; i < h.length; i++) {
                maximo = Math.max(maximo, h[i]);
            }
            //Definimos la constante de aumento para duplicar el ancho del histograma
            int c = 1;
            //rellenamos el histograma
            for (int i = 0; i < h.length; i++) {
                for (int j = hist.getHeight() - 1; j >= hist.getHeight() - ((h[i] / maximo) * hist.getHeight()); j--) {
                    hist.setRGB(i + c, j, color.getRGB());
                    if (i != h.length - 1) {
                        hist.setRGB(i + c + 1, j, color.getRGB());
                    }
                }
                c += 1;
            }
            //mostramos el histograma
            JframeImagen f1 = new JframeImagen(hist, "Histograma Verde");
        }
        //convertimos el arreglo del histograma a un arreglo de enteros
        int[] h2 = new int[256];
        for (int i = 0; i < h2.length; i++) {
            h2[i] = (int) h[i];
        }
        return h2;
    }

    public static int[] sacarHistogramaRojo(Image io, boolean f) {
        //Definir el histograma
        double[] h = new double[256];
        //Definir la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        //Definir el color
        Color color;
        //Recorrer la imagen y llenar el arreglo de histograma
        for (int u = 0; u < bi.getWidth(); u++) {
            for (int v = 0; v < bi.getHeight(); v++) {
                //obtenemos el rgb del pixel y sacamos su valor segun sus componentes
                color = new Color(bi.getRGB(u, v));
                int r = color.getRed();;
                h[r] += 1;
            }
        }
        if (f) {
            //Crear la imagen en bufer del tamaño deseado
            BufferedImage hist = new BufferedImage(256 * 2, 200 * 2, BufferedImage.TYPE_INT_RGB);
            //declarar el color que usaremos para llenar el histograma
            color = new Color(255, 0, 0);
            //Conseguir el valor maximo del histograma para poder realizar el clamping en la imagen
            double maximo = 0;
            for (int i = 0; i < h.length; i++) {
                maximo = Math.max(maximo, h[i]);
            }
            //Definimos la constante de aumento para duplicar el ancho del histograma
            int c = 1;
            //rellenamos el histograma
            for (int i = 0; i < h.length; i++) {
                for (int j = hist.getHeight() - 1; j >= hist.getHeight() - ((h[i] / maximo) * hist.getHeight()); j--) {
                    hist.setRGB(i + c, j, color.getRGB());
                    if (i != h.length - 1) {
                        hist.setRGB(i + c + 1, j, color.getRGB());
                    }
                }
                c += 1;
            }
            //mostramos el histograma
            JframeImagen f1 = new JframeImagen(hist, "Histograma Rojo");
        }
        //convertimos el arreglo del histograma a un arreglo de enteros
        int[] h2 = new int[256];
        for (int i = 0; i < h2.length; i++) {
            h2[i] = (int) h[i];
        }
        return h2;
    }

    public static int[] sacarHistograma(Image io, boolean f) {
        //Definir el histograma
        double[] h = new double[256];
        //Definir la imagen en buffer
        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        //Definir el color
        Color color;
        //Recorrer la imagen y llenar el arreglo de histograma
        for (int u = 0; u < bi.getWidth(); u++) {
            for (int v = 0; v < bi.getHeight(); v++) {
                //obtenemos el rgb del pixel y sacamos su valor segun sus componentes
                color = new Color(bi.getRGB(u, v));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                r = (r + g + b) / 3;
                h[r] += 1;
            }
        }
        if (f) {
            //Crear la imagen en bufer del tamaño deseado
            BufferedImage hist = new BufferedImage(256 * 2, 200 * 2, BufferedImage.TYPE_INT_RGB);
            //declarar el color que usaremos para llenar el histograma
            color = new Color(255, 255, 255);
            //Conseguir el valor maximo del histograma para poder realizar el clamping en la imagen
            double maximo = 0;
            for (int i = 0; i < h.length; i++) {
                maximo = Math.max(maximo, h[i]);
            }
            //Definimos la constante de aumento para duplicar el ancho del histograma
            int c = 1;
            //rellenamos el histograma
            for (int i = 0; i < h.length; i++) {
                for (int j = hist.getHeight() - 1; j >= hist.getHeight() - ((h[i] / maximo) * hist.getHeight()); j--) {
                    hist.setRGB(i + c, j, color.getRGB());
                    if (i != h.length - 1) {
                        hist.setRGB(i + c + 1, j, color.getRGB());
                    }
                }
                c += 1;
            }
            //mostramos el histograma
            JframeImagen f1 = new JframeImagen(hist, "Histograma");
        }
        //convertimos el arreglo del histograma a un arreglo de enteros
        int[] h2 = new int[256];
        for (int i = 0; i < h2.length; i++) {
            h2[i] = (int) h[i];
        }
        return h2;
    }

    public static void main(String arg[]) {
        ImagePlus im = new ImagePlus(AbrirImagen.openImage());
        JframeImagen f = new JframeImagen(im.getImagen());

        int[] hist = sacarHistograma(im.getImagen(), true);
//        
//        hist = sacarHistogramaRojo(im.getImagen(), true);
//        
//        hist = sacarHistogramaVerde(im.getImagen(), true);
//        
//        hist = sacarHistogramaAzul(im.getImagen(), true);

//        int [] histCum = sacarHistogramaCumulativo(im.getImagen(),true); 
//        int max = sacarMaximo(hist);
//        System.out.println(max);
//        int min = sacarMinimo(hist);
//        System.out.println(min);
//        double mean = calcularMean(im.getImagen());
//        System.out.println(mean);
        double variance = calcularVariance(im.getImagen());
        System.out.println(Math.sqrt(variance));

    }
}
