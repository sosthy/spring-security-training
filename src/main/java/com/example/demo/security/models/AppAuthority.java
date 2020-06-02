package com.example.demo.security.models;

import com.example.demo.audit.Auditable;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "app_auth")
@Audited
@Data @NoArgsConstructor @AllArgsConstructor
public class AppAuthority extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(generator = "auth_generator")
    @SequenceGenerator(
            name = "auth_generator",
            sequenceName = "auth_sequence"
    )
    private Long id;

    @Column(name = "auth_code")
    private String code;

    @Column(name = "auth_name")
    private String authName;

    @Column(name = "auth_desc")
    private String description;
}
