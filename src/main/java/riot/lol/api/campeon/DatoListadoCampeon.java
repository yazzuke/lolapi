package riot.lol.api.campeon;

import riot.lol.api.habilidades.Habilidades;

public record DatoListadoCampeon(Long id, String nombre, String region, String carril, String especialidad,
        Habilidades habilidades) {

    public DatoListadoCampeon(Campeon campeon) {

        this(campeon.getId(), campeon.getNombre(), campeon.getRegion(), campeon.getCarril(),
                campeon.getEspecialidad(), campeon.getHabilidad());

    }
}
