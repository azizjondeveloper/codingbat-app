package uz.pdp.codingbat.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class AddSectionDTO {


    private String title;


    private String url;


    private Short maxRate;


    private String description;


    private Short languageId;
}
