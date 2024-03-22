public class Nacional extends Producto {
    public String RegistroDIAN;

    public Nacional(String nombre, String codigo, String registroDIAN) {
        super(nombre, codigo);
        RegistroDIAN = registroDIAN;
    }
}
