package uz.pdp.codingbat.entity;

import uz.pdp.codingbat.entity.template.AbcIntAuditingUserAndTime;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title", "language_id"}),
        @UniqueConstraint(columnNames = {"url", "language_id"})
})
public class Section extends AbcIntAuditingUserAndTime {


    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Short maxRate;

    @Column(nullable = false,columnDefinition = "text")
    private String description;

    @ManyToOne(optional = false)
    private Language language;
}
