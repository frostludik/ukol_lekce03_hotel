import cz.engeto.hotel.Booking;
import cz.engeto.hotel.BookingManager;
import cz.engeto.hotel.Guest;
import cz.engeto.hotel.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    List<Guest> guestsList = new ArrayList<>();
    List<Room> roomsList = new ArrayList<>();
    BookingManager bookingList = new BookingManager();

//creating guests
    public void createGuests () {
        guestsList.add(new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15)));
        guestsList.add(new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3)));
        guestsList.add(new Guest("Karolína", "Tmavá", LocalDate.of(1981, 6, 3)));
    }

//creating rooms
    public void createRooms () {
        roomsList.add(new Room(1, 1, true, true, BigDecimal.valueOf(1000)));
        roomsList.add(new Room(2, 1, true, true, BigDecimal.valueOf(1000)));
        roomsList.add(new Room(3, 3, false, true, BigDecimal.valueOf(2400)));
    }

//adding bookings
    public void createBookings () {
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

//print all booking with details
    public void printAllBookings() {
        System.out.println("-------all bookings----------------------------------------------------------------------");
        for (int i = 0; i < bookingList.getNumberOfBookings(); i++) {
            String seaViewAvailability = bookingList.getBooking(i).isHasSeaView() ? "room with seaview" : "room without seaview";
            System.out.println(bookingList.getBooking(i).getFormattedDateFrom() + " to " + bookingList.getBooking(i).getFormattedDateTo()
                    + ": " + bookingList.getBooking(i).getGuest() + ", [total guests: " + bookingList.getBooking(i).getNumberOfGuests() + ", "
                    + seaViewAvailability + "] for " + bookingList.getBooking(i).getPricePerNight() + " CZK");
        }
    }

//print first 8 vacation bookings
    public void printFirstEightVacationBookings() {
        System.out.println("");
        System.out.println("-------Frst eight vacation bookings------------------------------------------------------");
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

//print guest statistics
    public void printGuestStatistics() {
        System.out.println("");
        System.out.println("-------Guest Statistics------------------------------------------------------------------");

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

//print total price per booking
    public void printTotalPricePerBooking() {
        System.out.println("");
        System.out.println("-------Total price per booking-----------------------------------------------------------");
        for (int i = 0; i < bookingList.getNumberOfBookings(); i++) {
            System.out.println(bookingList.getBooking(i).getFormattedDateFrom() + " to " + bookingList.getBooking(i).getFormattedDateTo()
                    + ": " + bookingList.getBooking(i).getGuest()+ ", "+ bookingList.getBooking(i).getBookinglength()
                    + " nights, Total price of booking: " + bookingList.getBooking(i).getTotalPrice() + " CZK");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.createGuests();
        main.createRooms();
        main.createBookings();
        main.printAllBookings();
        main.printFirstEightVacationBookings();
        main.printGuestStatistics();
        main.printTotalPricePerBooking();
    }

}




