package ICATest;

import ICA.IndiaCensusAnalyser;
import ICA.IndiaCensusException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class IndiaCensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private Assertions Assert;


    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords()   {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int numOfRecords = censusAnalyser.readIndianCensusCsvData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (IOException e) {
        }
    }
}
