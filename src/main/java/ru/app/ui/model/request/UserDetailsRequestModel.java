package ru.app.ui.model.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

    @NotNull(message = "firstName cant be null")
    @Size(min=2, message = "firstName must be more than 2 char")
    private String firstName;

    @NotNull(message = "lastName cant be null")
    @Size(min=2, message = "lastName must be more than 2 char")
    private String lastName;

    @NotNull(message = "email cant be null")
    @Email
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
