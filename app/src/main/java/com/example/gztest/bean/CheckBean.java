package com.example.gztest.bean;

/**
 * Created by Eric on 2018/3/26.
 */

public class CheckBean {
    /**
     * status : 200
     * data : {" isSame":1}
     */

    private int status;
    private DataBean data;

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

    /**
     * code : /home/projects/idcard/photos/exception/6383873787980419072_20180326111517_f.jpg (No such file or directory)
     * message : /home/projects/idcard/photos/exception/6383873787980419072_20180326111517_f.jpg (No such file or directory)
     */


    private String code;
    private String message;
    /**
     * timestamp : 2018-03-26 11:41:47
     * error : Internal Server Error
     * exception : java.lang.IllegalArgumentException
     * path : /idcard/v1/face/check
     */

    private String timestamp;
    private String error;
    private String exception;
    private String path;

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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static class DataBean {
        /**
         *  isSame : 1
         */

        private int isSame;

        public int getIsSame() {
            return isSame;
        }

        public void setIsSame(int isSame) {
            this.isSame = isSame;
        }
    }
}
