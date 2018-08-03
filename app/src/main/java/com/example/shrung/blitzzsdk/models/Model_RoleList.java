package com.example.shrung.blitzzsdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Model_RoleList {

    @SerializedName("RESULT")
    @Expose
    private Integer result;
    @SerializedName("ROLELIST")
    @Expose
    private ArrayList<ROLELIST> rolelist = null;

    public Integer getRESULT() {
        return result;
    }

    public void setRESULT(Integer rESULT) {
        this.result = rESULT;
    }

    public ArrayList<ROLELIST> getROLELIST() {
        return rolelist;
    }

    public void setROLELIST(ArrayList<ROLELIST> rOLELIST) {
        this.rolelist = rOLELIST;
    }


    public class ROLELIST {

        @SerializedName("RCODE")
        @Expose
        private String rcode;
        @SerializedName("DISPLAYNAME")
        @Expose
        private String displayName;

        public String getRCODE() {
            return rcode;
        }

        public void setRCODE(String rCODE) {
            this.rcode = rCODE;
        }

        public String getDISPLAYNAME() {
            return displayName;
        }

        public void setDISPLAYNAME(String dISPLAYNAME) {
            this.displayName = dISPLAYNAME;
        }

    }

}
