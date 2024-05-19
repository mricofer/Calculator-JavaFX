package model;

public class Operaciones {
    private double op1;
    private double op2;

    public Operaciones(double op1, double op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    public double getOp1() {
        return op1;
    }

    public void setOp1(double op1) {
        this.op1 = op1;
    }

    public double getOp2() {
        return op2;
    }

    public void setOp2(double op2) {
        this.op2 = op2;
    }


    public double sumar() {
        return op1 + op2;
    }

    public double restar() {
        return op1 - op2;
    }

    public double multiplicar() {
        return op1 * op2;
    }

    public double dividir() {
        return op1 / op2;
    }
}
