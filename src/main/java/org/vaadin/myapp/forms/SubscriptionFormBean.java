package org.vaadin.myapp.forms;

import java.time.LocalDate;

public class SubscriptionFormBean {
    public String email;
    public LocalDate birthday;
    public boolean acceptMarketingEmails;

    public SubscriptionFormBean() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setAcceptMarketingEmails(boolean acceptMarketingEmails) {
        this.acceptMarketingEmails = acceptMarketingEmails;
    }

    public boolean isAcceptMarketingEmails() {
        return acceptMarketingEmails;
    }
}
