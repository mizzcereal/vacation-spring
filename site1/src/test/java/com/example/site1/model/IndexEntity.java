package com.example.site1.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class IndexEntity {
    
    @Id

    @Column(name = "idx", nullable = false, unique = true)
    private Integer idx;

    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "password", nullable = false)
    private String password;

    @Override
    public String toString(){
        return "IndexEntity [idx = " + idx + ", id = " + id + ", password  = " + password +"]";
    }

}
