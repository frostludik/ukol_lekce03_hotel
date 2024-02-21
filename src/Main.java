import cz.engeto.hotel.Booking;
import cz.engeto.hotel.BookingManager;
import cz.engeto.hotel.Guest;
import cz.engeto.hotel.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Guest> guestsList = new ArrayList<>();
        List<Room> roomsList = new ArrayList<>();
        BookingManager bookingList = new BookingManager();

//creating guests
        createGuests(guestsList);
//creating room
        createRooms(roomsList);
//adding bookings
        addBookings(bookingList, roomsList, guestsList);
//print all booking with details
        printAllBookingsWithDetails(bookingList);
//print first 8 vacation bookings
        printFirstEightVacationBookings(bookingList);
//print guest statistics
        printGuestStatistics(bookingList);
//print total price per booking
        printTotalPricePerBooking(bookingList);
    }

    private static void printTotalPricePerBooking(BookingManager bookingList) {
        System.out.println("\n-------Total price per booking-----------------------------------------------------------");
        for (int i = 0; i < bookingList.getNumberOfBookings(); i++) {
            System.out.println(bookingList.getBooking(i).getFormattedDateFrom() + " to " + bookingList.getBooking(i).getFormattedDateTo()
                    + ": " + bookingList.getBooking(i).getGuest() + ", " + bookingList.getBooking(i).getBookingLength()
                    + " nights, Total price of booking: " + bookingList.getBooking(i).getTotalPrice() + " CZK");
        }
    }

    private static void printGuestStatistics(BookingManager bookingList) {
        System.out.println("\n-------Guest Statistics------------------------------------------------------------------");

        int bookingsWithOneGuest = 0;
        int bookingsWithTwoGuests = 0;
        int bookingsWithMoreGuests = 0;
        for (int i = 0; i < bookingList.getNumberOfBookings(); i++) {
            switch (bookingList.getBooking(i).getNumberOfGuests()) {
                case 1:
                    bookingsWithOneGuest++;
                    break;
                case 2:
                    bookingsWithTwoGuests++;
                    break;
                default:
                    bookingsWithMoreGuests++;
                    break;
            }
        }
        System.out.println("Bookings with 1 guest: " + bookingsWithOneGuest);
        System.out.println("Bookings with 2 guests: " + bookingsWithTwoGuests);
        System.out.println("Bookings with > 2 guests: " + bookingsWithMoreGuests);
    }

    private static void printFirstEightVacationBookings(BookingManager bookingList) {
        System.out.println("\n-------First eight vacation bookings------------------------------------------------------");
        int firstEight = 0;
        for (int i = 0; i < bookingList.getNumberOfBookings(); i++) {
            if (bookingList.getBooking(i).isVacation()) {
                String vacationOrBusiness = bookingList.getBooking(i).isVacation() ? "vacation" : "business";
                System.out.println(bookingList.getBooking(i).getFormattedDateFrom() + " to " + bookingList.getBooking(i).getFormattedDateTo()
                        + ": " + bookingList.getBooking(i).getGuest() + ", [total guests: " + bookingList.getBooking(i).getNumberOfGuests() + ", "
                        + "room with seaview" + "] for " + bookingList.getBooking(i).getPricePerNight() +
                        " CZK, type of stay: " + vacationOrBusiness);
                firstEight++;
                if (firstEight == 8) break;
            }
        }
    }

    private static void printAllBookingsWithDetails(BookingManager bookingList) {
        System.out.println("\n-------all bookings----------------------------------------------------------------------");
        for (int i = 0; i < bookingList.getNumberOfBookings(); i++) {
            String seaViewAvailability = bookingList.getBooking(i).isHasSeaView() ? "room with seaview" : "room without seaview";
            System.out.println(bookingList.getBooking(i).getFormattedDateFrom() + " to " + bookingList.getBooking(i).getFormattedDateTo()
                    + ": " + bookingList.getBooking(i).getGuest() + ", [total guests: " + bookingList.getBooking(i).getNumberOfGuests() + ", "
                    + seaViewAvailability + "] for " + bookingList.getBooking(i).getPricePerNight() + " CZK");
        }
    }

    private static void addBookings(BookingManager bookingList, List<Room> roomsList, List<Guest> guestsList) {
        bookingList.addBooking(new Booking(roomsList.get(2), guestsList.get(0), LocalDate.of(2023, 6, 1),
                LocalDate.of(2023, 6, 7), false));

        bookingList.addBooking(new Booking(roomsList.get(1), guestsList.get(1), LocalDate.of(2023, 7, 18),
                LocalDate.of(2023, 7, 21), true));

        //adding multiple bookings with same parameters, but consequent dates
        LocalDate startDate = LocalDate.of(2023, 8, 1);
        for (int i = 0; i < 10; i++) {
            LocalDate endDate = startDate.plusDays(1);
            bookingList.addBooking(new Booking(roomsList.get(1), guestsList.get(2), startDate, endDate, true));
            startDate = endDate.plusDays(1);
        }
        bookingList.addBooking(new Booking(roomsList.get(2), guestsList.get(2), LocalDate.of(2023, 8, 1),
                LocalDate.of(2023, 8, 31), true));
    }

    private static void createRooms(List<Room> roomsList) {
        roomsList.add(new Room(1, 1, true, true, BigDecimal.valueOf(1000)));
        roomsList.add(new Room(2, 1, true, true, BigDecimal.valueOf(1000)));
        roomsList.add(new Room(3, 3, false, true, BigDecimal.valueOf(2400)));
    }

    private static void createGuests(List<Guest> guestsList) {
        guestsList.add(new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15)));
        guestsList.add(new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3)));
        guestsList.add(new Guest("Karolína", "Tmavá", LocalDate.of(1981, 6, 3)));
    }

}




