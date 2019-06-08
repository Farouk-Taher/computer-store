package com.in3.task.model;

import java.util.ArrayList;

public class SearchCriteriaModel {
    private ArrayList<String> ram = new ArrayList<>();
    private ArrayList<String> cpu = new ArrayList<>();
    private ArrayList<String> os = new ArrayList<>();
    private ArrayList<String> inches = new ArrayList<>();

    public ArrayList<String> getRam() {
        return ram;
    }

    public void setRam(ArrayList<String> ram) {
        this.ram = ram;
    }

    public ArrayList<String> getCpu() {
        return cpu;
    }

    public void setCpu(ArrayList<String> cpu) {
        this.cpu = cpu;
    }

    public ArrayList<String> getOs() {
        return os;
    }

    public void setOs(ArrayList<String> os) {
        this.os = os;
    }

    public ArrayList<String> getInches() {
        return inches;
    }

    public void setInches(ArrayList<String> inches) {
        this.inches = inches;
    }
}
