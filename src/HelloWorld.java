
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

/**
 * First iText example: Hello World.
 */
public class HelloWorld {

    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "D:\\hello.pdf";

    /**
     * Creates a PDF file: hello.pdf
     * @param    args    no arguments needed
     */
    public static void main(String[] args)
    	throws DocumentException, IOException {
    	new HelloWorld().createPdf(RESULT);
    }

    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException
     * @throws    IOException
     */
    public void createPdf(String filename)
	throws DocumentException, IOException {
    	//
    	Chunk glue = 	new Chunk(new VerticalPositionMark());
    	Paragraph p = new Paragraph();
    	p.add(new Chunk(glue));
    	p.add("lol je suis a droite !");

        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        document.add(p);
        // step 5
        document.close();
    }

}