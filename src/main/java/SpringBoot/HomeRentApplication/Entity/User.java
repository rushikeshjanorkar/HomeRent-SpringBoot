package SpringBoot.HomeRentApplication.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private Long roomId;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    @Lob
    private byte[] photo;
    private String fullName;
    private String address;
    private String contactNumber;
    private Long adminId;
    private Long addharNumber;
    private String role = "USER";

}
