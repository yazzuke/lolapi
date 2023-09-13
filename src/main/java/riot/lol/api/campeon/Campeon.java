package riot.lol.api.campeon;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import riot.lol.api.habilidades.Habilidades;

@Table(name = "campeones")
@Entity(name = "Campeon")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Campeon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String region;
    private String carril;
    private String especialidad;
    @Embedded
    private Habilidades habilidad;

    public Campeon(DatoRegistroCampeon datoRegistroCampeon) {
        this.nombre = datoRegistroCampeon.nombre();
        this.region = datoRegistroCampeon.region();
        this.carril = datoRegistroCampeon.carril();
        this.especialidad = datoRegistroCampeon.especialidad();
        this.habilidad = new Habilidades(datoRegistroCampeon.habilidades());

    }

    public void actualizarDatos(DatosActualizarCampeon datosActualizarCampeon) {

        if (datosActualizarCampeon.nombre() != null) {
            this.nombre = datosActualizarCampeon.nombre();
        }

        if (datosActualizarCampeon.region() != null) {
            this.region = datosActualizarCampeon.region();
        }
        if (datosActualizarCampeon.carril() != null) {
            this.carril = datosActualizarCampeon.carril();
        }
        if (datosActualizarCampeon.especialidad() != null) {
            this.especialidad = datosActualizarCampeon.especialidad();
        }

    }

}
