package ru.sstu.hotel.loyalty.model;

public class Booking {
    private String status;
    private double price;

    public Booking(String status, double price) {
        this.status = status;
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }
}
