package Classes.CSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFileHelper {

    public static List<String> readFile(File file) {
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
            System.out.println("Ce fichier n'a pas pu être chargé, arrêt du programme");
        }catch (IOException IOex){
            System.out.println("Une erreur est survenue lors de la lecture / fermeture du fichier, arrêt du programme");
        }
        return null;
    }

    public static String getResourcePath(String fileName) {
        final File f = new File("");
        final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
        return dossierPath;
    }

    public static File getResource(String fileName) {
        final String completeFileName = getResourcePath(fileName);
        File file = new File(completeFileName);
        return file;
    }

}
