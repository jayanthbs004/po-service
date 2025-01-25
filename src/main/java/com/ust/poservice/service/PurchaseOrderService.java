package com.ust.poservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ust.poservice.entity.PurchaseOrder;
import com.ust.poservice.feign.EmployeeClient;
import com.ust.poservice.feign.ProjectClient;
import com.ust.poservice.repository.PurchaseOrderRepository;


@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;
    private final EmployeeClient employeeClient;
    private final ProjectClient projectClient;

    public PurchaseOrderService(PurchaseOrderRepository repository, EmployeeClient employeeClient, ProjectClient projectClient) {
        this.repository = repository;
        this.employeeClient = employeeClient;
        this.projectClient = projectClient;
    }

    public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder) {
        return repository.save(purchaseOrder);
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return repository.findAll();
    }

    public PurchaseOrder getPurchaseOrderById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Purchase Order not found"));
    }

    // public Object getEmployeeDetails(Long employeeId) {
    //     return employeeClient.getEmployeeById(employeeId);
    // }

    // public Object getProjectDetails(Long projectId) {
    //     return projectClient.getProjectById(projectId);
    // }

    public void deletePurchaseOrder(Long id) {
        repository.deleteById(id);
    }

        public Map<String, Object> getProjectAndEmployeeDetailsByPoId(Long poId) {
        PurchaseOrder purchaseOrder = repository.findById(poId).orElse(null);
        if (purchaseOrder == null) {
            return null;
        }

        Map<String, Object> details = new HashMap<>();
        details.put("projectDetails", projectClient.getProjectById(purchaseOrder.getProjectId()));
        details.put("employeeDetails", employeeClient.getEmployeeById(purchaseOrder.getEmployeeId()));
        return details;
    }
}
