package org.example.oneToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "address", schema = "test")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private String city;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Address{" +
                " id = " + id +
                " city = " + city +
                " user = " + user +
                '}';
    }
}
