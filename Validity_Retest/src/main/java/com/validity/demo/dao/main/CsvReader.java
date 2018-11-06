package com.validity.demo.dao.main;

import com.validity.demo.helper.CsvData;

import java.util.ArrayList;

/**
 * Author darshan
 */
public interface CsvReader {

    /**
     * Get Csv Data from Csv file
     * @param fileName
     * @return
     */
    public ArrayList<CsvData> getCsvData(String fileName);
}
