package com.example.customerserver.service;

import com.example.customerserver.model.Customer;

public interface UserRepository {
        Customer findById(Long id);
}
