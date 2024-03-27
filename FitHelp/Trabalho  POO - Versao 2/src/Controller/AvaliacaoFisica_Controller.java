package Controller;

import Model.Alimento;
import Model.AvaliacaoFisica;
import Model.AvaliacaoFisica_DAO;
import Model.IdNext;
import Model.Pessoa;
import java.util.Scanner;
import Model.Pessoa;
import Model.Pessoa_DAO;
import View.GUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class AvaliacaoFisica_Controller {

    private final AvaliacaoFisica_DAO avaliacaoFisicaDAO;
    private final Pessoa_Controller pessoaController;
    AvaliacaoFisica[] avaliacoes;

    public AvaliacaoFisica_Controller(Pessoa_Controller pessoaController) {
        this.avaliacaoFisicaDAO = new AvaliacaoFisica_DAO();
        this.avaliacoes = null;
        this.pessoaController = pessoaController;

    }


    public AvaliacaoFisica criarAvaliacaoFisica(AvaliacaoFisica avaliacao) {
       
        avaliacaoFisicaDAO.adicionarAvaliacaoFisica(avaliacao);
        return avaliacao;
    }
     public boolean deletarAvaliacaoFisicaporId(int id) {

        boolean foiDeletado = avaliacaoFisicaDAO.deletarAvalicaoFisicaPorId(id);
        if (foiDeletado) {
            return true;
        }

        return false;

    }

    public double calcularIMC(double peso, double altura) {
        double imc = peso / (altura * altura);

        return imc;
    }

    public double calcularTMB(String sexo, double altura, int idade, double fatorAtividade, double peso) {

        double tmb = 0;

        if (sexo.equalsIgnoreCase("masculino")) {
            tmb = (66 + (13.7 * peso) + (5 * altura * 100) - (6.8 * idade)) * fatorAtividade;
        } else if (sexo.equalsIgnoreCase("feminino")) {
            tmb = (655 + (9.6 * peso) + (1.8 * altura * 100) - (4.7 * idade)) * fatorAtividade;
        } else {

        }

        return tmb;

    }

    public double calcularBF(String sexo, double altura, double cintura, double pescoco, double peso, double quadril) {

        double bf;

        if (sexo.equalsIgnoreCase("masculino")) {
            bf = 86.010 * Math.log10(cintura - pescoco) - 70.041 * Math.log10(altura * 100) + 36.76;
        } else if (sexo.equalsIgnoreCase("feminino")) {
            bf = 163.205 * Math.log10(cintura + quadril - pescoco) - 97.684 * Math.log10(altura * 100) - 78.387;
        } else {

            return -1;
        }

        return bf;
    }

    public double calcularMassaGordaKg(double peso, double bf) {

        double massaGorda = (bf / 100) * peso;
        return massaGorda;
    }

    public double calcularMassaMagraKg(double peso, double bf) {
        double massaGorda = calcularMassaGordaKg(peso, bf);
        double massaMagra = peso - massaGorda;

        return massaMagra;
    }

    public double obterTMBDaUltimaAvaliacao(AvaliacaoFisica avaliacoes) {

        double tmbDaUltimaAvaliacao = avaliacoes.getTmb();

        return tmbDaUltimaAvaliacao;

    }

    public double obterPesoUltimaAvaliacao(AvaliacaoFisica avaliacoes) {

        double pesoDaUltimaAvaliacao = avaliacoes.getPeso();

        return pesoDaUltimaAvaliacao;

    }

    public AvaliacaoFisica listarAvaliacaoPorId(int id) {

        return avaliacaoFisicaDAO.listarAvaliacaoFisicaPorId(id);

    }
    
    
    
       public AvaliacaoFisica[] listarAvaliacoes() {

        return avaliacaoFisicaDAO.listarAvaliacoesFisicas();

    }
    

    public String gerarRelatorio(AvaliacaoFisica avaliacao) {
       
        Pessoa pessoa = this.pessoaController.EncontrarPessoa(avaliacao.getId());
        
       
       
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório da Avaliação Física:\n");
        relatorio.append("------------------------------\n");
        relatorio.append("ID da Avaliação: ").append(avaliacao.getId()).append("\n");
        relatorio.append("ID da Pessoa: ").append(pessoa.getNome()).append("\n");

        relatorio.append("Percentual de Gordura Corporal (% BF): ").append(String.format("%.2f", avaliacao.getBf())).append("%\n");

        String interpretacao = interpretarPercentualGordura(avaliacao.getBf(), pessoa.getSexo(), avaliacao.getIdade());
        relatorio.append("Interpretação: ").append(interpretacao).append("\n");

        double mg = calcularMassaGordaKg(avaliacao.getPeso(), avaliacao.getBf());
        relatorio.append("Massa Gorda: ").append(String.format("%.2f", mg)).append("Kg\n");

        double mm = calcularMassaMagraKg(avaliacao.getPeso(), avaliacao.getBf());
        relatorio.append("Massa magra: ").append(String.format("%.2f", mm)).append("Kg\n");

        relatorio.append("IMC: ").append(String.format(" %.2f", avaliacao.getImc())).append("Kg/m2\n");

        relatorio.append("tmb: ").append(String.format(" %.2f", avaliacao.getTmb())).append("Calorias\n");

        return relatorio.toString();

    }

    private String interpretarPercentualGordura(double bf, String sexo, int idade) {
        String interpretacao = "";

        if (sexo.equalsIgnoreCase("Masculino")) {
            if (idade >= 20 && idade <= 29) {
                if (bf < 11) {
                    interpretacao = "Atleta";
                } else if (bf >= 11 && bf < 13) {
                    interpretacao = "Bom";
                } else if (bf >= 13 && bf < 20) {
                    interpretacao = "Normal";
                } else if (bf >= 20 && bf <= 23) {
                    interpretacao = "Elevado";
                } else {
                    interpretacao = "Muito elevado";
                }
            } else if (idade >= 30 && idade <= 39) {
                if (bf < 12) {
                    interpretacao = "Atleta";
                } else if (bf >= 12 && bf < 14) {
                    interpretacao = "Bom";
                } else if (bf >= 14 && bf < 21) {
                    interpretacao = "Normal";
                } else if (bf >= 21 && bf <= 24) {
                    interpretacao = "Elevado";
                } else {
                    interpretacao = "Muito elevado";
                }
            } else if (idade >= 40 && idade <= 49) {
                if (bf < 14) {
                    interpretacao = "Atleta";
                } else if (bf >= 14 && bf < 16) {
                    interpretacao = "Bom";
                } else if (bf >= 16 && bf < 23) {
                    interpretacao = "Normal";
                } else if (bf >= 23 && bf <= 26) {
                    interpretacao = "Elevado";
                } else {
                    interpretacao = "Muito elevado";
                }
            } else if (idade >= 50 && idade <= 59) {
                if (bf < 15) {
                    interpretacao = "Atleta";
                } else if (bf >= 15 && bf < 17) {
                    interpretacao = "Bom";
                } else if (bf >= 17 && bf < 24) {
                    interpretacao = "Normal";
                } else if (bf >= 24 && bf <= 27) {
                    interpretacao = "Elevado";
                } else {
                    interpretacao = "Muito elevado";
                }
            }
        } else if (sexo.equalsIgnoreCase("Feminino")) {
            if (idade >= 20 && idade <= 29) {
                if (bf < 16) {
                    interpretacao = "Atleta";
                } else if (bf >= 16 && bf < 19) {
                    interpretacao = "Bom";
                } else if (bf >= 19 && bf < 28) {
                    interpretacao = "Normal";
                } else if (bf >= 28 && bf <= 31) {
                    interpretacao = "Elevado";
                } else {
                    interpretacao = "Muito elevado";
                }
            } else if (idade >= 30 && idade <= 39) {
                if (bf < 17) {
                    interpretacao = "Atleta";
                } else if (bf >= 17 && bf < 20) {
                    interpretacao = "Bom";
                } else if (bf >= 20 && bf < 29) {
                    interpretacao = "Normal";
                } else if (bf >= 29 && bf <= 32) {
                    interpretacao = "Elevado";
                } else {
                    interpretacao = "Muito elevado";
                }
            } else if (idade >= 40 && idade <= 49) {
                if (bf < 18) {
                    interpretacao = "Atleta";
                } else if (bf >= 18 && bf < 21) {
                    interpretacao = "Bom";
                } else if (bf >= 21 && bf < 30) {
                    interpretacao = "Normal";
                } else if (bf >= 30 && bf <= 33) {
                    interpretacao = "Elevado";
                } else {
                    interpretacao = "Muito elevado";
                }
            } else if (idade >= 50 && idade <= 59) {
                if (bf < 19) {
                    interpretacao = "Atleta";
                } else if (bf >= 19 && bf < 22) {
                    interpretacao = "Bom";
                } else if (bf >= 22 && bf < 31) {
                    interpretacao = "Normal";
                } else if (bf >= 31 && bf <= 34) {
                    interpretacao = "Elevado";
                } else {
                    interpretacao = "Muito elevado";
                }
            }
        }

        return interpretacao;
    }

}
