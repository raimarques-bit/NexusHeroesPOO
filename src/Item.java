public class Item {
    private final String nome;
    private final int valor;

    public Item(String nome, int valor) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do item não pode ser nulo ou vazio.");
        }
        this.nome = nome;
        this.valor = Math.max(0, valor);
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }
}