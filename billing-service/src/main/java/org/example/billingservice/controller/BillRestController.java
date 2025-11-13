package org.example.billingservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.billingservice.entities.Bill;
import org.example.billingservice.feign.CustomerServiceRestClient;
import org.example.billingservice.feign.InventoryServiceRestClient;
import org.example.billingservice.model.Customer;
import org.example.billingservice.repository.BillRepository;
import org.example.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BillRestController {

    private final BillRepository billRepository;
    private  final ProductItemRepository productItemRepository;
    private final CustomerServiceRestClient customerServiceRestClient;
    private final InventoryServiceRestClient inventoryServiceRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id){
        Bill bill = billRepository.findById(id).orElse(null);
        assert bill != null;
        Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> productItem.setProduct(inventoryServiceRestClient.getProduct(productItem.getProductId())));
        return bill;
    }


}
