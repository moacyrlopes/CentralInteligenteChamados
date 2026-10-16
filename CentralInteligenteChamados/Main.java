public class Main {

    public static void main(String[] args) {

        CentralAtendimento central = new CentralAtendimento();

        System.out.println("=== CENTRAL DE CHAMADOS ===");

        central.cadastrar(new Chamado(
            10, "Joao", "Problema no computador", 2
        ));

        central.cadastrar(new Chamado(
            17, "Maria", "Sistema fora do ar", 5
        ));

        central.cadastrar(new Chamado(
            24, "Pedro", "Erro no programa", 3
        ));

        central.cadastrar(new Chamado(
            101, "Ana", "Falha urgente na rede", 5
        ));

        central.cadastrar(new Chamado(
            102, "Carlos", "Instalar software", 4
        ));

        central.cadastrar(new Chamado(
            103, "Lucas", "Duvida de acesso", 1
        ));

        System.out.println("\n=== BUSCA POR ID ===");

        Chamado encontrado = central.buscarPorId(24);

        if (encontrado != null) {
            System.out.println("Chamado encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("Chamado nao encontrado.");
        }

        System.out.println("\n=== BUSCA INVALIDA ===");

        Chamado inexistente = central.buscarPorId(999);

        if (inexistente == null) {
            System.out.println("ID 999 nao encontrado.");
        }

        System.out.println("\n=== PROXIMO CHAMADO ===");

        Chamado proximo = central.consultarProximo();

        if (proximo != null) {
            System.out.println(proximo);
        }

        System.out.println("\n=== ATENDIMENTO ===");

        Chamado atendido = central.atenderProximo();

        if (atendido != null) {
            System.out.println("Chamado atendido:");
            System.out.println(atendido);
        }

        System.out.println("\n=== VERIFICAR REMOCAO ===");

        if (central.buscarPorId(atendido.getId()) == null) {
            System.out.println(
                "Chamado removido corretamente das estruturas."
            );
        }

        System.out.println("\n=== NOVO PROXIMO CHAMADO ===");

        proximo = central.consultarProximo();

        if (proximo != null) {
            System.out.println(proximo);
        }

        System.out.println("\n=== TESTE DE DUPLICIDADE ===");

        central.cadastrar(new Chamado(
            24, "Outro solicitante", "Chamado repetido", 5
        ));

        System.out.println("\n=== FILA DE ATENDIMENTO ===");

        while (!central.filaVazia()) {
            Chamado chamado = central.atenderProximo();
            System.out.println("Atendido: " + chamado);
        }

        System.out.println("\n=== FILA VAZIA ===");

        Chamado ultimo = central.atenderProximo();

        if (ultimo == null) {
            System.out.println("Nao existem chamados para atender.");
        }
    }
}