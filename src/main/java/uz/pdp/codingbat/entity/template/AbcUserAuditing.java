package uz.pdp.codingbat.entity.template;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbcUserAuditing extends AbcTimeStamp{
    @CreatedBy
    private UUID createdBy;

    @LastModifiedBy
    private UUID modifiedBy;
}
