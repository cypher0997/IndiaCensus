package ICA;

public class IndiaCensusException extends Exception{
    public String warning;

    public IndiaCensusException(String message){
        this.warning =message;
    }
    public enum ExceptionType {
        CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE,  NO_CENSUS_DATA, CSV_FILE_INTERNAL_ISSUES
    }
    public ExceptionType typeOfException;

    public IndiaCensusException(String message , ExceptionType type){
        this.warning = message;
        this.typeOfException = type;
    }
}
