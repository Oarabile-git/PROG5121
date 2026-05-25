package com.mycompany.chatapplication;

/**
 *
 * @author Oarabile Mbuyane
 */
public class Login {
    private String username;
    private String password;
    private String cellphone;
    private String firstName;
    private String lastName;
    
public Login(String username, String password, String cellphone,
String firstName, String lastName) {
this.username = username;
this.password = password;
this.cellphone = cellphone;
this.firstName = firstName;
this.lastName = lastName;
}
public boolean checkUserName() {
return username.contains("_") && username.length() <= 5;
}
public boolean checkPasswordComplexity() {
boolean length = password.length() >= 8;
boolean capital = password.matches(".*[A-Z].*");
boolean number = password.matches(".*[0-9].*");
boolean special = password.matches(".*[^a-zA-Z0-9].*");
return length && capital && number && special;
}
public boolean checkCellPhoneNumber() {
return cellphone.matches("^\\\\+27[0-9]{9}$");
}
public String registerUser() {
if (!checkUserName()) {
return "Username is not correctly formatted.";
}
if (!checkPasswordComplexity()) {
return "Password is not correctly formatted.";
}
if (!checkCellPhoneNumber()) {
return "Cell phone number incorrectly formatted.";
}
return "User registered successfully.";
}
public boolean loginUser(String enteredUsername, String enteredPassword) {
return enteredUsername.equals(username)
&& enteredPassword.equals(password);
}
public String returnLoginStatus(boolean loginSuccess) {
if (loginSuccess) {
return "Welcome " + firstName + ", " + lastName +
" it is great to see you again.";
}
return "Username or password incorrect, please try again.";
}
}