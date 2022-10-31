package uz.pdp.codingbat.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Problem;
import uz.pdp.codingbat.entity.Section;
import uz.pdp.codingbat.payload.AddProblemDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.ProblemDTO;
import uz.pdp.codingbat.repository.ProblemRepositary;
import uz.pdp.codingbat.repository.SectionRepositary;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProblemServiceImpl implements ProblemService{


    @Autowired
    private ProblemRepositary problemRepositary;


    @Autowired
    private SectionRepositary sectionRepositary;


    @Override
    public ApiResult add(AddProblemDTO addProblemDTO) {
        Problem problem = mapAddProblemDTOToProblem(addProblemDTO, new Problem());
        problemRepositary.save(problem);
        return ApiResult.successResponse();
    }



    @Override
    public List<ProblemDTO> getAll() {
        List<Problem> problemList = problemRepositary.findAll();
        return mapProblemListToProblemDTOList(problemList);
    }



    @Override
    public ProblemDTO get(Integer id) {
        Problem problem = problemRepositary.findById(id).orElseThrow(IllegalStateException::new);
        return mapProblemToProblemDTO(problem);
    }



    @Override
    public ApiResult edit(Integer id, AddProblemDTO addProblemDTO) {
        Problem problem = problemRepositary
                .findById(id)
                .orElseThrow(IllegalStateException::new);

        Problem editProblem = mapAddProblemDTOToProblem(addProblemDTO, problem);
        problemRepositary.save(editProblem);
        return ApiResult.successResponse();
    }



    @Override
    public ApiResult delete(Integer id) {
        problemRepositary.deleteById(id);
        return ApiResult.successResponse();
    }



    private List<ProblemDTO> mapProblemListToProblemDTOList(List<Problem> problemList) {
        return problemList.stream()
                .map(this::mapProblemToProblemDTO)
                .collect(Collectors.toList());

    }




    private ProblemDTO mapProblemToProblemDTO(Problem problem) {
        ProblemDTO problemDTO = new ProblemDTO();
        problemDTO.setDescription(problem.getDescription());
        problemDTO.setTitle(problem.getTitle());
        problemDTO.setMethod(problem.getMethod());
        problemDTO.setSection(problem.getSection());
        return problemDTO;

    }



    private Problem mapAddProblemDTOToProblem(
            AddProblemDTO addProblemDTO,
            Problem problem){

        Section section = sectionRepositary
                .findById(addProblemDTO.getSectionId())
                .orElseThrow(IllegalStateException::new);

        problem.setTitle(addProblemDTO.getTitle());
        problem.setDescription(addProblemDTO.getDescription());
        problem.setMethod(addProblemDTO.getMethod());
        problem.setSection(section);
        return problem;
    }


}
