package uz.pdp.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.payload.AddSectionDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SectionDTO;
import uz.pdp.codingbat.service.SectionService;

import java.util.List;

@RestController
public class SectionControllerImpl implements SectionController{


    @Autowired
    private SectionService sectionService;


    @Override
    public ApiResult add(AddSectionDTO addSectionDTO) {
        return sectionService.add(addSectionDTO);
    }



    @Override
    public List<SectionDTO> getAll() {
        return sectionService.getAll();
    }



    @Override
    public SectionDTO get(Short id) {
        return sectionService.get(id);
    }



    @Override
    public ApiResult edit(Short id, AddSectionDTO addSectionDTO) {
        return sectionService.edit(id, addSectionDTO);
    }



    @Override
    public ApiResult delete(Short id) {
        return sectionService.delete(id);
    }
}
