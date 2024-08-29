package com.mycompany.hotelreservationsystem;

public class Reservation {

    private String customerName;
    private Room room;
    private int days;

    public Reservation(String customerName, Room room, int days) {
        this.customerName = customerName;
        this.room = room;
        this.days = days;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }

    public int getDays() {
        return days;
    }

    public double calculateTotalCost() {
        return room.getPrice() * days;
    }

    @Override
    public String toString() {
        return "Reservation{"
                + "customerName='" + customerName + '\''
                + ", room=" + room.getRoomNumber()
                + ", type=" + room.getType()
                + ", days=" + days
                + ", total cost=" + calculateTotalCost()
                + '}';
    }
}
