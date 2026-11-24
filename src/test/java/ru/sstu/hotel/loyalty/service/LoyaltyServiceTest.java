package ru.sstu.hotel.loyalty.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sstu.hotel.loyalty.model.LoyaltyCard;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyServiceTest {
    private LoyaltyService service;

    @BeforeEach
    void setUp() {
        service = new LoyaltyService();
    }

    @Test
    void shouldAddFivePercentPoints() {
        LoyaltyCard card = new LoyaltyCard("HOTEL-01", 0);
        service.addBonusPoints(card, 10000.0);
        assertEquals(500, card.getBonusBalance());
    }

    @Test
    void shouldThrowExceptionWhenNotEnoughPoints() {
        LoyaltyCard card = new LoyaltyCard("HOTEL-01", 500);
        assertThrows(IllegalStateException.class, () -> service.redeemPoints(card, 600));
    }

    @Test
    void shouldUpgradeTierToSilverAt5000Points() {
        assertEquals("Silver", service.updateTier(5000));
    }
}
