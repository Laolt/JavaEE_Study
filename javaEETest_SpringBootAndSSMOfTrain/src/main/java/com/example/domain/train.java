package com.example.domain;

public class train {
    int number,Dtime,Mnumber,Bnumber;
    String trainN;
    String startTime;

    @Override
    public String toString() {
        return "train{" +
                "number=" + number +
                ", Dtime=" + Dtime +
                ", Mnumber=" + Mnumber +
                ", Bnumber=" + Bnumber +
                ", trainN='" + trainN + '\'' +
                ", startTime='" + startTime + '\'' +
                ", startAddress='" + startAddress + '\'' +
                ", endAddress='" + endAddress + '\'' +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDtime() {
        return Dtime;
    }

    public void setDtime(int dtime) {
        Dtime = dtime;
    }

    public int getMnumber() {
        return Mnumber;
    }

    public void setMnumber(int mnumber) {
        Mnumber = mnumber;
    }

    public int getBnumber() {
        return Bnumber;
    }

    public void setBnumber(int bnumber) {
        Bnumber = bnumber;
    }

    public String getTrainN() {
        return trainN;
    }

    public void setTrainN(String trainN) {
        this.trainN = trainN;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    String startAddress;
    String endAddress;
}
