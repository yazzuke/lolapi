package riot.lol.api.habilidades;

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

    public Habilidades(DatosHabilidades habilidad) {
        this.habilidadpasiva = habilidad.habilidadpasiva();
        this.habilidadq = habilidad.habilidadq();
        this.habilidade = habilidad.habilidade();
        this.habilidadw = habilidad.habilidadw();
        this.habilidadr = habilidad.habilidadr();
    }

    public Habilidades actualizarDatos(DatosHabilidades habilidad) {
        this.habilidadpasiva = habilidad.habilidadpasiva();
        this.habilidadq = habilidad.habilidadq();
        this.habildade = habilidad.habilidade();
        this.habilidadw = habilidad.habilidadw();
        this.habilidadr = habilidad.habilidadr();
        return this;
    }

}