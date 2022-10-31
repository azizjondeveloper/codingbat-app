package uz.pdp.codingbat.controller;


import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.payload.AddCaseDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.CaseDTO;

import java.util.List;


@RequestMapping("/case")
public interface CaseController {



    @PostMapping
    ApiResult add(@RequestBody AddCaseDTO addCaseDTO);


    @GetMapping
    List<CaseDTO> getAll();


    @GetMapping("/{id}")
    CaseDTO get(@PathVariable Long id);


    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Long id,
                   @RequestBody AddCaseDTO addCaseDTO);


    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Long id);
}
