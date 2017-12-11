package Classes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {

    public static void main(String[] args)  {

    }
    public static BufferedImage generate(String content, int sizeInPixels) throws WriterException {
        QRCodeWriter qrWriter = new QRCodeWriter();
        Object matrix = qrWriter.encode(content, BarcodeFormat.QR_CODE, sizeInPixels, sizeInPixels);
        return MatrixToImageWriter.toBufferedImage((BitMatrix) matrix);
    }
}
