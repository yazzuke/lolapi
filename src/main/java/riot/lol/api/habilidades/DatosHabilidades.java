package riot.lol.api.habilidades;

import jakarta.validation.constraints.NotBlank;

public record DatosHabilidades(
        @NotBlank String habilidadpasiva,
        @NotBlank String habilidadq,
        @NotBlank String habilidadw,
        @NotBlank String habilidade,
        @NotBlank String habilidadr) {

}