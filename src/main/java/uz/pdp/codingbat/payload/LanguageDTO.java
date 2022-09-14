package uz.pdp.codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDTO {

    private Integer id;

    private String title;

    private String url;

    private Short sectionCount;

    public LanguageDTO(Integer id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }
}
