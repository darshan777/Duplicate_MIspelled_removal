package com.validity.demo.controller;

import com.validity.demo.service.main.CsvDataLoad;
import com.validity.demo.service.Impl.CsvDataLoadImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
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
}
