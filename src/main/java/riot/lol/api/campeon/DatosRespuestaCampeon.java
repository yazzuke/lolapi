package riot.lol.api.campeon;

import riot.lol.api.habilidades.DatosHabilidades;

public record DatosRespuestaCampeon(Long id, String nombre, String region, String carril, String especialidad,
                DatosHabilidades habilidades) {

}
