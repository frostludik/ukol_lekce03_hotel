package cz.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList;
    private Booking booking;


    public BookingManager() {
        this.bookingList = new ArrayList<>();

    }



    public void addBooking(Booking newBooking) {
        this.bookingList.add(newBooking);
    }

    public Booking getBooking(int index) {
        if (index >= 0 && index < bookingList.size()) {
            return bookingList.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookingList);
    }

    public void clearBookings() {
        bookingList.clear();
    }


}