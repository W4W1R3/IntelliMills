package com.example.intellimills;

public class FarmsRegisteredClass {
    String farmer_phonenumber,farmer_County,farmer_Subcounty,farm_Area,farmer_BankAccountName,farmer_ID,land_Acres,farm_Account_Number,emails;

    public FarmsRegisteredClass() {
    }

    public FarmsRegisteredClass(String farmer_phonenumber, String farmer_County, String farmer_Subcounty, String farm_Area, String farmer_BankAccountName, String farmer_ID, String land_Acres, String farm_Account_Number, String emails) {
        this.farmer_phonenumber = farmer_phonenumber;
        this.farmer_County = farmer_County;
        this.farmer_Subcounty = farmer_Subcounty;
        this.farm_Area = farm_Area;
        this.farmer_BankAccountName = farmer_BankAccountName;
        this.farmer_ID = farmer_ID;
        this.land_Acres = land_Acres;
        this.farm_Account_Number = farm_Account_Number;
        this.emails = emails;
    }

    public String getFarmer_phonenumber() {
        return farmer_phonenumber;
    }

    public void setFarmer_phonenumber(String farmer_phonenumber) {
        this.farmer_phonenumber = farmer_phonenumber;
    }

    public String getFarmer_County() {
        return farmer_County;
    }

    public void setFarmer_County(String farmer_County) {
        this.farmer_County = farmer_County;
    }

    public String getFarmer_Subcounty() {
        return farmer_Subcounty;
    }

    public void setFarmer_Subcounty(String farmer_Subcounty) {
        this.farmer_Subcounty = farmer_Subcounty;
    }

    public String getFarm_Area() {
        return farm_Area;
    }

    public void setFarm_Area(String farm_Area) {
        this.farm_Area = farm_Area;
    }

    public String getFarmer_BankAccountName() {
        return farmer_BankAccountName;
    }

    public void setFarmer_BankAccountName(String farmer_BankAccountName) {
        this.farmer_BankAccountName = farmer_BankAccountName;
    }

    public String getFarmer_ID() {
        return farmer_ID;
    }

    public void setFarmer_ID(String farmer_ID) {
        this.farmer_ID = farmer_ID;
    }

    public String getLand_Acres() {
        return land_Acres;
    }

    public void setLand_Acres(String land_Acres) {
        this.land_Acres = land_Acres;
    }

    public String getFarm_Account_Number() {
        return farm_Account_Number;
    }

    public void setFarm_Account_Number(String farm_Account_Number) {
        this.farm_Account_Number = farm_Account_Number;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }
}
