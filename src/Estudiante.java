import java.util.Random;

public class Estudiante implements Runnable {

    private int id;
    private CentroCopias centro;
    private int copiasHechas = 0;
    private boolean activo = true;
    private Random random = new Random();

    public Estudiante(int id, CentroCopias centro) {
        this.id = id;
        this.centro = centro;
    }

    public void detener() {
        activo = false;
    }

    public int getCopiasHechas() {
        return copiasHechas;
    }

    @Override
    public void run() {
        try {
            while (activo) {
                System.out.println("Estudiante " + id + " está estudiando");
                Thread.sleep(500 + random.nextInt(1000));

                System.out.println("Estudiante " + id + " solicita máquina");
                int maquina = centro.solicitarMaquina(id);

                Thread.sleep(500 + random.nextInt(1000));
                copiasHechas++;

                centro.liberarMaquina(id, maquina);
            }
        } catch (InterruptedException e) {
            // Finalización del hilo
        }
    }
}
