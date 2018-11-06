package com.validity.demo.service.Impl;

import com.validity.demo.dao.impl.CsvReaderImpl;
import com.validity.demo.dao.main.CsvReader;
import com.validity.demo.helper.CsvData;
import com.validity.demo.service.main.RemoveDuplicate;
import javafx.util.Pair;
import org.springframework.stereotype.Service;
import java.io.File;
import java.sql.SQLOutput;
import java.util.*;


@Service
public class RemoveDuplicateImpl implements RemoveDuplicate {
    ArrayList<CsvData> miss = new ArrayList<>();
    /**
     *
     * @return Arraylist of csv data
     * removing exact duplicates form the list
     */
    @Override
    public ArrayList<CsvData> CsvDataWithNoDuplicate(int file){
        ArrayList<CsvData> CsvDataNoDuplicate = new ArrayList<>();

        CsvReader csvReader = new CsvReaderImpl();
        if(file == 1){
            File ff = new File("src\\main\\resources\\normal[1].csv");
            CsvDataNoDuplicate = csvReader.getCsvData(ff.getAbsolutePath());
            System.out.println("Normal");
        }
        else if(file == 2){
            File ff = new File("src\\main\\resources\\advanced[1].csv");
            CsvDataNoDuplicate = csvReader.getCsvData(ff.getAbsolutePath());
            System.out.println("Advance ");
        }
        else{
            File ff = new File("src\\main\\resources\\normal[1].csv");
            CsvDataNoDuplicate = csvReader.getCsvData(ff.getAbsolutePath());
        }
        for(int i=0; i<CsvDataNoDuplicate.size()-1; i++ ) {
            for (int j = i + 1; j < CsvDataNoDuplicate.size(); j++) {
                if ((CsvDataNoDuplicate.get(i).getEmail().equals(CsvDataNoDuplicate.get(j).getEmail())) && (CsvDataNoDuplicate.get(i).getFirst_name().equals(CsvDataNoDuplicate.get(j).getFirst_name())) && (CsvDataNoDuplicate.get(i).getPhone().equals(CsvDataNoDuplicate.get(j).getPhone()))) {
                    miss.add(CsvDataNoDuplicate.get(i));
                    miss.add(CsvDataNoDuplicate.get(j));
                    CsvDataNoDuplicate.remove(CsvDataNoDuplicate.get(j));
                }
                if((CsvDataNoDuplicate.get(i).getFirst_name().equals(CsvDataNoDuplicate.get(j).getFirst_name()))&&(CsvDataNoDuplicate.get(i).getEmail().equals(CsvDataNoDuplicate.get(j).getEmail()))){
                    if(CsvDataNoDuplicate.get(j).getPhone().equals("")){
                        miss.add(CsvDataNoDuplicate.get(i));
                        miss.add(CsvDataNoDuplicate.get(j));
                        CsvDataNoDuplicate.remove(CsvDataNoDuplicate.get(j));
                    }
                }
                if((CsvDataNoDuplicate.get(i).getFirst_name().equals(CsvDataNoDuplicate.get(j).getFirst_name()))&&(CsvDataNoDuplicate.get(i).getPhone().equals(CsvDataNoDuplicate.get(j).getPhone()))){
                    if(CsvDataNoDuplicate.get(j).getEmail().equals("")){
                        miss.add(CsvDataNoDuplicate.get(i));
                        miss.add(CsvDataNoDuplicate.get(j));
                        CsvDataNoDuplicate.remove(CsvDataNoDuplicate.get(j));
                    }
                }
                if((CsvDataNoDuplicate.get(i).getEmail().equals(CsvDataNoDuplicate.get(j).getEmail()))&&(CsvDataNoDuplicate.get(i).getPhone().equals(CsvDataNoDuplicate.get(j).getPhone()))){
                    if(CsvDataNoDuplicate.get(j).getFirst_name().equals("")){
                        miss.add(CsvDataNoDuplicate.get(i));
                        miss.add(CsvDataNoDuplicate.get(j));
                        CsvDataNoDuplicate.remove(CsvDataNoDuplicate.get(j));
                    }
                }
            }

        }
        return CsvDataNoDuplicate;
    }

    @Override
    public ArrayList<CsvData> getDuplicate(int file){
        System.out.println("File number for duplicate"+file);
        CsvDataWithNoDuplicate(file);
        return miss;
    }
}
