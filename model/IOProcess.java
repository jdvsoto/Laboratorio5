package model;

public class IOProcess extends Process {

    public IOProcess(int pid, String name) {
        super(pid, name);
    }

    @Override
    public void execute() {
        System.out.println("[I/O] Esperando dispositivo... luego procesando entrada/salida: " + getName());
    }
}
