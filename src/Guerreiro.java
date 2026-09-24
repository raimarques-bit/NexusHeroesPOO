public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        // Atributos base do Guerreiro no jogo: HP: 120, Mana: 40, ATK: 25, MATK: 10
        super(nome, 120, 40, 25, 10);
    }

    @Override
    public int calcularDano() {
        return this.atk; // Dano baseado em ataque físico (espada)
    }
}