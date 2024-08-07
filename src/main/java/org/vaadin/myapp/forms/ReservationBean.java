package org.vaadin.myapp.forms;

import java.time.LocalTime;

public class ReservationBean {
    public String email;
    public int numberOfGuests;
    public LocalTime bookingTime;
    public boolean agreed;

    public ReservationBean() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    public boolean isAgreed() {
        return agreed;
    }

}
