package metier;

public class TypeRepas {
    private final String id;
    private String lib;

    public TypeRepas(String lib) {
        this.id = null;
        this.lib = lib;
    }

    public TypeRepas(String id, String lib) {
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
        return "TypeRepas{" +
                "id=" + id +
                ", lib='" + lib + '\'' +
                '}';
    }
}
