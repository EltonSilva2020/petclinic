package be.com.elton.sfgpetclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends AbstractModel {

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "petType", referencedColumnName = "id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Owner owner;

    @Column(name = "Birth_date", length = 50, nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public Pet(String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {

        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;

        if (visits == null || visits.size() > 0) {
            this.visits = visits;
        }
    }
}
