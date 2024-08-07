package org.vaadin.myapp;

import org.vaadin.myapp.forms.SubscriptionForm;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route("subscription-form")
public class SubscriptionFormView extends Div {
    public SubscriptionFormView() {
        setWidth("400px");
        getStyle().set("margin", "var(--lumo-space-m) auto");

        H1 h1 = new H1("Subscription Form");
        h1.getStyle().set("margin-bottom", "var(--lumo-space-l)");

        SubscriptionForm subscriptionForm = new SubscriptionForm();
        add(h1, subscriptionForm);
    }
}
