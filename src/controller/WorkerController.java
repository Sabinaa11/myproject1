package controller;

import service.WorkerService;
import util.ReadProperties;

import java.text.ParseException;
import java.util.Scanner;

public class WorkerController {
    WorkerService workerService = new WorkerService();
    static Scanner scan = new Scanner(System.in);


    private void showMenu() {
        System.out.println("\n-- Main menu --");
        System.out.println("1 - Add worker");
        System.out.println("2 - Edit worker");
        System.out.println("3 - Dismiss worker");
        System.out.println("4 - Show worker's list");
        System.out.println("5 - Search worker");
        System.out.println("6 - Report\n");
        System.out.println("0 - Exit\n---");
    }

    public static void main(String[] args) throws ParseException {
        System.out.print("Login: ");
        String login = scan.nextLine();
        System.out.print("Password: ");
        String password = scan.nextLine();
        if (login.equals(ReadProperties.getProperty("login")) && password.equals(ReadProperties.getProperty("password"))) {
            new WorkerController().start();
        } else {
            System.out.println("Incorrect login/password!");
        }
    }

    private void start() throws ParseException {
        System.out.println("\n-- Workers registration app --");
        int choose = 1;
        while (choose != 0) {
            showMenu();
            choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    workerService.addWorker();
                    break;
                case 2:
                    workerService.editWorker();
                    break;
                case 3:
                    workerService.dismissWorker();
                    break;
                case 4:
                    workerService.showWorkers(workerService.getWorkers());
                    break;
                case 5:
                    workerService.searchWorker();
                    break;
                case 6:
                    workerService.report();
                    break;
                default:
                    System.out.println("Incorrect choose");
                    break;
            }
        }
    }
}
