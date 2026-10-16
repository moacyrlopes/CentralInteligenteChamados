public class Chamado {
    private int id;
    private String solicitante;
    private String descricao;
    private int prioridade;
    private long ordemChegada;

    public Chamado(int id, String solicitante,
                   String descricao, int prioridade) {

        if (prioridade < 1 || prioridade > 5) {
            throw new IllegalArgumentException(
                "A prioridade deve estar entre 1 e 5."
            );
        }

        this.id = id;
        this.solicitante = solicitante;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.ordemChegada = 0;
    }

    public int getId() {
        return id;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public long getOrdemChegada() {
        return ordemChegada;
    }

    public void setOrdemChegada(long ordemChegada) {
        this.ordemChegada = ordemChegada;
    }

    @Override
    public String toString() {
        return "ID: " + id
            + " | Solicitante: " + solicitante
            + " | Descricao: " + descricao
            + " | Prioridade: " + prioridade
            + " | Ordem de chegada: " + ordemChegada;
    }
}