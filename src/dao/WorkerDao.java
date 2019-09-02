package dao;

import model.Worker;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static db.MockDB.workers;

public class WorkerDao {

    static Scanner scan = new Scanner(System.in);

    public Worker getWorker(int index) {
        return workers.get(index);
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void showWorkers(List<Worker> workers) {
        System.out.println("-- Workers list --");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%5s %20s %10s %5s %10s %15s %15s %15s %10s %10s %5s", "ID", "NAME", "BIRTHDAY", "GENDER", "PHONE", "POSITION", "DEPARTMENT", "BOSS", "START DATE", "SALARY", "ACTIVE");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < workers.size(); i++) {
            System.out.format("%5s %20s %10s %5s %10s %15s %15s %15s %10s %10s %5s",
                    (i + 1), workers.get(i).getName(), workers.get(i).getBirthday(), workers.get(i).getGender(),
                    workers.get(i).getPhone(), workers.get(i).getPosition(), workers.get(i).getDepartment(), workers.get(i).getBossName(),
                    workers.get(i).getStart(), workers.get(i).getSalary(), workers.get(i).isActive());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void addWorker() {
        System.out.println("-- Add worker --");
        System.out.print("Input name: ");

        String name = scan.nextLine();
        System.out.print("Input birthday(yyyy-dd-mm): ");
        LocalDate birthday = LocalDate.parse(scan.nextLine());
        System.out.print("Choose gender(m-f): ");
        char gender = scan.nextLine().charAt(0);
        System.out.print("Input phone: ");
        String phone = scan.nextLine();
        System.out.print("Input position: ");
        String position = scan.nextLine();
        System.out.print("Input department: ");
        String department = scan.nextLine();
        System.out.print("Input bossName: ");
        String bossName = scan.nextLine();
        System.out.print("Input start working date(yyyy-dd-mm): ");
        LocalDate start = LocalDate.parse(scan.nextLine());
        System.out.print("Input salary: ");
        double salary = Double.parseDouble(scan.nextLine());

        workers.add(new Worker(name, birthday, gender, phone, position, department, bossName, start, salary));
    }

    public void dismissWorker() {
        showWorkers(workers);
        System.out.print("Choose ID: ");
        int choose = Integer.parseInt(scan.nextLine());
        if (choose < 1 || choose > workers.size()) {
            System.out.println("Incorrect ID");
        } else {
            workers.get(choose - 1).setActive(false);
        }
    }

    public void editWorker() {
        showWorkers(workers);
        System.out.print("Choose ID: ");
        int choose = Integer.parseInt(scan.nextLine());
        if (choose < 1 || choose > workers.size()) {
            System.out.println("Incorrect ID");
        } else {
            Worker worker = workers.get(choose - 1);
            System.out.print("Input name: ");
            String name = scan.nextLine();
            System.out.print("Input birthday(yyyy-dd-mm): ");
            LocalDate birthday = LocalDate.parse(scan.nextLine());
            System.out.print("Choose gender(m-f): ");
            char gender = scan.nextLine().charAt(0);
            System.out.print("Input phone: ");
            String phone = scan.nextLine();
            System.out.print("Input position: ");
            String position = scan.nextLine();
            System.out.print("Input department: ");
            String department = scan.nextLine();
            System.out.print("Input bossName: ");
            String bossName = scan.nextLine();
            System.out.print("Input start working date(yyyy-dd-mm): ");
            LocalDate start = LocalDate.parse(scan.nextLine());
            System.out.print("Input salary: ");
            double salary = Double.parseDouble(scan.nextLine());
            worker.setName(name);
            worker.setBirthday(birthday);
            worker.setGender(gender);
            worker.setPhone(phone);
            worker.setPosition(position);
            worker.setDepartment(department);
            worker.setBossName(bossName);
            worker.setStart(start);
            worker.setSalary(salary);
            workers.set(choose - 1, worker);
        }
    }

    public void searchWorker() {
        System.out.println("-- Search --");
        System.out.println("1 - By name");
        System.out.println("2 - By position");
        System.out.println("3 - By department");
        System.out.println("4 - By boss name");
        int choose = Integer.parseInt(scan.nextLine());
        switch (choose) {
            case 1:
                System.out.print("Input search name: ");
                String name = scan.nextLine();
                showWorkers(findByName(name));
                break;
            case 2:
                System.out.print("Input search position: ");
                String position = scan.nextLine();
                showWorkers(findByPosition(position));
                break;
            case 3:
                System.out.print("Input search department: ");
                String department = scan.nextLine();
                showWorkers(findByDepartment(department));
                break;
            case 4:
                System.out.print("Input search boss name: ");
                String bossName = scan.nextLine();
                showWorkers(findByBossName(bossName));
                break;
            default:
                System.out.println("Incorrect select!");
                break;
        }
    }

    public List<Worker> findByName(String name) {
        List<Worker> searchWorker = new ArrayList<>();
        for (Worker w : workers) {
            if (w.getName().contains(name)) {
                searchWorker.add(w);
            }
        }
        return searchWorker;
    }

    public List<Worker> findByPosition(String position) {
        List<Worker> searchWorker = new ArrayList<>();
        for (Worker w : workers) {
            if (w.getPosition().equals(position)) {
                searchWorker.add(w);
            }
        }
        return searchWorker;
    }

    public List<Worker> findByDepartment(String department) {
        List<Worker> searchWorker = new ArrayList<>();
        for (Worker w : workers) {
            if (w.getDepartment().equals(department)) {
                searchWorker.add(w);
            }
        }
        return searchWorker;
    }

    public List<Worker> findByBossName(String bossName) {
        List<Worker> searchWorker = new ArrayList<>();
        for (Worker w : workers) {
            if (w.getBossName().contains(bossName)) {
                searchWorker.add(w);
            }
        }
        return searchWorker;
    }

    public void report() {
        System.out.println("-- Report --");
        System.out.println("1 - Organization structure");
        System.out.println("2 - Average salary");
        System.out.println("3 - TOP-10 highest salaries");
        System.out.println("4 - TOP-10 oldest work experiencies");
        int choose = Integer.parseInt(scan.nextLine());
        switch (choose) {
            case 1:
                getOrganizationStructure();
                break;
            case 2:
                getAverageSalary();
                break;
            case 3:
                showWorkers(getTopSalaries());
                break;
            case 4:
                showWorkers(getTopExperiencies());
                break;
            default:
                System.out.println("Incorrect select!");
                break;
        }
    }

    public void getOrganizationStructure() {
        List<Organization> organizations = new ArrayList<>();
        for (Worker w : workers) {
            organizations.add(new Organization(w.getDepartment(), w.getBossName()));
        }
        System.out.println("-- Departments list --");
        System.out.println("--------------------------");
        System.out.printf("%10s %15s", "DEPARTMENT", "BOSS");
        System.out.println();
        System.out.println("--------------------------");
        for (Organization o : organizations.stream().distinct().collect(Collectors.toList())) {
            System.out.format("%10s %15s", o.getDepartment(), o.getBossName());
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public void getAverageSalary() {
        double totalSalary = 0;
        for (Worker w : workers) {
            totalSalary += w.getSalary();
        }
        System.out.println("Average salary: " + (totalSalary / workers.size()));
    }

    public List<Worker> getTopSalaries() {
        List<Worker> list = workers;
        List<Worker> result = new ArrayList<>();
        Collections.sort(list, (Worker w1, Worker w2) -> Double.compare(w2.getSalary(), w1.getSalary()));
        if (list.size() > 10) {
            for (int i = 0; i < 10; i++) {
                result.add(list.get(i));
            }
        } else {
            for (Worker w : list) {
                result.add(w);
            }
        }
        return result;
    }

    public List<Worker> getTopExperiencies() {
        List<Worker> list = workers;
        List<Worker> result = new ArrayList<>();
        Collections.sort(list, (Worker w1, Worker w2) -> Long.compare(w2.getDateDiff(), w1.getDateDiff()));
        if (list.size() > 10) {
            for (int i = 0; i < 10; i++) {
                result.add(list.get(i));
            }
        } else {
            for (Worker w : list) {
                result.add(w);
            }
        }
        return result;
    }

    private static class Organization {

        private String department;
        private String bossName;

        Organization(String department, String bossName) {
            this.department = department;
            this.bossName = bossName;
        }

        String getDepartment() {
            return department;
        }

        String getBossName() {
            return bossName;
        }

    }

}
