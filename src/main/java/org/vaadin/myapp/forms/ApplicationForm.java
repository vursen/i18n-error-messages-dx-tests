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
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

public class ApplicationForm extends FormLayout {
    private List<HasValidation> fields = new ArrayList<>();

    public ApplicationForm() {
        setResponsiveSteps(new ResponsiveStep("0", 1));

        // 1. Add the following error messages for "Full name":
        // - This field is required
        // - Please enter at least 2 characters
        TextField fullNameField = new TextField("Full name");
        fullNameField.setRequiredIndicatorVisible(true);
        fullNameField.setMinLength(2);
        fields.add(fullNameField);

        // 2. Add the following error messages for "Date of birth":
        // - This field is required
        // - Please enter a valid date
        // - Date must be in the past
        // - Date cannot be more than 100 years in the past
        DatePicker birthDateField = new DatePicker("Date of birth");
        birthDateField.setRequiredIndicatorVisible(true);
        birthDateField.setMax(LocalDate.now());
        birthDateField.setMin(LocalDate.now().minusYears(100));
        fields.add(birthDateField);

        // 3. Add the following error messages for "Email":
        // - This field is required
        // - Please enter a valid email address
        EmailField emailField = new EmailField("Email");
        emailField.setRequiredIndicatorVisible(true);
        emailField.setHelperText("Format: example@example.com");
        fields.add(emailField);

        // 4. Add the following error messages for "Phone number":
        // - This field is required
        // - Please enter a valid phone number
        TextField phoneField = new TextField("Phone number");
        phoneField.setRequiredIndicatorVisible(true);
        phoneField.setPrefixComponent(new Div("+358"));
        phoneField.setPattern("\\d{9}");
        phoneField.setHelperText("Format: 123456789 (9 digits, no spaces or dashes)");
        fields.add(phoneField);

        // 5. Add the following error messages for "I agree to the terms and conditions":
        // - You must agree
        Checkbox agreementField = new Checkbox("I agree to the terms and conditions");
        agreementField.getStyle().set("padding-top", "var(--lumo-space-s)");
        agreementField.setRequiredIndicatorVisible(true);
        fields.add(agreementField);

        Button submitButton = new Button("Submit", this::onSubmitClick);
        submitButton.getStyle().set("margin-top", "var(--lumo-space-m)");

        add(fullNameField, birthDateField, emailField, phoneField,
                agreementField, submitButton);
    }

    private void onSubmitClick(ClickEvent<Button> event) {
        Notification notification = new Notification();
        notification.setPosition(Notification.Position.TOP_CENTER);
        if (hasInvalidFields()) {
            notification.setText("Please address the errors in the form.");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } else if (hasEmptyRequiredFields()) {
            notification.setText("Please fill in all required fields.");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        } else {
            notification.setText("Application has been submitted successfully. We will contact you soon.");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        }
        notification.open();
    }

    private boolean hasInvalidFields() {
        return fields.stream().anyMatch((field) -> field.isInvalid());
    }

    private boolean hasEmptyRequiredFields() {
        return fields.stream().anyMatch((field) -> {
            HasValue<?, ?> fieldAsHasValue = (HasValue<?, ?>) field;
            return fieldAsHasValue.isRequiredIndicatorVisible() && fieldAsHasValue.isEmpty();
        });
    }
}
