package Classes.PDF;

import Classes.Produit;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class FicheProduit extends DocumentProduit {

	public FicheProduit(String fileName, List<Produit> listeProduits){
		super(fileName, listeProduits);
	}

	public void creerSortie() {
		Font f1 = new Font(Font.FontFamily.TIMES_ROMAN, 12f);
		Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 30.0f, Font.BOLD);
		Document document = new Document(PageSize.A4, 30, 30, 30 ,30);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(this.getFileName()));
		document.open();
		int i=0;
		for (Produit p: this.getListeProduits()) {
			Paragraph P = new Paragraph();
			Phrase a = new Phrase("lalala");
			Chunk glue = new Chunk(new VerticalPositionMark());
			try {
				P.setFont(f1);
				P.add("Code : " + p.getCode());
				P.add(Chunk.NEWLINE);
				P.add(Chunk.NEWLINE);
				P.add(new Chunk(glue));
				P.add("Catégorie : " + p.getCategorie().toString());
				document.add(P);
				P.clear();
				P.setFont(f2);
				P.add(Chunk.NEWLINE);
				P.add(p.getNom());
				document.add(P);
				P.clear();
				P.setFont(f1);
				P.add(Chunk.NEWLINE);
				P.add(p.getDescription());
				P.add(Chunk.NEWLINE);
				P.add(Chunk.NEWLINE);

				PdfPTable tab = Tableau(1, a);
				Paragraph P2 = new Paragraph();
				P2.add(new Chunk(glue));
				P2.add("Montant HT : " + p.getPrixHT());
				P2.add(Chunk.NEWLINE);
				P2.add(Chunk.NEWLINE);
				P2.add(new Chunk(glue));
				P2.add("TVA : " + p.getTVA());
				P2.add(Chunk.NEWLINE);
				P2.add(Chunk.NEWLINE);
				P2.add(new Chunk(glue));
				P2.add("Montant TTC : " + p.getPrixTTC());
				document.add(P);
				document.add(tab);
				document.add(P2);
				document.newPage();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		document.close(); // no need to close PDFwriter?
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
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
