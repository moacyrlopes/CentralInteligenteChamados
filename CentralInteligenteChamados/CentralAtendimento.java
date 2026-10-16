public class CentralAtendimento {

    private TabelaHashChamados chamadosPorId;
    private MaxHeapChamados filaPrioridade;
    private long proximaOrdem;

    public CentralAtendimento() {
        chamadosPorId = new TabelaHashChamados();
        filaPrioridade = new MaxHeapChamados();
        proximaOrdem = 1;
    }

    public void cadastrar(Chamado chamado) {
        if (chamadosPorId.containsKey(chamado.getId())) {
            System.out.println(
                "Erro: ID duplicado: " + chamado.getId()
            );
            return;
        }

        chamado.setOrdemChegada(proximaOrdem);
        proximaOrdem++;

        chamadosPorId.put(chamado.getId(), chamado);
        filaPrioridade.offer(chamado);

        System.out.println(
            "Chamado cadastrado: " + chamado.getId()
        );
    }

    public Chamado buscarPorId(int id) {
        return chamadosPorId.get(id);
    }

    public Chamado consultarProximo() {
        return filaPrioridade.peek();
    }

    public Chamado atenderProximo() {
        Chamado chamado = filaPrioridade.poll();

        if (chamado != null) {
            chamadosPorId.remove(chamado.getId());
        }

        return chamado;
    }
    public boolean filaVazia() {
    return filaPrioridade.isEmpty();
}
}