package riot.lol.api.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import riot.lol.api.campeon.Campeon;
import riot.lol.api.campeon.CampeonRepository;
import riot.lol.api.campeon.DatoListadoCampeon;
import riot.lol.api.campeon.DatoRegistroCampeon;
import riot.lol.api.campeon.DatosActualizarCampeon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public void RegistarCampeon(@RequestBody @Valid DatoRegistroCampeon DatoRegistroCampeon) {
        campeonRepository.save(new Campeon(DatoRegistroCampeon));

    }

    @GetMapping
    public Page<DatoListadoCampeon> listasdoCampeon(@PageableDefault(size = 10) Pageable paginacion) { // Spring.domain.pageable
        // return medicoRepository.findAll(paginacion).map(DatoListadoMedico::new);
        return campeonRepository.findAll(paginacion).map(DatoListadoCampeon::new); // Esto hace que solo traiga
                                                                                   // los activos
    }

    @GetMapping("/region/{region}")
    public Page<DatoListadoCampeon> listarCampeonesPorRegion(@PathVariable String region,
            @PageableDefault(size = 10) Pageable paginacion) {
        return campeonRepository.findByRegion(region, paginacion).map(DatoListadoCampeon::new);
    }

    @GetMapping("/carril/{carril}")
    public Page<DatoListadoCampeon> listarCampeonesPorCarril(@PathVariable String carril,
            @PageableDefault(size = 10) Pageable paginacion) {
        return campeonRepository.findByCarril(carril, paginacion).map(DatoListadoCampeon::new);
    }

    @PutMapping
    @Transactional
    public void actualizarCampeon(@RequestBody @Valid DatosActualizarCampeon datosActualizarCampeon) {
        Campeon campeon = campeonRepository.getReferenceById(datosActualizarCampeon.id());
        campeon.actualizarDatos(datosActualizarCampeon);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarCampeon(@PathVariable Long id) {
        Campeon campeon = campeonRepository.getReferenceById(id);
        campeonRepository.delete(campeon);
    }

    // public void eliminarMedico(@PathVariable Long id) {
    // Medico medico = medicoRepository.getReferenceById(id);
    // medicoRepository.delete(medico); }

}
