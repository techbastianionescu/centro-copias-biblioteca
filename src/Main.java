public class Main {

    public static void main(String[] args) throws InterruptedException {

        CentroCopias centro = new CentroCopias();
        Estudiante[] estudiantes = new Estudiante[5];
        Thread[] hilos = new Thread[5];

        for (int i = 0; i < 5; i++) {
            estudiantes[i] = new Estudiante(i, centro);
            hilos[i] = new Thread(estudiantes[i]);
            hilos[i].start();
        }

        Thread.sleep(20000);

        for (Estudiante e : estudiantes) {
            e.detener();
        }

        for (Thread t : hilos) {
            t.join();
        }

        System.out.println("\n--- RESULTADO FINAL ---");
        for (int i = 0; i < 5; i++) {
            System.out.println("Estudiante " + i + " hizo copias " + estudiantes[i].getCopiasHechas() + " veces");
        }
    }
}
