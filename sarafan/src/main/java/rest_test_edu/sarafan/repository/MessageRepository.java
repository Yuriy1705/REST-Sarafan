package rest_test_edu.sarafan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest_test_edu.sarafan.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
