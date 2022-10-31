package uz.pdp.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.AddCaseDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;
import uz.pdp.codingbat.service.CaseService;

import java.util.List;


@RestController
public class CaseControllerImpl implements CaseController{



    @Autowired
    private CaseService caseService;


    @Override
    public ApiResult add(AddCaseDTO addCaseDTO) {
        return caseService.add(addCaseDTO);
    }


    @Override
    public List<CaseDTO> getAll() {
        return caseService.getAll();
    }


    @Override
    public CaseDTO get(Long id) {
        return caseService.get(id);
    }


    @Override
    public ApiResult edit(Long id, AddCaseDTO addCaseDTO) {
        return caseService.edit(id, addCaseDTO);
    }


    @Override
    public ApiResult delete(Long id) {
        return caseService.delete(id);
    }
}
