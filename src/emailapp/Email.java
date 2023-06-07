package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "company.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your passoword is: " + password);
        this.email = createEmail();
    }

    private String createEmail() {
        if (this.department.equals("none")) {
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
        } else {
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        }
    }

    private String  setDepartment() {
        System.out.println("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) { return "sales"; }
        else if (departmentChoice == 2) { return "development"; }
        else if (departmentChoice == 3 ) { return "accounting"; }
        else return "none";

    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    public String showInfo() {
        return "DISPLAY NAME: " + this.firstName + " " + this.lastName +
                "\nCOMPANY EMAIL: " + this.email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String getPassword() {
        return password;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
}
