package metier;

public class Boisson {
    private final String id;
    private String lib;

    public Boisson(String lib) {
        this.id = null;
        this.lib = lib;
    }

    public Boisson(String id, String lib) {
        this.id = id;
        this.lib = lib;
    }

    public String getId() {
        return id;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    @Override
    public String toString() {
        return "Boisson{" +
                "id='" + id + '\'' +
                ", lib='" + lib + '\'' +
                '}';
    }
}
