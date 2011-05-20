package com.codequality.assembly.domain;

import javax.persistence.*;

@Entity
public class Build {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String summary;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Component cpu;
    @ManyToOne(fetch = FetchType.LAZY)
    private Component mainboard;
    @ManyToOne(fetch = FetchType.LAZY)
    private Component memory;
    @ManyToOne(fetch = FetchType.LAZY)
    private Component vga;
    @ManyToOne(fetch = FetchType.LAZY)
    private Component monitor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Component hardDisk;
    @ManyToOne(fetch = FetchType.LAZY)
    private Component opticalDrive;
    @ManyToOne(fetch = FetchType.LAZY)
    private Component powerSupply;
    @ManyToOne(fetch = FetchType.LAZY)
    private Component casing;
    @ManyToOne(fetch = FetchType.LAZY)
    private Component mouse;
    @ManyToOne(fetch = FetchType.LAZY)
    private Component keyboard;

    Build() {
    }

    public Build(String name, String summary, Category category) {
        this.name = name;
        this.summary = summary;
        setCategory(category);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Component getCpu() {
        return cpu;
    }

    public void setCpu(Component cpu) {
        this.cpu = cpu;
    }

    public Component getMainboard() {
        return mainboard;
    }

    public void setMainboard(Component mainboard) {
        this.mainboard = mainboard;
    }

    public Component getMemory() {
        return memory;
    }

    public void setMemory(Component memory) {
        this.memory = memory;
    }

    public Component getVga() {
        return vga;
    }

    public void setVga(Component vga) {
        this.vga = vga;
    }

    public Component getMonitor() {
        return monitor;
    }

    public void setMonitor(Component monitor) {
        this.monitor = monitor;
    }

    public Component getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(Component hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Component getOpticalDrive() {
        return opticalDrive;
    }

    public void setOpticalDrive(Component opticalDrive) {
        this.opticalDrive = opticalDrive;
    }

    public Component getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(Component powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Component getCasing() {
        return casing;
    }

    public void setCasing(Component casing) {
        this.casing = casing;
    }

    public Component getMouse() {
        return mouse;
    }

    public void setMouse(Component mouse) {
        this.mouse = mouse;
    }

    public Component getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Component keyboard) {
        this.keyboard = keyboard;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        category.addBuild(this);
    }
}
