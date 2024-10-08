package org.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt;
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @ManyToMany(targetEntity = Ingredients.class)
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<String> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
