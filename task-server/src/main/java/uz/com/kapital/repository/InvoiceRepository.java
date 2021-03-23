package uz.com.kapital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.com.kapital.entity.Invoice;
import uz.com.kapital.projection.ResOverpaidInvoice;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "select * from invoice where (invoice.due-invoice.issued)<0", nativeQuery = true)
    List<Invoice> getExpiredInvoices();

    @Query(value = "select * from invoice where (invoice.due-invoice.issued)>0", nativeQuery = true)
    List<Invoice> getWrongDateInvoices();


    @Query(value = "select i.id as number,Sum(p.amount-i.amount) as amount from invoice i,payment p" +
            " where i.id=p.inv_id and (p.amount-i.amount)>0  group by(i.id)", nativeQuery = true)
    List<ResOverpaidInvoice> getInvoivesOverPaid();

}
