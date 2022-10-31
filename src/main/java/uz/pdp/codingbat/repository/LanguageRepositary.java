package uz.pdp.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.codingbat.entity.Language;

public interface LanguageRepositary extends JpaRepository<Language, Short> {
    boolean existsByTitleAndUrl(String title, String url);
}
