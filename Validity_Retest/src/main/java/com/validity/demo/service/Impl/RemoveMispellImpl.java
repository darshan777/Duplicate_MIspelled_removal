package com.validity.demo.service.Impl;

import com.validity.demo.dao.impl.CsvReaderImpl;
import com.validity.demo.dao.main.CsvReader;
import com.validity.demo.helper.CsvData;
import com.validity.demo.service.main.RemoveMispell;

import java.util.ArrayList;

public class RemoveMispellImpl implements RemoveMispell {
    /**
     * Checks The Data For Spelling mistake(Not more than 2 Characters)
     * Compares Email_id, First_name, Last_name
     */
    @Override
    public ArrayList<CsvData> removeMissSpell() {
        CsvReader csvReader = new CsvReaderImpl();
        ArrayList<CsvData> data = csvReader.getCsvData("");
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = i + 1; j < data.size(); j++) {
                //Calls misspellCheck method to get the cost of edit
                int countFirstName = misspellCheck(data.get(i).getFirst_name(), data.get(j).getFirst_name());
                int countLastName = misspellCheck(data.get(i).getLast_name(), data.get(j).getLast_name());
                int countEmail = misspellCheck(data.get(i).getEmail(), data.get(j).getEmail());
                if ((countFirstName == 1 || countFirstName == 2) && ((countLastName == 0) && (countEmail == 0))) {
                    System.out.println(data.get(i).getFirst_name());
                    System.out.println(data.get(j).getFirst_name());
                    data.remove(j);
                }
                if ((countLastName == 1 || countLastName == 2) && ((countFirstName == 0) && (countEmail == 0))) {
                    data.remove(j);
                }
                if ((countEmail == 1 || countEmail == 2) && ((countLastName == 1) && (countFirstName == 0))) {
                    data.remove(j);
                }
            }
        }
    }
    /**
     * Calculates The cost of different Characters in Strings
     * Takes tow string as input and returns the cost
     *
     */
    public  int misspellCheck(String a, String b)
    {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++)
        {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++)
            {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),
                        a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
}
