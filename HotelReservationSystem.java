package com.mycompany.hotelreservationsystem;

import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Hotel Reservation System");
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scan.nextInt();
            scan.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String type = scan.nextLine();
                    List<Room> availableRooms = hotel.searchAvailableRooms(type);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms for the selected type.");
                    } else {
                        System.out.println("Available rooms:");
                        for (Room room : availableRooms) {
                            System.out.println("Room " + room.getRoomNumber() + " - $" + room.getPrice() + " per night");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String customerName = scan.nextLine();
                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = scan.nextInt();
                    System.out.print("Enter number of days: ");
                    int days = scan.nextInt();
                    Room room = null;
                    for (Room r : hotel.searchAvailableRooms("")) {
                        if (r.getRoomNumber() == roomNumber && r.isAvailable()) {
                            room = r;
                            break;
                        }
                    }
                    if (room != null) {
                        hotel.makeReservation(customerName, room, days);
                    } else {
                        System.out.println("Invalid room number or room not available.");
                    }
                    break;

                case 3:
                    List<Reservation> reservations = hotel.viewReservations();
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found.");
                    } else {
                        for (Reservation reservation : reservations) {
                            System.out.println(reservation);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
