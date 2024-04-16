package metier;

public class Plat {
    private final String id;
    private String lib;

    public Plat(String lib) {
        this.id = null;
        this.lib = lib;
    }

    public Plat(String id, String lib) {
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
        return "Plat{" +
                "id='" + id + '\'' +
                ", lib='" + lib + '\'' +
                '}';
    }
}
