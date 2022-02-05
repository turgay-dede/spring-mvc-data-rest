package com.innova.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "computer")
public class ComputerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computer_id")
    private Long computerId;

    @Column(name = "computer_name")
    private String computerName;

    @Column(name = "computer_trade")
    private String computerTrade;

    @Transient // Java için var db te eklenmez
    private String justJava;

    @Column(name = "computer_price")
    private String computerPrice;

//    @Column(name = "computer_price",columnDefinition = "Decimal(18,2 default='100.00'")
//    private String computerPrice;

//    @Column(name = "computer_serial_number",length = 11,nullable = false,unique = true)
//    private int serialComputerNumber;

//    @Lob
//    private String bigData;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;
}
