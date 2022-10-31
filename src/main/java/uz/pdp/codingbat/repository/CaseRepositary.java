package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.Case;

public interface CaseRepositary extends JpaRepository<Case, Long> {
}
