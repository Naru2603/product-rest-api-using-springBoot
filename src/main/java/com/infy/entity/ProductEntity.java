package com.infy.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ProductEntity {

	@Schema(name = "Product ID", example = "1", required = true)
	@Id
	private Integer id;
	
	@Schema(name = "Product name", example = "IPhone 15", required = false)
	@Column
	private String name;
	
	@Schema(name = "Product price", example = "150000", required = true)
	@Column
	private float price;
}
