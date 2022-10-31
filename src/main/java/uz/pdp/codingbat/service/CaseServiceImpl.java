package uz.pdp.codingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Case;
import uz.pdp.codingbat.entity.Problem;
import uz.pdp.codingbat.payload.AddCaseDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;
import uz.pdp.codingbat.repository.CaseRepositary;
import uz.pdp.codingbat.repository.ProblemRepositary;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CaseServiceImpl implements CaseService{



    @Autowired
    private CaseRepositary caseRepositary;


    @Autowired
    private ProblemRepositary problemRepositary;


    @Override
    public ApiResult add(AddCaseDTO addCaseDTO) {
        Case newCase = mapCaseDTOToCase(addCaseDTO, new Case());
        caseRepositary.save(newCase);
        return ApiResult.successResponse();
    }

    @Override
    public List<CaseDTO> getAll() {
        List<Case> caseList = caseRepositary.findAll();
        return mapCaseListToCaseDTOList(caseList);
    }



    @Override
    public CaseDTO get(Long id) {
        Case aCase = caseRepositary.findById(id)
                .orElseThrow(IllegalStateException::new);
        return mapCaseToCaseDTO(aCase);
    }




    @Override
    public ApiResult edit(Long id, AddCaseDTO addCaseDTO) {
        Case findCase = caseRepositary.findById(id)
                .orElseThrow(IllegalStateException::new);

        Case editCase = mapCaseDTOToCase(addCaseDTO, findCase);
        caseRepositary.save(editCase);
        return ApiResult.successResponse();
    }

    @Override
    public ApiResult delete(Long id) {
        caseRepositary.deleteById(id);
        return ApiResult.successResponse();
    }



    private List<CaseDTO> mapCaseListToCaseDTOList(List<Case> caseList) {
        return caseList.stream()
                .map(this::mapCaseToCaseDTO)
                .collect(Collectors.toList());

    }




    private CaseDTO mapCaseToCaseDTO(Case aCase) {
        CaseDTO caseDTO = new CaseDTO();
        caseDTO.setArgs(aCase.getArgs());
        caseDTO.setExpected(aCase.getExpected());
        caseDTO.setProblem(aCase.getProblem());
        return caseDTO;
    }



    private Case mapCaseDTOToCase(
            AddCaseDTO addCaseDTO,
            Case cases){

        Problem problem = problemRepositary
                .findById((addCaseDTO.getProblemId()))
                .orElseThrow(IllegalStateException::new);

        cases.setArgs(addCaseDTO.getArgs());
        cases.setExpected(addCaseDTO.getExpected());
        cases.setProblem(problem);
        return cases;
    }

}
