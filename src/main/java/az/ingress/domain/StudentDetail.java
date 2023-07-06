package az.ingress.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = StudentDetail.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@FieldDefaults(level = PRIVATE)
public class StudentDetail {
    static final String TABLE_NAME = "student_details";
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            initialValue = 3,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    Long id;
    String address;
    Integer age;
    String email;
    @OneToOne(fetch = LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @JsonBackReference
    @ToString.Exclude
    Student student;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        StudentDetail that = (StudentDetail) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
