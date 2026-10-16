import java.util.ArrayList;

public class MaxHeapChamados {

    private ArrayList<Chamado> heap;

    public MaxHeapChamados() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void offer(Chamado chamado) {
        heap.add(chamado);
        subir(heap.size() - 1);
    }

    public Chamado peek() {
        if (isEmpty()) {
            return null;
        }

        return heap.get(0);
    }

    public Chamado poll() {
        if (isEmpty()) {
            return null;
        }

        Chamado primeiro = heap.get(0);
        Chamado ultimo = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            descer(0);
        }

        return primeiro;
    }

    private boolean temMaiorPrioridade(
            Chamado a, Chamado b) {

        if (a.getPrioridade() != b.getPrioridade()) {
            return a.getPrioridade() > b.getPrioridade();
        }

        return a.getOrdemChegada() < b.getOrdemChegada();
    }

    private void subir(int indice) {
        while (indice > 0) {
            int pai = (indice - 1) / 2;

            if (temMaiorPrioridade(
                    heap.get(indice), heap.get(pai))) {

                trocar(indice, pai);
                indice = pai;

            } else {
                break;
            }
        }
    }

    private void descer(int indice) {
        int tamanho = heap.size();

        while (true) {
            int esquerdo = 2 * indice + 1;
            int direito = 2 * indice + 2;
            int maior = indice;

            if (esquerdo < tamanho
                    && temMaiorPrioridade(
                        heap.get(esquerdo),
                        heap.get(maior))) {

                maior = esquerdo;
            }

            if (direito < tamanho
                    && temMaiorPrioridade(
                        heap.get(direito),
                        heap.get(maior))) {

                maior = direito;
            }

            if (maior == indice) {
                break;
            }

            trocar(indice, maior);
            indice = maior;
        }
    }

    private void trocar(int posicaoA, int posicaoB) {
        Chamado temporario = heap.get(posicaoA);

        heap.set(posicaoA, heap.get(posicaoB));
        heap.set(posicaoB, temporario);
    }
}