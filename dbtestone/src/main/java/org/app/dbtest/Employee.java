package org.app.dbtest;


public class Employee {

    private int eId;
    private String ename;
    private double eSal;

    public Employee()
    {

    }
    public Employee(String ename, double eSal)
    {
        this.ename=ename;
        this.eSal=eSal;
    }

    public Employee(int eId, String ename, double eSal) {
        this.eId = eId;
        this.ename = ename;
        this.eSal = eSal;
    }

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

    public double geteSal() {
        return eSal;
    }

    public void seteSal(double eSal) {
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
