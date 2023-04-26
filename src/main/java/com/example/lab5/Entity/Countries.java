package com.example.lab5.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Countries {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id")
    private String countryId;
    @Basic
    @Column(name = "country_name")
    private String countryName;
    @Basic
    @Column(name = "region_id")
    private Integer regionId;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

}
