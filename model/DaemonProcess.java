package model;

public class DaemonProcess extends Process {

    public DaemonProcess(int pid, String name) {
        super(pid, name);
    }

    @Override
    public void execute() {
        System.out.println("[Daemon] Servicio en segundo plano activo: " + getName());
    }
}
