package com.live.board.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrawingEvent {
    @Min(value = 0)
    private double x;
    @Min(value = 0)
    private double y;
    @NotBlank
    private String type;
    @Pattern(regexp = "^#([A-Fa-f0-9]{6})$")
    private String color;
    @Min(value = 1)
    @Max(value = 50)
    private int lineWidth;
    @NotBlank
    private String sessionId;
}
