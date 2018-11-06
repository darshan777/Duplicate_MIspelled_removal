package com.validity.demo.controller;

import com.validity.demo.helper.CsvData;
import com.validity.demo.service.Impl.RemoveDuplicateImpl;
import com.validity.demo.service.Impl.RemoveMispellImpl;
import com.validity.demo.service.main.RemoveDuplicate;
import com.validity.demo.service.main.RemoveMispell;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * author Darshan
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/csv")
public class CsvController {


    /**
     * get data with no duplicate
     * @param name
     * @return List with no duplicate data
     */
    @GetMapping(value = "/noduplicate/{filename}")
    public ArrayList<CsvData> getDataWithoutDuplicate(@PathVariable(value = "filename") Integer name){
        System.out.println(name);
        RemoveDuplicate removeDuplicate = new RemoveDuplicateImpl();
        ArrayList<CsvData> csvDataNoDuplicate = removeDuplicate.CsvDataWithNoDuplicate(name);
        return csvDataNoDuplicate;
    }

    /**
     * Get data with no mispell
     * @param name
     * @return csvDataNoMispell
     */
    @GetMapping(value = "/nomispell/{filename}")
    public ArrayList<CsvData> getDataWithoutMispell(@PathVariable(value = "filename") Integer name ){
        System.out.println(name);
        RemoveMispell removeMispell = new RemoveMispellImpl();
        ArrayList<CsvData> csvDataNoMispell = removeMispell.removeMissSpell(name);
        return csvDataNoMispell;
    }

    /**
     * get duplicates pair in list
     * @param name
     * @return duplicateDataList
     */
    @GetMapping(value = "/duplicate/{filename}")
    public ArrayList<CsvData> getDuplicateData(@PathVariable(value = "filename") Integer name ){
        System.out.println(name);
        RemoveDuplicate removeDuplicate = new RemoveDuplicateImpl();
        ArrayList<CsvData> duplicateDataList = removeDuplicate.getDuplicate(name);
        return duplicateDataList;
    }

    /**
     * get mispelled data from list
     * @param name
     * @return missSpellList
     */
    @GetMapping(value = "/mispell/{filename}")
    public ArrayList<CsvData> getMispellData(@PathVariable(value = "filename") Integer name ){
        System.out.println(name);
        RemoveMispell removeMispell = new RemoveMispellImpl();
        ArrayList<CsvData> missSpellList = removeMispell.getMispell(name);
        return missSpellList;
    }
}
