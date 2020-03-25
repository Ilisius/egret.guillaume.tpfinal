package com.example.egretguillaumetpfinal;

public class Pays
{
    private int drapeau;
    private String name;
    private String region;
    private String subregion;
    private String capital;
    private int population;

    public Pays(String name, String region, String subregion, String capital, int population)
    {
        this.name = name;
        this.region = region;
        this.subregion = subregion;
        this.capital = capital;
        this.population = population;
    }

    public void setDrapeau(int drapeau) {
        this.drapeau = drapeau;
    }

    public int getDrapeau() {
        return drapeau;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }
}
