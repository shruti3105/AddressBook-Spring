package com.addressbook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.addressbook.model.AddressBookData;

@Repository
public interface AddressBookRepository extends CrudRepository<AddressBookData, Integer> {

}