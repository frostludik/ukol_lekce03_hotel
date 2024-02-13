import cz.engeto.hotel.Booking;
import cz.engeto.hotel.Guest;
import cz.engeto.hotel.Room;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Guest guest1 = new Guest("Adela", "Malikova",
                LocalDate.of(1993, 3, 13));
        Guest guest2 = new Guest("Jana", "Dvorackova",
                LocalDate.of(1995, 5, 5));

        List<Guest> guestsList = new ArrayList<>();
        guestsList.add(guest1);
        guestsList.add(guest2);

        System.out.println("----GUESTS-----------------------------------------------------------------------------");
        for (Guest guest : guestsList) {
            System.out.println(guest.getNameAndSurnameWithBirthdate());
        }


        Room room1 = new Room(
                1, 1, true,
                true, BigDecimal.valueOf(1000));

        Room room2 = new Room(
                2, 1, true,
                true, BigDecimal.valueOf(1000));

        Room room3 = new Room(
                3, 3, false,
                true, BigDecimal.valueOf(2400));

        List<Room> roomsList = new ArrayList<>();
        roomsList.add(room1);
        roomsList.add(room2);
        roomsList.add(room3);

        System.out.println("----ROOMS------------------------------------------------------------------------------");
        for (Room room : roomsList) {
            String balconyAvailability = room.isHasBalcony() ? "with balcony" : "no balcony";
            String seaViewAvailability = room.isHasSeaView() ? "with seaview" : "without seaview";
            System.out.println("Room Nr." + room.getRoomNumber() + ", " + room.getNumberOfBeds() + " bed, "
                    + balconyAvailability + ", " + seaViewAvailability + ", price per night: " + room.getPricePerNight() + " CZK.");
        }


        Booking booking1 = new Booking(room1, guest1, LocalDate.of(2021, 7, 19),
                LocalDate.of(2021, 7, 26), true);

        Booking booking2 = new Booking(room3, guest1, new ArrayList<>(), LocalDate.of(2021, 9, 1),
                LocalDate.of(2021, 9, 14), true);
        booking2.addGuest(guest2);


        List<Booking> bookingsList = new ArrayList<>();
        bookingsList.add(booking1);
        bookingsList.add(booking2);

        System.out.println("----BOOKINGS---------------------------------------------------------------------------");
        for (Booking booking : bookingsList) {
            String vacationOrBusiness = booking.isVacation() ? "Vacation" : "Business";
            System.out.println("Room "+booking.getRoom()+", main guest: "+booking.getGuest()
            +", other guest: "+booking.getOtherGuests()+", From: "+booking.getDateFrom()
            +" To: "+booking.getDateTo()+", type of stay: "+vacationOrBusiness);
        }
    }

}



