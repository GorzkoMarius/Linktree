package com.project.linked.models;
import com.project.linked.dto.DtoUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id_user")
        })
public class UserModel {
    /*@SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )*/
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String username;
    private String email;
    private String password;
    public void setFields(DtoUser dtoUser) {
        this.id = dtoUser.getId();
        this.username = dtoUser.getUsername();
        this.email = dtoUser.getEmail();
        this.password = dtoUser.getPassword();


    }
}
