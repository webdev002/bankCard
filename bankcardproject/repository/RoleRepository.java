package uz.pdp.bankcardproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankcardproject.entity.Role;
import uz.pdp.bankcardproject.entity.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRoleName(RoleName rolename);
}
