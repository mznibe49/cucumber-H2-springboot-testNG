package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"), name = "Contract")
public class Contract {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String address;

    @ManyToOne @JoinColumn(name="idUser", nullable=false)
    private Subscriber subscriber;

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public long getIdContract() {
        return id;
    }

    public Contract(String address, Subscriber s) {
        this.address = address;
        this.subscriber = s;
    }

    /*public Contract(long id, String address){
        this.id = id;
        this.address = address;
    }*/

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
