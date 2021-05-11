package ICA;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class IndiaCensusAnalyser {


    public int readIndianCensusCsvData(String csvFilePath) throws IndiaCensusException {
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
                System.out.println("state: " + csvUser.getState());
                System.out.println("population : " + csvUser.getPopulation());
                System.out.println("density : " + csvUser.getDensityPerSqKm());
                System.out.println("area: " + csvUser.getAreaInSqKm());
                System.out.println("==========================");
            }

        } catch (IOException e) {
            throw new IndiaCensusException("file not found,or wrong file path", IndiaCensusException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
        return count;
    }
}
