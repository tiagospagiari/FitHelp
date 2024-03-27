/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tiago
 */


public class TipoDieta {

    private int id;
    private String nome;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private Date dataCriacao;
    private Date dataModificacao;
    private String objetivo;
    private Refeicoes[] refeicoes;

    public void setRefeicoes( Refeicoes[] refeicoes) {
        this.refeicoes = refeicoes;
       
    }

    public Refeicoes[] getRefeicoes() {
        return refeicoes;
    }

      
    // Construtor
    public TipoDieta(int id, String nome, double carboidrato, double proteina, double gordura) {
        this.id = id;
        this.nome = nome;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.dataCriacao = new Date();
        this.dataModificacao = new Date();
        this.objetivo = "MANTER O PESO";
    }

    
    
    public void setEquilibrada() {
        this.carboidrato = 40;
        this.proteina = 30;
        this.gordura = 30;
        this.dataModificacao = new Date();
    }

    public void setLowCarb() {
        this.carboidrato = 30;
        this.proteina = 50;
        this.gordura = 20;
        this.dataModificacao = new Date();
    }

    public void setCetogenica() {
        this.carboidrato = 15;
        this.proteina = 15;
        this.gordura = 70;
        this.dataModificacao = new Date();
    }

    public void setAtleta(double peso) {
        double carboidrato = 100 - (proteina + gordura);//Verificar com Edurdo
        this.carboidrato = carboidrato;
        this.proteina = 2 * peso;
        this.gordura = 0.8 * peso;
        this.dataModificacao = new Date();
    }

    public void setObjetivoManterPeso() {
        this.objetivo = "MANTER O PESO";
        this.dataModificacao = new Date();
    }

    public void setObjetivoDiminuirPeso() {
        this.objetivo = "DIMINUIR O PESO";
        this.dataModificacao = new Date();
    }

    public void setObjetivoMelhorarComposicao() {
        this.objetivo = "MELHORAR COMPOSIÇÃO CORPORAL";
        this.dataModificacao = new Date();
    }

    public void setObjetivoAumentarPeso() {
        this.objetivo = "AUMENTAR O PESO";
        this.dataModificacao = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    // Calcular calorias da dieta com base na TMB
    public double calcularCaloriasDieta(double tmb) {
        double caloriasDieta = tmb; // Valor padrão (manter o peso)

        if (objetivo.equals("DIMINUIR O PESO")) {
            caloriasDieta -= 200; // Redução de 200 calorias
        } else if (objetivo.equals("AUMENTAR O PESO")) {
            caloriasDieta += 200; // Aumento de 200 calorias
        } else if (objetivo.equals("MELHORAR COMPOSIÇÃO CORPORAL")) {
            caloriasDieta -= 80; // Redução de 80 calorias
        }

        return caloriasDieta;
    }
     public static List<TipoDieta> listarTiposDeDieta() {
        // Aqui, você pode criar uma lista com tipos de dieta disponíveis
        List<TipoDieta> tiposDeDieta = new ArrayList<>();

        // Crie instâncias de TipoDieta e adicione à lista
        TipoDieta equilibrada = new TipoDieta(1, "Equilibrada", 40, 30, 30);
        TipoDieta lowCarb = new TipoDieta(2, "Low Carb", 30, 50, 20);
        TipoDieta cetogenica = new TipoDieta(3, "Cetogênica", 15, 15, 70);

        tiposDeDieta.add(equilibrada);
        tiposDeDieta.add(lowCarb);
        tiposDeDieta.add(cetogenica);

        // Retorne a lista de tipos de dieta
        return tiposDeDieta;
    }

    
       
//     public double calculadoraCaloriasDieta() {
//        double caloriasTotais = 0;
//        for (Refeicoes refeicao : refeicoes) {
//            caloriasTotais += refeicao.calcularCaloriasRefeicao();
//        }
//        return caloriasTotais;
//    }
//
//    // Método para calcular os carboidratos totais da dieta
//    public double calcularCarboidratosDieta() {
//        double carboidratosTotais = 0;
//        for (Refeicoes refeicao : refeicoes) {
//            carboidratosTotais += refeicao.calcularCarboidratosRefeicao();
//        }
//        return carboidratosTotais;
//    }
//
//    // Métodos semelhantes para calcular proteínas totais e gorduras totais

    @Override
    public String toString() {
        return "ID: " + id + "\n"
                + "Nome: " + nome + "\n"
                + "Carboidrato: " + carboidrato + "g\n"
                + "Proteína: " + proteina + "g\n"
                + "Gordura: " + gordura + "g\n"
                + "Data de Criação: " + dataCriacao + "\n"
                + "Data de Modificação: " + dataModificacao + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.carboidrato) ^ (Double.doubleToLongBits(this.carboidrato) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.proteina) ^ (Double.doubleToLongBits(this.proteina) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.gordura) ^ (Double.doubleToLongBits(this.gordura) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.dataCriacao);
        hash = 97 * hash + Objects.hashCode(this.dataModificacao);
        hash = 97 * hash + Objects.hashCode(this.objetivo);
        hash = 97 * hash + Arrays.deepHashCode(this.refeicoes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoDieta other = (TipoDieta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.carboidrato) != Double.doubleToLongBits(other.carboidrato)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proteina) != Double.doubleToLongBits(other.proteina)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gordura) != Double.doubleToLongBits(other.gordura)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.objetivo, other.objetivo)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.dataModificacao, other.dataModificacao)) {
            return false;
        }
        return Arrays.deepEquals(this.refeicoes, other.refeicoes);
    }
    
}
