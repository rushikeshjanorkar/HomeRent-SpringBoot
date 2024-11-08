package SpringBoot.HomeRentApplication.Repository;

import SpringBoot.HomeRentApplication.Entity.MonthalyBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyBillRepository extends JpaRepository<MonthalyBill, Integer> {

}
