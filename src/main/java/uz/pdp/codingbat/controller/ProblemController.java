package uz.pdp.codingbat.controller;


import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.AddProblemDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.ProblemDTO;

import java.util.List;

@RequestMapping("/problem")
public interface ProblemController {

    @PostMapping
    ApiResult add(@RequestBody AddProblemDTO addProblemDTO);

    @GetMapping
    List<ProblemDTO> getAll();

    @GetMapping("/{id}")
    ProblemDTO get(@PathVariable Integer id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Integer id,
                   @RequestBody  AddProblemDTO addProblemDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Integer id);


}
