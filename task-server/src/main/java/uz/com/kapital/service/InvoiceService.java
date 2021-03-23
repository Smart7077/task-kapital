package uz.com.kapital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.com.kapital.entity.Invoice;
import uz.com.kapital.payload.ResInvoice;
import uz.com.kapital.payload.ResInvoiceOrder;
import uz.com.kapital.projection.ResOverpaidInvoice;
import uz.com.kapital.repository.InvoiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public List<ResInvoice> getInvoices() {
        List<Invoice> invoiceList = invoiceRepository.getExpiredInvoices();
        return invoiceList.stream().map(this::getInvoice).collect(Collectors.toList());
    }

    public List<ResInvoiceOrder> getInvoiceOrder() {
        List<Invoice> invoiceList = invoiceRepository.getWrongDateInvoices();
        return invoiceList.stream().map(this::getwrongDateInvoices).collect(Collectors.toList());
    }

    public ResInvoice getInvoice(Invoice invoice) {
        return new ResInvoice(
                invoice.getId(),
                invoice.getOrder().getId(),
                invoice.getAmount(),
                invoice.getIssued(),
                invoice.getDue()
        );

    }

    public ResInvoiceOrder getwrongDateInvoices(Invoice invoice) {
        return new ResInvoiceOrder(
                invoice.getId(),
                invoice.getIssued(),
                invoice.getOrder().getId(),
                invoice.getOrder().getDate()
        );
    }

    public List<ResOverpaidInvoice> getoverPaid() {
        List<ResOverpaidInvoice> invoiceList = invoiceRepository.getInvoivesOverPaid();
        return invoiceList.stream().map(this::getInvoiceOrder).collect(Collectors.toList());
    }

    public ResOverpaidInvoice getInvoiceOrder(ResOverpaidInvoice resOverpaidInvoice) {
        return new ResOverpaidInvoice() {
            @Override
            public Integer getNumber() {
                return resOverpaidInvoice.getNumber();
            }

            @Override
            public Double getAmount() {
                return resOverpaidInvoice.getAmount();
            }
        };
    }
}
