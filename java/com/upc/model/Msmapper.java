package com.upc.model;

public class Msmapper {
    private Integer msmapperId;

    private Integer medicineId;
    
    private Integer id;

    private Integer sicknessId;

    private String sname;

    private String mname;

    public Integer getMsmapperId() {
        return msmapperId;
    }

    public void setMsmapperId(Integer msmapperId) {
        this.msmapperId = msmapperId;
    }
    
    public Integer id() {
        return id;
    }

    public void id(Integer id) {
        this.id = id;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Integer getSicknessId() {
        return sicknessId;
    }

    public void setSicknessId(Integer sicknessId) {
        this.sicknessId = sicknessId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }
}