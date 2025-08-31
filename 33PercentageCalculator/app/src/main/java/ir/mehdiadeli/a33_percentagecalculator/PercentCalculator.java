package ir.mehdiadeli.a33_percentagecalculator;

public class PercentCalculator {
    public double calculate(double amount,double total){
        if (total==0)
            return 0;
        return (double) Math.round((amount / total) * 10000) /100.0;
    }
}
