package com.addressbook.service;

import java.util.List;

import com.addressbook.DTO.AddressBookDTO;
import com.addressbook.model.AddressBookData;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookContactData();

	AddressBookData getAddressBookContactDataById(int id);

	AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookContactData(int id, AddressBookDTO addressBookDTO);

	void deleteAddressBookContactData(int id);

	List<AddressBookData> getAddressByKeywordName(String keyword);
}