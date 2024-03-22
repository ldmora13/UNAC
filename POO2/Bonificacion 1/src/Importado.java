public class Importado extends Producto {
    public String LicenciaImportacion;

    public Importado(String nombre, String codigo, String licenciaImportacion) {
        super(nombre, codigo);
        LicenciaImportacion = licenciaImportacion;
    }
}