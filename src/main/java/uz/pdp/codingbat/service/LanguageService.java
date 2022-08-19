package uz.pdp.codingbat.service;

import org.springframework.stereotype.Service;
import uz.pdp.codingbat.payload.AddLanguageDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;

import java.util.List;

public interface LanguageService {

    ApiResult add(AddLanguageDTO addLanguageDTO);

    List<LanguageDTO> getAll();

    LanguageDTO get(Short id);

    ApiResult edit(Short id, LanguageDTO languageDTO);

    ApiResult delete(Short id);
}
