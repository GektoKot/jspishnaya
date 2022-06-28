package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hobby")
@NoArgsConstructor
@Getter
@Setter
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "hobby_id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToMany(
            mappedBy = "hobby",
            fetch = FetchType.EAGER)
    private List<User> users;

    public Hobby(String name) {
        this.name = name;
    }
}
