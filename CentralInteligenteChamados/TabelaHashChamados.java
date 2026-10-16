import java.util.LinkedList;

public class TabelaHashChamados {

    private static class EntradaHash {
        int id;
        Chamado chamado;

        EntradaHash(int id, Chamado chamado) {
            this.id = id;
            this.chamado = chamado;
        }
    }

    private LinkedList<EntradaHash>[] buckets;

    @SuppressWarnings("unchecked")
    public TabelaHashChamados() {
        buckets = (LinkedList<EntradaHash>[])
            new LinkedList[7];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int calcularIndice(int id) {
        return Math.floorMod(
            Integer.hashCode(id), buckets.length
        );
    }

    public void put(int id, Chamado chamado) {
        int indice = calcularIndice(id);

        for (EntradaHash entrada : buckets[indice]) {
            if (entrada.id == id) {
                entrada.chamado = chamado;
                return;
            }
        }

        buckets[indice].add(
            new EntradaHash(id, chamado)
        );
    }

    public Chamado get(int id) {
        int indice = calcularIndice(id);

        for (EntradaHash entrada : buckets[indice]) {
            if (entrada.id == id) {
                return entrada.chamado;
            }
        }

        return null;
    }

    public Chamado remove(int id) {
        int indice = calcularIndice(id);

        for (EntradaHash entrada : buckets[indice]) {
            if (entrada.id == id) {
                buckets[indice].remove(entrada);
                return entrada.chamado;
            }
        }

        return null;
    }

    public boolean containsKey(int id) {
        return get(id) != null;
    }
}