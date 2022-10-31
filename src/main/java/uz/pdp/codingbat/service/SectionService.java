package uz.pdp.codingbat.service;


import uz.pdp.codingbat.payload.AddSectionDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SectionDTO;

import java.util.List;

public interface SectionService {

    ApiResult add(AddSectionDTO addSectionDTO);


    List<SectionDTO> getAll();


    SectionDTO get(Short id);


    ApiResult edit(Short id, AddSectionDTO addSectionDTO);


    ApiResult delete(Short id);
}
