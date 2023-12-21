package com.sg.addressbook.ui;

import com.sg.addressbook.dto.AddressBook;

import java.util.List;

public class AddressBookView {

    private final UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Initial Menu:");
        io.print("1. Create New AddressBook");
        io.print("2. Remove a AddressBook");
        io.print("3. View a AddressBook");
        io.print("4. Amount of Addresses Currently");
        io.print("5. List of All Addresses");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public AddressBook getNewStudentInfo() {

        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String address = io.readString("Please enter Address");

        AddressBook currentAddress = new AddressBook(lastName);
        currentAddress.setAddress(address);
        currentAddress.setFirstName(firstName);

        return currentAddress;
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "AddressBook successfully created.  Please hit enter to continue");
    }

    public void displayStudentList(List<AddressBook> addressList) {
        for (AddressBook currentAddress : addressList) {
            String studentInfo = String.format("#%s : %s %s",
                    currentAddress.getAddress(),
                    currentAddress.getFirstName(),
                    currentAddress.getLastName());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }

    public void displayDisplayStudentBanner() {
        io.print("=== Display AddressBook ===");
    }

    public String getLastNameChoice() {
        return io.readString("Please enter last name.");
    }

    public void displayOneAddressInfo(AddressBook address) {
        if (address != null) {
            io.print("Address: " + address.getAddress());
            io.print("Full Name: " + address.getFirstName() + " " + address.getLastName());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveStudentBanner() {
        io.print("=== Remove AddressBook ===");
    }

    public void displayRemoveResult(AddressBook studentRecord) {
        if (studentRecord != null) {
            io.print("AddressBook successfully removed.");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    public void displayCount() {
        io.print("There are this many addresses in this text: ");
    }
    public void displayCreateAddressBanner() {
        io.print("=== Create AddressBook ===");
    }
}

