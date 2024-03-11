package com.example.customerserver.service.ServiceIpml;

import com.example.customerserver.model.Customer;
import com.example.customerserver.service.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Service
public class CustomerRepositoryIml implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Customer findById(Long id) {
     Query query=   entityManager.createNativeQuery("SELECT * FROM Customer c WHERE c.id = ?",Customer.class).setParameter(1, id);
        return (Customer)query.getSingleResult();
    }
}
