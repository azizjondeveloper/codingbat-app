package uz.pdp.codingbat.entity;

import lombok.Getter;
import uz.pdp.codingbat.entity.template.AbcIntAuditingUserAndTime;

import javax.persistence.*;

@Entity
@Getter
public class UserProblem extends AbcIntAuditingUserAndTime {


    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Problem problem;

    @Column(columnDefinition = "text")
    private String solution;

    private boolean solved;
}
