package uz.pdp.codingbat.entity;

import uz.pdp.codingbat.entity.template.AbcIntAuditingUserAndTime;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cases")
public class Case  extends AbcIntAuditingUserAndTime {



    @Column(nullable = false, columnDefinition = "text")
    private String args;

    @Column(nullable = false, columnDefinition = "text")
    private String expected;

    @ManyToOne(optional = false)
    private Problem problem;


}
