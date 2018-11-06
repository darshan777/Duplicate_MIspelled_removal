package com.validity.demo.service.main;

import com.validity.demo.helper.CsvData;
import java.util.ArrayList;

/**
 * Author Darshan
 */
public interface RemoveMispell {

    public ArrayList<CsvData> removeMissSpell(int file);
    public ArrayList<CsvData> getMispell(int file);
}
