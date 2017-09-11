package com.example.egypt2.banksprice.myClass;

/**
 * Created by egypt2 on 8/27/2017.
 */

public class ayINFO {

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {

        return type;
    }

    private static int type ;
    private int bank_ID ;
    private String bank_Name ;
    private int currency_ID ;
    private String currency_Name ;
    private String currency_code ;
    private String buy ;
    private String sell ;
    private String LastUpdata ;

    public void setBank_ID(int bank_ID) {
        this.bank_ID = bank_ID;
    }

    public void setBank_Name(String bank_Name) {
        this.bank_Name = bank_Name;
    }

    public void setCurrency_ID(int currency_ID) {
        this.currency_ID = currency_ID;
    }

    public void setCurrency_Name(String currency_Name) {
        this.currency_Name = currency_Name;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public void setLastUpdata(String lastUpdata) {
        LastUpdata = lastUpdata;
    }

    public int getBank_ID() {

        return bank_ID;
    }

    public String getBank_Name() {
        return bank_Name;
    }

    public int getCurrency_ID() {
        return currency_ID;
    }

    public String getCurrency_Name() {
        return currency_Name;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public String getBuy() {
        return buy;
    }

    public String getSell() {
        return sell;
    }

    public String getLastUpdata() {
        return LastUpdata;
    }
}
