package org.vaadin.myapp.data;

import java.time.LocalTime;

public class ReservationBean {
    public String email;
    public int numberOfGuests;
    public LocalTime reservationTime;
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

    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    public boolean isAgreed() {
        return agreed;
    }

}
