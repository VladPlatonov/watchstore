package com.rolex.model.watches;

import com.rolex.model.Color;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
public abstract class Watch {

    private Long id;

    private Long price;

    private Color color;

    private LocalDate arrivalDate;

}
