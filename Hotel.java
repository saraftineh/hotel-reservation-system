package com.mycompany.hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single", 100));
        rooms.add(new Room(102, "Double", 150));
        rooms.add(new Room(103, "Suite", 300));
        rooms.add(new Room(104, "Single", 100));
        rooms.add(new Room(105, "Double", 150));
    }

    public List<Room> searchAvailableRooms(String type) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable() && room.getType().equalsIgnoreCase(type)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void makeReservation(String customerName, Room room, int days) {
        room.bookRoom();
        Reservation reservation = new Reservation(customerName, room, days);
        reservations.add(reservation);
        System.out.println("Reservation successful for " + customerName);
    }

    public List<Reservation> viewReservations() {
        return reservations;
    }
}
