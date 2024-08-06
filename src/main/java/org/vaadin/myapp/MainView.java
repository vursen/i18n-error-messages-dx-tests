package org.vaadin.myapp;

import org.vaadin.myapp.forms.ApplicationForm;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends Div {
    public MainView() {
        setWidth("400px");
        getStyle().set("margin", "var(--lumo-space-m) auto");

        H1 h1 = new H1("Application form");
        h1.getStyle().set("margin-bottom", "var(--lumo-space-l)");

        ApplicationForm applicationForm = new ApplicationForm();
        add(h1, applicationForm);
    }
}
