package uz.pdp.codingbat.entity;

import uz.pdp.codingbat.entity.template.AbcIntAuditingUserAndTime;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"title", "section_id"}))
public class Problem extends AbcIntAuditingUserAndTime {



    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(nullable = false, columnDefinition = "text")
    private String method;

    @ManyToOne(optional = false)
    private Section section;
}
