package vn.evnhcmc.itc.asset.portal.restapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;

    @CreatedDate
    @Column(name = "CREATED_AT")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @Basic
    @CreatedBy
    @Column(name = "CREATED_BY")
    private Long createdBy;

    @Basic
    @LastModifiedBy
    @Column(name = "UPDATED_BY")
    private Long updatedBy;

    @Basic
    @Column(name = "IS_ACTIVE")
    private boolean active = true;
}
