package com.musicapp.model;

public class Artist {
    private int id;
    private String name;
    private String type;
    private int formationYear;
    private Integer disbandmentYear;
    private String officialWebsite;

    public Artist(int id, String name, String type, int formationYear, Integer disbandmentYear, String officialWebsite) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.formationYear = formationYear;
        this.disbandmentYear = disbandmentYear;
        this.officialWebsite = officialWebsite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFormationYear() {
        return formationYear;
    }

    public void setFormationYear(int formationYear) {
        this.formationYear = formationYear;
    }

    public Integer getDisbandmentYear() {
        return disbandmentYear;
    }

    public void setDisbandmentYear(Integer disbandmentYear) {
        this.disbandmentYear = disbandmentYear;
    }

    public String getOfficialWebsite() {
        return officialWebsite;
    }

    public void setOfficialWebsite(String officialWebsite) {
        this.officialWebsite = officialWebsite;
    }
}
