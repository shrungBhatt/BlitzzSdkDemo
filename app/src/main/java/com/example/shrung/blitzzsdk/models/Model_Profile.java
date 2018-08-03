package com.example.shrung.blitzzsdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model_Profile {


    @SerializedName("RESULT")
    @Expose
    private Integer rESULT;
    @SerializedName("PROFILE")
    @Expose
    private PROFILE pROFILE;

    public Integer getRESULT() {
        return rESULT;
    }

    public void setRESULT(Integer rESULT) {
        this.rESULT = rESULT;
    }

    public PROFILE getPROFILE() {
        return pROFILE;
    }

    public void setPROFILE(PROFILE pROFILE) {
        this.pROFILE = pROFILE;
    }


    public class PROFILE {

        @SerializedName("UCID")
        @Expose
        private Integer uCID;
        @SerializedName("RCODE")
        @Expose
        private String rCODE;
        @SerializedName("ROLEDISPLAYNAME")
        @Expose
        private String rOLEDISPLAYNAME;
        @SerializedName("NOTIFYEMAIL")
        @Expose
        private Object nOTIFYEMAIL;
        @SerializedName("FNAME")
        @Expose
        private String fNAME;
        @SerializedName("LNAME")
        @Expose
        private String lNAME;
        @SerializedName("FULLNAME")
        @Expose
        private String fULLNAME;
        @SerializedName("PNO")
        @Expose
        private String pNO;
        @SerializedName("PROFILEPIC")
        @Expose
        private String pROFILEPIC;
        @SerializedName("PCCODE")
        @Expose
        private String pCCODE;
        @SerializedName("JOBROLE")
        @Expose
        private String jOBROLE;
        @SerializedName("COMPANY")
        @Expose
        private String cOMPANY;
        @SerializedName("TYPE")
        @Expose
        private Integer tYPE;
        @SerializedName("TECHID")
        @Expose
        private String tECHID;
        @SerializedName("UEMAIL")
        @Expose
        private String uEMAIL;
        @SerializedName("THUMBNAIL")
        @Expose
        private String tHUMBNAIL;

        public Integer getUCID() {
            return uCID;
        }

        public void setUCID(Integer uCID) {
            this.uCID = uCID;
        }

        public String getRCODE() {
            return rCODE;
        }

        public void setRCODE(String rCODE) {
            this.rCODE = rCODE;
        }

        public String getROLEDISPLAYNAME() {
            return rOLEDISPLAYNAME;
        }

        public void setROLEDISPLAYNAME(String rOLEDISPLAYNAME) {
            this.rOLEDISPLAYNAME = rOLEDISPLAYNAME;
        }

        public Object getNOTIFYEMAIL() {
            return nOTIFYEMAIL;
        }

        public void setNOTIFYEMAIL(Object nOTIFYEMAIL) {
            this.nOTIFYEMAIL = nOTIFYEMAIL;
        }

        public String getFNAME() {
            return fNAME;
        }

        public void setFNAME(String fNAME) {
            this.fNAME = fNAME;
        }

        public String getLNAME() {
            return lNAME;
        }

        public void setLNAME(String lNAME) {
            this.lNAME = lNAME;
        }

        public String getFULLNAME() {
            return fULLNAME;
        }

        public void setFULLNAME(String fULLNAME) {
            this.fULLNAME = fULLNAME;
        }

        public String getPNO() {
            return pNO;
        }

        public void setPNO(String pNO) {
            this.pNO = pNO;
        }

        public String getPROFILEPIC() {
            return pROFILEPIC;
        }

        public void setPROFILEPIC(String pROFILEPIC) {
            this.pROFILEPIC = pROFILEPIC;
        }

        public String getPCCODE() {
            return pCCODE;
        }

        public void setPCCODE(String pCCODE) {
            this.pCCODE = pCCODE;
        }

        public String getJOBROLE() {
            return jOBROLE;
        }

        public void setJOBROLE(String jOBROLE) {
            this.jOBROLE = jOBROLE;
        }

        public String getCOMPANY() {
            return cOMPANY;
        }

        public void setCOMPANY(String cOMPANY) {
            this.cOMPANY = cOMPANY;
        }

        public Integer getTYPE() {
            return tYPE;
        }

        public void setTYPE(Integer tYPE) {
            this.tYPE = tYPE;
        }

        public String getTECHID() {
            return tECHID;
        }

        public void setTECHID(String tECHID) {
            this.tECHID = tECHID;
        }

        public String getUEMAIL() {
            return uEMAIL;
        }

        public void setUEMAIL(String uEMAIL) {
            this.uEMAIL = uEMAIL;
        }

        public String getTHUMBNAIL() {
            return tHUMBNAIL;
        }

        public void setTHUMBNAIL(String tHUMBNAIL) {
            this.tHUMBNAIL = tHUMBNAIL;
        }

    }
}
