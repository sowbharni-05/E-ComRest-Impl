package com.banfico.EcomApplication.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
@NamedQuery(name = "Payment.getBypayTypeMatch",
        query = "SELECT p FROM Payment p WHERE p.payType =:pType"
)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private String payType;

    @JsonManagedReference(value = "paymentRef")
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "payment")
    private OrderDetail orderdetail;
}
