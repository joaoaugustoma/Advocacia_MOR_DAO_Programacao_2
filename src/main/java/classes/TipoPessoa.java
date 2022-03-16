package classes;

public enum TipoPessoa {
    CLIENTE("Cliente"),
    PARTE_CONTRARIA("Parte Contrária");

    private final String label;

    TipoPessoa(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}