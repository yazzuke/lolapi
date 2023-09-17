package riot.lol.api.domain.habilidades;

import org.mapstruct.Mapper;

@Mapper
public interface HabilidadesMapper {

    Habilidades toHabilidades(DatosHabilidades habilidad);

}