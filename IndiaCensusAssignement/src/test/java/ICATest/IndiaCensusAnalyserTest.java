package ICATest;

import ICA.IndiaCensusAnalyser;
import ICA.IndiaCensusException1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class IndiaCensusAnalyserTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INCORRECT_FILE_TYPE = "./src/test/resources/IndiaStateCensusData.pdf";
    private static final String INDIAN_CENSUS_CSV_WRONG_DELIMITER = "./src/test/resources/IndiaStateCensusWrongData.csv";
    private static final String INDIAN_CENSUS_CSV_HEADER_MISSING =  "./src/test/resources/IndiaStateCensusDataHeaderMissing.csv";
    private static final String INDIA_CENSUS_CSV_SC_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_CSV_SC_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String INCORRECT_SC_FILE_TYPE = "./src/test/resources/IndiaStateCode.pdf";
    private static final String INDIAN_CENSUS_CSV_SC_WRONG_DELIMITER = "./src/test/resources/IndiaStateCodeWrongData.csv";
    private static final String INDIAN_CENSUS_CSV_SC_HEADER_MISSING =  "./src/test/resources/IndiaStateCodeHeaderMissing.csv";
    private Assertions Assert;


    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords()   {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int numOfRecords = censusAnalyser.readIndianCensusCsvData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (IndiaCensusException1 e) {
        }
    }

    @Test
    public void wrongCsvFilePassedAsArguement_test() {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int num = censusAnalyser.readIndianCensusCsvData(WRONG_CSV_FILE_PATH);
            Assert.assertEquals(29,num);
        } catch (IndiaCensusException1 e) {
            Assert.assertEquals(IndiaCensusException1.ExceptionType.CENSUS_FILE_PROBLEM,e.typeOfException);
            System.out.println(e.warning);
        }
    }

    @Test
    public void wrongTypeOfFilePassedAsArguement_test() {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int num = censusAnalyser.readIndianCensusCsvData(INCORRECT_FILE_TYPE);
            Assert.assertEquals(29,num);
        } catch (IndiaCensusException1 e) {
            Assert.assertEquals(IndiaCensusException1.ExceptionType.CENSUS_FILE_PROBLEM,e.typeOfException);
            System.out.println(e.warning);
        }
    }

    @Test
    public void givenWrongDelimiter_InIndiaCensusData_ShouldReturnCustomExceptionType() {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int numOfRecords = censusAnalyser.readIndianCensusCsvData(INDIAN_CENSUS_CSV_WRONG_DELIMITER);
        } catch (IndiaCensusException1 e) {
            Assert.assertEquals(IndiaCensusException1.ExceptionType.CSV_FILE_INTERNAL_ISSUES, e.typeOfException);
            System.out.println(e.warning);
        }
    }

    @Test
    public void givenWrongHeader_InIndiaCensusData_ShouldReturnCustomExceptionType() {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int numOfRecords = censusAnalyser.readIndianCensusCsvData(INDIAN_CENSUS_CSV_HEADER_MISSING);
        } catch (IndiaCensusException1 e) {
            Assert.assertEquals(IndiaCensusException1.ExceptionType.CSV_FILE_INTERNAL_ISSUES, e.typeOfException);
            System.out.println(e.warning);
        }
    }

    @Test
    public void givenIndianCensusCSVStateCodeFileReturnsCorrectRecords()   {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int numOfRecords = censusAnalyser.readIndianStateCodesCsvData(INDIA_CENSUS_CSV_SC_FILE_PATH);
            Assert.assertEquals(37, numOfRecords);
        } catch (IndiaCensusException1 e) {
            System.out.println(e.warning);
        }
    }

    @Test
    public void wrongStateCodeCsvFilePassedAsArguement_test() {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int num = censusAnalyser.readIndianStateCodesCsvData(WRONG_CSV_SC_FILE_PATH);
            Assert.assertEquals(37,num);
        } catch (IndiaCensusException1 e) {
            Assert.assertEquals(IndiaCensusException1.ExceptionType.CENSUS_FILE_PROBLEM,e.typeOfException);
            System.out.println(e.warning);
        }
    }

    @Test
    public void wrongTypeOf_StaeCodeCsvFile_PassedAsArguement_test() {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int num = censusAnalyser.readIndianStateCodesCsvData(INCORRECT_SC_FILE_TYPE);
            Assert.assertEquals(29,num);
        } catch (IndiaCensusException1 e) {
            Assert.assertEquals(IndiaCensusException1.ExceptionType.CENSUS_FILE_PROBLEM,e.typeOfException);
            System.out.println(e.warning);
        }
    }

    @Test
    public void givenWrongDelimiter_InIndiaStateCodeData_ShouldReturnCustomExceptionType() {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int numOfRecords = censusAnalyser.readIndianStateCodesCsvData(INDIAN_CENSUS_CSV_SC_WRONG_DELIMITER);
        } catch (IndiaCensusException1 e) {
            Assert.assertEquals(IndiaCensusException1.ExceptionType.CSV_FILE_INTERNAL_ISSUES, e.typeOfException);
            System.out.println(e.warning);
        }
    }

    @Test
    public void givenWrongHeader_InIndiaStateCodeData_ShouldReturnCustomExceptionType() {
        try {
            IndiaCensusAnalyser censusAnalyser = new IndiaCensusAnalyser();
            int numOfRecords = censusAnalyser.readIndianStateCodesCsvData(INDIAN_CENSUS_CSV_SC_HEADER_MISSING);
        } catch (IndiaCensusException1 e) {
            Assert.assertEquals(IndiaCensusException1.ExceptionType.CSV_FILE_INTERNAL_ISSUES, e.typeOfException);
            System.out.println(e.warning);
        }
    }
    
}

