package org.example.oneToOne;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users", schema = "test")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="employee")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;


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
