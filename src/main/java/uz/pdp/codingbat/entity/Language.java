package uz.pdp.codingbat.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.codingbat.entity.template.AbcIntAuditingUserAndTime;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Language extends AbcIntAuditingUserAndTime {



    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String url;


}
