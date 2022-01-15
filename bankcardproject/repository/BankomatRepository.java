package uz.pdp.bankcardproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankcardproject.entity.Bankomat;

public interface BankomatRepository extends JpaRepository<Bankomat,Integer> {
}
