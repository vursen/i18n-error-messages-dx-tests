package org.vaadin.myapp.forms;

import java.time.LocalDate;

public class SubscriptionFormBean {
    public String fullName;
    public LocalDate birthDate;
    public String email;
    public String phone;
    public String password;
    public String city;
    public int numberOfChildren;
    public boolean acceptTerms;

    public SubscriptionFormBean() {
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setAcceptTerms(boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }

    public boolean getAcceptTerms() {
        return acceptTerms;
    }
}
