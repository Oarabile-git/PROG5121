package com.mycompany.chatapplication;



public class MessageAppUpdate { 
    
    // UPDATE
    
    int choice = -1;

while (choice != 0) {

    System.out.println("\npart 3 menu");

    System.out.println("1. display stored messages");
    System.out.println("2. display longest message");
    System.out.println("3. search message id");
    System.out.println("4. search recipient");
    System.out.println("5. delete message hash");
    System.out.println("6. display report");
    System.out.println("0. exit");

    choice = input.nextint();
    input.nextline();

    switch (choice) {

        case 1:

            Message.displaysendersandrecipients();
            break;

        case 2:

            System.out.println(
                    Message.longestmessage());
            break;

        case 3:

            system.out.print(
                    “enter message id: “);

            string id = input.nextline();

            int index =
                    message.searchmessageid(id);

            if (index != -1) {

                system.out.println(
                        “message found”);
            } else {

                system.out.println(
                        “message not found”);
            }

            break;

        case 4:

            system.out.print(
                    “enter recipient: “);

            string number =
                    input.nextline();

            message.searchrecipient(number);

            break;

        case 5:

            system.out.print(
                    “enter hash: “);

            string hash =
                    input.nextline();

            if (message.deletehash(hash)) {

                system.out.println(
                        “message successfully deleted.”);

            } else {

                system.out.println(
                        “hash not found.”);
            }

            break;

        case 6:

            message.displayreport();

            break;

        case 0:

            system.out.println(
                    “goodbye.”);
            break;

        default:

            system.out.println(
                    “invalid option.”);
    }
} 
    
}
