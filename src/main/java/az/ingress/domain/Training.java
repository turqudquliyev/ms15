package az.ingress.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = Training.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@FieldDefaults(level = PRIVATE)
public class Training {
    static final String TABLE_NAME = "trainings";
    @Id
    @SequenceGenerator(
            name = "training_sequence",
            sequenceName = "training_sequence",
            initialValue = 3,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "training_sequence"
    )
    Long id;
    String name;
    Integer price;
    @ManyToOne(
            fetch = LAZY,
            cascade = ALL
    )
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @JsonBackReference
    @ToString.Exclude
    Course course;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Training training = (Training) o;
        return getId() != null && Objects.equals(getId(), training.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
