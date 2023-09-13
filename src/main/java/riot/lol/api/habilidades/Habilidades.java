package riot.lol.api.habilidades;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Habilidades {

    private String habilidadpasiva;
    private String habilidadq;
    private String habilidadw;
    private String habilidade;
    private String habilidadr;

    @Autowired
    public Habilidades(DatosHabilidades datosHabilidades) {
        this.habilidadpasiva = datosHabilidades.getHabilidadpasiva();
        this.habilidadq = datosHabilidades.getHabilidadq();
        this.habilidadw = datosHabilidades.getHabilidadw();
        this.habilidadr = datosHabilidades.getHabilidadr();
        this.habilidade = datosHabilidades.getHabilidade();
    }

    public Habilidades actualizarDatos(HabilidadesMapper habilidadesMapper, DatosHabilidades habilidad) {
        Habilidades habilidades = habilidadesMapper.toHabilidades(habilidad);
        this.habilidadpasiva = habilidades.getHabilidadpasiva();
        this.habilidadq = habilidades.getHabilidadq();
        this.habilidadw = habilidades.getHabilidadw();
        this.habilidade = habilidades.getHabilidade();
        this.habilidadr = habilidades.getHabilidadr();
        return this;
    }
}