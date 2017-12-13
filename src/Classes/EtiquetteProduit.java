package Classes;

import com.google.zxing.WriterException;
import com.itextpdf.text.*;
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

	public boolean creerFichierPdf() throws DocumentException, IOException, WriterException {
		Chunk glue = new Chunk(new VerticalPositionMark());
		Paragraph p = new Paragraph();

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(this.getFileName()));
		document.open();

		for (int i=0; i<this.getListeProduits().size(); i++) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			QRCodeGenerator qrGenerator = new QRCodeGenerator();
			ImageIO.write(qrGenerator.getQRCode(this.getListeProduits().get(i).getCode()), "png", baos);
			Image iTextImage = Image.getInstance(baos.toByteArray());
			p.add(new Chunk(glue));
			document.add(iTextImage);
		}


		document.add(p);
		document.close();
		return true;
	}
	
}
