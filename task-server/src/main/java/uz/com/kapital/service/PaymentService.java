package uz.com.kapital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.com.kapital.entity.Payment;
import uz.com.kapital.payload.ApiResponse;
import uz.com.kapital.payload.ResPayment;
import uz.com.kapital.repository.InvoiceRepository;
import uz.com.kapital.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    InvoiceRepository invoiceRepository;


    public ApiResponse add(Integer id) {
        try {
            Payment payment = new Payment();
            payment.setAmount(0d);
            payment.setInvoice(invoiceRepository.getOne(id));
            Payment savedPayment = paymentRepository.save(payment);
            return new ApiResponse("SUCCESS", true, savedPayment);

        } catch (Exception e) {
            return new ApiResponse("FAILED", false);

        }
    }

    public ResPayment getPayment(Payment payment) {
        return new ResPayment(
                payment.getId(),
                payment.getTime(),
                payment.getAmount(),
                payment.getInvoice().getId()
        );
    }
}
