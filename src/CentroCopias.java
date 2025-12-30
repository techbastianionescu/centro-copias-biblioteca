public class CentroCopias {

    private boolean[] maquinas = { true, true };

    public synchronized int solicitarMaquina(int idEstudiante) throws InterruptedException {
        while (!hayMaquinaLibre()) {
            System.out.println("Estudiante " + idEstudiante + " espera máquina");
            wait();
        }

        for (int i = 0; i < maquinas.length; i++) {
            if (maquinas[i]) {
                maquinas[i] = false;
                System.out.println("Estudiante " + idEstudiante + " usa máquina " + i);
                return i;
            }
        }
        return -1;
    }

    public synchronized void liberarMaquina(int idEstudiante, int maquina) {
        maquinas[maquina] = true;
        System.out.println("Estudiante " + idEstudiante + " libera máquina " + maquina);
        notifyAll();
    }

    private boolean hayMaquinaLibre() {
        for (boolean libre : maquinas) {
            if (libre)
                return true;
        }
        return false;
    }
}
