
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
        //Paragraph P = new Paragraph();
        //Phrase a = new Phrase("lalala");
        //Chunk glue = new Chunk(new VerticalPositionMark());
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(code + nom + ".pdf"));
            document.open();
            document.add(createFirstTable());
            document.close(); // no need to close PDFwriter?
        }catch (FileNotFoundException ex){

        }catch (DocumentException exc){

        }
	}

	public static void main(String[] args)
        	throws DocumentException, IOException {
        	PDF.createPDF("pouet", "coucou", "yay","desc","cher");
    }
    public static PdfPTable createFirstTable() {
        // a table with three columns
        PdfPTable table = new PdfPTable(2);
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("Cell with colspan 3"));
        cell.setColspan(1);
        table.addCell(cell);
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(1);
        table.addCell(cell);
        return table;
    }

}
