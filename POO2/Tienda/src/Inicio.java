public class Inicio {
    public static void main(String[] args) {

        Nacional objNacional1 = new Nacional("Tetero", "001","RD001");
        Nacional objNacional2 = new Nacional("Compota", "002","RD002");
        Importado objImportado1 = new Importado("Pañales", "003", "LI001");
        Importado objImportado2 = new Importado("Toallas", "004", "LI002");

        System.out.println("----------- Productos Nacionales -----------");
        System.out.println(objImportado1.getCodigo() + " "
                + objNacional1.nombre + " "
                + objNacional1.RegistroDIAN);
        System.out.println(objImportado2.getCodigo() + " "
                + objNacional2.nombre + " "
                + objNacional2.RegistroDIAN);

        System.out.println("----------- Productos Importados -----------");
        System.out.println(objImportado1.getCodigo()+ " "
                + objImportado1.nombre + " "
                + objImportado1.LicenciaImportacion);
        System.out.println(objImportado2.getCodigo()+ " "
                + objImportado2.nombre + " "
                + objImportado2.LicenciaImportacion);

    }
}
