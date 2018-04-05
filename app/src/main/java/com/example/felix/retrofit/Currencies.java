package com.example.felix.retrofit;

/**
 * Created by Felix on 4/3/2018.
 */

public class Currencies {


    private String country;
    private String name;
    private String code;
    private String symbol;

    public Currencies(String country, String name, String code, String symbol) {
        this.country = country;
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }

    public String getSymbol ()
    {
        return symbol;
    }

    public void setSymbol (String symbol)
    {
        this.symbol = symbol;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [symbol = "+symbol+", name = "+name+", code = "+code+", country = "+country+"]";
    }

}
