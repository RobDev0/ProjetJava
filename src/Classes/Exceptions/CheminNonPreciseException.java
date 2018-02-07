package Classes.Exceptions;

import java.io.FileNotFoundException;

public class CheminNonPreciseException extends FileNotFoundException{

    private String msg;

    public CheminNonPreciseException(String msg){
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return "Vous n'avez pas précisé de fichier : " + this.msg;
    }

}
