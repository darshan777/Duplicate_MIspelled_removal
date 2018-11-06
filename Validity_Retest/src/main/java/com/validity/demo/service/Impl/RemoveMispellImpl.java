package com.validity.demo.service.Impl;
import com.validity.demo.dao.impl.CsvReaderImpl;
import com.validity.demo.dao.main.CsvReader;
import com.validity.demo.helper.CsvData;
import com.validity.demo.service.main.RemoveDuplicate;
import com.validity.demo.service.main.RemoveMispell;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class RemoveMispellImpl implements RemoveMispell {
    ArrayList<CsvData> mispellDataList = new ArrayList<>();
    /**
     * Checks The Data For Spelling mistake(Not more than 2 Characters)
     * Compares Email_id, First_name, Last_name
     */
    @Override
    public ArrayList<CsvData> removeMissSpell(int file) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicateImpl();
        ArrayList<CsvData> data = removeDuplicate.CsvDataWithNoDuplicate(file);
        ArrayList<CsvData> dataWithoutMispell = new ArrayList<>();
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = i + 1; j < data.size(); j++) {
                //Calls misspellCheck method to get the cost of edit
                int countFirstName = misspellCheck(data.get(i).getFirst_name(), data.get(j).getFirst_name());
                int countPhone = misspellCheck(data.get(i).getPhone(), data.get(j).getPhone());
                int countEmail = misspellCheck(data.get(i).getEmail(), data.get(j).getEmail());
                if (((countFirstName<3) &&(countPhone == 0)) || ((countFirstName <3) &&(countEmail == 0))) {
                    mispellDataList.add(data.get(i));
                    mispellDataList.add(data.get(j));
                    data.remove(j);
                }
                else if((countFirstName==0)&&(countEmail==0)&&(countPhone<3))
                {
                    mispellDataList.add(data.get(i));
                    mispellDataList.add(data.get(j));
                    data.remove(j);
                }
                else if((countFirstName==0)&&(countPhone==0)&&(countEmail<3))
                {
                    mispellDataList.add(data.get(i));
                    mispellDataList.add(data.get(j));
                    data.remove(j);
                }

            }
        }
        System.out.println(mispellDataList);
        return data;
    }

    @Override
    public ArrayList<CsvData> getMispell(int file){
        removeMissSpell(file);
        System.out.println("File number for Mispell "+file);
        return mispellDataList;
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
