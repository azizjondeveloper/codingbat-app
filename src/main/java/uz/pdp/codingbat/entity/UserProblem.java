package uz.pdp.codingbat.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class UserProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Problem problem;

    @Column(columnDefinition = "text")
    private String solution;

    private boolean solved;
}
