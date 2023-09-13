package riot.lol.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import riot.lol.api.campeon.Campeon;
import riot.lol.api.campeon.CampeonRepository;
import riot.lol.api.campeon.DatoListadoCampeon;
import riot.lol.api.campeon.DatoRegistroCampeon;
import riot.lol.api.campeon.DatosActualizarCampeon;
import riot.lol.api.campeon.DatosRespuestaCampeon;
import riot.lol.api.habilidades.DatosHabilidades;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/campeon")
public class CampeonController {

    @Autowired // esta forma NO EN LA PRACTCA
    private CampeonRepository campeonRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaCampeon> RegistrarCampeon(
            @RequestBody @Valid DatoRegistroCampeon datoRegistroCampeon, UriComponentsBuilder uriComponentsBuilder) {
        Campeon campeon = campeonRepository.save(new Campeon(datoRegistroCampeon));
        DatosRespuestaCampeon datosRespuestaCampeon = new DatosRespuestaCampeon(campeon.getId(), campeon.getNombre(),
                campeon.getRegion(), campeon.getCarril(), campeon.getEspecialidad(),
                new DatosHabilidades(campeon.getHabilidad().getHabilidadpasiva(),
                        campeon.getHabilidad().getHabilidadq(), campeon.getHabilidad().getHabilidadw(),
                        campeon.getHabilidad().getHabilidade(), campeon.getHabilidad().getHabilidadr()));
        URI url = uriComponentsBuilder.path("/campeon/{id}").buildAndExpand(campeon.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCampeon);
    }

    @GetMapping
    public ResponseEntity<Page<DatoListadoCampeon>> listasdoCampeon(@PageableDefault(size = 10) Pageable paginacion) { // Spring.domain.pageable
        return ResponseEntity.ok(campeonRepository.findAll(paginacion).map(DatoListadoCampeon::new));
    }

    @GetMapping("/region/{region}")
    public Page<DatoListadoCampeon> listarCampeonesPorRegion(@PathVariable String region,
            @PageableDefault(size = 10) Pageable paginacion) {
        return campeonRepository.findByRegion(region, paginacion).map(DatoListadoCampeon::new);
        // Método para ver los campeones por región
    }

    @GetMapping("/carril/{carril}")
    public Page<DatoListadoCampeon> listarCampeonesPorCarril(@PathVariable String carril,
            @PageableDefault(size = 10) Pageable paginacion) {
        return campeonRepository.findByCarril(carril, paginacion).map(DatoListadoCampeon::new);
        // Método para ver los campeones por carril
    }

    
    @PutMapping
    @Transactional
    public ResponseEntity actualizarCampeon(@RequestBody @Valid DatosActualizarCampeon datosActualizarCampeon) {
        Campeon campeon = campeonRepository.getReferenceById(datosActualizarCampeon.id());
        campeon.actualizarDatos(datosActualizarCampeon);
        return ResponseEntity.ok(new DatosRespuestaCampeon(campeon.getId(), campeon.getNombre(),
                campeon.getRegion(), campeon.getCarril(), campeon.getEspecialidad(),
                new DatosHabilidades(campeon.getHabilidad().getHabilidadpasiva(),
                        campeon.getHabilidad().getHabilidadq(), campeon.getHabilidad().getHabilidadw(),
                        campeon.getHabilidad().getHabilidade(), campeon.getHabilidad().getHabilidadr())));
        // Método para actualizar los datos de un campeón en la base de datos
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCampeon(@PathVariable Long id) {
        Campeon campeon = campeonRepository.getReferenceById(id);
        campeonRepository.delete(campeon);
        return ResponseEntity.noContent().build();
        // Método para eliminar un campeón de la base de datos
    }

}
