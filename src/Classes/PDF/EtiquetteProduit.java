package Classes.PDF;

import Classes.Produit;
import Classes.QRCodeGenerator;
import com.google.zxing.WriterException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class EtiquetteProduit extends DocumentProduit {

	public EtiquetteProduit(String fileName, List<Produit> listeProduits){
		super(fileName, listeProduits);
	}

	public void creerSortie() throws DocumentException, IOException, WriterException {
		Document document = new Document();
		Chunk glue = new Chunk(new VerticalPositionMark());
		//Paragraph p = new Paragraph();
		//p.add("Test");
		//document.add(p);

		PdfWriter.getInstance(document, new FileOutputStream(this.getFileName()));
		document.open();

		for (int i=0; i<this.getListeProduits().size(); i++) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			QRCodeGenerator qrGenerator = new QRCodeGenerator();
			ImageIO.write(qrGenerator.getQRCode(this.getListeProduits().get(0).getCode(), 50), "png", baos);
			Image iTextImage = Image.getInstance(baos.toByteArray());
			PdfPTable table = new PdfPTable(1);
			// the cell object
			PdfPCell cell;
			// now we add a cell with rowspan 2
			cell = new PdfPCell();
			cell.addElement(iTextImage);
			cell.setRowspan(1);
			table.addCell(cell);
			document.add(table);
		}

		document.close();
	}
	
}
