package com.example.rentsystem;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository


public interface BillItemRepository extends CrudRepository<BillItem, Integer> {
//    Page<BillItem> findByBill_id(Integer bill_id, Pageable pageable);
//    Optional<BillItem> findByIdAndPostId(Long id, Long postId);
}