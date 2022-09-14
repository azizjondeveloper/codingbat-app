package uz.pdp.codingbat.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import uz.pdp.codingbat.entity.template.AbcUUIDUserAndTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@Setter
@Getter
public class AttachmentContent extends AbcUUIDUserAndTime {



    private byte[] content;

    @OneToOne
    private Attachment attachment;

}
