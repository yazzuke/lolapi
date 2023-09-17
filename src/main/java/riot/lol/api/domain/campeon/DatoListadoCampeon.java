package riot.lol.api.domain.campeon;

import riot.lol.api.domain.habilidades.DatosHabilidades;
import riot.lol.api.domain.habilidades.Habilidades;

public record DatoListadoCampeon(Long id, String nombre, String region, String carril, String especialidad,
        Habilidades habilidades) {

    public DatoListadoCampeon(Campeon campeon) {

        this(campeon.getId(), campeon.getNombre(), campeon.getRegion(), campeon.getCarril(),
                campeon.getEspecialidad(), campeon.getHabilidad());

    }
}
