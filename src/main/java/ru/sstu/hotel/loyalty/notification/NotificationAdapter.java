package ru.sstu.hotel.loyalty.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationAdapter {
    private static final Logger logger = LoggerFactory.getLogger(NotificationAdapter.class);

    public void notifyGuest(String email, int points) {
        if (email == null || !email.contains("@")) {
            logger.error("Некорректный email гостя для отправки уведомления: {}", email);
            return;
        }
        String text = "Начислено баллов: " + points;
        MailGatewayClient.sendEmail(email, "Карта лояльности мини-отеля", text);
    }
}
