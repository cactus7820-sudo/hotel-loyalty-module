package ru.sstu.hotel.loyalty.integration;

import ru.sstu.hotel.loyalty.model.Booking;
import ru.sstu.hotel.loyalty.model.LoyaltyCard;
import ru.sstu.hotel.loyalty.service.LoyaltyService;

public class BookingIntegrationService {
    private final LoyaltyService loyaltyService;

    public BookingIntegrationService(LoyaltyService loyaltyService) {
        this.loyaltyService = loyaltyService;
    }

    public void processPoints(Booking booking, LoyaltyCard card) {
        if ("COMPLETED".equals(booking.getStatus())) {
            loyaltyService.addBonusPoints(card, booking.getPrice());
        }
    }
}
