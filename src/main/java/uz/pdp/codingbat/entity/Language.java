package uz.pdp.codingbat.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String url;
}
