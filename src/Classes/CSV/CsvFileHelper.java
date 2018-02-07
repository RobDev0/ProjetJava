package Classes.CSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class CsvFileHelper {

    List<String> readFile(File file) {
        List<String> result = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                result.add(line);
            }
            br.close();
            fr.close();
            return result;
        }catch (FileNotFoundException FnFex){
            System.out.println("Le fichier d'entrée n'a pas pu être chargé, arrêt du programme");
            System.out.println("path : " + file.getAbsolutePath());
        }catch (IOException IOex){
            System.out.println("Une erreur est survenue lors de la lecture / fermeture du fichier d'entrée, arrêt du programme");
        }
        return null;
    }

    private String getResourcePath(String fileName) {
        final File f = new File("");
        return f.getAbsolutePath() + File.separator + fileName;
    }

    File getResource(String fileName) {
        final String completeFileName = getResourcePath(fileName);
        return new File(completeFileName);
    }

}
