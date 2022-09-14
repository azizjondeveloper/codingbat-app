package uz.pdp.codingbat.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import uz.pdp.codingbat.entity.template.AbcIntAuditingUserAndTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Language extends AbcIntAuditingUserAndTime {



    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String url;


}
