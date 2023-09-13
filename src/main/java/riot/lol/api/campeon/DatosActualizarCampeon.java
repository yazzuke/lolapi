package riot.lol.api.campeon;

import riot.lol.api.habilidades.Habilidades;

public record DatosActualizarCampeon(Long id, String nombre, String region, String carril, String especialidad,
                Habilidades habilidades) {
}
