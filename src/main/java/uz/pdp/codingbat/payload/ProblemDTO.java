package uz.pdp.codingbat.payload;


import lombok.Getter;
import lombok.Setter;
import uz.pdp.codingbat.entity.Section;

@Getter
@Setter

public class ProblemDTO {

    private Integer id;

    private String title;

    private String description;

    private String method;

    private Section section;
}
