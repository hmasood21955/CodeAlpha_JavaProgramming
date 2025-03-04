import java.util.*;

// Room class to represent a hotel room
class Room {
    int roomNumber;
    String category;
    double price;
    boolean isBooked;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isBooked = false; 
    }
}

// Reservation class to manage bookings
class Reservation {
    String guestName;
    Room room;
    int nights;
    double totalCost;

    public Reservation(String guestName, Room room, int nights) {
        this.guestName = guestName;
        this.room = room;
        this.nights = nights;
        this.totalCost = room.price * nights;
        room.isBooked = true; // Mark the room as booked
    }
}

// Hotel class to manage rooms and reservations
class Hotel {
    String name;
    Room[] rooms;
    Reservation[] reservations;
    int reservationCount;

    public Hotel(String name, int numberOfRooms) {
        this.name = name;
        this.rooms = new Room[numberOfRooms];
        this.reservations = new Reservation[100]; // Max 100 reservations
        this.reservationCount = 0;
    }

    // Add a room to the hotel
    public void addRoom(int index, int roomNumber, String category, double price) {
        rooms[index] = new Room(roomNumber, category, price);
    }

    // Search for available rooms
    public void searchAvailableRooms() {
        System.out.println("Available Rooms:");
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null && !rooms[i].isBooked) {
                System.out.println("Room " + rooms[i].roomNumber + " (" + rooms[i].category + ") - $" + rooms[i].price + " per night");
            }
        }
    }

    // Make a reservation
    public void makeReservation(String guestName, int roomNumber, int nights) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null && rooms[i].roomNumber == roomNumber && !rooms[i].isBooked) {
                reservations[reservationCount] = new Reservation(guestName, rooms[i], nights);
                reservationCount++;
                System.out.println("Reservation successful!");
                System.out.println("Guest: " + guestName);
                System.out.println("Room: " + rooms[i].roomNumber + " (" + rooms[i].category + ")");
                System.out.println("Total Cost: $" + (rooms[i].price * nights));
                return;
            }
        }
        System.out.println("Room not available or invalid room number.");
    }

    // View all reservations
    public void viewReservations() {
        if (reservationCount == 0) {
            System.out.println("No reservations found.");
        } else {
            System.out.println("Current Reservations:");
            for (int i = 0; i < reservationCount; i++) {
                System.out.println("Guest: " + reservations[i].guestName +
                        ", Room: " + reservations[i].room.roomNumber +
                        ", Nights: " + reservations[i].nights +
                        ", Total Cost: $" + reservations[i].totalCost);
            }
        }
    }
}

// Main class to run the hotel reservation system
public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("Sunset Paradise", 5); // Hotel with 5 rooms

        // Add rooms to the hotel
        hotel.addRoom(0, 101, "Standard", 100.0);
        hotel.addRoom(1, 102, "Standard", 100.0);
        hotel.addRoom(2, 201, "Deluxe", 150.0);
        hotel.addRoom(3, 202, "Deluxe", 150.0);
        hotel.addRoom(4, 301, "Suite", 250.0);

        while (true) {
            System.out.println("\nWelcome to " + hotel.name + "!");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    hotel.searchAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter number of nights: ");
                    int nights = scanner.nextInt();
                    hotel.makeReservation(guestName, roomNumber, nights);
                    break;

                case 3:
                    hotel.viewReservations();
                    break;

                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

