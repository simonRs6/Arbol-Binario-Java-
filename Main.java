import java.util.Scanner;

// --- CLASE NODO ---
class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

// --- CLASE ÁRBOL BINARIO ---
class ArbolBinario {
    Nodo raiz;

    // Método para insertar
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }
        if (valor < raiz.valor) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertarRec(raiz.derecho, valor);
        }
        return raiz;
    }

    // Método Inorden (Izquierda - Raíz - Derecha)
    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            inordenRec(raiz.derecho);
        }
    }

    // Método de Búsqueda
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null) return false;
        if (raiz.valor == valor) return true;
        
        return valor < raiz.valor 
            ? buscarRec(raiz.izquierdo, valor) 
            : buscarRec(raiz.derecho, valor);
    }
}

// --- CLASE PRINCIPAL ---
public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- ÁRBOL BINARIO ---");
            System.out.println("1. Insertar número");
            System.out.println("2. Mostrar Inorden");
            System.out.println("3. Buscar número");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Número a insertar: ");
                    arbol.insertar(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Recorrido Inorden: ");
                    arbol.inorden();
                    break;
                case 3:
                    System.out.print("Número a buscar: ");
                    int num = sc.nextInt();
                    if (arbol.buscar(num)) System.out.println("¡El número existe!");
                    else System.out.println("El número no está en el árbol.");
                    break;
                case 4: opcion = 5; break;
            }
        }
    }
}
