package uz.com.kapital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ord_id")
    private Order order;

    @Column(columnDefinition = "numeric(8,2)", nullable = false)
    private Double amount;

    @Column(nullable = false, columnDefinition = "Date")
    private Date issued;

    @Column(nullable = false, columnDefinition = "Date")
    private Date due;

}
