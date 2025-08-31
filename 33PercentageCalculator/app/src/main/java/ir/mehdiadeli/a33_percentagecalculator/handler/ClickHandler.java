package ir.mehdiadeli.a33_percentagecalculator.handler;

import android.view.View;

import ir.mehdiadeli.a33_percentagecalculator.PercentCalculator;
import ir.mehdiadeli.a33_percentagecalculator.model.Percentage;

public class ClickHandler {
    Percentage percentage;

    public ClickHandler(Percentage percentage) {
        this.percentage = percentage;
    }

    public void onButtonClicked(View view){
        double amountValue=Double.parseDouble(percentage.getAmount());
        double totalValue=Double.parseDouble(percentage.getTotal());
        PercentCalculator calculator=new PercentCalculator();
        double result=calculator.calculate(amountValue,totalValue);
        percentage.setPercent(String.valueOf( result));
    }
}
