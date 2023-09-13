package riot.lol.api.habilidades;

import org.mapstruct.Mapper;

@Mapper
public interface HabilidadesMapper {

    Habilidades toHabilidades(DatosHabilidades habilidad);

}