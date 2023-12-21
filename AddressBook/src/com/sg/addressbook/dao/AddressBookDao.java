package com.sg.addressbook.dao;

import com.sg.addressbook.dto.AddressBook;

import java.util.List;

public interface AddressBookDao {
    AddressBook addAddress( String lastName, AddressBook addressBook)
            throws AddressBookDaoException;
    List<AddressBook> getAllAddress()
            throws AddressBookDaoException;
    AddressBook getLastName(String lastName)
            throws AddressBookDaoException;
    AddressBook removeStudent(String studentId)
            throws AddressBookDaoException;
    int countAllAddress()
        throws AddressBookDaoException;

}
