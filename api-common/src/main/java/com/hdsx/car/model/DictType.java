package com.hdsx.car.model;

import java.io.Serializable;

public class DictType implements Serializable {
    private String mcode;
    private String mtable;
    private String mtype;

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public String getMtable() {
        return mtable;
    }

    public void setMtable(String mtable) {
        this.mtable = mtable;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

}
