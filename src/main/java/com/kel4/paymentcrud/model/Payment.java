package com.kel4.paymentcrud.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "staff_id")
    private int staffId;

    @Column(name = "rental_id")
    private int rentalId;

    @Column(name = "amount")
    private float amount;

    @CreatedDate
    @Column(name = "payment_date", updatable = false)
    private Date paymentDate;

    @Basic(optional = false)
    @Column(name = "last_update")
    private Date lastUpdate;

}
