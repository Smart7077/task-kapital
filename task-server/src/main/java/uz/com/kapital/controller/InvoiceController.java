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
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/expiredInvoices")
    public HttpEntity<?> getExpiredInvoice() {
        return ResponseEntity.ok(invoiceService.getInvoices());
    }

    @GetMapping("/wrongDateInvoices")
    public HttpEntity<?> getWrongDateInvoices() {
        return ResponseEntity.ok(invoiceService.getInvoiceOrder());
    }

    @GetMapping("/overpaid_invoices")
    public HttpEntity<?> getOverpaidInvoices() {
        return ResponseEntity.ok(invoiceService.getoverPaid());
    }
}
