package com.yang.areaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yang.areaservice.data.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
