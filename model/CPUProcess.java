package model;

public class CPUProcess extends Process {

    public CPUProcess(int pid, String name) {
        super(pid, name);
    }

    @Override
    public void execute() {
        System.out.println("[CPU] Ejecutando proceso intensivo de cálculo: " + getName());
    }
}
