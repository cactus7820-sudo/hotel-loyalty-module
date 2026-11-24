package ru.sstu.hotel.loyalty.service;

public class TierDiscountCalculator {
    public double getRateByTier(String tier) {
        return "Silver".equals(tier) ? 0.10 : 0.05;
    }
}
