package uz.pdp.codingbat.service;

import org.springframework.stereotype.Service;
import uz.pdp.codingbat.payload.AddLanguageDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;

import java.util.List;

@Service

public class LanguageServiceImpl implements LanguageService{
    @Override
    public ApiResult add(AddLanguageDTO addLanguageDTO) {
        //todo yoz logicni
        return new ApiResult();
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
