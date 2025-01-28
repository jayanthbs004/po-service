package com.ust.poservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.poservice.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,String> {
    List<PurchaseOrder> findByProjectId(Long projectId);
    List<PurchaseOrder> findByEmployeeId(Long employeeId);
}
