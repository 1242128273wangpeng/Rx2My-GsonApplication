package com.example.wangpeng.mygsonapplication;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangpeng on 2017/9/21.
 */

public class ResultList implements Serializable {
    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private List<String> result;
    @SerializedName("error_code")
    private int error_code;
    @SerializedName("nothing")
    private String nothing;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public void setString(List<String> result) {
        this.result = result;
    }

    public List<String> getString() {
        return this.result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getError_code() {
        return this.error_code;
    }

    public String getNothing() {
        return nothing;
    }

    public void setNothing(String nothing) {
        this.nothing = nothing;
    }

    @Override
    public String toString() {
        return "ResultList{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                ", nothing=" + nothing +
                '}';
    }
}
