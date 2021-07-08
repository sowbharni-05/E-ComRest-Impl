package com.banfico.EcomApplication.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name="customer")
@EntityListeners(AuditingEntityListener.class)
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    private String emailId;
  //  private String address;
    private String phNo;
  // private String pinCode;

    @CreatedDate
    private Date CreatedDate;
    @LastModifiedDate
    private Date ModifiedDate;

    @ElementCollection
    @CollectionTable(name = "Customer_Address",joinColumns = @JoinColumn(name = "CustomerId",referencedColumnName = "customerId"))
    private List<Address> addresses;
   // private Set<Address> addressSet;ImmutableCollection error


    @JsonManagedReference("customerRef")
    @OneToMany(targetEntity = OrderDetailEntity.class,
            mappedBy = "customerDetails",cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderDetailEntity> orderDetails;

}
