package org.example.oneToOne;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users", schema = "test")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @OneToOne()
    @JoinColumn(name = "address_id")
    private Address address;

    @Column()
    @CreationTimestamp
    public LocalDateTime createdDate;

    @Override
    public String toString() {
        return "User{" +
                " id= " + id +
                " name= " + name +
                '}';
    }

}
