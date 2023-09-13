package riot.lol.api.campeon;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import riot.lol.api.habilidades.DatosHabilidades;

public record DatoRegistroCampeon(
                @NotBlank String nombre,
                @NotBlank String region,
                @NotBlank String carril,
                @NotBlank String especialidad,
                @NotNull @Valid DatosHabilidades habilidades) {

}
