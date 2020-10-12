package com.github.habahnow.productsapi.repository;

import com.github.habahnow.productsapi.model.MiniPC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniPCRepository extends JpaRepository<MiniPC, String> {

}
