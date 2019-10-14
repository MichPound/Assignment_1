package Assignment;

public class Show {
    private String title, sDate, eDate;
    private int time, bCost, cCost, sCost;
    private Object performance;


    public Show(String title, String sDate, String eDate, int time, int bCost, int cCost, int sCost, Object performance) {
        this.title = title;
        this.sDate = sDate;
        this.eDate = eDate;
        this.time = time;
        this.bCost = bCost;
        this.cCost = cCost;
        this.sCost = sCost;
        this.performance = performance;
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

    public int getbCost() {
        return bCost;
    }

    public void setbCost(int bCost) {
        this.bCost = bCost;
    }

    public int getcCost() {
        return cCost;
    }

    public void setcCost(int cCost) {
        this.cCost = cCost;
    }

    public int getsCost() {
        return sCost;
    }

    public void setsCost(int sCost) {
        this.sCost = sCost;
    }

    public Object getPerformance() {
        return performance;
    }

    public void setPerformance(Object performance) {
        this.performance = performance;
    }
}
