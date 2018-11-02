package com.validity.demo.controller;

import com.validity.demo.helper.CsvData;
import com.validity.demo.service.Impl.RemoveDuplicateImpl;
import com.validity.demo.service.Impl.RemoveMispellImpl;
import com.validity.demo.service.main.CsvDataLoad;
import com.validity.demo.service.Impl.CsvDataLoadImpl;
import com.validity.demo.service.main.RemoveDuplicate;
import com.validity.demo.service.main.RemoveMispell;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class CsvController {

    @RequestMapping(value ="/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean storeCsvData(@Valid @RequestBody String fileName){
        CsvDataLoad csvDataLoad = new CsvDataLoadImpl();
        fileName = "C:/Users/Vrunda/Desktop/Validity_Retest/Validity_Retest/src/main/java/com/validity/demo/dao/resource/normal[1].csv";
        boolean isDone =  csvDataLoad.loaadCsv(fileName);
        if(!isDone){
            return false;
        }
    return true;
    }

    @GetMapping(value = "/noduplicate")
    public ArrayList<CsvData> getDataWithoutDuplicate(@Valid @RequestBody String fileName){
        RemoveDuplicate removeDuplicate = new RemoveDuplicateImpl();
        ArrayList<CsvData> csvDataNoDuplicate = removeDuplicate.CsvDataWithNoDuplicate();
        return csvDataNoDuplicate;
    }

    @GetMapping(value = "/nomispell")
    public ArrayList<CsvData> getDataWithoutMispell(@Valid @RequestBody String fileName){
        RemoveMispell removeMispell = new RemoveMispellImpl();
        ArrayList<CsvData> csvDataNoMispell = removeMispell.removeMissSpell();
        return csvDataNoMispell;
    }
}
