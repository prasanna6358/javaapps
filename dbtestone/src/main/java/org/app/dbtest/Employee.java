package org.app.dbtest;


public class Employee {

    private int eId;
    private String ename;
    private String eSal;

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String geteSal() {
        return eSal;
    }

    public void seteSal(String eSal) {
        this.eSal = eSal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId='" + eId + '\'' +
                ", ename='" + ename + '\'' +
                ", eSal='" + eSal + '\'' +
                '}';
    }
}
