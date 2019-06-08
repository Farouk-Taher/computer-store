package com.in3.task.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "COMPUTER_CATALOG")
public class ComputerStore {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    @NotNull
    private UUID uuid;
    @NotNull
    @Column(name = "COMPANY")
    private String company;
    @NotNull
    @Column(name = "PRODUCT")
    private String product;
    @NotNull
    @Column(name = "TYPE")
    private String type;
    @NotNull
    @Column(name = "INCHES")
    private String inches;
    @NotNull
    @Column(name = "RESOLUTION")
    private String resolution;
    @NotNull
    @Column(name = "CPU")
    private String cpu;
    @NotNull
    @Column(name = "RAM")
    private String ram;
    @NotNull
    @Column(name = "MEMORY")
    private String memory;
    @NotNull
    @Column(name = "GRAPHICS")
    private String graphics;
    @NotNull
    @Column(name = "OP_SYS")
    private String os;
    @NotNull
    @Column(name = "WEIGHT")
    private String weight;
    @NotNull
    @Column(name = "PRICE")
    private String price;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInches() {
        return inches;
    }

    public void setInches(String inches) {
        this.inches = inches;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
