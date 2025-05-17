package com.poopaises.paises.entity;

public class PaisesEntity {
    private String name;
    private String capital;
    private ContinentEntity continent;
    private String flagUrl;

    public PaisesEntity(String name, String capital, ContinentEntity continent, String flagUrl) {
        this.name = name;
        this.capital = capital;
        this.continent = continent;
        this.flagUrl = flagUrl;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public ContinentEntity getContinent() {
        return continent;
    }

    public String getFlagUrl() {
        return flagUrl;
    }
}
