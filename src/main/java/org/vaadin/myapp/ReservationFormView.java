package org.vaadin.myapp;

import org.vaadin.myapp.forms.ReservationForm;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("reservation-form")
public class ReservationFormView extends Div {
    public ReservationFormView() {
        setWidth("400px");
        getStyle().set("margin", "var(--lumo-space-m) auto");

        H1 h1 = new H1("Reservation Form");
        h1.getStyle().set("margin-bottom", "var(--lumo-space-l)");

        ReservationForm reservationForm = new ReservationForm();
        add(h1, reservationForm);
    }
}
