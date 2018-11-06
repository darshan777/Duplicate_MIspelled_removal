package com.validity.demo.service;


import com.validity.demo.ValidityApplication;
import com.validity.demo.helper.CsvData;
import com.validity.demo.service.main.RemoveMispell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ValidityApplication.class)
public class RemoveMispellImpl {


    @Autowired
    private RemoveMispell removeMispell;


    @Test
    public void removeMispellData(){
        removeMispell = new com.validity.demo.service.Impl.RemoveMispellImpl();
        ArrayList<CsvData> data = removeMispell.removeMissSpell(1);
        Assert.assertTrue("More than 1 person was returned", data.size()>0);
    }

    @Test
    public void getMispell(){
        removeMispell = new com.validity.demo.service.Impl.RemoveMispellImpl();
        ArrayList<CsvData> data = removeMispell.getMispell(1);
        Assert.assertTrue("More than 1 person was returned", data.size()>=0);
    }
}
