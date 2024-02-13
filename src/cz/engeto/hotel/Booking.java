package cz.engeto.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Room room;
    private Guest guest;
    private List<Guest> otherGuests;
    private LocalDate dateFrom, dateTo;
    private boolean isVacation;

    public Booking(Room room, Guest guest, List<Guest> otherGuests, LocalDate dateFrom, LocalDate dateTo, boolean isVacation) {
        this.room = room;
        this.guest = guest;
        this.otherGuests = otherGuests;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.isVacation = isVacation;
    }
    //no need to add additional guests
    public Booking(Room room, Guest guest, LocalDate dateFrom, LocalDate dateTo, boolean isVacation) {
        this.room = room;
        this.guest = guest;
        this.otherGuests = new ArrayList<>();
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.isVacation = isVacation;
    }

    //adding additional guests in a list
    public void addGuest(Guest guest) {
        if (otherGuests == null) {
            otherGuests = new ArrayList<>();
        }
        otherGuests.add(guest);
    }

    public int getRoom() {
        return room.getRoomNumber();
    }

    public String getGuest() {
        return guest.getNameAndSurnameWithBirthdate();
    }

    public List<Guest> getOtherGuests() {
        return otherGuests;
   }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setOtherGuests(List<Guest> otherGuests) {
        this.otherGuests = otherGuests;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public boolean isVacation() {
        return isVacation;
    }

    public void setVacation(boolean vacation) {
        isVacation = vacation;
    }


}