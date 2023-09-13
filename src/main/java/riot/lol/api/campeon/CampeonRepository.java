package riot.lol.api.campeon;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampeonRepository extends JpaRepository<Campeon, Long> {
    Page<Campeon> findAll(Pageable paginacion);

    Page<Campeon> findByRegion(String region, Pageable pageable);

    Page<Campeon> findByCarril(String carril, Pageable pageable);
}
