package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "app_user")
@NoArgsConstructor
@Getter @Setter
public class User  { //implements Serializable

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private int age;
    @OneToMany
    @Column(name = "pet")
    private List<Pet> pet;

    public User(int id, String name, String surname, int age) {
        this(name, surname, age);
        this.id = id;
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User(int id) {
        this.id = id;
    }
}
