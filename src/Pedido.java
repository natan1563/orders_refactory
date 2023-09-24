import java.util.ArrayList;
import java.util.List;

class Pedido {
    private List<Item> itens = new ArrayList<>();
    public void adicionarItem(Item item) {
        itens.add(item);
    }
    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }
    public List<Item> getItens() {
        return itens;
    }
}