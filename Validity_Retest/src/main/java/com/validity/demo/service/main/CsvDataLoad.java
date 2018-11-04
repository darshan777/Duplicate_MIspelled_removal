package com.validity.demo.service.main;

import com.validity.demo.helper.CsvData;

import java.util.ArrayList;

public interface CsvDataLoad {
    public ArrayList<CsvData> loaadCsv(String fileName);
}
