package com.example.gztest.bean;

/**
 * Created by Eric on 2018/3/26.
 */

public class IdBean {


    /**
     * status : 200
     * data : {"isVerified":1,"idCardNo":"xxxxxx","name":"xxx","ctlAddress":"xxx","validDate":"20180101","frontPhotoUrl":"","backPhotoUrl":""}
     */

    private int status;
    private DataBean data;
    /**
     * code : /home/projects/idcard/photos/exception/6383873787980419072_20180326111517_f.jpg (No such file or directory)
     * message : /home/projects/idcard/photos/exception/6383873787980419072_20180326111517_f.jpg (No such file or directory)
     */

    private String code;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * isVerified : 1
         * idCardNo : xxxxxx
         * name : xxx
         * ctlAddress : xxx
         * validDate : 20180101
         * frontPhotoUrl :
         * backPhotoUrl :
         */

        private int isVerified;
        private String idCardNo;
        private String name;
        private String ctlAddress;
        private String validDate;
        private String frontPhotoUrl;
        private String backPhotoUrl;

        public int getIsVerified() {
            return isVerified;
        }

        public void setIsVerified(int isVerified) {
            this.isVerified = isVerified;
        }

        public String getIdCardNo() {
            return idCardNo;
        }

        public void setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCtlAddress() {
            return ctlAddress;
        }

        public void setCtlAddress(String ctlAddress) {
            this.ctlAddress = ctlAddress;
        }

        public String getValidDate() {
            return validDate;
        }

        public void setValidDate(String validDate) {
            this.validDate = validDate;
        }

        public String getFrontPhotoUrl() {
            return frontPhotoUrl;
        }

        public void setFrontPhotoUrl(String frontPhotoUrl) {
            this.frontPhotoUrl = frontPhotoUrl;
        }

        public String getBackPhotoUrl() {
            return backPhotoUrl;
        }

        public void setBackPhotoUrl(String backPhotoUrl) {
            this.backPhotoUrl = backPhotoUrl;
        }
    }
}
