package ir.mehdiadeli.a33_percentagecalculator.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import ir.mehdiadeli.a33_percentagecalculator.BR;

public class Percentage extends BaseObservable {
    String amount,total,percent;

    public Percentage(String amount, String total, String percent) {
        this.amount = amount;
        this.total = total;
        this.percent = percent;
    }

    public Percentage() {
    }
@Bindable
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
        notifyPropertyChanged(BR.amount);
    }
@Bindable
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
        notifyPropertyChanged(BR.total);
    }
    @Bindable
    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
        notifyPropertyChanged(BR.percent);
    }
}
