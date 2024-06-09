package com.example.ga;

public class Data {
    String nameout;
    String rollout;
    String codeout;
    String selectedDate;

    public Data(String nameout, String rollout, String codeout, String selectedDate) {
        this.nameout = nameout;
        this.rollout = rollout;
        this.codeout = codeout;
        this.selectedDate = selectedDate;
    }

    public String getNameout() {
        return nameout;
    }

    public void setNameout(String nameout) {
        this.nameout = nameout;
    }

    public String getRollout() {
        return rollout;
    }

    public void setRollout(String rollout) {
        this.rollout = rollout;
    }

    public String getCodeout() {
        return codeout;
    }

    public void setCodeout(String codeout) {
        this.codeout = codeout;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }
}

