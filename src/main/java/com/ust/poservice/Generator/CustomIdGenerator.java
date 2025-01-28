package com.ust.poservice.Generator;



// import java.io.Serializable;
// import java.util.UUID;

// import org.hibernate.engine.spi.SharedSessionContractImplementor;
// import org.hibernate.id.IdentifierGenerator;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContextAware;
// import org.springframework.lang.NonNull;
// import org.springframework.stereotype.Component;

// import com.ust.poservice.repository.PurchaseOrderRepository;

// @Component // Register this class as a Spring bean
// public class CustomIdGenerator implements IdentifierGenerator, ApplicationContextAware {

//     private static ApplicationContext applicationContext;

//     @Override
//     public void setApplicationContext(@NonNull ApplicationContext context) {
//         applicationContext = context;
//     }

//     @Override
//     public Serializable generate(SharedSessionContractImplementor session, Object object) {
//         PurchaseOrderRepository purchaseorderRepository = applicationContext.getBean(PurchaseOrderRepository.class);
//         int count = (int) purchaseorderRepository.count();
//         return "PO" + (count + 1) + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
//     }
// }


import java.io.Serializable;
import java.time.Year;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.ust.poservice.repository.PurchaseOrderRepository;

@Component
public class CustomIdGenerator implements IdentifierGenerator, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext context) {
        applicationContext = context;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        // Get the current year and extract the last two digits
        String currentYear = String.valueOf(Year.now().getValue()).substring(2);

        // Fetch the repository bean
        PurchaseOrderRepository purchaseOrderRepository = applicationContext.getBean(PurchaseOrderRepository.class);

        // Count the existing number of records to generate the next sequence
        long count = purchaseOrderRepository.count() + 1;

        // Format the sequence with 4 digits (e.g., 0001, 0002)
        String sequence = String.format("%04d", count);

        // Construct the custom ID
        return "PO" + currentYear + sequence;
    }
}
