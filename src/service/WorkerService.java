package service;

import dao.WorkerDao;
import model.Worker;

import java.text.ParseException;
import java.util.List;

public class WorkerService {
     WorkerDao dao = new WorkerDao();
    public List<Worker> getWorkers() {
        return dao.getWorkers();
    }

    public void showWorkers(List<Worker> workers) throws ParseException {
        dao.showWorkers(workers);
    }

    public Worker getWorker(int index) {
        return dao.getWorker(index);
    }

    public void addWorker() throws ParseException {
        dao.addWorker();
    }

    public void editWorker() throws ParseException {
        dao.editWorker();
    }

    public void dismissWorker() throws ParseException {
        dao.dismissWorker();
    }

    public void searchWorker() throws ParseException {
        dao.searchWorker();
    }

    public void report() throws ParseException {
        dao.report();
    }

}
