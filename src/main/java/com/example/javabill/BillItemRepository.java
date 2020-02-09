package com.example.javabill;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
import com.example.javabill.BillItem;

public interface BillItemRepository extends CrudRepository<BillItem, Integer> {
//    Page<BillItem> findByBill_id(Long postId, Pageable pageable);
//    Optional<BillItem> findByIdAndPostId(Long id, Long postId);
}