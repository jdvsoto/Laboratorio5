package view;

import controller.ProcessManager;
import java.util.Scanner;
import model.*;

public class ConsoleView {
    private ProcessManager manager;
    private Scanner scanner;

    public ConsoleView(ProcessManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n=== Simulador de Procesos ===");
            System.out.println("1. Registrar proceso CPU");
            System.out.println("2. Registrar proceso I/O");
            System.out.println("3. Registrar proceso Daemon");
            System.out.println("4. Ejecutar todos los procesos");
            System.out.println("5. Buscar proceso por PID");
            System.out.println("6. Buscar proceso por Nombre");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> createCPUProcess();
                case 2 -> createIOProcess();
                case 3 -> createDaemonProcess();
                case 4 -> manager.runAllProcesses();
                case 5 -> searchByPID();
                case 6 -> searchByName();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (option != 0);
    }

    private void createCPUProcess() {
        System.out.print("PID: ");
        int pid = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        manager.addProcess(new CPUProcess(pid, name));
    }

    private void createIOProcess() {
        System.out.print("PID: ");
        int pid = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        manager.addProcess(new IOProcess(pid, name));
    }

    private void createDaemonProcess() {
        System.out.print("PID: ");
        int pid = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        manager.addProcess(new DaemonProcess(pid, name));
    }

    private void searchByPID() {
        System.out.print("Ingrese PID: ");
        int pid = scanner.nextInt();
        model.Process p = manager.findProcess(pid);
        if (p != null) {
            System.out.println("Proceso encontrado: " + p);
        } else {
            System.out.println("No existe un proceso con ese PID.");
        }
    }

    private void searchByName() {
        System.out.print("Ingrese Nombre: ");
        String name = scanner.nextLine();
        model.Process p = manager.findProcess(name);
        if (p != null) {
            System.out.println("Proceso encontrado: " + p);
        } else {
            System.out.println("No existe un proceso con ese nombre.");
        }
    }
}
