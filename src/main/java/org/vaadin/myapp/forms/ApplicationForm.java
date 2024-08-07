package org.vaadin.myapp.forms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.HasValidation;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

public class ApplicationForm extends FormLayout {
    private List<HasValidation> fields = new ArrayList<>();

    public ApplicationForm() {
        setResponsiveSteps(new ResponsiveStep("0", 1));

        TextField fullNameField = new TextField("Full name");
        fullNameField.setRequiredIndicatorVisible(true);
        fullNameField.setMinLength(2);
        fields.add(fullNameField);

        Select<String> genderField = new Select<>();
        genderField.setLabel("Gender");
        genderField.setItems("Male", "Female", "Other");
        genderField.setRequiredIndicatorVisible(true);
        fields.add(genderField);

        DatePicker birthDateField = new DatePicker("Date of birth");
        birthDateField.setRequiredIndicatorVisible(true);
        birthDateField.setMax(LocalDate.now());
        birthDateField.setMin(LocalDate.now().minusYears(100));
        fields.add(birthDateField);

        EmailField emailField = new EmailField("Email");
        emailField.setRequiredIndicatorVisible(true);
        emailField.setHelperText("Format: example@example.com");
        fields.add(emailField);

        TextField phoneField = new TextField("Phone number");
        phoneField.setRequiredIndicatorVisible(true);
        phoneField.setPrefixComponent(new Div("+358"));
        phoneField.setPattern("\\d{9}");
        phoneField.setHelperText("Format: 123456789 (9 digits, no spaces or dashes)");
        fields.add(phoneField);

        Checkbox acceptTermsField = new Checkbox("I accept the terms and conditions");
        acceptTermsField.getStyle().set("padding-top", "var(--lumo-space-s)");
        acceptTermsField.setRequiredIndicatorVisible(true);
        fields.add(acceptTermsField);

        Button submitButton = new Button("Submit", this::onSubmitClick);
        submitButton.getStyle().set("margin-top", "var(--lumo-space-m)");

        add(fullNameField, genderField, birthDateField, emailField, phoneField,
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
            notification.setText("Application has been submitted successfully. We will contact you soon.");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        }
        notification.open();
    }
}
