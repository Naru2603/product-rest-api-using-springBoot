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
public class Device {

		@Schema(name = "Device ID", example = "2", required = true)
		@Id
	    private Integer id;

		@Schema(name = "Device name", example = "Epson Printer", required = false)
		@Column
	    private String name;
		
		@Schema(name = "Device price", example = "12000", required = true)

		@Column
	    private float price;
}

