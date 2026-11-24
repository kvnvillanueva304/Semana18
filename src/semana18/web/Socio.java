package semana18.web;

public class Socio {
    private final int id;
    private final String nombre;
    private final int saldo;

    public Socio(int id, String nombre, int saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String toJson() {
        return "{\"id\": " + id + ", \"nombre\": \"" + nombre + "\", \"saldo\": " + saldo + "}";
    }
}