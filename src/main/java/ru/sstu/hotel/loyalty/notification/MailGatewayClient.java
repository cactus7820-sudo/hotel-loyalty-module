package ru.sstu.hotel.loyalty.notification;

public class MailGatewayClient {
    public static void sendEmail(String email, String subject, String text) {
        System.out.println("[EMAIL -> " + email + "] " + subject + ": " + text);
    }
}
