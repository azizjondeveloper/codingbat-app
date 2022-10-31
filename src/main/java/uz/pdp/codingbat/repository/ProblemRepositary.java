package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.Problem;

public interface ProblemRepositary extends JpaRepository<Problem, Integer> {
}
