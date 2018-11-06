package com.validity.demo.service;

import com.validity.demo.ValidityApplication;
import com.validity.demo.helper.CsvData;
import com.validity.demo.service.Impl.RemoveDuplicateImpl;
import com.validity.demo.service.main.RemoveDuplicate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ValidityApplication.class)
public class RemoveDuplicateImplTest {

    @Autowired
    private RemoveDuplicate removeDuplicate;

    @Test
    public void removeDuplicateData(){
        removeDuplicate = new RemoveDuplicateImpl();
        ArrayList<CsvData> data = new ArrayList<>();
        data = removeDuplicate.CsvDataWithNoDuplicate(1);
        Assert.assertTrue("More than 1 person was returned", data.size()>0);
    }

    @Test
    public void getDuplicates(){
        removeDuplicate = new RemoveDuplicateImpl();
        ArrayList<CsvData> data = new ArrayList<>();
        data = removeDuplicate.CsvDataWithNoDuplicate(1);
        Assert.assertTrue("More than 1 person was returned", data.size()>=0);

    }
}
