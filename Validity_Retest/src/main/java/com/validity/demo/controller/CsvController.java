package com.validity.demo.controller;

import com.validity.demo.helper.CsvData;
import com.validity.demo.service.Impl.RemoveDuplicateImpl;
import com.validity.demo.service.Impl.RemoveMispellImpl;
import com.validity.demo.service.main.CsvDataLoad;
import com.validity.demo.service.Impl.CsvDataLoadImpl;
import com.validity.demo.service.main.RemoveDuplicate;
import com.validity.demo.service.main.RemoveMispell;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.util.ArrayList;

@RestController
@CrossOrigin

@RequestMapping(value = "/csv")
public class CsvController {

    @GetMapping(value = "/noduplicate/{filename}")
    public ArrayList<CsvData> getDataWithoutDuplicate(@PathVariable(value = "filename") Integer name){
        System.out.println(name);
        RemoveDuplicate removeDuplicate = new RemoveDuplicateImpl();
        ArrayList<CsvData> csvDataNoDuplicate = removeDuplicate.CsvDataWithNoDuplicate(name);
        return csvDataNoDuplicate;
    }

    @GetMapping(value = "/nomispell/{filename}")
    public ArrayList<CsvData> getDataWithoutMispell(@PathVariable(value = "filename") Integer name ){
        System.out.println(name);
        RemoveMispell removeMispell = new RemoveMispellImpl();
        ArrayList<CsvData> csvDataNoMispell = removeMispell.removeMissSpell(name);
        return csvDataNoMispell;
    }

    @GetMapping(value = "/duplicate/{filename}")
    public ArrayList<CsvData> getDuplicateData(@PathVariable(value = "filename") Integer name ){
        System.out.println(name);
        RemoveDuplicate removeDuplicate = new RemoveDuplicateImpl();
        ArrayList<CsvData> duplicateDataList = removeDuplicate.getDuplicate(name);
        return duplicateDataList;
    }

    @GetMapping(value = "/mispell/{filename}")
    public ArrayList<CsvData> getMispellData(@PathVariable(value = "filename") Integer name ){
        System.out.println(name);
        RemoveMispell removeMispell = new RemoveMispellImpl();
        ArrayList<CsvData> missSpellList = removeMispell.getMispell(name);
        return missSpellList;
    }
}
