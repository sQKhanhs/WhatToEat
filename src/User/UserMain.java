package User;

import Search.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) {
        try {
            int choice = -1;
            Scanner input = new Scanner(System.in);
            choice = logOut(choice, input);
            if (User.getInstance().isAccess()) {
                while (choice != 0) {
                    System.out.println("1. Dish lookup");
                    System.out.println("2. What to eat?");
                    System.out.println("3. Log out");
                    System.out.println("0. Exit");
                    choice = input.nextInt();
                    switch (choice) {
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            Scanner text = new Scanner(System.in);
                            System.out.println("Enter dish name: ");
                            String name = text.nextLine();
                            User.getInstance().dishAddToList();
                            for (int index = 0; index < User.getInstance().getDishes().size(); index++) {
                                if (name.equalsIgnoreCase(User.getInstance().getDishes().get(index).getName())) {
                                    System.out.println(User.getInstance().getDishes().get(index).getDescription());
                                    System.out.println(User.getInstance().getDishes().get(index).getValue());
                                    break;
                                }
                            }
                            while (choice != 0) {
                                System.out.println("1. Find restaurant by location");
                                System.out.println("2. Find restaurant by price");
                                System.out.println("3. Find restaurant by rating");
                                System.out.println("0. Exit");
                                choice = input.nextInt();
                                switch (choice) {
                                    case 0:
                                        System.exit(0);
                                    case 1:
                                        while (choice != 0) {
                                            System.out.println("1. Ho Chi Minh City");
                                            System.out.println("2. Ha Noi City");
                                            choice = input.nextInt();
                                                switch (choice){
                                                    case 1:
                                                        Search search = SearchFactory.getSearch("HCM");
                                                        search.search(name);
                                                        break;
                                                }
                                        }
                                        break;
                                    case 2:
                                        Search search = SearchFactory.getSearch("price");
                                        search.search(name);
                                        break;
                                    default:
                                        System.out.println("Please choose again!");
                                }
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            logOut(choice, input);
                            break;
                        default:
                            System.out.println("Please choose again!");
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter number to proceed!");
        }
    }


    private static int logOut(int choice, Scanner input) {
        User.getInstance().setAccess(false);
        while (choice != 0 && choice != 1) {
            System.out.println("What To Eat");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    User.getInstance().login();
                    break;
                case 2:
                    User.getInstance().register();
                    break;
                default:
                    System.out.println("Please choose again!");
            }
        }
        return choice;
    }
}