package riot.lol.api.domain.habilidades;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class DatosHabilidades {
        @NotBlank
        String habilidadpasiva;
        @NotBlank
        String habilidadq;
        @NotBlank
        String habilidadw;
        @NotBlank
        String habilidade;
        @NotBlank
        String habilidadr;
}

// otra forma de hacerlo:
// public record DatosHabilidades(
// @NotBlank String habilidadpasiva,
// @NotBlank String habilidadq,
/// @NotBlank String habilidadw,
// @NotBlank String habilidade,
// @NotBlank String habilidadr) {
//
// public String getHabilidadpasiva() {
// return habilidadpasiva;
// }
//// public String getHabilidadq() {
// return habilidadpasiva;
// }
// public String getHabilidadw() {
// return habilidadpasiva;
// }
// public String getHabilidade() {
// return habilidadpasiva;
// }
//// public String getHabilidadr() {
// return habilidadpasiva;
// }
// }
//

// package riot.lol.api.habilidades;
//
// import jakarta.validation.constraints.NotBlank;
// import lombok.Value;

// @Value
// public class DatosHabilidades {
// @NotBlank
// String habilidadpasiva;
// @NotBlank
// String habilidadq;
// @NotBlank
// String habilidadw;
// @NotBlank
// String habilidade;
// @NotBlank
// String habilidadr;
// }
