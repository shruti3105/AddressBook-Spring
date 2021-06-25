package com.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.addressbook.DTO.AddressBookDTO;
import com.addressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService{

	@Override
	public List<AddressBookData> getAddressBookContactData() {
		List<AddressBookData> contactDataList = new ArrayList<>();
		contactDataList.add(new AddressBookData(1, new AddressBookDTO("Arpit Verma", "1234-A Lane", "Surat",
				"Gujarat", "665544", "+91 9988776655")));
		return contactDataList;
	}

	@Override
	public AddressBookData getAddressBookDataContactById(int id) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(id, new AddressBookDTO("Arpit Verma", "1234-A Lane", "Surat",
				"Gujarat", "665544", "+91 9988776655"));
		return contactData;
	}

	@Override
	public AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(1, addressBookDTO);
		return contactData;
	}

	@Override
	public AddressBookData updateAddressBookContactData(int id, AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(id, addressBookDTO);
		return contactData;
	}

	@Override
	public void deleteAddressBookContactData(int id) {
				
	}

}