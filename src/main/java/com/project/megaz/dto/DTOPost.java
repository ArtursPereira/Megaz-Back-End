package com.project.megaz.dto;

import com.project.megaz.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DTOPost {
    @NotBlank(message = "branco")
    @NotNull(message = "nulo")
    private String text;

    public DTOPost() {
    }

    public @NotBlank(message = "branco") @NotNull(message = "nulo") String getText() {
        return text;
    }

    public void setText(@NotBlank(message = "branco") @NotNull(message = "nulo") String text) {
        this.text = text;
    }

}
