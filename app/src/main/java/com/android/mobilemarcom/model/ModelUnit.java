package com.android.mobilemarcom.model;


public class ModelUnit {

    private String unitCode,unitName,untiStatus;
    private String unitQty;

    public ModelUnit(String unitCode, String unitName, String untiStatus, String unitQty) {
        this.unitCode = unitCode;
        this.unitName = unitName;
        this.untiStatus = untiStatus;
        this.unitQty = unitQty;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUntiStatus() {
        return untiStatus;
    }

    public void setUntiStatus(String untiStatus) {
        this.untiStatus = untiStatus;
    }

    public String getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(String unitQty) {
        this.unitQty = unitQty;
    }
}
