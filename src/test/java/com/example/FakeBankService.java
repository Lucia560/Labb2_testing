package com.example;

import java.util.HashMap;
import java.util.Map;

public class FakeBankService implements BankService{
    private Map<String, Double> payments = new HashMap<>();
    private int paymentsExecuted = 0;

    @Override
    public void pay(String id, double amount) {
            payments.put(id, amount);
            paymentsExecuted++;
    }

    public boolean hasPaid(String id) {
        return payments.containsKey(id);
    }

    public int getPaymentsExecuted() {
            return paymentsExecuted;
        }
    }


