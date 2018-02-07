package Classes.CSV;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CSVAdapteur extends CsvFileHelper {

    private File file;

    CSVAdapteur(String fileName){
        this.file = this.getResource(fileName);
    }

    List<List<String>> getContentLinesList(){
        List<List<String>> allLinesList = new ArrayList<>();
        List<String> fileContent = this.readFile(this.file);
        if (fileContent != null) {
            for (int i = 0; i < fileContent.size(); i++) {
                if (i > 0) {
                    String[] lineContent = fileContent.get(i).split(";");
                    List<String> linesList = new ArrayList<>();
                    for (int j = 0; j < lineContent.length; j++) {
                        linesList.add(lineContent[j]);
                    }
                    allLinesList.add(linesList);
                }
            }
        }
        return allLinesList;
    }

    public List<String> getHeadersList(){
        List<String> fileContent = this.readFile(this.file);
        String[] lineContent = fileContent.get(0).split(";");
        List<String> headersList = new ArrayList<>();
        for (int i = 0; i < lineContent.length; i++) {
            headersList.add(lineContent[i]);
        }
        return headersList;
    }

}
