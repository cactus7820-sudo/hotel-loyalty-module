package ru.sstu.hotel.loyalty.model;

public class LoyaltyCard {
    private String cardNumber;
    private int bonusBalance;
    private String tierLevel;

    public LoyaltyCard(String cardNumber, int bonusBalance) {
        this.cardNumber = cardNumber;
        this.bonusBalance = bonusBalance;
        this.tierLevel = "Bronze";
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getBonusBalance() {
        return bonusBalance;
    }

    public void setBonusBalance(int bonusBalance) {
        this.bonusBalance = bonusBalance;
    }

    public String getTierLevel() {
        return tierLevel;
    }

    public void setTierLevel(String tierLevel) {
        this.tierLevel = tierLevel;
    }
}
