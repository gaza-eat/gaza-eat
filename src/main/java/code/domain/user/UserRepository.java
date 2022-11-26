package code.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    @Query(value = "SELECT * FROM user WHERE id=:id", nativeQuery = true)
    public UserEntity findById(@Param("id") String id);
    
}
