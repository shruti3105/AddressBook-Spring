package com.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.addressbook.DTO.AddressBookDTO;
import com.addressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {

	private List<AddressBookData> contactDataList = new ArrayList<>();

	@Override
	public List<AddressBookData> getAddressBookContactData() {
		return contactDataList;
	}

	@Override
	public AddressBookData getAddressBookContactDataById(int id) {
		return contactDataList.get(id - 1);
	}

	@Override
	public AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(contactDataList.size() + 1, addressBookDTO);
		contactDataList.add(contactData);
		return contactData;
	}

	@Override
	public AddressBookData updateAddressBookContactData(int id, AddressBookDTO addressBookDTO) {
		AddressBookData contactData = this.getAddressBookContactDataById(id);
		contactData.setFullName(addressBookDTO.fullName);
		contactData.setAddress(addressBookDTO.address);
		contactData.setCity(addressBookDTO.city);
		contactData.setState(addressBookDTO.state);
		contactData.setZip(addressBookDTO.zip);
		contactData.setPhoneNumber(addressBookDTO.phoneNumber);
		contactDataList.set(id - 1, contactData);
		return contactData;
	}

	@Override
	public void deleteAddressBookContactData(int id) {
		contactDataList.remove(id - 1);
	}

}