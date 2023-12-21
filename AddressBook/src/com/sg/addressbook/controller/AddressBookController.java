package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoException;
import com.sg.addressbook.dto.AddressBook;
import com.sg.addressbook.ui.AddressBookView;

import java.util.List;

public class AddressBookController {

    private final AddressBookView view;
    private final AddressBookDao dao;

    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createAddress();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        countAddresses();
                        break;
                    case 5:
                        listStudents();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createAddress() throws AddressBookDaoException {
        view.displayCreateAddressBanner();
        AddressBook newAddress = view.getNewStudentInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayCreateSuccessBanner();
    }

    private void listStudents() throws AddressBookDaoException {
        view.displayDisplayAllBanner();
        List<AddressBook> studentList = dao.getAllAddress();
        view.displayStudentList(studentList);
    }

    private void viewStudent() throws AddressBookDaoException {
        view.displayDisplayStudentBanner();
        String lastName = view.getLastNameChoice();
        AddressBook address = dao.getLastName(lastName);
        view.displayOneAddressInfo(address);
    }

    private void removeStudent() throws AddressBookDaoException {
        view.displayRemoveStudentBanner();
        String studentId = view.getLastNameChoice();
        AddressBook removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }
    private void countAddresses() throws AddressBookDaoException {
        view.displayCount();
        dao.countAllAddress();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}