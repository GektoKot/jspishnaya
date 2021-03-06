package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "app_user")
@NoArgsConstructor
@Getter
@Setter
public class User { //implements Serializable

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "app_user_pet",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "pet_id") })
    private List<Pet> pet;
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "app_user_hobby",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "hobby_id") })
    private List<Hobby> hobby;

    public User(int id) {
        this.id = id;
    }
    public User(int id, String name, String surname) {
        this(name, surname);
        this.id = id;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname, List<Pet> pets, List<Hobby> hobbies) {
        this.name = name;
        this.surname = surname;
        this.pet = pets;
        this.hobby = hobbies;
    }

}
