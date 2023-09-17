package riot.lol.api.domain.campeon;

import riot.lol.api.domain.habilidades.DatosHabilidades;

public record DatosRespuestaCampeon(Long id, String nombre, String region, String carril, String especialidad,
        DatosHabilidades habilidades) {

}
