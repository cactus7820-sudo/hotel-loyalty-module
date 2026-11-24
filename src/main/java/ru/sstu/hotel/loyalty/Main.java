package ru.sstu.hotel.loyalty;

import ru.sstu.hotel.loyalty.integration.BookingIntegrationService;
import ru.sstu.hotel.loyalty.model.Booking;
import ru.sstu.hotel.loyalty.model.Guest;
import ru.sstu.hotel.loyalty.model.LoyaltyCard;
import ru.sstu.hotel.loyalty.notification.NotificationAdapter;
import ru.sstu.hotel.loyalty.service.LoyaltyService;

public class Main {
    public static void main(String[] args) {
        LoyaltyService loyaltyService = new LoyaltyService();
        BookingIntegrationService bookingService = new BookingIntegrationService(loyaltyService);
        NotificationAdapter notificationAdapter = new NotificationAdapter();

        Guest guest = new Guest("Иванов Иван Иванович", "89001234567", "test@mail.ru");
        String cardId = loyaltyService.createCardId(guest);
        LoyaltyCard card = new LoyaltyCard(cardId, 0);

        System.out.println("Выпущена карта: " + card.getCardNumber() + ", статус: " + card.getTierLevel());

        Booking booking = new Booking("COMPLETED", 10000.0);
        bookingService.processPoints(booking, card);
        System.out.println("Баланс после выезда: " + card.getBonusBalance());

        notificationAdapter.notifyGuest(guest.getEmail(), card.getBonusBalance());
    }
}
