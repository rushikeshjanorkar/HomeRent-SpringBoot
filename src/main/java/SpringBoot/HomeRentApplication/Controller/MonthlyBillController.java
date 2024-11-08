package SpringBoot.HomeRentApplication.Controller;

import SpringBoot.HomeRentApplication.Entity.MonthalyBill;
import SpringBoot.HomeRentApplication.Repository.MonthlyBillRepository;
import SpringBoot.HomeRentApplication.Service.MonthlyBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monthly-bills/")
@CrossOrigin(origins = "*")
public class MonthlyBillController {

    @Autowired
    private  MonthlyBillService service;

    @Autowired
    private MonthlyBillRepository monthlyBillRepository;

    @GetMapping
    public List<MonthalyBill> getAllBills() {
        return service.getAllBills();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonthalyBill> getBillById(@RequestParam Integer id) {
        System.out.println("serial"+id);
        return service.getBillById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MonthalyBill> getMonthlyBillById(@PathVariable Integer id) {

        Optional<MonthalyBill> bill = service.findById(id);
        return bill.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/post")
    public MonthalyBill createBill(@RequestBody MonthalyBill bill) {
        return service.createBill(bill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonthalyBill> updateBill(@PathVariable int id, @RequestBody MonthalyBill bill) {
        return ResponseEntity.ok(service.updateBill(id, bill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Integer id) {
        service.deleteBill(id);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/generate-pdf")
//    public ResponseEntity<byte[]> generateBillPdf(@RequestBody MonthalyBill bill) {
//        // Calculate bill first
//        MonthalyBill calculatedBill = createBill(bill);
//
//        // Generate PDF
//        byte[] pdfBytes = service.generateBillPdf(calculatedBill);
//
//        // Return PDF as a downloadable response
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=bill.pdf")
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(pdfBytes);
//    }




}
