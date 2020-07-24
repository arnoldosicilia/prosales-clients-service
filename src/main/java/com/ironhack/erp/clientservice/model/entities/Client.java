package com.ironhack.erp.clientservice.model.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Client Entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "clients")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nif;
    private String email;
    private String commercialName;
    private String fiscalName;
    private String address;
    private String city;
    private String province;
    private Integer zipCode;
    private String country;
    private String web;
    private String telNumber;
    private Long credit;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Client(String nif, String email, String commercialName, String fiscalName, String address, String city, String province, Integer zipCode, String country, String web, String telNumber, Long credit) {
        this.nif = nif;
        this.email = email;
        this.commercialName = commercialName;
        this.fiscalName = fiscalName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.zipCode = zipCode;
        this.country = country;
        this.web = web;
        this.telNumber = telNumber;
        this.credit = credit;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


