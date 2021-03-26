package uz.com.kapital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.com.kapital.repository.InvoiceRepository;
import uz.com.kapital.repository.OrderRepository;
import uz.com.kapital.service.InvoiceService;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/expired_invoices")
    public HttpEntity<?> getExpiredInvoice() {
        return ResponseEntity.ok(invoiceService.getInvoices());
    }

    @GetMapping("/wrong_date_invoices")
    public HttpEntity<?> getWrongDateInvoices() {
        return ResponseEntity.ok(invoiceService.getInvoiceOrder());
    }

    @GetMapping("/overpaid_invoices")
    public HttpEntity<?> getOverpaidInvoices() {
        return ResponseEntity.ok(invoiceService.getoverPaid());
    }
}
