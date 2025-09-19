package com.sweetshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sweets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sweet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	private String category;

	private double price;

	private int quantity;
}
