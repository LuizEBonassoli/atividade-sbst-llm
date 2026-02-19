public class CalculadoraCusto {
    public double calcularFrete(double peso, boolean expresso) {
        if (peso <= 0) throw new IllegalArgumentException("Peso invalido");
        double base = peso * 5.0;
        if (expresso) return base + 20.0;
        return (peso > 10) ? base * 0.9 : base;
    }
}
