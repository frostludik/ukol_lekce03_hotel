import cz.engeto.hotel.Booking;
import cz.engeto.hotel.BookingManager;
import cz.engeto.hotel.Guest;
import cz.engeto.hotel.Room;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.lang.Boolean.TRUE;

public class Main {
    public static void main(String[] args) {

        List<Guest> guestsList = new ArrayList<>();
        List<Room> roomsList = new ArrayList<>();
        BookingManager bookingList = new BookingManager();

//creating guests
        guestsList.add(new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15)));
        guestsList.add(new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3)));
        guestsList.add(new Guest("Karolína", "Tmavá", LocalDate.of(1981, 6, 3)));

//creating rooms
        roomsList.add(new Room(1, 1, true, true, BigDecimal.valueOf(1000)));
        roomsList.add(new Room(2, 1, true, true, BigDecimal.valueOf(1000)));
        roomsList.add(new Room(3, 3, false, true, BigDecimal.valueOf(2400)));

//adding bookings
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



        System.out.println("----all bookings-----------------------------------------------------------------------------");
        for (int i = 0; i < bookingList.getNumberOfBookings(); i++) {
            String seaViewAvailability = bookingList.getBooking(i).isHasSeaView() ? "room with seaview" : "room without seaview";
            System.out.println(bookingList.getBooking(i).getFormattedDateFrom() + " to " + bookingList.getBooking(i).getFormattedDateTo()
                    + ": " + bookingList.getBooking(i).getGuest() + ", [total guests: " + bookingList.getBooking(i).getNumberOfGuests() + ", "
                    + seaViewAvailability + "] for " + bookingList.getBooking(i).getPricePerNight() + " CZK");
            }



    }
}



//        Booking booking1 = new Booking(room1, guest1, LocalDate.of(2021, 7, 19),
//                LocalDate.of(2021, 7, 26), true);
//
//        Booking booking2 = new Booking(room3, guest1, new ArrayList<>(), LocalDate.of(2021, 9, 1),
//                LocalDate.of(2021, 9, 14), true);
//        booking2.addGuest(guest2);
//
//
//        List<Booking> bookingsList = new ArrayList<>();
//        bookingsList.add(booking1);
//        bookingsList.add(booking2);


//        Guest guest1 = new Guest("Adela", "Malikova",
//                LocalDate.of(1993, 3, 13));
//        Guest guest2 = new Guest("Jana", "Dvorackova",
//                LocalDate.of(1995, 5, 5));
//
//        List<Guest> guestsList = new ArrayList<>();
//        guestsList.add(guest1);
//        guestsList.add(guest2);
//
//        System.out.println("----GUESTS-----------------------------------------------------------------------------");
//        for (Guest guest : guestsList) {
//            System.out.println(guest.getNameAndSurnameWithBirthdate());
//        }
//
//
//        Room room1 = new Room(
//                1, 1, true,
//                true, BigDecimal.valueOf(1000));
//
//        Room room2 = new Room(
//                2, 1, true,
//                true, BigDecimal.valueOf(1000));
//
//        Room room3 = new Room(
//                3, 3, false,
//                true, BigDecimal.valueOf(2400));
//
//        List<Room> roomsList = new ArrayList<>();
//        roomsList.add(room1);
//        roomsList.add(room2);
//        roomsList.add(room3);
//
//        System.out.println("----ROOMS------------------------------------------------------------------------------");
//        for (Room room : roomsList) {
//            String balconyAvailability = room.isHasBalcony() ? "with balcony" : "no balcony";
//            String seaViewAvailability = room.isHasSeaView() ? "with seaview" : "without seaview";
//            System.out.println("Room Nr." + room.getRoomNumber() + ", " + room.getNumberOfBeds() + " bed, "
//                    + balconyAvailability + ", " + seaViewAvailability + ", price per night: " + room.getPricePerNight() + " CZK.");
//        }
//
//

//
//        System.out.println("----BOOKINGS---------------------------------------------------------------------------");
//        for (Booking booking : bookingsList) {
//            String vacationOrBusiness = booking.isVacation() ? "Vacation" : "Business";
//            System.out.println("Room "+booking.getRoom()+", main guest: "+booking.getGuest()
//            +", other guest: "+booking.getOtherGuests()+", From: "+booking.getDateFrom()
//            +" To: "+booking.getDateTo()+", type of stay: "+vacationOrBusiness);
//        }
//        }

//    }



