package uz.pdp.codingbat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.AddProblemDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.ProblemDTO;
import uz.pdp.codingbat.service.ProblemService;

import java.util.List;

@RestController
public class ProblemControllerImpl implements ProblemController{


    @Autowired
    private ProblemService problemService;


    @Override
    public ApiResult add(AddProblemDTO addProblemDTO) {
        return problemService.add(addProblemDTO);
    }

    @Override
    public List<ProblemDTO> getAll() {
        return problemService.getAll();
    }

    @Override
    public ProblemDTO get(Integer id) {
        return problemService.get(id);
    }

    @Override
    public ApiResult edit(Integer id, AddProblemDTO addProblemDTO) {
        return problemService.edit(id, addProblemDTO);
    }

    @Override
    public ApiResult delete(Integer id) {
        return problemService.delete(id);
    }
}
