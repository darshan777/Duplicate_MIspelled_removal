package com.validity.demo.dao.main;

import com.validity.demo.helper.CsvData;

import java.util.ArrayList;

public interface CsvReader {
    public ArrayList<CsvData> getCsvData(String fileName);
}
