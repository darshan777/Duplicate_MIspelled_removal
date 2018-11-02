package com.validity.demo.service.Impl;

import com.validity.demo.dao.impl.CsvReaderImpl;
import com.validity.demo.dao.main.CsvReader;
import com.validity.demo.helper.CsvData;
import com.validity.demo.service.main.RemoveDuplicate;
import javafx.util.Pair;

import java.util.*;

public class RemoveDuplicateImpl implements RemoveDuplicate {

    /**
     *
     * @return Arraylist of csv data
     * removing exact duplicates form the list
     */
    @Override
    public ArrayList<CsvData> CsvDataWithNoDuplicate(){
        ArrayList<CsvData> CsvDataNoDuplicate = new ArrayList<>();
        CsvReader csvReader = new CsvReaderImpl();
        CsvDataNoDuplicate = csvReader.getCsvData("");
        ArrayList<CsvData> miss = new ArrayList<>();
        for(int i=0; i<CsvDataNoDuplicate.size()-1; i++ ) {
            for(int j = i+1; j<CsvDataNoDuplicate.size(); j++) {
                if((CsvDataNoDuplicate.get(i).getEmail().equals(CsvDataNoDuplicate.get(j).getEmail()))&&(CsvDataNoDuplicate.get(i).getFirst_name().equals(CsvDataNoDuplicate.get(j).getFirst_name()))&&(CsvDataNoDuplicate.get(i).getLast_name().equals(CsvDataNoDuplicate.get(j).getLast_name()))) {
                    if(miss.contains(CsvDataNoDuplicate.get(i))) {
                        miss.add(CsvDataNoDuplicate.get(j));
                    }
                    else {
                        miss.add(CsvDataNoDuplicate.get(i));
                    }
                }
            }
        }
        return miss;
    }
}
