package org.vaadin.myapp.forms;

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

        EmailField emailField = new EmailField("Email");
        binder.forField(emailField).bind("email");

        IntegerField numberOfGuestsField = new IntegerField("Number of guests");
        binder.forField(numberOfGuestsField).bind("numberOfGuests");

        TimePicker bookingTimeField = new TimePicker("Booking time");
        binder.forField(bookingTimeField).bind("bookingTime");

        Checkbox agreeField = new Checkbox("I agree to the terms and conditions");
        agreeField.getStyle().set("padding-top", "var(--lumo-space-s)");
        binder.forField(agreeField).bind("agreed");

        Button subscribeButton = new Button("Subscribe", this::onSubscribeClick);
        subscribeButton.getStyle().set("margin-top", "var(--lumo-space-m)");

        add(emailField, numberOfGuestsField, agreeField, subscribeButton);
    }

    private void onSubscribeClick(ClickEvent<Button> event) {
        if (binder.validate().isOk()) {
            Notification notification = new Notification();
            notification.setPosition(Notification.Position.TOP_CENTER);
            notification.setText("You have successfully booked a table");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            notification.open();
        }
    }
}
