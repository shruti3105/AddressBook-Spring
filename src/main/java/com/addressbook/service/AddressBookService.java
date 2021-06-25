package com.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressbook.DTO.AddressBookDTO;
import com.addressbook.model.AddressBookData;
import com.addressbook.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {
	
	@Autowired
	private AddressBookRepository addressBookRepository;

	@Override
	public List<AddressBookData> getAddressBookContactData() {		
		return (List<AddressBookData>) addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookContactDataById(int id) {
		return addressBookRepository.findById(id).get();
	}

	@Override
	public AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(addressBookDTO);
		return addressBookRepository.save(contactData);
	}

	@Override
	public AddressBookData updateAddressBookContactData(int id, AddressBookDTO addressBookDTO) {
		AddressBookData contactData = this.getAddressBookContactDataById(id);
		if(contactData != null) {
			deleteAddressBookContactData(id);
			contactData.setFullName(addressBookDTO.fullName);
			contactData.setAddress(addressBookDTO.address);
			contactData.setCity(addressBookDTO.city);
			contactData.setState(addressBookDTO.state);
			contactData.setZip(addressBookDTO.zip);
			contactData.setPhoneNumber(addressBookDTO.phoneNumber);
			contactData = addressBookRepository.save(contactData);
			}
		return contactData;
	}

	@Override
	public void deleteAddressBookContactData(int id) {
		addressBookRepository.deleteById(id);
	}
}