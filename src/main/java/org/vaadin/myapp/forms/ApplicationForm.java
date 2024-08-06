package org.vaadin.myapp.forms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HasValidation;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class ApplicationForm extends FormLayout {
    private List<HasValidation> fields = new ArrayList<>();

    public ApplicationForm() {
        setResponsiveSteps(new ResponsiveStep("0", 1));

        TextField fullNameField = new TextField("Full name");
        fullNameField.setRequiredIndicatorVisible(true);
        fullNameField.setMinLength(2);
        fields.add(fullNameField);

        DatePicker birthDateField = new DatePicker("Birth date");
        birthDateField.setRequiredIndicatorVisible(true);
        birthDateField.setMax(LocalDate.now());
        fields.add(birthDateField);

        TextField phoneField = new TextField("Phone");
        phoneField.setRequiredIndicatorVisible(true);
        phoneField.setPattern("\\+\\d+");
        phoneField.setHelperText("Format: +01234567890");
        fields.add(phoneField);

        EmailField emailField = new EmailField("Email");
        emailField.setRequiredIndicatorVisible(true);
        fields.add(emailField);

        PasswordField passwordField = new PasswordField("Password");
        passwordField.setRequiredIndicatorVisible(true);
        passwordField.setMinLength(8);
        passwordField.setPattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$");
        passwordField.setHelperText(
                "Minimum 8 characters, at least one uppercase letter, one lowercase letter, one number and one special character");
        fields.add(passwordField);

        ComboBox<String> cityField = new ComboBox<>("City");
        cityField.setItems("New York", "Los Angeles", "Helsinki", "Tokyo");
        cityField.setRequiredIndicatorVisible(true);
        fields.add(cityField);

        TextArea addressField = new TextArea("Address");
        addressField.setRequiredIndicatorVisible(true);
        fields.add(addressField);

        Checkbox acceptTermsField = new Checkbox("I accept the terms and conditions");
        acceptTermsField.getStyle().set("padding-top", "var(--lumo-space-s)");
        acceptTermsField.setRequiredIndicatorVisible(true);
        fields.add(acceptTermsField);

        Button submitButton = new Button("Submit", this::onSubmitClick);
        submitButton.getStyle().set("margin-top", "var(--lumo-space-m)");

        add(fullNameField, birthDateField, phoneField, emailField, passwordField, cityField, addressField,
                acceptTermsField, submitButton);
    }

    private void onSubmitClick(ClickEvent<Button> event) {
        boolean isInvalid = fields.stream().anyMatch((field) -> {
            return field.isInvalid();
        });
        boolean isRequired = fields.stream().anyMatch((field) -> {
            HasValue<?, ?> fieldAsHasValue = (HasValue<?, ?>) field;
            return fieldAsHasValue.isRequiredIndicatorVisible() && fieldAsHasValue.isEmpty();
        });

        Notification notification = new Notification();
        notification.setPosition(Notification.Position.TOP_CENTER);
        if (isInvalid) {
            notification.setText("Please address the errors in the form.");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } else if (isRequired) {
            notification.setText("Please fill in all required fields.");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } else {
            notification.setText("Application has been submitted successfully!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        }
        notification.open();
    }
}
