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
import com.itextpdf.text.DocumentException;

public class QRCodeGenerator {

    public BufferedImage getQRCode(String content, int size) throws DocumentException, IOException, WriterException {
        //String filename = "qrcode" + this.getCode() + ".png";
        return generate(content, size);
    }

    private BufferedImage generate(String content, int sizeInPixels) throws WriterException {
        QRCodeWriter qrWriter = new QRCodeWriter();
        Object matrix = qrWriter.encode(content, BarcodeFormat.QR_CODE, sizeInPixels, sizeInPixels);
        return MatrixToImageWriter.toBufferedImage((BitMatrix) matrix);
    }

}
