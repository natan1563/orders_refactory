import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaDePedidos {
    private static List<Pedido> pedidos = new ArrayList<>();
    public static void main(String[] args) {
        iniciarAtendimento();
    }

    private static void iniciarAtendimento() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirOpcoes();

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    adicionarPedido();
                    break;
                case 2:
                    if (!verificaSeOPedidoEstaVazio()) {
                        vincularItemAoPedido();
                    }
                    break;
                case 3:
                    if (!verificaSeOPedidoEstaVazio()) {
                        obterValorTotal();
                    }
                    break;
                case 4:
                    if (!verificaSeOPedidoEstaVazio()) {
                        obterItensDoPedido();
                    }
                    break;
                case 5:
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static boolean verificaSeOPedidoEstaVazio() {
        if (pedidos.isEmpty()) {
            System.out.println("Crie um pedido primeiro.");
            return true;
        }

        return false;
    }
    private static void exibirOpcoes() {
        System.out.println("1. Criar Pedido");
        System.out.println("2. Adicionar Item ao Pedido");
        System.out.println("3. Calcular Total do Pedido");
        System.out.println("4. Listar Itens do Pedido");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarPedido() {
        Pedido novoPedido = new Pedido();
        pedidos.add(novoPedido);
        System.out.println("Pedido criado.");
    }

    private static void vincularItemAoPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do item: ");
        String nomeItem = scanner.nextLine();

        System.out.print("Digite o preço do item: ");
        double precoItem = scanner.nextDouble();

        Item item = new Item(nomeItem, precoItem);
        Pedido ultimoPedido = pedidos.get(pedidos.size() - 1);
        ultimoPedido.adicionarItem(item);

        System.out.println("Item adicionado ao pedido.");
    }
    
    private static void obterValorTotal() {
        Pedido pedidoAtual = pedidos.get(pedidos.size() - 1);
        double total = pedidoAtual.calcularTotal();
        System.out.println("Total do pedido: " + total);
    }

    private static void obterItensDoPedido() {
        Pedido pedidoParaListar = pedidos.get(pedidos.size() - 1);
        List<Item> itensDoPedido = pedidoParaListar.getItens();
        System.out.println("Itens do pedido:");

        for (Item i : itensDoPedido) {
            System.out.println(i.getNome() + ": " + i.getPreco());
        }
    }
}