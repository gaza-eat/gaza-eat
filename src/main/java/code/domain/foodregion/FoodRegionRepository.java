package code.domain.foodregion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRegionRepository extends JpaRepository<FoodRegionEntity, Long>
{

}
