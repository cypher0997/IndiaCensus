package ICA;

public class IndiaCensusException1 extends Exception{
    public String warning;
    public String form;

    public IndiaCensusException1(String message){
        this.warning =message;
    }
    public enum ExceptionType {
        CENSUS_FILE_PROBLEM,CSV_FILE_INTERNAL_ISSUES
    }
    public ExceptionType typeOfException;

    public IndiaCensusException1(String message , ExceptionType type){
        this.warning = message;
        this.typeOfException = type;
    }

    public IndiaCensusException1(String message , ExceptionType type, String form){
        this.warning = message;
        this.typeOfException = type;
        this.form = form;

    }
}
