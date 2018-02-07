package Classes;

import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface Sortable {

    void creerSortie() throws DocumentException, IOException, WriterException;

}
