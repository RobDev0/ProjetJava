
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
public class PDF {

    public static void createPDF(String code, String nom, String description, String cate, String prix)
	{
    	 Font f1=new Font(FontFamily.TIMES_ROMAN,12f);
    	 Font f2=new Font(FontFamily.TIMES_ROMAN,30.0f,Font.BOLD);
		Document document = new Document();
        Paragraph P = new Paragraph();
        Phrase a = new Phrase("lalala");
        Chunk glue = new Chunk(new VerticalPositionMark());
        try {
        	P.setFont(f1);
            PdfWriter writer = PdfWriter.getInstance(document,
            new FileOutputStream(code+nom+".pdf"));
            P.add("Code : " + code);
            P.add(Chunk.NEWLINE);
            P.add(Chunk.NEWLINE);
            P.add(new Chunk(glue));
            P.add("Catégorie : " + cate);
            document.open();
            document.add(P);
            P.clear();
            P.setFont(f2);
            P.add(Chunk.NEWLINE);
            P.add(nom);
            document.add(P);
            P.clear();
            P.setFont(f1);
            P.add(Chunk.NEWLINE);
            P.add(description);
            P.add(Chunk.NEWLINE);
            P.add(Chunk.NEWLINE);
            PdfPTable tab = Tableau(1,a);
            Paragraph P2 = new Paragraph();
            P2.add(new Chunk(glue));
            P2.add("Montant HT : " + prix);
            P2.add(Chunk.NEWLINE);
            P2.add(Chunk.NEWLINE);
            P2.add(new Chunk(glue));
            P2.add("TVA : 6,04");
            P2.add(Chunk.NEWLINE);
            P2.add(Chunk.NEWLINE);
            P2.add(new Chunk(glue));
            P2.add("Montant TTC : 36,25");
            document.add(P);
            document.add(tab);
            document.add(P2);
            document.close(); // no need to close PDFwriter?

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args)
        	throws DocumentException, IOException {
        	PDF.createPDF("pouet", "coucou", "yay","desc","cher");
        }
	public static PdfPTable Tableau(int size,Phrase string) {
		PdfPTable table = new PdfPTable(size);
        PdfPCell cell = new PdfPCell(string);
        cell.setPaddingLeft(8);
        cell.setPaddingBottom(500);
        table.addCell(cell);
        return table;
	}

}
