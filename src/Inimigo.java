public class Inimigo {
    private int hp;
    private int atk;
    private int posicaoX;
    private int posicaoY;

    public Inimigo(int hp, int atk, int x, int y) {
        this.hp = Math.max(1, hp);
        this.atk = Math.max(0, atk);
        this.posicaoX = x;
        this.posicaoY = y;
    }

    public int calcularDano() {
        return this.atk;
    }

    public void receberDano(int dano) {
        if (dano > 0) {
            this.hp = Math.max(0, this.hp - dano);
        }
    }

    public int getHp() { return hp; }
    public int getAtk() { return atk; }
    public int getPosicaoX() { return posicaoX; }
    public int getPosicaoY() { return posicaoY; }
}