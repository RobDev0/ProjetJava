
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Classes.Produit;
import Classes.QRCodeGenerator;
import com.google.zxing.WriterException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import javax.imageio.ImageIO;

/**
 * First iText example: Hello World.
 */
public class PdfEtiquette {

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException
     * @throws    IOException
     */
    public void createEtiquette(String filename, List<Produit> productsList)
	throws DocumentException, IOException, WriterException {
    	//
    	Chunk glue = new Chunk(new VerticalPositionMark());
    	Paragraph p = new Paragraph();

        // step 1
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();

        for (int i=0; i<productsList.size(); i++) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            QRCodeGenerator qrGenerator = new QRCodeGenerator();
            ImageIO.write(qrGenerator.getQRCode(productsList.get(i).getCode()), "png", baos);
            Image iTextImage = Image.getInstance(baos.toByteArray());
            p.add(new Chunk(glue));
            document.add(iTextImage);
        }


        document.add(p);
        document.close();
    }

}