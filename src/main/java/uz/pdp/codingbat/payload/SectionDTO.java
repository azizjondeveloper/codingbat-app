package uz.pdp.codingbat.payload;


import lombok.Getter;
import lombok.Setter;
import uz.pdp.codingbat.entity.Language;

@Getter
@Setter
public class SectionDTO {

    private Short id;

    private String description;

    private Short maxRate;

    private String title;

    private String url;

    private Language language;

}
