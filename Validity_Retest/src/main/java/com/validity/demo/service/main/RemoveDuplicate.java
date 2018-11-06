package com.validity.demo.service.main;

import com.validity.demo.helper.CsvData;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Author Darshan
 */
public interface RemoveDuplicate {

    public ArrayList<CsvData> CsvDataWithNoDuplicate(int file);
    public ArrayList<CsvData> getDuplicate(int file);
}
