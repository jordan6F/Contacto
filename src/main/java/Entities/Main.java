package Entities;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<Contacto> listaContactos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    eliminarContacto();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    mostrarContactos();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número del 1 al 5.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Eliminar contacto");
        System.out.println("3. Buscar contacto por nombre");
        System.out.println("4. Mostrar todos los contactos");
        System.out.println("5. Salir");
        System.out.print("Ingrese su opción: ");
    }

    private static void agregarContacto() {
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese la dirección de correo electrónico: ");
        String email = scanner.nextLine();

        Contacto contacto = new Contacto(nombre, telefono, email);
        listaContactos.add(contacto);
        System.out.println("Contacto agregado correctamente.");
    }

    private static void eliminarContacto() {
        System.out.print("Ingrese el nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();

        boolean encontrado = false;
        for (Contacto contacto : listaContactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                listaContactos.remove(contacto);
                encontrado = true;
                System.out.println("Contacto eliminado correctamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }

    private static void buscarContacto() {
        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String nombre = scanner.nextLine();

        boolean encontrado = false;
        for (Contacto contacto : listaContactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Nombre: " + contacto.getNombre());
                System.out.println("Teléfono: " + contacto.getTelefono());
                System.out.println("Email: " + contacto.getEmail());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }

    private static void mostrarContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos para mostrar.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacto contacto : listaContactos) {
                System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getTelefono() + ", Email: " + contacto.getEmail());
            }
        }
    }
}
