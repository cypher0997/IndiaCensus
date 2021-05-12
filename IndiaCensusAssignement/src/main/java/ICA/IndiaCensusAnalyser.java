package ICA;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class IndiaCensusAnalyser {


    public int readIndianCensusCsvData(String csvFilePath) throws IndiaCensusException1 {
        int count =0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
        ) {
            CsvToBean<IndiaCensusData> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(IndiaCensusData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<IndiaCensusData> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                count++;
                IndiaCensusData csvUser = csvUserIterator.next();
            }

        }catch (IOException e) {
            throw new IndiaCensusException1("file not found,or wrong file type", IndiaCensusException1.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch(RuntimeException x){
            throw new IndiaCensusException1("internal issue with file detected", IndiaCensusException1.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        }
        return count;
    }

    public int readIndianStateCodesCsvData(String csvFilePath) throws IndiaCensusException1 {
        int count =0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
        ) {
            CsvToBean<IndiaStateCodes> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(IndiaStateCodes.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<IndiaStateCodes> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                count++;
                IndiaStateCodes csvUser = csvUserIterator.next();
            }

        }catch (IOException e) {
            throw new IndiaCensusException1("file not found,or wrong file type", IndiaCensusException1.ExceptionType.CENSUS_FILE_PROBLEM);
        }catch(RuntimeException x){
            throw new IndiaCensusException1("internal issue with file detected", IndiaCensusException1.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        }
        return count;
    }
}
