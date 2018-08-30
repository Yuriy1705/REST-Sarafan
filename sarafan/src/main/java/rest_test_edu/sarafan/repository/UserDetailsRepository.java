package rest_test_edu.sarafan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest_test_edu.sarafan.domain.User;

public interface UserDetailsRepository extends JpaRepository<User, String> {
}
