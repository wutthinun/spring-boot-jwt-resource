package com.example.demo.model;

import javax.validation.constraints.NotNull;

public record AuthRequest (
        @NotNull String username,
        @NotNull String password
) {}
