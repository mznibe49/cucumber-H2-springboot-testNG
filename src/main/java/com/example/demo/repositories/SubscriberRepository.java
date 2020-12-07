package com.example.demo.repositories;

import com.example.demo.model.Subscriber;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {

    Iterable<Subscriber> findAll();

    @Modifying
    @Query(value = "update Subscriber set address = ?2 where address = ?1", nativeQuery = true)
    void updateSubscriberAddress(String oldAddress, String newAddress);

    @Query(value = "Select * from Subscriber where lastName = ?1", nativeQuery = true)
    Subscriber findByLastName(String lastName);

}
