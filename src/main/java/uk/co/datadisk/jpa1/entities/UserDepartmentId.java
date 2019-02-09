package uk.co.datadisk.jpa1.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserDepartmentId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "department_id")
    private Long departmentId;

    public UserDepartmentId() { }

    public UserDepartmentId(Long userId, Long departmentId) {
        this.userId = userId;
        this.departmentId = departmentId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
