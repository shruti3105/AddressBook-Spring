package com.addressbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.DTO.AddressBookDTO;
import com.addressbook.DTO.ResponseDTO;
import com.addressbook.model.AddressBookData;

@RestController
@RequestMapping(value = "/addressbookservice")
public class AddressBookController {

	@GetMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getAddressBookContactData() {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, new AddressBookDTO("Shruti Verma", "Awas Vikas-1", "Kanpur",
				"Uttar Pradesh", "208017", "+91 7376563320"));
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookContactData(@PathVariable("id") int id) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, new AddressBookDTO("Tapasya Chaudhary", "234v road", "Dehradun",
				"Uttarakhand", "996644", "+91 9876543278"));
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successfull for id: " + id, contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookContactData(@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Address Book Contact Data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBookContactData(@PathVariable("id") int id,
			@RequestBody AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Address Book Contact Data Successfully", contactData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookContactData(@PathVariable("id") int id) {
		ResponseDTO responseDTO = new ResponseDTO("Deleted Address Book Contact Data Successfully", "Deleted id: " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}