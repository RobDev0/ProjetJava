import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class CSVReader {
	
	public static void main(String[] args) {

        String csvFile = "D:\\Panchoa\\EPSI\\Cours\\B3\\Java\\test.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] product = line.split(cvsSplitBy);

                System.out.println("Produit : " + product[1] + "; Description : " + product[2]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
