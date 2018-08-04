package com.example.shrung.blitzzsdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Model_RoleList {

    @SerializedName("RESULT")
    @Expose
    private Integer rESULT;
    @SerializedName("ROLELIST")
    @Expose
    private ArrayList<ROLELIST> rOLELIST = null;
    @SerializedName("ROLEPERMISSIONLIST")
    @Expose
    private ArrayList<ROLEPERMISSIONLIST> rOLEPERMISSIONLIST = null;
    @SerializedName("COMPANYSETTING")
    @Expose
    private COMPANYSETTING cOMPANYSETTING;

    public Integer getRESULT() {
        return rESULT;
    }

    public void setRESULT(Integer rESULT) {
        this.rESULT = rESULT;
    }

    public ArrayList<ROLELIST> getROLELIST() {
        return rOLELIST;
    }

    public void setROLELIST(ArrayList<ROLELIST> rOLELIST) {
        this.rOLELIST = rOLELIST;
    }

    public ArrayList<ROLEPERMISSIONLIST> getROLEPERMISSIONLIST() {
        return rOLEPERMISSIONLIST;
    }

    public void setROLEPERMISSIONLIST(ArrayList<ROLEPERMISSIONLIST> rOLEPERMISSIONLIST) {
        this.rOLEPERMISSIONLIST = rOLEPERMISSIONLIST;
    }

    public COMPANYSETTING getCOMPANYSETTING() {
        return cOMPANYSETTING;
    }

    public void setCOMPANYSETTING(COMPANYSETTING cOMPANYSETTING) {
        this.cOMPANYSETTING = cOMPANYSETTING;
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

    public class PERMISSIONLIST {

        @SerializedName("PID")
        @Expose
        private Integer pID;
        @SerializedName("PERMISSIONTYPE")
        @Expose
        private String pERMISSIONTYPE;
        @SerializedName("ISACCESS")
        @Expose
        private Integer iSACCESS;

        public Integer getPID() {
            return pID;
        }

        public void setPID(Integer pID) {
            this.pID = pID;
        }

        public String getPERMISSIONTYPE() {
            return pERMISSIONTYPE;
        }

        public void setPERMISSIONTYPE(String pERMISSIONTYPE) {
            this.pERMISSIONTYPE = pERMISSIONTYPE;
        }

        public Integer getISACCESS() {
            return iSACCESS;
        }

        public void setISACCESS(Integer iSACCESS) {
            this.iSACCESS = iSACCESS;
        }

    }


    public class ROLEPERMISSIONLIST {

        @SerializedName("RCODE")
        @Expose
        private String rCODE;
        @SerializedName("DISPLAYNAME")
        @Expose
        private String dISPLAYNAME;
        @SerializedName("PERMISSIONLIST")
        @Expose
        private ArrayList<PERMISSIONLIST> pERMISSIONLIST = null;

        public String getRCODE() {
            return rCODE;
        }

        public void setRCODE(String rCODE) {
            this.rCODE = rCODE;
        }

        public String getDISPLAYNAME() {
            return dISPLAYNAME;
        }

        public void setDISPLAYNAME(String dISPLAYNAME) {
            this.dISPLAYNAME = dISPLAYNAME;
        }

        public ArrayList<PERMISSIONLIST> getPERMISSIONLIST() {
            return pERMISSIONLIST;
        }

        public void setPERMISSIONLIST(ArrayList<PERMISSIONLIST> pERMISSIONLIST) {
            this.pERMISSIONLIST = pERMISSIONLIST;
        }

    }


    public class COMPANYSETTING {

        @SerializedName("LOGOIMAGE")
        @Expose
        private String lOGOIMAGE;
        @SerializedName("CDATETIME")
        @Expose
        private String cDATETIME;
        @SerializedName("EXPIREDATE")
        @Expose
        private Object eXPIREDATE;
        @SerializedName("ISTRIAL")
        @Expose
        private Integer iSTRIAL;
        @SerializedName("CHANGEPASSWORD")
        @Expose
        private Integer cHANGEPASSWORD;
        @SerializedName("ALLOWCUSTOMERCALL")
        @Expose
        private Integer aLLOWCUSTOMERCALL;
        @SerializedName("ENABLERECORDING")
        @Expose
        private Integer eNABLERECORDING;

        public String getLOGOIMAGE() {
            return lOGOIMAGE;
        }

        public void setLOGOIMAGE(String lOGOIMAGE) {
            this.lOGOIMAGE = lOGOIMAGE;
        }

        public String getCDATETIME() {
            return cDATETIME;
        }

        public void setCDATETIME(String cDATETIME) {
            this.cDATETIME = cDATETIME;
        }

        public Object getEXPIREDATE() {
            return eXPIREDATE;
        }

        public void setEXPIREDATE(Object eXPIREDATE) {
            this.eXPIREDATE = eXPIREDATE;
        }

        public Integer getISTRIAL() {
            return iSTRIAL;
        }

        public void setISTRIAL(Integer iSTRIAL) {
            this.iSTRIAL = iSTRIAL;
        }

        public Integer getCHANGEPASSWORD() {
            return cHANGEPASSWORD;
        }

        public void setCHANGEPASSWORD(Integer cHANGEPASSWORD) {
            this.cHANGEPASSWORD = cHANGEPASSWORD;
        }

        public Integer getALLOWCUSTOMERCALL() {
            return aLLOWCUSTOMERCALL;
        }

        public void setALLOWCUSTOMERCALL(Integer aLLOWCUSTOMERCALL) {
            this.aLLOWCUSTOMERCALL = aLLOWCUSTOMERCALL;
        }

        public Integer getENABLERECORDING() {
            return eNABLERECORDING;
        }

        public void setENABLERECORDING(Integer eNABLERECORDING) {
            this.eNABLERECORDING = eNABLERECORDING;
        }

    }

}
