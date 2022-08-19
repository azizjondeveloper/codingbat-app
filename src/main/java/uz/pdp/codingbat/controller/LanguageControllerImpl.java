package uz.pdp.codingbat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.codingbat.payload.AddLanguageDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;
import uz.pdp.codingbat.service.LanguageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LanguageControllerImpl implements LanguageController {

    private final LanguageService languageService;

    @Override
    public ApiResult add(AddLanguageDTO addLanguageDTO) {
        return languageService.add(addLanguageDTO);
    }

    @Override
    public List<LanguageDTO> getAll() {
        return null;
    }

    @Override
    public LanguageDTO get(Short id) {
        return null;
    }

    @Override
    public ApiResult edit(Short id, LanguageDTO languageDTO) {
        return null;
    }

    @Override
    public ApiResult delete(Short id) {
        return null;
    }
}
