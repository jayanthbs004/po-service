package com.ust.poservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.poservice.entity.PurchaseOrder;
import com.ust.poservice.service.PurchaseOrderService;

@RestController
@RequestMapping("/api/po")
public class PurchaseOrderController {
    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PurchaseOrder> addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder savedPO = service.addPurchaseOrder(purchaseOrder);
        return ResponseEntity.ok(savedPO);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        List<PurchaseOrder> purchaseOrders = service.getAllPurchaseOrders();
        return ResponseEntity.ok(purchaseOrders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable Long id) {
        PurchaseOrder purchaseOrder = service.getPurchaseOrderById(id);
        return ResponseEntity.ok(purchaseOrder);
    }

    // @GetMapping("/employee-details/{employeeId}")
    // public ResponseEntity<Object> getEmployeeDetails(@PathVariable Long employeeId) {
    //     Object employeeDetails = service.getEmployeeDetails(employeeId);
    //     return ResponseEntity.ok(employeeDetails);
    // }

    // @GetMapping("/project-details/{projectId}")
    // public ResponseEntity<Object> getProjectDetails(@PathVariable Long projectId) {
    //     Object projectDetails = service.getProjectDetails(projectId);
    //     return ResponseEntity.ok(projectDetails);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePurchaseOrder(@PathVariable Long id) {
        service.deletePurchaseOrder(id);
        return ResponseEntity.ok("Purchase Order deleted successfully!");
    }

    @GetMapping("/details/{poId}")
    public ResponseEntity<Map<String, Object>> getProjectAndEmployeeDetailsByPoId(@PathVariable Long id) {
        Map<String, Object> details = service.getProjectAndEmployeeDetailsByPoId(id);
        if (details == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(details);
    }
}
