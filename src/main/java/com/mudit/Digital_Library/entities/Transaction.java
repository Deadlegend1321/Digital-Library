package com.mudit.Digital_Library.entities;

import com.mudit.Digital_Library.entities.enums.TransactionStatus;
import com.mudit.Digital_Library.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String externalTxnId;

    @CreationTimestamp
    private Date transactionTime;
    @UpdateTimestamp
    private Date updatedOn;

    private TransactionStatus transactionStatus;
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn
    private Book myBook;
    @ManyToOne
    @JoinColumn
    private Student myStudent;

    private Double fine;
}
