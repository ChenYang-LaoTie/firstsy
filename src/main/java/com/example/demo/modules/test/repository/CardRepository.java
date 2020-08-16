package com.example.demo.modules.test.repository;

import com.example.demo.modules.test.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description CardRepository
 * @Author ChenYang
 * @Date 2020/8/12 19:13
 */

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}
