package com.validity.demo.dao.impl;

import com.opencsv.CSVReader;
import com.validity.demo.dao.main.CsvReader;
import com.validity.demo.helper.CsvData;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Darshan
 */
public class CsvReaderImpl implements CsvReader {

    /**
     * @param fileName
     * @return ArrayList
     * This method returns An Arraylist of csv data
     */
    @Override
    public ArrayList<CsvData> getCsvData(String fileName){
        ArrayList<CsvData> csvDataList = new ArrayList<>();
        File ff = new File("src/main/java/com.validity.demo/dao/resource/normal[1].csv");
        String abs = ff.getAbsolutePath();

        System.out.println(abs);
        Path currentDir = Paths.get("/src/main/java/com.validity.demo/dao/resource/normal[1].csv");
        String Path = currentDir.toAbsolutePath().toString();
        System.out.println(fileName);
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader, ',', '"', 1);
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
        System.out.println(csvDataList);
        return  csvDataList;
    }
}
