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
