package com.delgadomiguel.main.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserPutRequestBody {
    private long id;
    @NotBlank(message = "This field cannot be null, empty, or blank")
    private String name;
}
