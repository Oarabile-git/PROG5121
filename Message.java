package com.mycompany.chatapplication;

import java.util.ArrayList;


public class Message {
private String messageID;
private int messageNumber;
private String recipient;
private String messageText;

public static ArrayList<String> sentMessages = new ArrayList<>();

public Message(String messageID,
int messageNumber,
String recipient,
String messageText) {
this.messageID = messageID;
this.messageNumber = messageNumber;
this.recipient = recipient;
this.messageText = messageText;
}


public boolean checkMessageID() {
return messageID.length() <= 10;
}


public boolean checkRecipientCell() {
return recipient.matches("^\\+27\\d{9}$");
}


public String createMessageHash() {
String[] words = messageText.split(" ");
String firstWord = words[0];
String lastWord = words[words.length - 1];
return (messageID.substring(0, 2)
+ ":"
+ messageNumber
+ ":"
+ firstWord
+ lastWord)
.toUpperCase();
}


public String sentMessage(String option) {
switch(option) {
case "Send":
sentMessages.add(messageText);
return "Message successfully sent.";
case "Disregard":
return "Press 0 to delete the message.";
case "Store":
return "Message successfully stored.";
default:
return "Invalid option.";
}
}


public String printMessages() {
String output = "";
for(String message : sentMessages) {
output += message + "\\n";
}
return output;
}


public int returnTotalMessages() {
return sentMessages.size();
}

public boolean checkMessageLength() {
return messageText.length() <= 250;
}

public String getMessageLengthStatus() {
if(checkMessageLength()) {
return "Message ready to send.";
}
int exceeded = messageText.length() - 250;
return "Message exceeds 250 characters by "
+ exceeded
+ ", please reduce the size.";
}
}