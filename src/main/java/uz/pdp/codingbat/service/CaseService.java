package uz.pdp.codingbat.service;

import uz.pdp.codingbat.payload.AddCaseDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;

import java.util.List;

public interface CaseService {


    ApiResult add(AddCaseDTO addCaseDTO);



    List<CaseDTO> getAll();



    CaseDTO get(Long id);



    ApiResult edit( Long id, AddCaseDTO addCaseDTO);



    ApiResult delete(Long id);

}
