package com.example.gztest.bean;

/**
 * Created by Eric on 2018/3/26.
 */

public class UpCheckBean {
//    jb.put("dataPackage",dataPackage);
//            jb.put("baseImg",baseImg);
//            jb.put("idCardNo",idCardNo);
//            jb.put("idName",idName);
    private String dataPackage;
    private String baseImg;
    private String idCardNo;
    private String name;

    public String getDataPackage() {
        return dataPackage;
    }

    public void setDataPackage(String dataPackage) {
        this.dataPackage = dataPackage;
    }

    public String getBaseImg() {
        return baseImg;
    }

    public void setBaseImg(String baseImg) {
        this.baseImg = baseImg;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getIdName() {
        return name;
    }

    public void setIdName(String name) {
        this.name = name;
    }
}
