package cz.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList = new ArrayList<>();
    private Booking booking;


    public BookingManager(List<Booking> bookingList, Booking booking) {
        this.bookingList = bookingList;
        this.booking = booking;
    }

    public BookingManager() {
    }

    public void addBooking(Booking booking) {
        this.bookingList.add(booking);
    }


    public Booking getBooking(int i) {
        if (i >= 0 && i < bookingList.size())
            return bookingList.get(i);
        else {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    public int getNumberOfBookings() {
        return bookingList.size();
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
        if (totalNumberOfGuest == 0) {
            System.out.println("No guest in bookings. Cannot calculate average guests per booking");
            return 0;
            }
        return (double) totalNumberOfGuest / bookingList.size();
    }
}

