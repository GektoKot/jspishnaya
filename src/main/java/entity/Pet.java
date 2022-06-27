package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pet")
@NoArgsConstructor
@Getter @Setter
public class Pet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public Pet(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
