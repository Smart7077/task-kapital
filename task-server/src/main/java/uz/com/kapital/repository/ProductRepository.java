package uz.com.kapital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.com.kapital.entity.Product;
import uz.com.kapital.projection.ResBulkProduct;
import uz.com.kapital.projection.ResHighDemandProduct;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p.id as code,COUNT(d.pr_id) as totalOrder  from detail d,product p where p.id=d.pr_id group by(p.id) HAVING COUNT(d.pr_id)>10", nativeQuery = true)
    List<ResHighDemandProduct> getHighDemandProduct();

    @Query(value = "select p.id as code,p.price as Price  from detail d,product p where p.id=d.pr_id and d.quantity>=8 group by(p.id,p.price)", nativeQuery = true)
    List<ResBulkProduct> getBulkProduct();
}
