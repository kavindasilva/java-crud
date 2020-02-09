package com.example.javabill;

import com.example.javabill.Bill;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface BillRepository extends CrudRepository<Bill, Integer> {

}