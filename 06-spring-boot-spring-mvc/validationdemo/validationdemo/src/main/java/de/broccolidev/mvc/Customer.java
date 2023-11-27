package de.broccolidev.mvc;

import de.broccolidev.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @Min(value = 0, message = "must be gte 0")
    @Max(value = 10, message = "must be lte 10")
    @NotNull
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}")
    private String postalCode;

    @CourseCode
    private String courseCode;
}
