package com.delgadomiguel.main.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class UserPostRequestBody {

    @NotBlank(message = "This field cannot be null, empty, or blank")
    private String name;

    @NotBlank(message = "This field cannot be null, empty, or blank")
    private String email;

}
