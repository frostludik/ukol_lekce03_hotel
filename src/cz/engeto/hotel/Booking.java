package cz.engeto.hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Room room;
    private Guest guest;
    private List<Guest> otherGuests;
    private LocalDate dateFrom, dateTo;
    private Boolean isVacation;

    public Booking(Room room, Guest guest, List<Guest> otherGuests, LocalDate dateFrom, LocalDate dateTo, Boolean isVacation) {
        this.room = room;
        this.guest = guest;
        this.otherGuests = otherGuests;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.isVacation = isVacation;
    }
    //no need to add additional guests
    public Booking(Room room, Guest guest, LocalDate dateFrom, LocalDate dateTo, Boolean isVacation) {
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

    public int getNumberOfGuests() {
        return 1 + otherGuests.size(); //always 1 main guest + otherGuests list
    }

    public String getFormattedDateFrom() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return dateFrom.format(formatter);
    }

    public String getFormattedDateTo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return dateTo.format(formatter);
    }

    public int getRoom() {
        return room.getRoomNumber();
    }

    public BigDecimal getPricePerNight() {
        return room.getPricePerNight();
    }
    public boolean isHasSeaView() {
        return room.isHasSeaView();
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

    public Boolean isVacation() {
        return isVacation;
    }

    public void setVacation(boolean vacation) {
        isVacation = vacation;
    }


}