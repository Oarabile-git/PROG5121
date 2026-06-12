package com.mycompany.chatapplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestMessage {
Message validMessage;
Message invalidRecipient;
Message longMessage;

    public TestMessage() {
        this.validMessage = new Message(
                "00",
                1,
                "+27718963002",
                "Hi Mike, can you join us for dinner tonight?"
        );
        this.invalidRecipient = new Message(
                "00",
                1,
                "08966553",
                "Hello"
        );
        this.longMessage = new Message(
                "00",
                1,
                "+27718963002",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                        + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }


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

    public TestMessage() {

    }

    @Test
    public void testSentMessagesArray() {

        Message.sentMessages.clear();

        Message message = new Message(
                "1234567890",
                "+27838884567",
                "Did you get the cake?");

        Message.sentMessage("Send");

        Message message2 = new Message("1234567891",2,
                "0838884567",
                "It’s dinner time!");

        Message2.sentMessage("Send");

        assertEquals(
                "Did you get the cake?",
                Message.sentMessages.get(0));

        assertEquals(
                "It’s dinner time!",
                Message.sentMessages.get(1));

    }

    @Test
    public void testLongestMessage() {

        Message.storedMessages.clear();

        Message.storedMessages.add(
                "Where are you? You are late! I have asked you to be on time.");

        Message.storedMessages.add(
                "Ok, I am leaving without you.");

        assertEquals(
                "Where are you? You are late! I have asked you to be on time.",
                Message.longestMessage());

    }

    @Test
    public void testSearchMessageID() {

        Message.messageIDs.clear();

        Message.messageIDs.add("07838884567");

        Int result =
                Message.searchMessageID("07838884567");

        assertEquals(0, result);

    }

    @Test
    public void testSearchRecipient() {

        Message.recipients.clear();
        Message.storedMessages.clear();

        Message.recipients.add("+27838884567");

        Message.recipients.add("+27838884567");

        Message.storedMessages.add("Where are you? You are late!");

        Message.storedMessages.add("Ok, I am leaving without you.");

        assertEquals("+27838884567",
                Message.recipients.get(0));

        assertEquals("+27838884567",
                Message.recipients.get(1));

    }

    @Test
    public void testDeleteMessageHash() {

        Message.messageHashes.clear();

        Message.messageHashes.add("AB:1:HELLOWORLD");

        Boolean result =
                Message.deleteHash("AB:1:HELLOWORLD");

        assertTrue(result);

    }

    @Test
    public void testDisplayReport() {

        Message.sentMessages.clear();
        Message.messageHashes.clear();
        Message.recipients.clear();

        Message.sentMessages.add( "Did you get the cake?");

        Message.messageHashes.add("AB:1:DIDCAKE");

        Message.recipients.add("+27838884567");

        assertEquals(1, Message.sentMessages.size());

        assertEquals(1, Message.messageHashes.size());

        assertEquals(1,Message.recipients.size());

    }

} 