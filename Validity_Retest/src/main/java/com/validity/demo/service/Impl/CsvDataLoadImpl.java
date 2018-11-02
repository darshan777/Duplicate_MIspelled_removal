package com.validity.demo.service.Impl;

import com.validity.demo.dao.impl.CsvReaderImpl;
import com.validity.demo.dao.main.CsvReader;
import com.validity.demo.helper.CsvData;
import com.validity.demo.service.main.CsvDataLoad;

import java.util.ArrayList;

public class CsvDataLoadImpl implements CsvDataLoad {

    @Override
    public boolean loaadCsv(String fileName){
        CsvReader csvReader = new CsvReaderImpl();
        ArrayList<CsvData> csvDataArrayList = csvReader.getCsvData(fileName);
        if(csvDataArrayList!=null){
            return true;
        }
        System.out.println(csvDataArrayList+"SErvice calads");
        return false;
    }
}
