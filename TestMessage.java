package com.mycompany.chatapplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestMessage {
Message validMessage = new Message(
"00",
1,
"+27718963002",
"Hi Mike, can you join us for dinner tonight?"
);
Message invalidRecipient = new Message(
"00",
1,
"08966553",
"Hello"
);
Message longMessage = new Message(
"00",
1,
"+27718963002",
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


@Test
public void testMessageIDCorrect() {
assertTrue(validMessage.checkMessageID());
}
@Test
public void testRecipientCorrect() {
assertTrue(validMessage.checkRecipientCell());
}
@Test
public void testRecipientIncorrect() {
assertFalse(invalidRecipient.checkRecipientCell());
}
@Test
public void testMessageHashCreated() {
assertEquals(
"00:1:HIKE,TONIGHT?",
validMessage.createMessageHash()
);
}
@Test
public void testMessageLengthSuccess() {
assertTrue(validMessage.checkMessageLength());
}
@Test
public void testMessageLengthFailure() {
assertFalse(longMessage.checkMessageLength());
}
@Test
public void testSentMessage() {
assertEquals(
"Message successfully sent.",
validMessage.sentMessage("Send")
);
}
}
