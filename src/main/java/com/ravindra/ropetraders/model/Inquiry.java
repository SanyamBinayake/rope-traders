package com.ravindra.ropetraders.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Inquiry {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String productName;
  private String customerName;
  private String email;
  private String phone;

  @Column(length = 2000)
  private String message;

  private String location;
  private LocalDateTime createdAt;
}
