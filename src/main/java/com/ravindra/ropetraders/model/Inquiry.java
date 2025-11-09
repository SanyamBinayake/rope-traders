package com.ravindra.ropetraders.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "inquiries")
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String customerName;
    private String email;
    private String phone;
    private String message;
    private LocalDateTime createdAt = LocalDateTime.now();
}
