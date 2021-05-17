package uaslp.objetos.exams;

public class MissingScoreException extends RuntimeException{

    private String message;

    public MissingScoreException(int partial) {

        int actualMissingPartial = partial-1;
        message = "Missing partial " +  actualMissingPartial;
    }

    public String getMessage(){
        return message;
    }
}
