package uz.pdp.codingbat.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.security.core.userdetails.User;
import uz.pdp.codingbat.entity.template.AbcUUIDUserAndTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Setter
@Getter
public class Attachment extends AbcUUIDUserAndTime {



    private String name;

    private Long size;

    private String contentType;



}
