package uz.com.kapital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(length = 20)
    private String decription;

    @Column(columnDefinition = "numeric(6,2)")
    private Double price;

    @Column(length = 1024)
    private String photo;


}
