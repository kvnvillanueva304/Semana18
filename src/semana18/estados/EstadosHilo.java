package semana18.estados;

public class EstadosHilo {
    private static final Object candado = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread dormilon = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        });

        System.out.println(" creado: " + dormilon.getState());
        dormilon.start();
        System.out.println(" Tras start(): " + dormilon.getState());

        Thread.sleep(100);
        System.out.println(" Durante sleep: " + dormilon.getState());

        Thread esperador = new Thread(() -> {
            try {
                dormilon.join();
            } catch (InterruptedException e) {
                return;
            }
        });
        esperador.start();
        Thread.sleep(100);
        System.out.println(" Esperando join: " + esperador.getState());

        Thread bloqueado = new Thread(() -> {
            synchronized (candado) {
                System.out.println("  (bloqueado)");
            }
        });

        synchronized (candado) {
            bloqueado.start();
            Thread.sleep(100);
            System.out.println("5. Esperando candado: " + bloqueado.getState());
        }

        bloqueado.join();
        dormilon.join();
        esperador.join();
        System.out.println(" Al terminar: " + dormilon.getState());
    }
}