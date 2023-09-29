package com.infy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.Device;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.log4j.Log4j2;

@Tag(name = "Device", description = "Device management/CRUD APIs")
@Log4j2
@RestController
@RequestMapping("/api/v1")
public class DeviceController {

	
	@Operation(
			summary = "Retrive all Devices",
			method = "getDevices",
			description = "Gets the list of all Devices!!"
			)
	  @ApiResponses({
		    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Device.class), mediaType = "application/json") }),
		    @ApiResponse(responseCode = "404", description = "Error while fetching the Products.", content = { @Content(schema = @Schema()) })
		  })

	@GetMapping("/devices")
	public ResponseEntity<List<Device>> getDevices()
	{
		log.info("Request received to fetch all devices!!");
		Device d1 = new Device(2, "Epson Projector", 36000);
		Device d2 = new Device(3, "DLink Router", 6000);
		
		List<Device> deviceList = new ArrayList<Device>();
		deviceList.add(d1);
		deviceList.add(d2);
		
		return new ResponseEntity<List<Device>>(deviceList, HttpStatus.OK);
	}
}
