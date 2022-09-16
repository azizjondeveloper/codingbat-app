package uz.pdp.codingbat.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.codingbat.entity.role.Permission;
import uz.pdp.codingbat.entity.template.AbcUUIDUserAndTime;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
public class User implements UserDetails {
//extends AbcUUIDUserAndTime

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean credentialsNonExpired = true;

    private boolean enabled = false;


    @ManyToMany(fetch = FetchType.EAGER)
    List<Permission> permissions;

    @Column(unique = true)
    private UUID emailCode;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //todo role and permissions
        return permissions;
    }
}
