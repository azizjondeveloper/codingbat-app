package uz.pdp.codingbat.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Language;
import uz.pdp.codingbat.entity.Section;
import uz.pdp.codingbat.payload.AddSectionDTO;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SectionDTO;
import uz.pdp.codingbat.repository.LanguageRepositary;
import uz.pdp.codingbat.repository.SectionRepositary;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService{



    private final SectionRepositary sectionRepositary;



    private final LanguageRepositary languageRepositary;


    @Override
    public ApiResult add(AddSectionDTO addSectionDTO) {
        Section section = mapSectionDTOToSection(addSectionDTO,
                new Section());
        sectionRepositary.save(section);
        return ApiResult.successResponse();
    }


    @Override
    public List<SectionDTO> getAll() {
        List<Section> sectionList = sectionRepositary.findAll();
        return mapSectionListToSectionDTOList(sectionList);
    }



    @Override
    public SectionDTO get(Short id) {
        Section section = sectionRepositary
                .findById(id)
                .orElseThrow(IllegalStateException::new);
        return mapSectionToSectionDTO(section);
    }



    @Override
    public ApiResult edit(Short id, AddSectionDTO addSectionDTO) {
        Section section = sectionRepositary.findById(id)
                .orElseThrow(IllegalStateException::new);

        Section editSection = mapSectionDTOToSection(addSectionDTO, section);
        sectionRepositary.save(editSection);
        return ApiResult.successResponse();
    }


    @Override
    public ApiResult delete(Short id) {
        sectionRepositary.deleteById(id);
        return ApiResult.successResponse();
    }



    private List<SectionDTO> mapSectionListToSectionDTOList(List<Section> sectionList) {
        return sectionList.stream()
                .map(this::mapSectionToSectionDTO)
                .collect(Collectors.toList());

    }




    private Section mapSectionDTOToSection(
            AddSectionDTO addSectionDTO,
            Section section){

        Language language = languageRepositary
                .findById(addSectionDTO.getLanguageId())
                .orElseThrow(IllegalStateException::new);

        section.setTitle(addSectionDTO.getTitle());
        section.setUrl(addSectionDTO.getUrl());
        section.setDescription(addSectionDTO.getDescription());
        section.setMaxRate(addSectionDTO.getMaxRate());
        section.setLanguage(language);

        return section;
    }



    private SectionDTO mapSectionToSectionDTO(Section section) {
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setDescription(section.getDescription());
        sectionDTO.setTitle(section.getTitle());
        sectionDTO.setMaxRate(section.getMaxRate());
        sectionDTO.setUrl(section.getUrl());
        sectionDTO.setLanguage(section.getLanguage());
        return sectionDTO;
    }



}
