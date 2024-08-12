package org.vaadin.myapp.forms;

import org.vaadin.myapp.data.ReservationBean;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.data.binder.Binder;

public class ReservationForm extends FormLayout {
    private Binder<ReservationBean> binder = new Binder<>(ReservationBean.class);

    public ReservationForm() {
        setResponsiveSteps(new ResponsiveStep("0", 1));

        // 1. Add the following error messages for "Email":
        // - "This field is required" when the value is empty.
        // - "Please enter a valid email address" when the value doesn't match the email format.
        // - "This email cannot be used. Please try another one" when the email equals john@vaadin.com.
        EmailField emailField = new EmailField("Email");
        binder.forField(emailField).bind("email");

        // 2. Add the following error messages for "Number of guests":
        // - "This field is required" when the value is empty.
        // - "Please enter a valid number" when the value is unparsable, e.g. "1-".
        // - "Number of guests must be 1 or greater" when the value is less than 1.
        IntegerField numberOfGuestsField = new IntegerField("Number of guests");
        binder.forField(numberOfGuestsField).bind("numberOfGuests");

        // 3. Add the following error messages for "Reservation time":
        // - "This field is required" when the value is empty.
        // - "Please enter a valid time" when the value is unparsable, e.g. "foobar"
        TimePicker reservationTimeField = new TimePicker("Reservation time");
        binder.forField(reservationTimeField).bind("reservationTime");

        // 4. Add the following error messages for "I agree to the terms and conditions":
        // - "You must agree" when the checkbox isn't selected.
        Checkbox agreeField = new Checkbox("I agree to the terms and conditions");
        agreeField.getStyle().set("padding-top", "var(--lumo-space-s)");
        binder.forField(agreeField).bind("agreed");

        Button subscribeButton = new Button("Subscribe", this::onSubscribeClick);
        subscribeButton.getStyle().set("margin-top", "var(--lumo-space-m)");

        add(emailField, numberOfGuestsField, reservationTimeField, agreeField, subscribeButton);
    }

    private void onSubscribeClick(ClickEvent<Button> event) {
        if (binder.validate().isOk()) {
            Notification notification = new Notification();
            notification.setPosition(Notification.Position.TOP_CENTER);
            notification.setText("You have successfully reserved a table");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            notification.open();
        }
    }
}
