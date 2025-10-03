package controller;

import java.util.ArrayList;
import java.util.List;
import model.Process;

public class ProcessManager {

    private List<Process> processList;

    public ProcessManager() {
        this.processList = new ArrayList<>();
    }

    public void addProcess(Process p) {
        processList.add(p);
    }

    // Polimorfismo: cada proceso ejecuta su versión de execute()
    public void runAllProcesses() {
        for (Process p : processList) {
            p.execute();
        }
    }

    // Overloading (sobrecarga)
    public Process findProcess(int pid) {
        for (Process p : processList) {
            if (p.getPid() == pid) {
                return p;
            }
        }
        return null;
    }

    public Process findProcess(String name) {
        for (Process p : processList) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public List<Process> getProcessList() {
        return processList;
    }
}
