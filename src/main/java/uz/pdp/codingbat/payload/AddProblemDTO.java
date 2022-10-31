package uz.pdp.codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddProblemDTO {

    private String title;

    private String description;

    private String method;

    private Short sectionId;

}
