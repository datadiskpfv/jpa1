package uk.co.datadisk.jpa1.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_departments")
public class UserDepartment {

    @EmbeddedId
    private UserDepartmentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("departmentId")
    private Department department;

    @Column(name = "created_on", updatable = false)
    private Date createdOn = new Date();

    public UserDepartment(User user, Department department) {
        this.user = user;
        this.department = department;
        this.id = new UserDepartmentId(user.getId(), department.getId());
    }
}
