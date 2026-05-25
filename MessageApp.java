package com.mycompany.chatapplication;

import java.util.Scanner;

public class MessageApp {
    
    
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.println("===== LOGIN =====");
Login login = new Login(
"Kyle",
"Smith",
"kyl_1",
"Ch&&sec@ke99!",
"+27838968976"
);

System.out.print("Enter username: ");
String enteredUsername = input.nextLine();
System.out.print("Enter password: ");
String enteredPassword = input.nextLine();
boolean loginSuccess =
login.loginUser(enteredUsername,
enteredPassword);
System.out.println(
login.returnLoginStatus(loginSuccess)
);

if(loginSuccess) {
System.out.print(
"How many messages would you like to send? "
);

int totalMessages = input.nextInt();
input.nextLine();
for(int i = 1; i <= totalMessages; i++) {
System.out.println("\\n===== MESSAGE " + i + " =====");
System.out.print("Enter Message ID: ");
String messageID = input.nextLine();
System.out.print("Enter recipient number: ");
String recipient = input.nextLine();
System.out.print("Enter message: ");
String messageText = input.nextLine();
Message message = new Message(
messageID,
i,
recipient,
messageText
);
if(!message.checkMessageID()) {
System.out.println(
"Message ID incorrectly formatted"
);
continue;
}
if(!message.checkRecipientCell()) {
System.out.println(
"Cell phone number incorrectly formatted"
);
continue;
}
System.out.println(
message.getMessageLengthStatus()
);
if(!message.checkMessageLength()) {
continue;
}
System.out.println(
"Message Hash: "
+ message.createMessageHash()
);
System.out.println("Choose option:");
System.out.println("1. Send Message");
System.out.println("2. Disregard Message");
System.out.println("3. Store Message");
int option = input.nextInt();
input.nextLine();
switch(option) {
case 1:
System.out.println(
message.sentMessage("Send")
);
break;
case 2:
System.out.println(
message.sentMessage("Disregard")
);
break;
case 3:
System.out.println(
message.sentMessage("Store")
);
break;
default:
System.out.println("Invalid option");
}
}
System.out.println("\\n===== ALL SENT MESSAGES =====");
Message finalMessage = new Message(
"00",
0,
"+27000000000",
""
);
System.out.println(finalMessage.printMessages());
System.out.println(
"Total messages sent: "
+ finalMessage.returnTotalMessages()
);
}
}
}