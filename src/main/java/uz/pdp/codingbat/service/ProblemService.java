package uz.pdp.codingbat.service;


import uz.pdp.codingbat.payload.AddProblemDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.ProblemDTO;

import java.util.List;


public interface ProblemService {

    ApiResult add(AddProblemDTO addProblemDTO);


    List<ProblemDTO> getAll();


    ProblemDTO get(Integer id);


    ApiResult edit(Integer id, AddProblemDTO addProblemDTO);


    ApiResult delete(Integer id);

}
