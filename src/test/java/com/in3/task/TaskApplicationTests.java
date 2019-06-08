package com.in3.task;

import com.in3.task.model.ComputerListModel;
import com.in3.task.model.ComputerModel;
import com.in3.task.service.ComputerStoreService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ModuleTest
//@DataJpaTest
public class TaskApplicationTests {

    @Autowired
    ComputerStoreService computerStoreService;

    @Test
    public void contextLoads() {

    }

    @Test
    public void loadProductCat() {
        ComputerListModel computerListModel = computerStoreService.loadProductCatalog(1, 1);
        ComputerListModel expected = new ComputerListModel();
        ComputerModel model = new ComputerModel();
        model.setCompany("Apple");
        model.setProduct("MacBook Pro");
        model.setType("Ultrabook");
        model.setInches("13.3");
        model.setResolution("IPS Panel Retina Display 2560x1600");
        model.setCpu("Intel Core i5 2.3GHz");
        model.setRam("8GB");
        model.setMemory("128GB SSD");
        model.setGraphics("Intel Iris Plus Graphics 640");
        model.setOs("macOS");
        model.setWeight("1.37kg");
        model.setPrice("1339.69");
        expected.getComputerModelList().add(model);
        System.out.println(computerListModel.getComputerModelList().get(0).getCompany());
        System.out.println(expected.getComputerModelList().get(0).getCompany());
        Assert.assertEquals("Product Catalog ", expected.getComputerModelList().get(0).getPrice(), computerListModel.getComputerModelList().get(0).getPrice());
    }

}
