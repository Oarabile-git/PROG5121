package com.mycompany.chatapplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

public void testCorrectUsername() {
Login login = new Login(
"kyl_1",
"Ch&&sec@ke99!",
"+27838968976",
"Kyle",
"Smith"
);
assertTrue(login.checkUserName());
}
public void testIncorrectUsername() {
Login login = new Login(
"kyle!!!!!!!",
"Ch&&sec@ke99!",
"+27838968976",
"Kyle",
"Smith"
);
assertFalse(login.checkUserName());
}
}

