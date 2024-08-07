package org.vaadin.myapp.forms;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.data.binder.Binder;

public class SubscriptionForm extends FormLayout {
    private Binder<SubscriptionFormBean> binder = new Binder<>(SubscriptionFormBean.class);

    public SubscriptionForm() {
        setResponsiveSteps(new ResponsiveStep("0", 1));

        EmailField emailField = new EmailField("Email");
        binder.forField(emailField).bind("email");

        DatePicker birthdayField = new DatePicker("Date of birth");
        binder.forField(birthdayField).bind("birthday");

        Checkbox agreementField = new Checkbox("I agree to receive marketing emails");
        agreementField.getStyle().set("padding-top", "var(--lumo-space-s)");
        agreementField.setRequiredIndicatorVisible(true);

        Button subscribeButton = new Button("Subscribe", this::onSubscribeClick);
        subscribeButton.getStyle().set("margin-top", "var(--lumo-space-m)");

        add(emailField, agreementField, subscribeButton);
    }

    private void onSubscribeClick(ClickEvent<Button> event) {
        if (binder.validate().isOk()) {
            Notification notification = new Notification();
            notification.setPosition(Notification.Position.TOP_CENTER);
            notification.setText("You have successfully subscribed.");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            notification.open();
        }
    }
}
