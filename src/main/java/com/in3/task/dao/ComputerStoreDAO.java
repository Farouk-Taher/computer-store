package com.in3.task.dao;

import com.in3.task.entity.ComputerStore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface ComputerStoreDAO extends PagingAndSortingRepository<ComputerStore, UUID> {
    @Query("select distinct ram from ComputerStore")
    ArrayList<String> findAllRam();

    @Query("select distinct cpu from ComputerStore")
    ArrayList<String> findAllCpu();

    @Query("select distinct os from ComputerStore")
    ArrayList<String> findAllOs();

    @Query("select distinct inches from ComputerStore")
    ArrayList<String> findAllInches();

    ArrayList<ComputerStore>
    findAllByProductLikeAndCompanyLikeAndCpuLikeAndOsLikeAndRamLikeAndInchesLike(String product,
                                                                                 String company,
                                                                                 String cpu,
                                                                                 String os,
                                                                                 String ram,
                                                                                 String inches);

}
