package uz.pdp.bankcardproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import uz.pdp.bankcardproject.entity.Card;

import java.time.LocalDate;
@EnableJpaRepositories
public interface CardRepository extends JpaRepository<Card,Integer> {

    boolean existsByCardNumberAndIdNot(String cardNumber, Integer id);
}
