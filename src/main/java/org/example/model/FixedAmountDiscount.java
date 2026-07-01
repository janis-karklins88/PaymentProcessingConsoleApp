package org.example.model;

public class FixedAmountDiscount extends Discount {
    private final double fixedAmount;

    public FixedAmountDiscount(String code, double fixedAmount) {
        super(code);
        this.fixedAmount = fixedAmount;
    }

    @Override
    public double apply(double originalAmount) {
        return Math.max(0, originalAmount - fixedAmount);
    }
}
