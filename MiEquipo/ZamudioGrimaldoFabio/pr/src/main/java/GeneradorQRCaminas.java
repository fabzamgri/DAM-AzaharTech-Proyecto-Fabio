import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GeneradorQRCaminas {

    public static void main(String[] args) throws Exception {
        String datosAlumno = "ALUMNO:12004217;CENTRO:IES_EL_CAMINAS;CURSO:1DAM";

        // 1. Invocamos a la librería externa para calcular la matriz QR
        QRCodeWriter escritorQR = new QRCodeWriter();
        // Generamos una matriz de 25x25 módulos en memoria
        BitMatrix matriz = escritorQR.encode(datosAlumno, BarcodeFormat.QR_CODE, 25, 25);

        System.out.println("=================================================");
        System.out.println("  CÓDIGO QR EN CONSOLA - ACCESO IES EL CAMINÀS   ");
        System.out.println("  Apunta con la cámara de tu móvil a la pantalla ");
        System.out.println("=================================================\n");

        // 2. Recorrido bidimensional de la matriz en memoria RAM (sin ficheros)
        for (int y = 0; y < matriz.getHeight(); y++) {
            for (int x = 0; x < matriz.getWidth(); x++) {
                // Si la posición tiene bit activo pintamos doble bloque negro "██";
                // si no, pintamos dos espacios en blanco "  "
                if (matriz.get(x, y)) {
                    System.out.print("██");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println(); // Salto a la siguiente fila
        }

        System.out.println("\n[OK] Código QR generado en memoria RAM y renderizado con éxito.");
    }
}