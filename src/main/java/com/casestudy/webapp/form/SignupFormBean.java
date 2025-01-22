package com.casestudy.webapp.form;

import com.casestudy.webapp.validation.EmailUnique;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupFormBean {

   // @EmailUnique(message = "Email already exists.")
    @NotEmpty(message = "Email is required")
    private String username;

    @NotEmpty(message = "Password is required")
    private String password;

    @NotEmpty(message = "Confirm Password is required.")
    private String confirmPassword;

    public boolean isPasswordsMatching() {
        return this.password != null && this.password.equals(this.confirmPassword);
    }
}