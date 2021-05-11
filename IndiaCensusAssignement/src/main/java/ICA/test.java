package ICA;

public class test {
    public static void main(String args[]) throws IndiaCensusException {
        final String INCORRECT_FILE_TYPE = "./src/test/resources/IndiaStateCensusData.pdf";
        IndiaCensusAnalyser ob = new IndiaCensusAnalyser();
        ob.readIndianCensusCsvData(INCORRECT_FILE_TYPE);
    }
}
