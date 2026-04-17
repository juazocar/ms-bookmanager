package cl.app.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Libro {

    private Long id;
    @NotBlank(message = "El título es obligatorio")
    private String titulo;
    @NotBlank(message = "El autor es obligatorio")
    private String autor;
    @NotBlank(message = "La categoria es obligatoria")
    private String categoria;
    @NotNull(message = "El estado es obligatorio")
    private Boolean disponible;

}
