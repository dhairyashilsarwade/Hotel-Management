package com.dhairyashil;

import java.util.List;
import java.util.Scanner;

public class MainFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Hotel Management System ===");
            System.out.println("1. Add Room");
            System.out.println("2. View All Rooms");
            System.out.println("3. Delete Room");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
    case 1:
        System.out.print("Enter room type: ");
        String type = sc.nextLine().trim();

        System.out.print("Enter room price: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid price. Enter a number: ");
            sc.next();
        }
        double price = sc.nextDouble();
        sc.nextLine();

        Room room = new Room(type, price);
        HotelDBManager.addRoom(room);
        break;

    case 2:
        List<Room> rooms = HotelDBManager.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms found.");
        } else {
            System.out.println("\nAvailable Rooms:");
            for (Room r : rooms) {
                System.out.printf("ID: %d | Type: %s | Price: %.2f%n", r.getId(), r.getType(), r.getPrice());
            }
        }
        break;

    case 3:
        System.out.print("Enter room ID to delete: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a valid ID: ");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();
        HotelDBManager.deleteRoom(id);
        break;

    case 4:
        System.out.println("Exiting Hotel Management System.");
        break;

    default:
        System.out.println("Invalid choice. Try again.");
}
        } while (choice != 4);

        sc.close();
    }
}
