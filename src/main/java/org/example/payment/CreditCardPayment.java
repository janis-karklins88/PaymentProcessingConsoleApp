package org.example.payment;

import org.example.model.PaymentResult;

public class CreditCardPayment extends PaymentMethod {
    private final String cardNumber;
    private final String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        super("CreditCard");
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public PaymentResult processPayment(double amount) {
        if (cardNumber == null || cardNumber.isBlank() || cardNumber.length() < 4 || !cardNumber.matches("\\d+")) {
            return new PaymentResult(false, "Card number must contain at least 4 digits.");
        }

        if (cardHolderName == null || cardHolderName.isBlank()) {
            return new PaymentResult(false, "Card holder name must be provided.");
        }

        return new PaymentResult(true, "Paid " + amount + " using credit card ending with " + cardNumber.substring(cardNumber.length() - 4));
    }
}
