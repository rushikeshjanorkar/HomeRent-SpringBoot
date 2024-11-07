package com.HomeRent.rentApplication.Service;

import com.HomeRent.rentApplication.Entity.MonthalyBill;
import com.HomeRent.rentApplication.Repository.MonthlyBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.ByteArrayOutputStream;


import java.util.List;
import java.util.Optional;

@Service
public class MonthlyBillService {

    @Autowired
    private MonthlyBillRepository repository;

    public List<MonthalyBill> getAllBills() {
        return repository.findAll();
    }

    public Optional<MonthalyBill> getBillById(int serialNo) {
        return repository.findById(serialNo);
    }

    public Optional<MonthalyBill> findById(int id) {
        return repository.findById(id);
    }

    public MonthalyBill createBill(MonthalyBill bill) {
        bill.setTotalReading((bill.getCurrentReading() - bill.getPreviousReading()) *10);
        bill.setTotalBill(bill.getTotalReading()+3200);
        return repository.save(bill);
    }

    public MonthalyBill updateBill(int serialNo, MonthalyBill updatedBill) {
        updatedBill.setId(serialNo);
        updatedBill.setTotalReading((updatedBill.getCurrentReading() - updatedBill.getPreviousReading()) *10);
        updatedBill.setTotalBill(updatedBill.getTotalReading()+3200);
        return repository.save(updatedBill);
    }

    public void deleteBill(int id) {
        repository.deleteById(id);
    }

//    public byte[] generateBillPdf(MonthalyBill bill) {
//        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//            // Initialize PDF document
//            PdfWriter writer = new PdfWriter(out);
//            PdfDocument pdfDoc = new PdfDocument(writer);
//            Document document = new Document(pdfDoc);
//
//            // Custom colors and font sizes
//            Color headerColor = new DeviceRgb(63, 81, 181);  // Indigo color
//            Color textColor = new DeviceRgb(33, 33, 33);     // Dark grey color
//
//            // Title styling
//            Paragraph title = new Paragraph("MonthlyBill Details")
//                    .setFontSize(20)
//                    .setBold()
//                    .setFontColor(headerColor)
//                    .setTextAlignment(TextAlignment.CENTER);
//            document.add(title);
//
//            // Adding space after title
//            document.add(new Paragraph("\n"));
//
//            // Table for bill details
//            Table table = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
//
//            // Header row
//            Cell headerCell1 = new Cell().add(new Paragraph("Description"))
//                    .setBackgroundColor(headerColor)
//
//                    .setTextAlignment(TextAlignment.CENTER)
//                    .setBold()
//                    .setBorder(Border.NO_BORDER);
//            Cell headerCell2 = new Cell().add(new Paragraph("Details"))
//                    .setBackgroundColor(headerColor)
//                    .setTextAlignment(TextAlignment.CENTER)
//                    .setBold()
//                    .setBorder(Border.NO_BORDER);
//
//            table.addHeaderCell(headerCell1);
//            table.addHeaderCell(headerCell2);
//
//            // Data rows with cell styles
//            table.addCell(createStyledCell("Room ID", textColor));
//            table.addCell(createStyledCell(String.valueOf(bill.getRoomId()), textColor));
//
//            table.addCell(createStyledCell("Bill Date", textColor));
//            table.addCell(createStyledCell(bill.getBillDate().toString(), textColor));
//
//            table.addCell(createStyledCell("Previous Reading", textColor));
//            table.addCell(createStyledCell(String.valueOf(bill.getPreviousReading()), textColor));
//
//            table.addCell(createStyledCell("Current Reading", textColor));
//            table.addCell(createStyledCell(String.valueOf(bill.getCurrentReading()), textColor));
//
//            table.addCell(createStyledCell("Total Reading", textColor));
//            table.addCell(createStyledCell(String.valueOf(bill.getTotalReading()), textColor));
//
//            table.addCell(createStyledCell("Total Bill", textColor));
//            table.addCell(createStyledCell(String.valueOf(bill.getTotalBill()), textColor));
//
//            document.add(table);
//
//            document.close();
//            return out.toByteArray(); // Return PDF as byte array
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    // Helper method to style cells
//    private Cell createStyledCell(String content, Color textColor) {
//        return new Cell()
//                .add(new Paragraph(content))
//                .setTextAlignment(TextAlignment.LEFT)
//                .setFontColor(textColor)
//                .setPadding(5)
//                .setBorder(Border.NO_BORDER);
//    }




}
