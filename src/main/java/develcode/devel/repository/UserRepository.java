package develcode.devel.repository;


import develcode.devel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
      boolean existsByCode(String code);
}
