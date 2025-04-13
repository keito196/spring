package com.ito.validation;

import com.ito.validation.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    @Size(min = 1, message = "Last name must be at least 1 character long")
    private String lastName;

    @NotNull(message = "Last name cannot be null")
    @Min(value = 0, message = "You must have at least 0 free passes")
    @Max(value = 10, message = "You cannot have more than 10 free passes")
    private Integer freePasses;

    @Pattern(regexp = "[a-zA-z0-9]{5}", message = "Postal code must be 5 characters long")
    private String postalCode;

    @CourseCode(value = "ITO", message = "Course code must start with ITO")
    private String courseCode;

    public Customer() {
    }

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
