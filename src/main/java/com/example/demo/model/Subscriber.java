package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"), name = "Subscriber")
public class Subscriber {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String address;
    @JsonProperty
    @OneToMany( targetEntity=Contract.class, mappedBy="subscriber" )
    private List<Contract> listContract ;

    public long getIdSubscriber() {
        return id;
    }

    public List<Contract> getListContract() {
        return listContract;
    }

    public void setListContract(List<Contract> listContract) {
        this.listContract = listContract;
    }

    public Subscriber(String firstName, String lastName, String address, ArrayList<Contract> listContract){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.listContract = listContract;
    }

    public Subscriber(String firstName, String lastName, String address){
        this.lastName = lastName;
        this.address = address;
        this.listContract = new ArrayList<>();
    }

    /*public void setAddressInAllContract(String s){
        for(int i = 0; i < listContract.size(); i++){
            //long tmpId = listContract.get(i).getIdContract();
            listContract.set(i, new Contract(s));
        }
    }*/

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addContract(Contract c){
        //this.listContract.add(c);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public List<Contract> getListContract() {
        return listContract;
    }

    public void setListContract(List<Contract> listContract) {
        this.listContract = listContract;
    }*/
}
