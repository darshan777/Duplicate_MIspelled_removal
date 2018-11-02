package com.validity.demo.controller;


import com.validity.demo.helper.CsvData;
import com.validity.demo.service.Impl.RemoveDuplicateImpl;
import com.validity.demo.service.Impl.RemoveMispellImpl;
import com.validity.demo.service.main.RemoveDuplicate;
import com.validity.demo.service.main.RemoveMispell;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class DuplicateController {

    @GetMapping(value = "/noduplicate")
    public ArrayList<CsvData> getDataWithoutDuplicate(){
        RemoveDuplicate removeDuplicate = new RemoveDuplicateImpl();
        ArrayList<CsvData> csvDataNoDuplicate = removeDuplicate.CsvDataWithNoDuplicate();
        return csvDataNoDuplicate;
    }

    @GetMapping(value = "/nomispell")
    public ArrayList<CsvData> getDataWithoutMispell(){
        RemoveMispell removeMispell = new RemoveMispellImpl();
        ArrayList<CsvData> csvDataNoMispell = removeMispell.removeMissSpell();
        return csvDataNoMispell;
    }
}
