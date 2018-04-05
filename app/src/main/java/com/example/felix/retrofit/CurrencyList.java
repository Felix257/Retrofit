package com.example.felix.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Felix on 4/3/2018.
 */

public class CurrencyList {

    public Currencies[] Currencies;

    public CurrencyList(com.example.felix.retrofit.Currencies[] currencies) {
        Currencies = currencies;
    }

    public Currencies[] getCurrencies ()
    {
        return Currencies;
    }

    public void setCurrencies (Currencies[] Currencies)
    {
        this.Currencies = Currencies;
    }

    @Override
    public String toString()
    {
        return "CurrencyList [Currencies = "+Currencies+", Crypto = ]";
    }
}
