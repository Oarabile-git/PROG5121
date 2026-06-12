package com.mycompany.chatapplication;

import java.util.ArrayList;

public class MessageUpdate {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;

    //ARRAYS

    public static ArrayList<String> sentMessages = new ArrayList<>();
    public static ArrayList<String> disregardedMessages = new ArrayList<>();
    public static ArrayList<String> storedMessages = new ArrayList<>();

    public static ArrayList<String> messageHashes = new ArrayList<>();
    public static ArrayList<String> messageIDs = new ArrayList<>();
    public static ArrayList<String> recipients = new ArrayList<>();

    public MessageUpdate(String messageID,
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

    public boolean checkMessageLength() {
        return messageText.length() <= 250;
    }

    public String getMessageLengthStatus() {

        if (checkMessageLength()) {
            return "Message ready to send.";
        }

        int exceeded = messageText.length()- 250;

        return "Message exceeds 250 characters by" + exceeded +
                ", please reduce the size.";
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
                + lastWord).toUpperCase();
    }

    public String sentMessage(String option) {

        switch (option) {

            case "Send":

                sentMessages.add(messageText);
                messageHashes.add(createMessageHash());
                messageIDs.add(messageID);
                recipients.add(recipient);

                return "Message successfully sent.";

            case "Disregard":

                disregardedMessages.add(messageText);

                return "Message discarded.";

            case "Store":

                storedMessages.add(messageText);
                messageHashes.add(createMessageHash());
                messageIDs.add(messageID);
                recipients.add(recipient);

                return "Message successfully stored.";

            default:

                return "Invalid option.";
        }
    }

    public String printMessages() {

        String output = "";

        for (String message : sentMessages) {
            output += message + "\n";
        }

        return output;
    }

    public int returnTotalMessages() {
        return sentMessages.size();
    }

    //METHODS

    public static void displaySendersAndRecipients() {

        System.out.println("STORED MESSAGES");

        for (int I = 0; I < storedMessages.size(); I++) {

            System.out.println("Recipient: "
                    + recipients.get(I));

            System.out.println("Message: "
                    + storedMessages.get(I));

            System.out.println();
        }
    }

    public static String longestMessage() {

        String longest = "" ;

        for (String message : storedMessages) {

            if (message.length() > longest.length()) {
                longest = message;
            }
        }

        return longest;
    }

    public static int searchMessageID(String id) {

        for (int I = 0; I < messageIDs.size(); I++) {

            if (messageIDs.get(I).equals(id)) {
                return I;
            }
        }

        return -1;
    }

    public static void searchRecipient(String number) {

        for (int I = 0; I < recipients.size(); I++) {

            if (recipients.get(I).equals(number)) {

                if (I < storedMessages.size()) {
                    System.out.println(storedMessages.get(I));
                }
            }
        }
    }

    public static boolean deleteHash(String hash) {

        int index = messageHashes.indexOf(hash);

        if (index == -1) {
            return false;
        }

        messageHashes.remove(index);

        if (index < messageIDs.size()) {
            messageIDs.remove(index);
        }

        if (index < recipients.size()) {
            recipients.remove(index);
        }

        if (index < storedMessages.size()) {
            storedMessages.remove(index);
        }

        return true;
    }

    public static void displayReport() {

        System.out.println("MESSAGE REPORT");

        for (int I = 0; I < messageHashes.size(); I++) {

            System.out.println("---------------------");

            System.out.println(
                    "Hash: "
                    + messageHashes.get(I));

            if (I < recipients.size()) {
                System.out.println(
                        "Recipient: "
                        + recipients.get(I));
            }

            if (I < sentMessages.size()) {
                System.out.println(
                        "Message: "
                        + sentMessages.get(I));
            }
        }
    }

}

