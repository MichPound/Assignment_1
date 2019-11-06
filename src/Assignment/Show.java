package Assignment;

import Lists.CustomList;

public class Show {
    private String title, sDate, eDate;
    private int time;
    private double bCost, cCost, sCost;
    private CustomList<Performance> performances = new CustomList<>();

    public Show(String title, String sDate, String eDate, int time, double bCost, double cCost, double sCost) {
        this.title = title;
        this.sDate = sDate;
        this.eDate = eDate;
        this.time = time;
        this.bCost = bCost;
        this.cCost = cCost;
        this.sCost = sCost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getbCost() {
        return bCost;
    }

    public void setbCost(int bCost) {
        this.bCost = bCost;
    }

    public double getcCost() {
        return cCost;
    }

    public void setcCost(int cCost) {
        this.cCost = cCost;
    }

    public double getsCost() {
        return sCost;
    }

    public void setsCost(int sCost) {
        this.sCost = sCost;
    }

    public void addPerformance(Performance performance) {
        this.performances.addItem(performance);
    }

    public CustomList<Performance> getPerformances() {
        return performances;
    }
}
