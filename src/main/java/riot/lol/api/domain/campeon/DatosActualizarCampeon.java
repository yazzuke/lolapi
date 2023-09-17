package riot.lol.api.domain.campeon;

import riot.lol.api.domain.habilidades.HabilidadesMapper;

public record DatosActualizarCampeon(Long id, String nombre, String region, String carril, String especialidad,
        HabilidadesMapper habilidades) {
}
