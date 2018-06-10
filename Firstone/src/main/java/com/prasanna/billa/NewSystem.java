package com.prasanna.billa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("newSystemObj")
public class NewSystem {

    @Value("Dell")
    private String companyname;
    @Value("16")
    private int RAM;
    @Value("1")
    private int HDD;
    @Value("#{listBean}")
    private List<Integer> supportOS;
    @Value("#{mapBean}")
    private Map<String, Object> mapData;

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setHDD(int HDD) {
        this.HDD = HDD;
    }

    public void setSupportOS(List<Integer> supportOS) {
        this.supportOS = supportOS;
    }

    public void setMapData(Map<String, Object> mapData) {
        this.mapData = mapData;
    }

    public String getCompanyname() {
        return companyname;
    }

    public int getRAM() {
        return RAM;
    }

    public int getHDD() {
        return HDD;
    }

    public List<Integer> getSupportOS() {
        return supportOS;
    }

    public Map<String, Object> getMapData() {
        return mapData;
    }

    @Override
    public String toString() {
        return "NewSystem{" +
                "companyname='" + companyname + '\'' +
                ", RAM=" + RAM +
                ", HDD=" + HDD +
                ", supportOS=" + supportOS +
                ", mapData=" + mapData +
                '}';
    }
}