public class Mago extends Personagem {

    public Mago(String nome) {
        // Atributos base do Mago no jogo: HP: 80, Mana: 120, ATK: 15, MATK: 40
        super(nome, 80, 120, 15, 40);
    }

    @Override
    public int calcularDano() {
        return this.matk; // Dano baseado em ataque mágico
    }
}