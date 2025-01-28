package com.ust.poservice.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
  @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(
            name = "custom-id-generator",
            strategy = "com.ust.poservice.Generator.CustomIdGenerator"
    )
    private String id;

    @Column(nullable = false, unique = true)
    private String poNumber;

    @Column(nullable = false)
    private Long projectId;

    @Column(nullable = false)
    private Long employeeId;

    @Column(nullable = false)
    private String fundInterval;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String IFSC;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String status;

    // Getters and Setters

    public PurchaseOrder() {
    }

    public PurchaseOrder(String id, String poNumber, Long projectId, Long employeeId, String fundInterval,
            String bankName, String ifsc, String accountNumber, String status) {
        this.id = id;
        this.poNumber = poNumber;
        this.projectId = projectId;
        //this.employeeId = employeeId;
        this.fundInterval = fundInterval;
        this.bankName = bankName;
        this.IFSC = ifsc;
        this.accountNumber = accountNumber;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFundInterval() {
        return fundInterval;
    }

    public void setFundInterval(String fundInterval) {
        this.fundInterval = fundInterval;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIFSC() {
        return IFSC;
    }

    public void setIFSC(String ifsc) {
       this.IFSC = ifsc;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}