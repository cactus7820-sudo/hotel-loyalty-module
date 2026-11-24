package ru.sstu.hotel.loyalty.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sstu.hotel.loyalty.model.Guest;
import ru.sstu.hotel.loyalty.model.LoyaltyCard;

public class LoyaltyService {
    private static final Logger logger = LoggerFactory.getLogger(LoyaltyService.class);
    private static final double CASHBACK_PERCENT = 0.05;
    private final TierDiscountCalculator discountCalculator = new TierDiscountCalculator();

    public String createCardId(Guest guest) {
        if (guest == null || guest.getPhone() == null) {
            return "GUEST-" + System.currentTimeMillis();
        }
        return "HOTEL-" + guest.getPhone();
    }

    public void addBonusPoints(LoyaltyCard card, double bookingPrice) {
        double rate = discountCalculator.getRateByTier(card.getTierLevel());
        int earnedPoints = (int) Math.round(bookingPrice * rate);
        int updatedBalance = card.getBonusBalance() + earnedPoints;
        card.setBonusBalance(updatedBalance);
        card.setTierLevel(updateTier(updatedBalance));
    }

    public void redeemPoints(LoyaltyCard card, int points) {
        if (points <= 0) {
            logger.error("Попытка списать некорректное количество баллов: {}", points);
            throw new IllegalArgumentException("Баллы должны быть больше нуля");
        }
        if (card.getBonusBalance() < points) {
            logger.warn("Недостаточно баллов на карте {}: запрошено {}", card.getCardNumber(), points);
            throw new IllegalStateException("Недостаточно баллов на счете");
        }
        card.setBonusBalance(card.getBonusBalance() - points);
    }

    public String updateTier(int totalPoints) {
        if (totalPoints >= 5000) {
            return "Silver";
        }
        return "Bronze";
    }
}
