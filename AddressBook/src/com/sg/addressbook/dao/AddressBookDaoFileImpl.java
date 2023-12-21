package com.sg.addressbook.dao;

import com.sg.addressbook.dto.AddressBook;

import java.io.*;
import java.util.*;

public class AddressBookDaoFileImpl implements AddressBookDao {
    public static final String BOOK_FILE = "addressBook.txt";
    public static final String DELIMITER = "::";
    private Map<String, AddressBook> addressInfo = new HashMap<>();

    @Override
    public AddressBook addAddress(String lastName, AddressBook addressBook)
            throws AddressBookDaoException {
        loadRoster();
        AddressBook newAddress = addressInfo.put(lastName,addressBook);
        writeRoster();
        return newAddress;
    }

    @Override
    public List<AddressBook> getAllAddress()
            throws AddressBookDaoException {
        loadRoster();
        return new ArrayList(addressInfo.values());
    }



    @Override
    public AddressBook getLastName(String lastName)
            throws AddressBookDaoException {
        loadRoster();
        return addressInfo.get(lastName);
    }

    @Override
    public AddressBook removeStudent(String studentId)
            throws AddressBookDaoException {
        loadRoster();
        AddressBook removedStudent = addressInfo.remove(studentId);
        writeRoster();
        return removedStudent;
    }
   @Override
    public int countAllAddress() {
        return addressInfo.size();
    }

    private AddressBook unmarshallStudent(String addressAsText) {

        String[] studentTokens = addressAsText.split(DELIMITER);

        String lastName = studentTokens[0];

        // Which we can then use to create a new AddressBook object to satisfy
        // the requirements of the AddressBook constructor.
        AddressBook addressFromFile = new AddressBook(lastName);

        // However, there are 3 remaining tokens that need to be set into the
        // new student object. Do this manually by using the appropriate setters.

        // Index 1 - FirstName
        addressFromFile.setAddress(studentTokens[1]);

        // Index 2 - Address
        addressFromFile.setFirstName(studentTokens[2]);

        // We have now created a student! Return it!
        return addressFromFile;
    }

    private void loadRoster() throws AddressBookDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(BOOK_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException(
                    "-_- Could not load address data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        AddressBook currentAddress;
        // Go through ROSTER_FILE line by line, decoding each line into a
        // AddressBook object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a AddressBook
            currentAddress = unmarshallStudent(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            addressInfo.put(currentAddress.getAddress(), currentAddress);
        }
        // close scanner
        scanner.close();
    }

    private String marshallStudent(AddressBook aStudent) {
        // We need to turn a AddressBook object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer.

        // Start with the student id, since that's supposed to be first.
        String addressAsText = aStudent.getAddress() + DELIMITER;

        // add the rest of the properties in the correct order:

        // FirstName
        addressAsText += aStudent.getFirstName() + DELIMITER;

        // LastName
        addressAsText += aStudent.getLastName();



        // We have now turned a student to text! Return it!
        return addressAsText;
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
     * for file format.
     *
     * @throws AddressBookDaoException if an error occurs writing to the file
     */
    private void writeRoster() throws AddressBookDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(BOOK_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException(
                    "Could not save student data.", e);
        }

        // Write out the AddressBook objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String studentAsText;
        List<AddressBook> studentList = this.getAllAddress();
        for (AddressBook currentStudent : studentList) {
            // turn a AddressBook into a String
            studentAsText = marshallStudent(currentStudent);
            // write the AddressBook object to the file
            out.println(studentAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
