package com.validity.demo.dao.impl;

import com.opencsv.CSVReader;
import com.validity.demo.dao.main.CsvReader;
import com.validity.demo.helper.CsvData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * Darshan
 */
public class CsvReaderImpl implements CsvReader {

    /**
     * @param fileName
     * @return ArrayList
     * This method returns An Arraylist of csv data
     */
    @Autowired
    private ResourceLoader res;

    private final static Logger LOGGER = Logger.getLogger("com.validity.demo");

    @Override
    public ArrayList<CsvData> getCsvData(String fileName){
        ArrayList<CsvData> csvDataList = new ArrayList<>();
        try {
            Handler fileHandler  = null;
            fileHandler  = new FileHandler( "./applicationLogs.log");
            LOGGER.setUseParentHandlers(false);
            LOGGER.addHandler(fileHandler);
            //passing the fle path for reading csv
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader, ',', '"', 1);
            LOGGER.info("Parsing csv to read");
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                CsvData personData = new CsvData();
                personData.setId(Integer.parseInt(nextRecord[0]));
                personData.setFirst_name(nextRecord[1]);
                personData.setLast_name(nextRecord[2]);
                personData.setCompany(nextRecord[3]);
                personData.setEmail(nextRecord[4]);
                personData.setAddress1(nextRecord[5]);
                personData.setAddress2(nextRecord[6]);
                String zipcode = String.valueOf(nextRecord[7]);
                if(zipcode == "" || zipcode == null)
                {
                    personData.setZip("null");
                }
                else
                {
                    personData.setZip(zipcode);
                }
                personData.setCity(nextRecord[8]);
                personData.setState_long(nextRecord[9]);
                personData.setState(nextRecord[10]);
                personData.setPhone(nextRecord[11]);
                csvDataList.add(personData);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("csv Loaded into a list");
        return  csvDataList;
    }
}
