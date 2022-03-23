package envio_paquetes;

import java.util.Scanner;

public class Principal {

    private static Scanner entrada = new Scanner(System.in);

    private static String numero_paquete = null;
    private static String dni = null;
    private static String peso = null;
    private static String numero_sucursal = null;
    private static String provincia;
    private static Paquete paquete[] = new Paquete[1000];
    private static Sucursal sucursal[] = new Sucursal[1000];
    private static EnvioPaquete envioPaquete[] = new EnvioPaquete[1000];
    private static SinEnviarPaquete sinEnvioPaquete[] = new SinEnviarPaquete[1000];
    private static String opcion = null;
    private static int contador_sucursal = 0;
    private static int contador_paquete = 0;
    private static int contador_paquete_enviado = 0;
    private static int contador_paquete_sin_enviar = 0;
    private static int contador_cantidad_paquetes = 0;

    public static void main(String[] args) {

        do {

            System.out.println("\t.........MENU.........");
            System.out.println();
            System.out.println("1. CREAR NUEVA SUCURSAL");
            System.out.println("2. CREAR NUEVO PAQUETE");
            System.out.println("3. ENVIAR PAQUETE");
            System.out.println("4. CONSULTAR SUCURSAL");
            System.out.println("5. CONSULTAR PAQUETE");
            System.out.println("6. CONSULTAR PAQUETES ENVIADOS");
            System.out.println("7. CONSULTAR PAQUETES NO ENVIADOS");
            System.out.println("8. CONSULTAR TODAS LAS SUCURSALES");
            System.out.println("9. CONSULTAR TODOS LOS PAQUETES");
            System.out.println("10. ELIMINAR SUCURSAL");
            System.out.println("11. ELIMINAR PAQUETE");
            System.out.println("12. MODIFICAR SUCURSAL");
            System.out.println("13. MODIFICAR PAQUETE");
            System.out.println("14. SALIR");
            System.out.println();

            System.out.print("Digite la opcion de menu: ");
            opcion = entrada.nextLine();

            //VALIDO opcion. MIENTRAS opcion SEA DIFERENTE DE 1 y 2 y 3 y 4 .......... REPETIME. 
            while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3")
                    && !opcion.equals("4") && !opcion.equals("5") && !opcion.equals("6")
                    && !opcion.equals("7") && !opcion.equals("8") && !opcion.equals("9")
                    && !opcion.equals("10") && !opcion.equals("11") && !opcion.equals("12")
                    && !opcion.equals("13") && !opcion.equals("14")) {

                System.out.println("La opcion no es correcta.");
                System.out.print("Digite nuevamente la opcion: ");
                opcion = entrada.nextLine();

            }

            switch (Integer.valueOf(opcion)) { //CON Integer.valueOf(opcion) CONVIERTO opcion A ENTERO PARA QUE PUEDA EVALUAR LOS CASE

                case 1: //CREAR NUEVA SUCURSAL

                    crearSucursal();

                    break;

                case 2: //CREAR NUEVO PAQUETE

                    crearNuevoPaquete();

                    break;

                case 3: //ENVIAR PAQUETE

                    enviarPaquete();

                    break;

                case 4: //CONSULTAR SUCURSAL

                    consultarSucursal();

                    break;

                case 5: //CONSULTAR PAQUETE

                    consultarPaquete();

                    break;

                case 6: //CONSULTAR PAQUETES ENVIADOS

                    consultarPaquetesEnviados();

                    break;

                case 7: //CONSULTAR PAQUETES NO ENVIADOS

                    consultarPaquetesNoEnviados();

                    break;

                case 8: //CONSULTAR TODAS LAS SUCURSALES

                    consultarTodasSucursales();

                    break;

                case 9: //CONSULTAR TODOS LOS PAQUETES

                    consultarTodosPaquetes();

                    break;

                case 10: //ELIMINAR SUCURSAL

                    eliminarSucursal();

                    break;

                case 11: //ELIMINAR PAQUETE

                    eliminarPaquete();

                    break;

                case 12: //MODIFICAR SUCURSAL

                    modificarSucursal();

                    break;

                case 13: //MODIFICAR PAQUETE

                    modificarPquete();

                    break;

                case 14: //SALIR

                    salirMenu();
            }

            System.out.println();

        } while (Integer.valueOf(opcion) != 14);

    }

    public static void crearSucursal() {

        System.out.print("Digite el numero de sucursal: ");

        numero_sucursal = entrada.nextLine();

        //VALIDO EL numero_sucursal PARA QUE SEA UN NUMERO SI O SI
        for (int i = 0; i < numero_sucursal.length(); i++) {

            String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

            for (int j = 0; j < letras.length(); j++) {

                while (numero_sucursal.charAt(i) == letras.charAt(j) || numero_sucursal.charAt(0) == '0') {

                    System.out.println("Error, el numero de sucursal no es correcto");
                    System.out.print("Digite el numero de sucursal nuevamente: ");
                    numero_sucursal = entrada.nextLine();
                    j = 0;//REINICIA EL CONTEO DE letras DESDE LA POSICION 0, ES DECIR a, PARA QUE VUELVA A COMPARAR LOS CARACTERES DE numero_sucursal CON EL PRIMERO DE letras
                    i = 0;//REINICIA EL CONTEO DE numero_sucursal DESDE LA POSICION 0 PARA QUE EN UNA SEGUNDA VUELTA DE BUCLE ME EVALUE DESDE EL PRIMER CARACTER DE numero_sucursal
                }

            }

        }

        //EL NUMERO DE SUCURSAL TIENE QUE SER UNICO
        for (int i = 0; i < contador_sucursal; i++) { //RECORRE SUCURSALES CREADAS

            while (numero_sucursal.equals(sucursal[i].getNumero_sucursal())) { //MIENTRAS EL NUMERO DE LA SUCURSAL SEA IGUAL A OTRO NUMERO DE SUCURSAL

                System.out.println("La sucursal ha sido creada previamente");
                System.out.print("Por favor digite un numero de sucursal diferente: ");
                numero_sucursal = entrada.nextLine();
                i = 0; //REINICIO i PARA COMPARAR A CADA VUELTA DE BUCLE CON EL NUMERO DE SUCURSAL DE LA PRIMERA SUCURSAL CREADA

                for (int p = 0; p < numero_sucursal.length(); p++) { //VALIDO EL NUMERO DE SUCURSAL

                    String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

                    for (int j = 0; j < letras.length(); j++) {

                        while (numero_sucursal.charAt(p) == letras.charAt(j) || numero_sucursal.charAt(0) == '0') {

                            System.out.println("Error, el numero de sucursal no es correcto");
                            System.out.print("Digite el numero de sucursal nuevamente: ");
                            numero_sucursal = entrada.nextLine();
                            j = 0;
                            p = 0;

                        }

                    }

                }

            }

        }

        System.out.print("Digite la provincia: ");
        provincia = entrada.nextLine();

        //VALIDO LA PROVINCIA
        while (!provincia.equalsIgnoreCase("Buenos Aires") && !provincia.equalsIgnoreCase("Tierra del Fuego")
                && !provincia.equalsIgnoreCase("Santa Cruz") && !provincia.equalsIgnoreCase("Chubut")
                && !provincia.equalsIgnoreCase("Rio Negro") && !provincia.equalsIgnoreCase("Neuquen")
                && !provincia.equalsIgnoreCase("La Pampa") && !provincia.equalsIgnoreCase("Entre Rios")
                && !provincia.equalsIgnoreCase("Corrientes") && !provincia.equalsIgnoreCase("Misiones")
                && !provincia.equalsIgnoreCase("Chaco") && !provincia.equalsIgnoreCase("San Luis")
                && !provincia.equalsIgnoreCase("Santiago del Estero") && !provincia.equalsIgnoreCase("Mendoza")
                && !provincia.equalsIgnoreCase("Salta") && !provincia.equalsIgnoreCase("Jujuy")
                && !provincia.equalsIgnoreCase("Formosa") && !provincia.equalsIgnoreCase("Tucuman")
                && !provincia.equalsIgnoreCase("La Rioja") && !provincia.equalsIgnoreCase("Catamarca")
                && !provincia.equalsIgnoreCase("San Juan") && !provincia.equalsIgnoreCase("Cordoba")
                && !provincia.equalsIgnoreCase("Santa Fe")) {

            System.out.println("Provincia no valida");

            System.out.print("Digite la provincia nuevamente: ");
            provincia = entrada.nextLine();
        }

        sucursal[contador_sucursal] = new Sucursal(numero_sucursal, provincia, 0); //CREO LA SUCURSAL. EL 0 CORRESPONDE A LA CANTIDAD DE PAQUETES QUE TIENE LA SUCURSAL. AL MOMENTO DE CREARLA LA SUCURSAL TIENE 0 PAQUETES

        contador_sucursal++; //VA CONTANDO LAS SUCURSALES QUE SE VAN CREANDO

        System.out.println();
        System.out.println("Sucursal creada con exito!!!");
    }

    public static void crearNuevoPaquete() {

        System.out.print("Digite el numero del paquete: ");
        numero_paquete = entrada.nextLine();

        //VALIDO EL numero_paquete PARA QUE SEA UN NUMERO SI O SI
        for (int i = 0; i < numero_paquete.length(); i++) {

            String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

            for (int j = 0; j < letras.length(); j++) {

                while (numero_paquete.charAt(i) == letras.charAt(j) || numero_paquete.charAt(0) == '0') {

                    System.out.println("Error, el numero de paquete no es correcto");
                    System.out.print("Digite el numero de paquete nuevamente: ");
                    numero_paquete = entrada.nextLine();
                    j = 0; //REINICIA EL CONTEO DE letras DESDE LA POSICION 0, ES DECIR a, PARA QUE VUELVA A LOS CARACTERES DE numero_paquete CON EL PRIMERO DE letras
                    i = 0; //REINICIA EL CONTEO DE numero_paquete DESDE LA POSICION 0 PARA QUE EN UNA SEGUNDA VUELTA DE BUCLE ME EVALUE DESDE EL PRIMER CARACTER DE numero_paquete
                }

            }

        }

        //EL NUMERO DE PAQUETE TIENE QUE SER UNICO
        for (int i = 0; i < contador_paquete; i++) { //RECORRE PAQUETES CREADOS

            while (numero_paquete.equals(paquete[i].getNumero_paquete())) { //MIENTRAS EL NUMERO DEL PAQUETE SEA IGUAL A OTRO NUMERO DE PAQUETE

                System.out.println("El paquete ha sido creado previamente");
                System.out.print("Por favor digite un numero de paquete diferente: ");
                numero_paquete = entrada.nextLine();
                i = 0; //REINICIO i PARA COMPARAR A CADA VUELTA DE BUCLE EL NUMERO DE PAQUETE CON EL PRIMER PAQUETE CREADO

                for (int p = 0; p < numero_paquete.length(); p++) { //VALIDO EL NUMERO DE PAQUETE

                    String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

                    for (int j = 0; j < letras.length(); j++) {

                        while (numero_paquete.charAt(p) == letras.charAt(j) || numero_paquete.charAt(0) == '0') {

                            System.out.println("Error, el numero de paquete no es correcto");
                            System.out.print("Digite el numero de paquete nuevamente: ");
                            numero_paquete = entrada.nextLine();
                            j = 0;
                            p = 0;
                        }

                    }

                }

            }

        }

        System.out.print("Digite el dni: ");
        dni = entrada.nextLine();

        //VALIDO EL DNI
        for (int i = 0; i < dni.length(); i++) {

            String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

            for (int j = 0; j < letras.length(); j++) {

                while (dni.charAt(i) == letras.charAt(j) || dni.length() > 8 || dni.length() < 8 || dni.charAt(0) == '0') {

                    System.out.println("Error, el dni no es valido");
                    System.out.print("Digite el numero de dni nuevamente: ");
                    dni = entrada.nextLine();
                    j = 0;
                    i = 0;
                }

            }

        }

        System.out.print("Digite el peso: ");
        peso = entrada.nextLine();

        //VALIDO EL PESO
        for (int i = 0; i < peso.length(); i++) {

            String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

            for (int j = 0; j < letras.length(); j++) {

                while (peso.charAt(i) == letras.charAt(j) || peso.length() > 2 || peso.length() > 1 && peso.charAt(1) != '0'
                        || Integer.valueOf(peso) > 10 || Integer.valueOf(peso) <= 0 || peso.charAt(0) == '0') {

                    System.out.println("Error, el peso no es valido.");
                    System.out.println("Compruebe que el peso este entre 1 y 10 Kg y no contenga letras");
                    System.out.print("Digite el peso nuevamente: ");
                    peso = entrada.nextLine();
                    j = 0;
                    i = 0;
                }

            }

        }

        paquete[contador_paquete] = new Paquete(numero_paquete, dni, peso, false); //CREO EL PAQUETE. AL MOMENTO DE CREAR EL PAQUETE SU ESTADO DE ENVIO ES false Y QUIERE DECIR QUE TODAVIA NO SE ENVIO
        sinEnvioPaquete[contador_paquete_sin_enviar] = new SinEnviarPaquete(numero_paquete, dni, peso); //EL PAQUETE HASTA EL MOMENTO ESTA SIN ENVIAR

        contador_paquete++; //VA CONTANTO LOS PAQUETES QUE SE VAN CREANDO
        contador_paquete_sin_enviar++; //VA CONTANDO LOS PAQUETES SIN ENVIAR A UNA SUCURSAL

        System.out.println();
        System.out.println("Paquete creado con exito!!!");
    }

    public static void enviarPaquete() {

        System.out.print("Digite el numero de sucursal para enviar el paquete: ");
        numero_sucursal = entrada.nextLine();

        //VALIDO EL NUMERO DE SUCURSAL
        for (int i = 0; i < numero_sucursal.length(); i++) {

            String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

            for (int j = 0; j < letras.length(); j++) {

                while (numero_sucursal.charAt(i) == letras.charAt(j) || numero_sucursal.charAt(0) == '0') {

                    System.out.println("Error, el numero de sucursal no es correcto");
                    System.out.print("Digite el numero de sucursal nuevamente: ");
                    numero_sucursal = entrada.nextLine();
                    j = 0;
                    i = 0;
                }

            }

        }

        boolean estado = false;
        boolean estadoPaquete = false;

        for (int i = 0; i < contador_sucursal; i++) { //RECORRE SUCURSALES CREADAS

            if (sucursal[i].getNumero_sucursal().equals(numero_sucursal)) {

                estado = true; //SI estado ES true ES PORQUE LA SUCURSAL EXISTE

                System.out.print("Digite el numero de paquete: ");
                numero_paquete = entrada.nextLine();

                for (int k = 0; k < numero_paquete.length(); k++) {

                    String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

                    for (int j = 0; j < letras.length(); j++) {

                        while (numero_paquete.charAt(k) == letras.charAt(j) || numero_paquete.charAt(0) == '0') {

                            System.out.println("Error, el numero de paquete no es correcto");
                            System.out.print("Digite el numero de paquete nuevamente: ");
                            numero_paquete = entrada.nextLine();
                            j = 0;
                            k = 0;

                        }

                    }

                }

                for (int j = 0; j < contador_paquete; j++) { //RECORRE PAQUETES CREADOS

                    if (paquete[j].getNumero_paquete().equals(numero_paquete)) {

                        estadoPaquete = true; //SI estadoPaquete ES true ES PORQUE EL PAQUETE EXISTE

                        if (paquete[j].getEstadoEnvio()) { // SI getEstadoEnvio() DEVUELVE true ES POQUE EL PAQUETE YA FUE ENVIADO

                            System.out.println("Error al enviar paquete");
                            System.out.println("El paquete fue enviado previamente");

                        } else { //SI getEstadoEnvio() DEVUELVE false ENTONCES EL PAQUETE SE ENVIA

                            paquete[j] = new Paquete(numero_paquete, paquete[j].getDni(), paquete[j].getPeso(), true); //EL PAQUETE CREADO EN SU MOMENTO PASA A TENER ESTADO true PORQUE FUE ENVIADO
                            envioPaquete[contador_paquete_enviado] = new EnvioPaquete(numero_paquete, paquete[j].getDni(), paquete[j].getPeso(), numero_sucursal); //EL PAQUETE SE ALMACENA EN LA CLASE EnvioPaquete QUE ES LA CLASE DONDE SE ALMACENAN LOS PAQUETES ENVIADOS

                            sinEnvioPaquete[j] = sinEnvioPaquete[j + 1]; //SE ELIMINA EL PAQUETE QUE FUE PREVIAMENTE ENVIADO DE LA CLASE SinEnviarPaquete

                            contador_cantidad_paquetes = sucursal[i].getCantidad_paquetes(); //OBTENGO LA CANTIDAD DE PAQUETES QUE TIENE LA SUCURSAL DONDE SE ENVIO PREVIAMENTE EL PAQUETE
                            contador_cantidad_paquetes++; //AL ENVIAR EL PAQUETE A ESA SUCURSAL EL contador_cantidad_paquetes++ AUMENTA
                            sucursal[i] = new Sucursal(numero_sucursal, sucursal[i].getProvincia(), contador_cantidad_paquetes); //ESA SUCURSAL AHORA TIENE UN PAQUETE MAS

                            contador_paquete_enviado++; //VA CONTANDO LA CANTIDAD DE PAQUETES QUE SE ENVIAN A LAS SUCURSALES
                            contador_paquete_sin_enviar--; //VA DESCONTANDO LA CANTIDAD DE PAQUETES SIN ENVIAR PORQUE PREVIAMENTE YA SE ENVIO UNO

                            System.out.println();
                            System.out.println("Paquete enviado con exito!!!");

                        }

                    }

                }

            }

        }

        if (!estado) { //SI estado ES false ES PORQUE LA SUCURSAL NO EXISTE

            System.out.println();
            System.out.println("La sucursal no existe");

        } else if (!estadoPaquete) { //SI estadoPaquete ES false ES PORQUE EL PAQUETE NO EXISTE

            System.out.println();
            System.out.println("El paquete no existe");

        }
    }

    public static void consultarSucursal() {

        System.out.print("Digite el numero de sucursal: ");
        numero_sucursal = entrada.nextLine();

        boolean estado = false;

        for (int i = 0; i < contador_sucursal; i++) { //RECORRE SUCURSALES CREADAS

            if (sucursal[i].getNumero_sucursal().equals(numero_sucursal)) { //SI EL NUMERO DE LA SUCURSAL ES IGUAL AL QUE CONSULTO

                estado = true; //SI ES true ES PORQUE LA SUCURSAL EXISTE

                System.out.println();
                System.out.println("Datos de la sucursal: ");
                System.out.println();
                System.out.println(sucursal[i].mostrarDatosSucursal()); //MUESTRA LOS DATOS DE LA SUCURSAL

                if (sucursal[i].getCantidad_paquetes() > 0) { //SI LA SUCURSAL TIENE PAQUETES

                    System.out.println();
                    System.out.println("Los paquetes que tiene la sucursal son: ");
                }

                for (int j = 0; j < contador_paquete_enviado; j++) { //RECORRE PAQUETES ENVIADOS

                    if (envioPaquete[j].getNumero_sucursal().equals(numero_sucursal)) { //SI EL NUMERO DE LA SUCURSAL DEL PAQUETE ENVIADO ES IGUAL AL NUMERO DE SUCURSAL QUE CONSULTO

                        System.out.println("Paquete: " + envioPaquete[j].getNumero_paquete()); //MUESTRA LOS PAQUETES DE LA SUCURSAL

                    }

                }

            }

        }

        if (!estado) { //SI estado ES false LA CUCURSAL NO EXISTE

            System.out.println();
            System.out.println("La sucursal no existe");
        }

    }

    public static void consultarPaquete() {

        System.out.print("Digite el numero de paquete: ");
        numero_paquete = entrada.nextLine();

        boolean estado = false;

        for (int i = 0; i < contador_paquete; i++) { //RECORRE PAQUETES CREADOS

            if (paquete[i].getNumero_paquete().equals(numero_paquete)) { //SI EL NUMERO DE PAQUETE ES IGUAL AL QUE QUIERO CONSULTAR

                estado = true; //SI ES true ES PORQUE EL PAQUETE EXISTE

                System.out.println();
                System.out.println("Datos del paquete: ");
                System.out.println();
                System.out.println(paquete[i].mostrarDatosPaquete()); //MUESTRA LOS DATOS DEL PAQUETE

                if (paquete[i].getEstadoEnvio()) { //SI EL PAQUETE FUE ENVIADO

                    for (int j = 0; j < contador_paquete_enviado; j++) { //RECORRE PAQUETES ENVIADOS

                        if (envioPaquete[j].getNumero_paquete().equals(numero_paquete)) { //SI EL NUMERO DE PAQUETE ENVIADO ES IGUAL AL NUMERO DE PAQUETE QUE CONSULTO

                            System.out.println("El paquete fue enviado a la sucursal numero: " + envioPaquete[j].getNumero_sucursal()); //MUESTRA LA SUCURSAL DONDE FUE ENVIADO EL PAQUETE

                        }
                    }

                } else { //SI EL PAQUETE NO FUE ENVIADO

                    System.out.println("El paquete no fue enviado o fue reembolsado");
                }

            }

        }

        if (!estado) { //SI estado ES false EL PAQUETE NO EXISTE

            System.out.println();
            System.out.println("El paquete no existe");
        }
    }

    public static void consultarPaquetesEnviados() {

        System.out.println();

        if (contador_paquete_enviado > 0) { //SI HAY PAQUETES ENVIADOS

            System.out.println("TOTAL DE PAQUETES ENVIADOS: " + contador_paquete_enviado);

        } else { //SI NO HAY PAQUETES ENVIADOS

            System.out.println("No hay paquetes enviados");
        }

        for (int i = 0; i < contador_paquete_enviado; i++) { //RECORRE PAQUETES ENVIADOS

            System.out.println();
            System.out.println("Datos del paquete: ");
            System.out.println();
            System.out.println(envioPaquete[i].mostrarDatosEnvioPaquete()); //MUESTRA DATOS DEL PAQUETE ENVIADO

        }
    }

    public static void consultarPaquetesNoEnviados() {

        System.out.println();

        if (contador_paquete_sin_enviar > 0) { //SI HAY PAQUETES SIN ENVIAR

            System.out.println("TOTAL DE PAQUETES SIN ENVIAR: " + contador_paquete_sin_enviar);

        } else { // SI NO HAY PAQUETES SIN ENVIAR

            System.out.println("Los paquetes han sido enviados o no fueron creados previamente");
        }

        for (int i = 0; i < contador_paquete_sin_enviar; i++) { //RECORRE PAQUETES SIN ENVIAR

            System.out.println();
            System.out.println("Datos del paquete sin enviar: ");
            System.out.println();
            System.out.println(sinEnvioPaquete[i].mostrarDatosSinEnviarPaquete()); //MUESTRA DATOS DE PAQUETES SIN ENVIAR

        }
    }

    public static void consultarTodasSucursales() {

        System.out.println();

        if (contador_sucursal > 0) { //SI HAY SUCURSALES CREADAS

            System.out.println("TOTAL DE SUCURSALES CREADAS: " + contador_sucursal);

        } else { //SI NO HAY SUCURSALES CREADAS

            System.out.println("No hay sucursales creadas");
        }

        for (int i = 0; i < contador_sucursal; i++) { //RECORRE SUCURSALES

            System.out.println();
            System.out.println("Datos de la sucursal: ");
            System.out.println();
            System.out.println(sucursal[i].mostrarDatosSucursal()); //MUESTRA DATOS DE LA SUCURSAL

            if (sucursal[i].getCantidad_paquetes() > 0) { //SI LA SUCURSAL TIENE PAQUETES

                System.out.println();
                System.out.println("Los paquetes que tiene la sucursal son: ");
            }

            for (int j = 0; j < contador_paquete_enviado; j++) { //RECORRE PAQUETES ENVIADOS

                if (sucursal[i].getNumero_sucursal().equals(envioPaquete[j].getNumero_sucursal())) { //SI EL NUMERO DE SUCURSAL ES IGUAL AL NUMERO DE SUCURSAL DEL PAQUETE ENVIADO A ESA SUCURSAL

                    System.out.println("Paquete: " + envioPaquete[j].getNumero_paquete()); //MUESTRA PAQUETES QUE PERTENECEN A LA SUCURSAL QUE VOY RECORRIENDO

                }
            }
        }
    }

    public static void consultarTodosPaquetes() {

        System.out.println();

        if (contador_paquete > 0) { //SI HAY PAQUETES CREADOS

            System.out.println("TOTAL DE PAQUETES CREADOS: " + contador_paquete);

        } else { //SI NO HAY PAQUETES CREADOS

            System.out.println("No hay paquetes creados");
        }

        for (int i = 0; i < contador_paquete; i++) { //RECORRE PAQUETES CREADOS

            System.out.println();
            System.out.println("Datos del paquete: ");
            System.out.println();
            System.out.println(paquete[i].mostrarDatosPaquete()); //MUESTRA DATOS DEL PAQUETE

            if (paquete[i].getEstadoEnvio()) { //SI EL PAQUETE FUE ENVIADO

                for (int j = 0; j < contador_paquete_enviado; j++) { //RECORRE PAQUETES ENVIADOS

                    if (envioPaquete[j].getNumero_paquete().equals(paquete[i].getNumero_paquete())) { //SI EL NUMERO DE PAQUETE ES IGUAL AL NUMERO DE PAQUETE ENVIADO

                        System.out.println("El paquete fue enviado a la sucursal numero: " + envioPaquete[j].getNumero_sucursal()); //MUESTRA A QUE SUCURSAL PERTENECE EL PAQUETE

                    }
                }

            } else { //SI EL PAQUETE NO FUE ENVIADO

                System.out.println("El paquete no fue enviado o fue reembolsado");
            }

        }
    }

    public static void eliminarSucursal() {

        boolean estado = false;

        System.out.print("Digite el numero de la sucursal: ");
        numero_sucursal = entrada.nextLine();

        for (int i = 0; i < contador_sucursal; i++) { //RECORRE SUCURSALES 

            if (sucursal[i].getNumero_sucursal().equals(numero_sucursal)) { //SI EL NUMERO DE SURCURSAL ES IGUAL AL NUMERO DE SUCURAL QUE QUIERO ELIMINAR

                estado = true; //SI ES true ES PORQUE LA SUCURSAL EXISTE

                if (sucursal[i].getCantidad_paquetes() > 0) { // SI LA SUCURSAL TIENE PAQUETES

                    System.out.println("La sucursal no puede eliminarse porque tiene paquetes");

                    System.out.println();
                    System.out.println("OPCION 1 SI DESEA ELIMINARLA Y REEMBOLSAR SUS PAQUETES");
                    System.out.println("OPCION 2 SI DESEA NO ELIMINARLA");
                    System.out.println();
                    System.out.print("Digite la opcion: ");
                    opcion = entrada.nextLine();

                    while (!opcion.equals("1") && !opcion.equals("2")) { //VALIDA LA OPCION

                        System.out.println();
                        System.out.println("La opcion no es correcta.");
                        System.out.print("Digite nuevamente la opcion: ");
                        opcion = entrada.nextLine();

                    }

                    switch (Integer.valueOf(opcion)) { //CON Integer.valueOf(opcion) CONVIERTO opcion EN ENTERO PARA QUE PUEDA EVALUAR LOS CASE

                        case 1:

                            sucursal[i] = sucursal[i + 1]; //ELIMINA LA SUCURSAL

                            System.out.println();
                            System.out.println("La sucursal numero: " + numero_sucursal + " fue eliminada y sus paquetes reembolsados");

                            contador_sucursal--; //DESCUENTA LA SUCURSAL ELIMINADA

                            for (int j = 0; j < contador_paquete_enviado; j++) { //RECORRE LOS PAQUETES ENVIADOS

                                if (numero_sucursal.equals(envioPaquete[j].getNumero_sucursal())) { //SI EL NUMERO DE LA SUCURSAL QUE ELIMINE ES IGUAL AL NUMERO DE SUCURSAL DE LOS PAQUETES QUE ENVIE A ESA SUCURSAL

                                    for (int k = 0; k < contador_paquete; k++) { // RECORRE PAQUETES CREADOS

                                        if (paquete[k].getNumero_paquete().equals(envioPaquete[j].getNumero_paquete())) { //SI EL NUMERO DE PAQUETE ES IGUAL AL NUMERO DE PAQUETE ENVIADO

                                            paquete[k] = new Paquete(paquete[k].getNumero_paquete(), paquete[k].getDni(), paquete[k].getPeso(), false); //REEMBOLSO EL PAQUETE. 
                                            sinEnvioPaquete[k] = new SinEnviarPaquete(paquete[k].getNumero_paquete(), paquete[k].getDni(), paquete[k].getPeso()); //EL PAQUETE PASA A ESTAR SIN ENVIAR PORQUE FUE REEMBOLSADO

                                            contador_paquete_sin_enviar++; //SE CUENTA EL PAQUETE REEMBOLSADO QUE PASO A ESTAR SIN ENVIAR 
                                        }

                                    }

                                    envioPaquete[j] = envioPaquete[j + 1]; //ELIMINO EL PAQUETE DE LA CLASE EnvioPaquete PORQUE FUE REEMBOLSADO

                                    contador_paquete_enviado--; //DESCUENTA EL PAQUETE REEMBOLSADO PORQUE YA NO ES UN PAQUETE ENVIADO
                                    j--; // VUELVE A CONTAR EN CASO DE QUE LA SUCURSAL TENGA MAS DE UN PAQUETE QUE REEMBOLSAR. EN envioPaquete[j] = envioPaquete[j + 1] HAY UN NUEVO PAQUETE Y TENGO QUE SABER SI PERTENECE A LA SUCURSAL QUE ESTOY ELIMINANDO

                                }

                            }

                            break;

                        case 2:

                            System.out.println("La sucursal no fue eliminada");

                    }

                } else { //SI LA SUCURSAL NO TIENE PAQUETES

                    sucursal[i] = sucursal[i + 1]; //ELIMINA LA SUCURSAL

                    System.out.println();
                    System.out.println("La sucursal numero: " + numero_sucursal + " fue eliminada");

                    contador_sucursal--; //DESCUENTA LA SUCURSAL ELIMINADA

                }
            }
        }

        if (!estado) { //SI ES false ES PORQUE LA SUCURSAL NO EXISTE

            System.out.println();
            System.out.println("La sucursal no existe");
        }
    }

    public static void eliminarPaquete() {

        boolean estado = false;

        System.out.print("Digite el numero de paquete: ");
        numero_paquete = entrada.nextLine();

        for (int i = 0; i < contador_paquete; i++) { //RECORRE PAQUETES CREADOS

            if (paquete[i].getNumero_paquete().equals(numero_paquete)) { //SI EL NUMERO DE PAQUETE ES IGUAL AL NUMERO DE PAQUETE QUE QUIERO ELIMINAR

                estado = true; //SI ES true ES PORQUE EL PAQUETE EXISTE

                paquete[i] = paquete[i + 1]; //ELIMINA EL PAQUETE

                contador_paquete--; //DESCUENTA EL PAQUETE ELIMINADO

                System.out.println("Paquete eliminado con exito!!!");
            }
        }

        for (int j = 0; j < contador_paquete_sin_enviar; j++) {  //RECORRE PAQUETES NO ENVIADOS

            if (sinEnvioPaquete[j].getNumero_paquete().equals(numero_paquete)) { //SI EL NUMERO DE PAQUETE SIN ENVIAR ES IGUAL AL QUE QUIERO ELIMINAR

                sinEnvioPaquete[j] = sinEnvioPaquete[j + 1]; //LO ELIMINA TAMBIEN DE LA CLASE SinEnviarPaquete

                contador_paquete_sin_enviar--; //DESCUENTA EL PAQUETE SI NO FUE ENVIADO

            }

        }

        for (int j = 0; j < contador_paquete_enviado; j++) { //RECORRE PAQUETES ENVIADOS

            for (int k = 0; k < contador_sucursal; k++) { //RECORRE SUCURSALES CREADAS

                if (envioPaquete[j].getNumero_paquete().equals(numero_paquete)) { //SI EL NUMERO DE PAQUETE QUE FUE ENVIADO ES IGUAL AL NUMERO DE PAQUETE QUE QUIERO ELIMINAR

                    if (sucursal[k].getNumero_sucursal().equals(envioPaquete[j].getNumero_sucursal())) { //SI EL NUMERO DE SUCURSAL ES IGUAL AL NUMERO DE SUCURSAL DEL PAQUETE ENVIADO

                        envioPaquete[j] = envioPaquete[j + 1]; //ELIMINA EL PAQUETE DE ENVIADOS

                        contador_paquete_enviado--; //DESCUENTA EL PAQUETE ELIMINADO DE ENVIADOS

                        contador_cantidad_paquetes = sucursal[k].getCantidad_paquetes(); //OBTENGO LA CANTIDAD DE PAQUETES QUE TIENE LA SUCURSAL
                        contador_cantidad_paquetes--; //LE DESCUENTO A LA SUCURSAL EL PAQUETE ELIMINADO QUE PERTENECIA A ESA SUCURSAL

                        sucursal[k] = new Sucursal(numero_sucursal, sucursal[k].getProvincia(), contador_cantidad_paquetes); //LA SUCURSAL TENDRA UN PAQUETE MENOS

                    }
                }
            }
        }

        if (!estado) {  //SI ES false ES PORQUE EL PAQUETE NO EXISTE

            System.out.println("El paquete no existe");
        }
    }

    public static void modificarSucursal() {

        boolean estado = false;

        System.out.print("Digite la sucursal que desea modificar: ");
        numero_sucursal = entrada.nextLine();

        for (int i = 0; i < contador_sucursal; i++) { //RECORRE SUCURSALES CREADAS

            if (sucursal[i].getNumero_sucursal().equals(numero_sucursal)) {

                estado = true;  //SI ES true ES PORQUE LA SUCURSAL EXISTE

                System.out.println();
                System.out.println("OPCION 1 SI DESEA MODIFICAR EL NUMERO DE SUCURSAL");
                System.out.println("OPCION 2 SI DESEA MODIFICAR LA PROVINCIA");
                System.out.println();
                System.out.print("Digite la opcion: ");
                opcion = entrada.nextLine();

                while (!opcion.equals("1") && !opcion.equals("2")) { //VALIDO opcion

                    System.out.println();
                    System.out.println("La opcion no es correcta.");
                    System.out.print("Digite nuevamente la opcion: ");
                    opcion = entrada.nextLine();

                }

                switch (Integer.valueOf(opcion)) { //CON Integer.valueOf(opcion) CONVIERTO opcion EN ENTERO PARA QUE PUEDA EVALUAR LOS CASE

                    case 1:

                        System.out.print("Digite un nuevo numero de sucursal: ");
                        String numero_sucursal_nuevo = entrada.nextLine();

                        //VALIDO numero_sucursal_nuevo
                        for (int k = 0; k < numero_sucursal_nuevo.length(); k++) {

                            String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

                            for (int h = 0; h < letras.length(); h++) {

                                while (numero_sucursal_nuevo.charAt(k) == letras.charAt(h) || numero_sucursal_nuevo.charAt(0) == '0') {

                                    System.out.println("Error, el numero de sucursal no es correcto");
                                    System.out.print("Digite el numero de sucursal nuevamente: ");
                                    numero_sucursal_nuevo = entrada.nextLine();
                                    h = 0;
                                    k = 0;
                                }

                            }

                        }

                        //VALIDO QUE EL NUMERO DE LA SUCURSAL SEA UNICO
                        for (int f = 0; f < contador_sucursal; f++) {

                            while (numero_sucursal_nuevo.equals(sucursal[f].getNumero_sucursal())) {

                                System.out.println("La sucursal ha sido creada previamente");
                                System.out.print("Por favor digite un numero de sucursal diferente: ");
                                numero_sucursal_nuevo = entrada.nextLine();
                                f = 0;

                                for (int p = 0; p < numero_sucursal_nuevo.length(); p++) {

                                    String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

                                    for (int t = 0; t < letras.length(); t++) {

                                        while (numero_sucursal_nuevo.charAt(p) == letras.charAt(t) || numero_sucursal_nuevo.charAt(0) == '0') {

                                            System.out.println("Error, el numero de sucursal no es correcto");
                                            System.out.print("Digite el numero de sucursal nuevamente: ");
                                            numero_sucursal_nuevo = entrada.nextLine();
                                            t = 0;
                                            p = 0;

                                        }

                                    }

                                }

                            }

                        }

                        sucursal[i] = new Sucursal(numero_sucursal_nuevo, sucursal[i].getProvincia(), sucursal[i].getCantidad_paquetes()); //REEMPLAZO EL ANTERIOR NUMERO DE LA SUCURSAL POR EL NUEVO
                        System.out.println();
                        System.out.println("Numero de sucursal modificado con exito!!!");

                        for (int j = 0; j < contador_paquete_enviado; j++) { //RECORRE PAQUETES ENVIADOS

                            if (envioPaquete[j].getNumero_sucursal().equals(numero_sucursal)) { //SI EL NUMERO DE LA SUCURSAL DEL PAQUETE ENVIADO ES IGUAL AL QUE QUIERO MODIFICAR

                                envioPaquete[j] = new EnvioPaquete(envioPaquete[j].getNumero_paquete(), envioPaquete[j].getDni(), envioPaquete[j].getPeso(), numero_sucursal_nuevo); //REEMPLAZO EL ANTERIOR NUMERO DE LA SUCURSAL POR EL NUEVO

                            }
                        }

                        break;

                    case 2:

                        System.out.print("Digite una nueva provincia: ");
                        provincia = entrada.nextLine();

                        //VALIDO provincia
                        while (!provincia.equalsIgnoreCase("Buenos Aires") && !provincia.equalsIgnoreCase("Tierra del Fuego")
                                && !provincia.equalsIgnoreCase("Santa Cruz") && !provincia.equalsIgnoreCase("Chubut")
                                && !provincia.equalsIgnoreCase("Rio Negro") && !provincia.equalsIgnoreCase("Neuquen")
                                && !provincia.equalsIgnoreCase("La Pampa") && !provincia.equalsIgnoreCase("Entre Rios")
                                && !provincia.equalsIgnoreCase("Corrientes") && !provincia.equalsIgnoreCase("Misiones")
                                && !provincia.equalsIgnoreCase("Chaco") && !provincia.equalsIgnoreCase("San Luis")
                                && !provincia.equalsIgnoreCase("Santiago del Estero") && !provincia.equalsIgnoreCase("Mendoza")
                                && !provincia.equalsIgnoreCase("Salta") && !provincia.equalsIgnoreCase("Jujuy")
                                && !provincia.equalsIgnoreCase("Formosa") && !provincia.equalsIgnoreCase("Tucuman")
                                && !provincia.equalsIgnoreCase("La Rioja") && !provincia.equalsIgnoreCase("Catamarca")
                                && !provincia.equalsIgnoreCase("San Juan") && !provincia.equalsIgnoreCase("Cordoba")
                                && !provincia.equalsIgnoreCase("Santa Fe")) {

                            System.out.println("Provincia no valida");

                            System.out.print("Digite la provincia nuevamente: ");
                            provincia = entrada.nextLine();
                        }

                        sucursal[i] = new Sucursal(sucursal[i].getNumero_sucursal(), provincia, sucursal[i].getCantidad_paquetes()); //REEMPLAZO LA ANTERIOR PROVINCIA POR LA NUEVA
                        System.out.println();
                        System.out.println("Provincia modificada con exito!!!");

                }
            }

        }

        if (!estado) { //SI ES false ES PORQUE LA SUCURSAL NO EXISTE

            System.out.println("La sucursal no existe");
        }

    }

    public static void modificarPquete() {

        boolean estado = false;

        System.out.print("Digite el paquete que desea modificar: ");
        numero_paquete = entrada.nextLine();

        for (int i = 0; i < contador_paquete; i++) { //RECORRE PAQUETES CREADOS

            if (paquete[i].getNumero_paquete().equals(numero_paquete)) { //SI EL NUMERO DE PAQUETE ES IGUAL AL QUE QUIERO MODIFICAR

                estado = true; //SI ES true ES PORQUE EL PAQUETE EXISTE

                System.out.println();
                System.out.println("OPCION 1 SI DESEA MODIFICAR EL NUMERO DEL PAQUETE");
                System.out.println("OPCION 2 SI DESEA MODIFICAR EL DNI");
                System.out.println("OPCION 3 SI DESEA MODIFICAR EL PESO");
                System.out.println();
                System.out.print("Digite la opcion: ");
                opcion = entrada.nextLine();

                while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3")) { //VALIDO opcion

                    System.out.println();
                    System.out.println("La opcion no es correcta.");
                    System.out.print("Digite nuevamente la opcion: ");
                    opcion = entrada.nextLine();

                }

                switch (Integer.valueOf(opcion)) { //CON Integer.valueOf(opcion) CONVIERTO opcion EN ENTERO PARA QUE PUEDA EVALUAR LOS CASE

                    case 1:

                        System.out.print("Digite un nuevo numero de paquete: ");
                        String numero_paquete_nuevo = entrada.nextLine();

                        //VALIDO numero_paquete_nuevo
                        for (int h = 0; h < numero_paquete_nuevo.length(); h++) {

                            String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

                            for (int j = 0; j < letras.length(); j++) {

                                while (numero_paquete_nuevo.charAt(h) == letras.charAt(j) || numero_paquete_nuevo.charAt(0) == '0') {

                                    System.out.println("Error, el numero de paquete no es correcto");
                                    System.out.print("Digite el numero de paquete nuevamente: ");
                                    numero_paquete_nuevo = entrada.nextLine();
                                    j = 0;
                                    h = 0;
                                }

                            }

                        }

                        //VALIDO QUE EL NUMERO DE PAQUETE SEA UNICO
                        for (int f = 0; f < contador_paquete; f++) {

                            while (numero_paquete_nuevo.equals(paquete[f].getNumero_paquete())) {

                                System.out.println("El paquete ha sido creado previamente");
                                System.out.print("Por favor digite un numero de paquete diferente: ");
                                numero_paquete_nuevo = entrada.nextLine();
                                f = 0;

                                for (int p = 0; p < numero_paquete_nuevo.length(); p++) {

                                    String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

                                    for (int j = 0; j < letras.length(); j++) {

                                        while (numero_paquete_nuevo.charAt(p) == letras.charAt(j) || numero_paquete_nuevo.charAt(0) == '0') {

                                            System.out.println("Error, el numero de paquete no es correcto");
                                            System.out.print("Digite el numero de paquete nuevamente: ");
                                            numero_paquete_nuevo = entrada.nextLine();
                                            j = 0;
                                            p = 0;
                                        }

                                    }

                                }

                            }

                        }

                        paquete[i] = new Paquete(numero_paquete_nuevo, paquete[i].getDni(), paquete[i].getPeso(), paquete[i].getEstadoEnvio()); //MODIFICO EL NUMERO DE PAQUETE ANTERIOR POR EL NUEVO

                        if (!paquete[i].getEstadoEnvio()) { //SI EL PAQUETE NO FUE ENVIADO

                            sinEnvioPaquete[i] = new SinEnviarPaquete(numero_paquete_nuevo, sinEnvioPaquete[i].getDni(), sinEnvioPaquete[i].getPeso()); //MODIFICO EL NUMERO DE PAQUETE ANTERIOR POR EL NUEVO
                        }

                        System.out.println();
                        System.out.println("Numero de paquete modificado con exito!!!");

                        for (int j = 0; j < contador_paquete_enviado; j++) { //RECORRE PAQUETES ENVIADOS

                            if (envioPaquete[j].getNumero_paquete().equals(numero_paquete)) { //SI EL NUMERO DE PAQUETE ENVIADO ES IGUAL AL QUE QUIERO MODIFICAR

                                envioPaquete[j] = new EnvioPaquete(numero_paquete_nuevo, envioPaquete[j].getDni(), envioPaquete[j].getPeso(), envioPaquete[j].getNumero_sucursal()); //MODIFICO EL NUMERO DE PAQUETE ANTERIOR POR EL NUEVO

                            }
                        }

                        break;

                    case 2:

                        System.out.print("Digite un nuevo numero de DNI: ");
                        String dni_nuevo = entrada.nextLine();

                        //VALIDO dni_nuevo
                        for (int h = 0; h < dni_nuevo.length(); h++) {

                            String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

                            for (int j = 0; j < letras.length(); j++) {

                                while (dni_nuevo.charAt(h) == letras.charAt(j) || dni_nuevo.length() > 8 || dni_nuevo.length() < 8 || dni_nuevo.charAt(0) == '0') {

                                    System.out.println("Error, el dni no es valido");
                                    System.out.print("Digite el numero de dni nuevamente: ");
                                    dni_nuevo = entrada.nextLine();
                                    j = 0;
                                    h = 0;
                                }

                            }

                        }

                        paquete[i] = new Paquete(paquete[i].getNumero_paquete(), dni_nuevo, paquete[i].getPeso(), paquete[i].getEstadoEnvio()); //MODIFICO EL DNI ANTERIOR POR EL NUEVO

                        if (!paquete[i].getEstadoEnvio()) { //SI EL PAQUETE NO FUE ENVIADO

                            sinEnvioPaquete[i] = new SinEnviarPaquete(sinEnvioPaquete[i].getNumero_paquete(), dni_nuevo, sinEnvioPaquete[i].getPeso()); //MODIFICO EL DNI ANTERIOR POR EL NUEVO
                        }

                        System.out.println();
                        System.out.println("DNI modificado con exito!!!");

                        for (int j = 0; j < contador_paquete_enviado; j++) { //RECORRE PAQUETES ENVIADOS

                            if (envioPaquete[j].getNumero_paquete().equals(numero_paquete)) { //SI EL NUMERO DE PAQUETE ENVIADO ES IGUAL AL QUE QUIERO MODIFICAR

                                envioPaquete[j] = new EnvioPaquete(envioPaquete[j].getNumero_paquete(), dni_nuevo, envioPaquete[j].getPeso(), envioPaquete[j].getNumero_sucursal()); //MODIFICO EL DNI ANTERIOR POR EL NUEVO

                            }
                        }

                        break;

                    case 3:

                        System.out.print("Digite un nuevo numero de peso: ");
                        String peso_nuevo = entrada.nextLine();

                        //VALIDO peso_nuevo
                        for (int g = 0; g < peso_nuevo.length(); g++) {

                            String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKMNLÑOPQRSTUVWXYZ";

                            for (int j = 0; j < letras.length(); j++) {

                                while (peso_nuevo.charAt(g) == letras.charAt(j) || peso_nuevo.length() > 2 || peso_nuevo.length() > 1 && peso_nuevo.charAt(1) != '0'
                                        || Integer.valueOf(peso_nuevo) > 10 || Integer.valueOf(peso_nuevo) <= 0 || peso_nuevo.charAt(0) == '0') {

                                    System.out.println("Error, el peso no es valido.");
                                    System.out.println("Compruebe que el peso este entre 1 y 10 Kg y no contenga letras");
                                    System.out.print("Digite el peso nuevamente: ");
                                    peso_nuevo = entrada.nextLine();
                                    j = 0;
                                    g = 0;
                                }

                            }

                        }

                        paquete[i] = new Paquete(paquete[i].getNumero_paquete(), paquete[i].getDni(), peso_nuevo, paquete[i].getEstadoEnvio()); //MODIFICO EL PESO ANTERIOR POR EL NUEVO

                        if (!paquete[i].getEstadoEnvio()) { //SI EL PAQUETE NO FUE ENVIADO

                            sinEnvioPaquete[i] = new SinEnviarPaquete(sinEnvioPaquete[i].getNumero_paquete(), sinEnvioPaquete[i].getDni(), peso_nuevo); //MODIFICO EL PESO ANTERIOR POR EL NUEVO
                        }

                        System.out.println();
                        System.out.println("Peso modificado con exito!!!");

                        for (int j = 0; j < contador_paquete_enviado; j++) { //RECORRE PAQUETES ENVIADOS

                            if (envioPaquete[j].getNumero_paquete().equals(numero_paquete)) { //SI EL NUMERO DE PAQUETE ENVIADO ES IGUAL AL QUE QUIERO MODIFICAR

                                envioPaquete[j] = new EnvioPaquete(envioPaquete[j].getNumero_paquete(), envioPaquete[j].getDni(), peso_nuevo, envioPaquete[j].getNumero_sucursal()); //MODIFICO EL PESO ANTERIOR POR EL NUEVO

                            }
                        }

                }
            }
        }

        if (!estado) { //SI ES false ES PORQUE EL PAQUETE NO EXISTE

            System.out.println("El paquete no existe");
        }
    }

    public static void salirMenu() {

        System.out.println();
        System.out.println("Saliste del menu");
    }

}
