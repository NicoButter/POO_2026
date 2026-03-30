import java.util.Hashtable;
import java.util.Enumeration;

public class DataBase {
    private String name;
    private boolean open;
    private Hashtable<String, Table> tables;

    public DataBase(String name) {
        this.name = name;
        this.open = false;
        this.tables = new Hashtable<>();
    }

    public void open() throws DBException {
        if (open) throw new DBException("La base de datos ya está abierta.");
        open = true;
    }

    public void close() throws DBException {
        if (!open) throw new DBException("La base de datos ya está cerrada.");
        open = false;
    }

    public void createTable(Table t) throws DBException, TableException {
        if (!open) throw new DBException("La base de datos no está abierta.");
        if (tables.containsKey(t.getName())) throw new TableException("La tabla ya existe.");
        tables.put(t.getName(), t);
    }

    public void removeTable(String idTable) throws DBException, TableException {
        if (!open) throw new DBException("La base de datos no está abierta.");
        if (!tables.containsKey(idTable)) throw new TableException("La tabla no existe.");
        tables.remove(idTable);
    }

    public void listTables() throws DBException {
        if (!open) throw new DBException("La base de datos no está abierta.");
        if (tables.isEmpty()) {
            System.out.println("No hay tablas en la base de datos.");
            return;
        }
        System.out.println("Tablas en la base de datos:");
        Enumeration<String> keys = tables.keys();
        while (keys.hasMoreElements()) {
            System.out.println("- " + keys.nextElement());
        }
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }
}
