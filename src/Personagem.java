public abstract class Personagem {
    private String nome;
    protected int hp;
    protected int hpMax;
    protected int mana;
    protected int manaMax;
    protected int atk;
    protected int matk;
    private int nivel;
    private int xp;
    private int coins;
    private int passos;
    private int posicaoX;
    private int posicaoY;

    public Personagem(String nome, int hpMax, int manaMax, int atk, int matk) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do herói é obrigatório.");
        }
        this.nome = nome;
        this.hpMax = Math.max(1, hpMax);
        this.manaMax = Math.max(0, manaMax);

        // Garante que o herói inicia com estado 100% válido (Invariantes)
        this.hp = this.hpMax;
        this.mana = this.manaMax;

        this.atk = Math.max(0, atk);
        this.matk = Math.max(0, matk);
        this.nivel = 1;
        this.xp = 0;
        this.coins = 0;
        this.passos = 0;
        this.posicaoX = 0;
        this.posicaoY = 0;
    }

    // Método Abstrato - Polimorfismo
    public abstract int calcularDano();

    public void mover(int dx, int dy) {
        this.posicaoX += dx;
        this.posicaoY += dy;
        this.passos++;
    }

    public void atacar() {
        System.out.println(nome + " ataca causando " + calcularDano() + " de dano!");
    }

    public void receberDano(int dano) {
        if (dano > 0) {
            setVida(this.hp - dano);
        }
    }

    // Mutador com Validação de Invariante: 0 <= hp <= hpMax
    public void setVida(int valor) {
        if (valor < 0) {
            this.hp = 0;
        } else if (valor > this.hpMax) {
            this.hp = this.hpMax;
        } else {
            this.hp = valor;
        }
    }

    // Mutador com Validação de Invariante: 0 <= mana <= manaMax
    public void setMana(int valor) {
        if (valor < 0) {
            this.mana = 0;
        } else if (valor > this.manaMax) {
            this.mana = this.manaMax;
        } else {
            this.mana = valor;
        }
    }

    public void pisarEmArmadilha() throws TrapDamageException {
        receberDano(20);
        throw new TrapDamageException("Armadilha ativada! " + nome + " recebeu 20 de dano.");
    }

    public void coletarItem(Item item) {
        if (item != null) {
            this.coins += item.getValor();
            System.out.println(nome + " coletou " + item.getNome() + " (+" + item.getValor() + " coins)");
        }
    }

    // Getters (Acessores)
    public String getNome() { return nome; }
    public int getHp() { return hp; }
    public int getHpMax() { return hpMax; }
    public int getMana() { return mana; }
    public int getManaMax() { return manaMax; }
    public int getNivel() { return nivel; }
    public int getXp() { return xp; }
    public int getCoins() { return coins; }
    public int getPassos() { return passos; }
    public int getPosicaoX() { return posicaoX; }
    public int getPosicaoY() { return posicaoY; }
}