package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.Section;

public interface SectionRepositary extends JpaRepository<Section, Short> {
}
