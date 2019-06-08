package com.in3.task.service;

import com.in3.task.dao.ComputerStoreDAO;
import com.in3.task.entity.ComputerStore;
import com.in3.task.model.ComputerListModel;
import com.in3.task.model.ComputerModel;
import com.in3.task.model.SearchCriteriaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class ComputerStoreService {

    // to make the method dynamic so it would work with any file path
    // also do not hard code any number or string in the code (no magic numbers or strings)
    private String FILE_PATH = "src/Assessment Task - Dataset.csv";
    private String DELIMITER = ",";

    @Autowired
    private ComputerStoreDAO computerStoreDAO;

    /**
     * Function to load product catalog to the view
     *
     * @param page to hold the page number the view want
     * @param size to hole the page size
     * @return List of model object to the view
     */
    public ComputerListModel loadProductCatalog(int page, int size) {
        ComputerListModel computerListModel = new ComputerListModel();
        Page<ComputerStore> storePage;
        Pageable pageable = PageRequest.of(page - 1, size);
        storePage = computerStoreDAO.findAll(pageable);
        ArrayList<ComputerStore> computerList = (ArrayList<ComputerStore>) storePage.get().collect(Collectors.toList());
        for (ComputerStore computerStore : computerList) {
            computerListModel.getComputerModelList().add(constructModelFromEntity(computerStore));
        }
        return computerListModel;
    }

    /**
     * Function to construct model from entity
     *
     * @param entity holds the entity to construct from
     * @return model after constructing
     */
    private ComputerModel constructModelFromEntity(ComputerStore entity) {
        ComputerModel model = new ComputerModel();
        model.setCompany(entity.getCompany());
        model.setCpu(entity.getCpu());
        model.setGraphics(entity.getGraphics());
        model.setInches(entity.getInches());
        model.setMemory(entity.getMemory());
        model.setOs(entity.getOs());
        model.setPrice(entity.getPrice());
        model.setProduct(entity.getProduct());
        model.setRam(entity.getRam());
        model.setResolution(entity.getResolution());
        model.setType(entity.getType());
        model.setWeight(entity.getWeight());
        return model;
    }

    /**
     * Function to construct entity from array of strings to Entity class
     *
     * @param line array of strings to construct the entity from
     * @return Entity object after constructing
     */
    private ComputerStore constructEntityFromCSV(String[] line) {
        ComputerStore entity = new ComputerStore();
        entity.setCompany(line[0]);
        entity.setProduct(line[1]);
        entity.setType(line[2]);
        entity.setInches(line[3]);
        entity.setResolution(line[4]);
        entity.setCpu(line[5]);
        entity.setRam(line[6]);
        entity.setMemory(line[7]);
        entity.setGraphics(line[8]);
        entity.setOs(line[9]);
        entity.setWeight(line[10]);
        entity.setPrice(line[11]);
        return entity;
    }

    /**
     * Function to load all the data from CSV file delimited with ',' to DB
     *
     * @throws Exception Normally will throw exception when it can not readLine from the buffer
     */
    @PostConstruct
    private void loadDB() throws Exception {
        ArrayList<ComputerStore> productList = new ArrayList<>();
        FileReader fileReader = new FileReader(FILE_PATH);
        // Always wrap FileReader in BufferedReader.
        BufferedReader file = new BufferedReader(fileReader);
        String line;
        boolean skipFirstLine = false;
        while ((line = file.readLine()) != null) {
            if (skipFirstLine) {
                ComputerStore entity = constructEntityFromCSV(line.split(DELIMITER));
                if (validProduct(entity))
                    productList.add(entity);
            }
            skipFirstLine = true;
        }
        computerStoreDAO.saveAll(productList);
    }

    /**
     * Function to Validate the record came from CSV file if it holds any nulls return false
     *
     * @param computerStore entity to be validated
     * @return true if valid false OW
     */
    private boolean validProduct(ComputerStore computerStore) {
        return !(computerStore.getCompany() == null || computerStore.getCpu() == null ||
                computerStore.getPrice() == null || computerStore.getGraphics() == null ||
                computerStore.getMemory() == null || computerStore.getOs() == null ||
                computerStore.getPrice() == null || computerStore.getResolution() == null ||
                computerStore.getRam() == null || computerStore.getInches() == null ||
                computerStore.getWeight() == null || computerStore.getProduct() == null);
    }

    /**
     * Function to return all OS, RAM, CPU and Inches distinct from the DB to fill the search page
     *
     * @return Model holds 4 ArrayLists OS, RAM, CPU and Inches
     */
    public SearchCriteriaModel getSearchCriteria() {
        SearchCriteriaModel searchCriteriaModel = new SearchCriteriaModel();
        searchCriteriaModel.getCpu().addAll(computerStoreDAO.findAllCpu());
        searchCriteriaModel.getOs().addAll(computerStoreDAO.findAllOs());
        searchCriteriaModel.getRam().addAll(computerStoreDAO.findAllRam());
        searchCriteriaModel.getInches().addAll(computerStoreDAO.findAllInches());
        return searchCriteriaModel;
    }

    /**
     * Function to search the DB to find match result to the search query user entered
     *
     * @param computerModel holds search query values
     * @return list of products matches user search query
     */
    public ComputerListModel getSearchResult(ComputerModel computerModel) {
        ComputerListModel computerListModel = new ComputerListModel();

        computerModel.setCompany(computerModel.getCompany() == null || computerModel.getCompany().equals("") ? "%" : "%" + computerModel.getCompany() + "%");
        computerModel.setProduct(computerModel.getProduct() == null || computerModel.getProduct().equals("") ? "%" : "%" + computerModel.getProduct() + "%");
        computerModel.setRam(computerModel.getRam() == null || computerModel.getRam().equals("") ? "%" : computerModel.getRam());
        computerModel.setOs(computerModel.getOs() == null || computerModel.getOs().equals("") ? "%" : computerModel.getOs());
        computerModel.setCpu(computerModel.getCpu() == null || computerModel.getCpu().equals("") ? "%" : computerModel.getCpu());
        computerModel.setInches(computerModel.getInches() == null || computerModel.getInches().equals("") ? "%" : computerModel.getInches());

        ArrayList<ComputerStore> computerStoreProductResult =
                computerStoreDAO.findAllByProductLikeAndCompanyLikeAndCpuLikeAndOsLikeAndRamLikeAndInchesLike(
                        computerModel.getProduct(), computerModel.getCompany(),
                        computerModel.getCpu(), computerModel.getOs(),
                        computerModel.getRam(), computerModel.getInches());
        for (ComputerStore computerStore : computerStoreProductResult) {
            computerListModel.getComputerModelList().add(constructModelFromEntity(computerStore));
        }
        return computerListModel;
    }

}
