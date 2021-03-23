package uz.com.kapital.projection;

import java.util.Date;

public interface ResOrderWithoutInvoice {
    Integer getId();

    Date getDate();

    Double getTotalPrice();
}
