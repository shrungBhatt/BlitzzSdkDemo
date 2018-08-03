package com.example.shrung.blitzzsdk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Model_Participants {

    @SerializedName("participants")
    @Expose
    private ArrayList<Participant> participants = null;

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }


    public class Participant {

        @SerializedName("UCID")
        @Expose
        private Integer uCID;
        @SerializedName("RCODE")
        @Expose
        private String rCODE;
        @SerializedName("DISPLAYNAME")
        @Expose
        private String dISPLAYNAME;
        @SerializedName("QBID")
        @Expose
        private Integer qBID;
        @SerializedName("FULLNAME")
        @Expose
        private String fULLNAME;
        @SerializedName("PROFILEPIC")
        @Expose
        private String pROFILEPIC;
        @SerializedName("isparticipant")
        @Expose
        private Integer isparticipant;
        @SerializedName("CHATID")
        @Expose
        private Object cHATID;
        @SerializedName("UEMAIL")
        @Expose
        private String uEMAIL;
        @SerializedName("QBDIALOGID")
        @Expose
        private Object qBDIALOGID;
        @SerializedName("CDATETIME")
        @Expose
        private Object cDATETIME;
        @SerializedName("JOBROLE")
        @Expose
        private String jOBROLE;
        @SerializedName("COMPANY")
        @Expose
        private String cOMPANY;
        @SerializedName("THUMBNAIL")
        @Expose
        private String tHUMBNAIL;
        @SerializedName("TYPE")
        @Expose
        private Integer tYPE;
        @SerializedName("ROOM")
        @Expose
        private Object rOOM;

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

        public String getDISPLAYNAME() {
            return dISPLAYNAME;
        }

        public void setDISPLAYNAME(String dISPLAYNAME) {
            this.dISPLAYNAME = dISPLAYNAME;
        }

        public Integer getQBID() {
            return qBID;
        }

        public void setQBID(Integer qBID) {
            this.qBID = qBID;
        }

        public String getFULLNAME() {
            return fULLNAME;
        }

        public void setFULLNAME(String fULLNAME) {
            this.fULLNAME = fULLNAME;
        }

        public String getPROFILEPIC() {
            return pROFILEPIC;
        }

        public void setPROFILEPIC(String pROFILEPIC) {
            this.pROFILEPIC = pROFILEPIC;
        }

        public Integer getIsparticipant() {
            return isparticipant;
        }

        public void setIsparticipant(Integer isparticipant) {
            this.isparticipant = isparticipant;
        }

        public Object getCHATID() {
            return cHATID;
        }

        public void setCHATID(Object cHATID) {
            this.cHATID = cHATID;
        }

        public String getUEMAIL() {
            return uEMAIL;
        }

        public void setUEMAIL(String uEMAIL) {
            this.uEMAIL = uEMAIL;
        }

        public Object getQBDIALOGID() {
            return qBDIALOGID;
        }

        public void setQBDIALOGID(Object qBDIALOGID) {
            this.qBDIALOGID = qBDIALOGID;
        }

        public Object getCDATETIME() {
            return cDATETIME;
        }

        public void setCDATETIME(Object cDATETIME) {
            this.cDATETIME = cDATETIME;
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

        public String getTHUMBNAIL() {
            return tHUMBNAIL;
        }

        public void setTHUMBNAIL(String tHUMBNAIL) {
            this.tHUMBNAIL = tHUMBNAIL;
        }

        public Integer getTYPE() {
            return tYPE;
        }

        public void setTYPE(Integer tYPE) {
            this.tYPE = tYPE;
        }

        public Object getROOM() {
            return rOOM;
        }

        public void setROOM(Object rOOM) {
            this.rOOM = rOOM;
        }

    }

}
