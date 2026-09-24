public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO NEXUS HEROES (SIMULAÇÃO Java) ===\n");

        // 1. Instanciação e Herança
        Personagem heroi = new Guerreiro("Raí");
        System.out.println("Herói criado: " + heroi.getNome() + " | HP: " + heroi.getHp() + "/" + heroi.getHpMax() + " | Class: Guerreiro");

        // 2. Movimentação
        heroi.mover(1, 0);
        heroi.mover(0, 1);
        System.out.println("Posição atual: (" + heroi.getPosicaoX() + ", " + heroi.getPosicaoY() + ") | Passos: " + heroi.getPassos());

        // 3. Invariante e Restauração de Vida (Orbe de Vida)
        heroi.receberDano(30);
        System.out.println("Após receber 30 de dano | HP: " + heroi.getHp());

        heroi.setVida(heroi.getHp() + 50); // Tenta curar +50 HP (Teto é 120)
        System.out.println("Após usar Orbe de Vida | HP (Validado pela Invariante): " + heroi.getHp());

        // 4. Coleta de Item
        Item coin = new Item("HeroCoin", 100);
        heroi.coletarItem(coin);

        // 5. Tratamento de Exceção (Armadilha)
        try {
            heroi.pisarEmArmadilha();
        } catch (TrapDamageException e) {
            System.err.println("EXCEÇÃO CAPTURADA: " + e.getMessage());
        }

        // 6. Polimorfismo no Ataque
        heroi.atacar();
    }
}