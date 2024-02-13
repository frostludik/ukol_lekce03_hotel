package cz.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList;
    private Booking booking;
    private Booking isVacation;


    public BookingManager(List<Booking> bookingList, Booking booking, Booking isVacation) {
        this.bookingList = new ArrayList<>();
        this.booking = booking;
        this.isVacation = isVacation;

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


    public int getNumberOfWorkingBookings() {
        int countOfWorkingBookings = 0;
        for (Booking booking : bookingList) {
            if (booking.isVacation() == null) {
                countOfWorkingBookings++;
            }
        }
        return countOfWorkingBookings;
    }

    public double getAverageGuests() {
        int totalNumberOfGuest = 0;
        for (Booking booking : bookingList) {
            totalNumberOfGuest += booking.getNumberOfGuests();
        }
        return (double) totalNumberOfGuest / bookingList.size();
    }
}