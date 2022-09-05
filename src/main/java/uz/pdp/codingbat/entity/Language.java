package uz.pdp.codingbat.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.codingbat.utils.RestConstants;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String url;

    public Language(String title) {
        this.title = title;
        setUrl(title);
    }

    private void setUrl(String title) {
        url = RestConstants.makeUrl(title);

    }
}
