package ICA;

public class IndiaCensusException extends Exception{
    public String warnign;
    public IndiaCensusException(String message){
        this.warnign =message;
    }
}
