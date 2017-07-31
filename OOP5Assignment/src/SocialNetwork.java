

import java.io.IOException;
import java.util.HashSet;


public class SocialNetwork extends Graph {

    /**
     * personInfo
     *
     * File Path to the file person Information
     */
    public final static String personInfo = "C:/Users/welcome/Desktop/socialnetwork/Person_Info.txt";

    /**
     *
     * organizationInfo
     *
     * File Path to the file organization Information
     */
    public final static String organizationInfo = "C:/Users/welcome/Desktop/socialnetwork/Organisation_Info.txt";

    /**
     * personSet
     *
     * contains the object of person class
     */
    public static HashSet<Person> personSet = new HashSet<>();

    /**
     * organizationSet
     *
     * contains the object of organization class
     */
    public static HashSet<Organization> organizationSet = new HashSet<>();

    /**
     * read
     *
     * Reader class Object to read file
     */
    private static Reader read;

    /**
     * consoleReader
     *
     * Reader class object to read console input
     */
    private static Reader consoleReader = new Reader(System.in);;

    /**
     * instantiate Social Network
     *
     */
    public SocialNetwork() {
        try {
            read = new Reader("person_Info");
            personSet = read.readPersonInformation();
            read = new Reader("organization_Info");
            organizationSet = read.readOrganisationInformation();
        } catch ( IOException |IllegalArgumentException  ex) {
            System.out.println(ex.getMessage());
            System.out.println(" Halting the application");
            System.exit(0);
        }
    }

    /**
     * print menu method
     *
     * prints the menu of application
     */
    public void printMenu() {
        String choice, name1, name2;
        boolean flag = true;
        do {
            System.out.println("Press 1 to add a new node");
            System.out.println("Press 2 to search an entity by name");
            System.out.println("Press 3 to add a friend");
            System.out.println("Press 4 to remove a node from network");
            System.out.println("Press 5 to remove a friend from friend list");
            System.out.println("Press 6 to exit");
            choice = consoleReader.nextLine().trim();
            switch (choice) {
                case "1":
                    /**
                     * adding new node to network*
                     */
                    addNode(getData());
                    break;
                case "2":
                    /**
                     * Searching the user *
                     */
                    searchDisplay(consoleReader.nextLine().trim());
                    break;
                case "3":
                    System.out.println("Enter your name");
                    name1 = consoleReader.nextLine().trim();
                    System.out.println("Enter name of friend want to add");
                    name2 = consoleReader.nextLine().trim();
                    /**
                     * Making two user friend*
                     */
                    addFriend(name1, name2);
                    break;
                case "4":
                    System.out.println("Enter name of node to remove");
                    name1 = consoleReader.nextLine().trim();
                    /**
                     * Deleting a node from network*
                     */
                    removeNode(name1);
                    break;
                case "5":
                    System.out.println("Enter your name");
                    name1 = consoleReader.nextLine().trim();
                    System.out.println("Enter name of friend want to remove");
                    name2 = consoleReader.nextLine().trim();
                    /**
                     * Making two user friend*
                     */
                    removeFriend(name1, name2);
                    break;
                case "6":
                    System.out.println("Closing The application......");
                    /**
                     * Application exit terminal*
                     */
                    System.exit(0);
                default:
                    /**
                     * In case if choice is not valid*
                     */
                    System.out.println("Please choose a valid option");
            }
        } while (flag);

    }

    /**
     * getData method
     *
     * Use to read data of entity from console
     *
     * @return Object of Entity type
     */
    private Entity getData() {
        System.out.println("If want to add Organisation press 1 ");
        System.out.println("If want to add Person press 2 ");
        int choice = 0;
        boolean flag = true;
        do {
            try {
                /**
                 * Take choice from user*
                 */
                choice = Integer.parseInt(consoleReader.nextLine().trim());
                if (choice <= 0 && choice > 2) {
                    throw new IllegalArgumentException();
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                /**
                 * In case if input is not valid*
                 */
                System.out.println("Please Select A Valid Option");
            }
        } while (flag);
        /**
         * Taking name number and mail id as input from user*
         */
        String name = getName();
        String mail = getMail();
        String number = getNumber();

        Entity entity = null;
        if (choice == 1) {
            System.out.println("/*****Enter type of Organisation******/");
            String type = consoleReader.nextLine().trim();
            /**
             * Making an instance of Organization*
             */
            entity = new Organization(name, mail, number, type);
        } else {
            System.out.println("/*****Enter Native city of Person******/");
            String city = consoleReader.nextLine().trim();
            /**
             * Making an instance of Person*
             */
            entity = new Organization(name, mail, number, city);
        }

        /**
         * Returning the entity*
         */
        return entity;
    }

    /**
     * get Name method
     *
     * @return name of user reads from console
     */
    private String getName() {
        boolean flag = true;
        String name = "";
        do {
            try {
                System.out.println("/*****Enter Name******/");
                name = consoleReader.nextLine().trim();
                if (!ValidationNetwork.checkName(name)) {
                    throw new IllegalArgumentException("Duplicate Username");
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
        /**
         * Returning name reads from console*
         */
        return name;
    }

    /**
     * get mail method
     *
     * @return mail of user reads from console
     */
    private String getMail() {
        boolean flag = true;
        String mail = "";
        do {
            try {
                System.out.println("/*****Enter Email Address******/");
                mail = consoleReader.nextLine().trim();
                if (!ValidationNetwork.checkMail(mail)) {
                    /**
                     * In case if mail id is not valid*
                     */
                    throw new IllegalArgumentException("Enter a valid mail Id");
                }
                if (!ValidationNetwork.checkDuplicacy(mail)) {
                    /**
                     * In case if mail id is duplicate*
                     */
                    throw new IllegalArgumentException("This mail Id is Already Registered");
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
        /**
         * Returning mail reads from console*
         */
        return mail;
    }

    /**
     * get number method
     *
     * @return contact number of user reads from console
     */
    private String getNumber() {
        boolean flag = true;
        String number = "";
        do {
            try {
                System.out.println("/*****Enter Number******/");
                number = consoleReader.nextLine().trim();
                if (!ValidationNetwork.checkNumber(number)) {
                    /**
                     * In case if number is not valid*
                     */
                    throw new IllegalArgumentException("Enter a valid number");
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
        /**
         * Returning number reads from console*
         */
        return number;
    }

}
