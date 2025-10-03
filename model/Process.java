package model;

public abstract class Process {
    private int pid;
    private String name;

    public Process(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    // Métodos abstractos (se implementan en subclases)
    public abstract void execute();

    // Encapsulación
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Buenas prácticas: toString
    @Override
    public String toString() {
        return "PID: " + pid + ", Nombre: " + name + ", Tipo: " + this.getClass().getSimpleName();
    }

    // Comparación por PID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Process)) return false;
        Process other = (Process) obj;
        return this.pid == other.pid;
    }
}
