package com.example.javabill;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface BillItemRepository extends CrudRepository<Bill, Integer> {

}