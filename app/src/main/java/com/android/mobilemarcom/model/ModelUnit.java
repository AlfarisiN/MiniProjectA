package com.android.mobilemarcom.model;


public class ModelUnit {

    private String unitCode,unitName,untiStatus;
    private int unitQty;

    public ModelUnit(String unitCode, String unitName, String untiStatus, int unitQty) {
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

    public int getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(int unitQty) {
        this.unitQty = unitQty;
    }
}
