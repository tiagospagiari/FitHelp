/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.AlimentoRefeicao_Controller;
import Model.Alimento;

import Controller.Alimento_Controller;
import Controller.AvaliacaoFisica_Controller;
import Controller.Dieta_Controller;
import Controller.Mensagens_Controller;
import Controller.Pessoa_Controller;
import Controller.Post_Controller;
import Controller.Preferencias_Controller;
import Controller.Refeicoes_Controller;
import Controller.Seguir_Controller;
import Model.AlimentoRefeicao;
import Model.AvaliacaoFisica;
import Model.Dieta;
import Model.IdNext;
import Model.Mensagens;
import Model.Pessoa;
import Model.Post;
import Model.Preferencias;
import Model.Refeicoes;
import Model.Seguir;
import Model.TipoDieta;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Alunos
 */
public class GUI {

    Pessoa_Controller pessoaController = new Pessoa_Controller();

    Alimento_Controller alimentoController = new Alimento_Controller();

    AvaliacaoFisica_Controller avaliacaoController = new AvaliacaoFisica_Controller(pessoaController);

    Preferencias_Controller preferenciasController = new Preferencias_Controller();

    Dieta_Controller dietaController = new Dieta_Controller();

    Refeicoes_Controller refeicoesController = new Refeicoes_Controller();

    Mensagens_Controller mensagensController = new Mensagens_Controller();

    Post_Controller postController = new Post_Controller();

    AlimentoRefeicao_Controller alimentoRefeicaoController = new AlimentoRefeicao_Controller();

    Seguir_Controller seguirController = new Seguir_Controller();

    private Pessoa usuarioLogado = getUsuarioLogado();
    private AvaliacaoFisica avaliacao;
    private Dieta dieta;
    private TipoDieta tipoDieta;
    private AvaliacaoFisica avaliacaoEscolhida;
    private Dieta dietaSelecionada;
    private Preferencias preferencia;
    private double calorias1;
    private int idEscolhido;
    private String objetivo;
    private double caloriasRefeicao;

    public Pessoa getUsuarioLogado() {
    
        return usuarioLogado;
    }

    public void setUsuarioLogado(Pessoa usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void exibirSubMenu() {
        int opcao;

        Scanner scanner = new Scanner(System.in);
        mostrarRefeicaoCompleta(0);
        do {
            System.out.println("=== Submenu ===");
            System.out.println("1. Alimentos");
            System.out.println("2. Avaliação Física");
            System.out.println("3. Dietas");
            System.out.println("4. Mensagens");
            System.out.println("5. Posts");
            System.out.println("6. Sair do Submenu");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    exibirSubMenuAlimentos();
                    break;
                case 2:
                    exibirSubMenuAvaliacaoFisica();
                    break;
                case 3:
                    exibirSubMenuDietas();
                    break;

                case 4:
                    exibirSubMenuMensagens();
                    break;
                case 5:
                    exibirSubMenuPosts();
                    break;
                case 6:
                    System.out.println("Saindo do programa. Até mais!");
                    break;

                default:

                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 6);

    }

    public void exibirSubMenuAlimentos() {

        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=== Submenu Alimentos ===");
            System.out.println("1. Lista de Alimentos");
            System.out.println("2. Buscar Alimento");
            System.out.println("3. Adicionar Alimento");
            System.out.println("4. Excluir Alimento");
            System.out.println("5. Adicionar alimentos de sua preferência");
            System.out.println("6. Listar suas preferências");
            System.out.println("7. Excluir alimento da lista de preferências");
            System.out.println("8.Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:

                    ListarAlimentos();

                    break;
                case 2:

                    BuscarAlimentosNome();

                    break;
                case 3:

                    CriarAlimentos();

                    break;

                case 4:

                    deletarAlimento();

                    break;
                case 5:

                    Adicionarpreferencias();

                    break;

                case 6:

                    listarPreferencias();

                    break;

                case 7:

                    deletarAlimentoPreferencias();

                    break;

                case 8:
                    System.out.println("Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 8);
    }

    public void exibirSubMenuAvaliacaoFisica() {
        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=== Avaliação Física ===");
            System.out.println("1. Realizar Avaliação Física");
            System.out.println("2. Ver Histórico de Avaliações");
            System.out.println("3. Excluir uma avaliação Física");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    submenuAvalFisica();
                    break;
                case 2:
                    listarAvaliacoesUsuarioLogado();
                    break;
                case 3:
                    deletarAvaliacaoFisica();
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);
    }

    public void exibirSubMenuDietas() {
        if (listarAvaliacoesUsuarioLogado() == false) {

            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha o número da avaliação física desejada: ");
        int escolha = scanner.nextInt();

// Recupere a avaliação física escolhida pelo usuário
        avaliacaoEscolhida = avaliacaoController.listarAvaliacaoPorId(escolha);
        int idDieta = IdNext.getNextIdDieta();
        int idRefeicao = IdNext.getNextIdRefeicoes();
        int idAlimento = IdNext.getNextIdAlimento();
        int opcao;

        do {
            System.out.println("===Dietas===");
            System.out.println("1. Criar uma Dieta ");
            System.out.println("2. Adicionar Refeições a Dieta ");
            System.out.println("3. Mostrar Refeicao ");
            System.out.println("4. Mostrar Dietas ");
            System.out.println("5. Adicionar Alimentos a Refeição ");
            System.out.println("6. Mostrar Refeicao Completa ");
            System.out.println("7. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    todosTiposDieta();
                    objetivo();
                    System.out.print("Digite a quantidade de Refeições: ");
                    int qtdRefeicoes = scanner.nextInt();
                    Dieta novaDieta = new Dieta(idDieta, usuarioLogado.getId(), avaliacaoEscolhida.getId(), idEscolhido, objetivo, calorias1, qtdRefeicoes);
                    novaDieta = dietaController.criarDieta(novaDieta);
                    if (novaDieta != null) {
                        System.out.println("Dieta Cadastrado com sucesso");
                    } else {
                        System.out.println("Falha ao cadastrar alimento");
                    }

                    break;
                case 2:
                    selecionaDieta();
                    double calorias = calorias1 / 4;
                    System.out.print("Digite a quantidade de carboidratos da Refeicao baseado na Dieta escolhida: ");
                    double carboidratos = scanner.nextDouble();

                    System.out.print("Digite a quantidade de gorduras baseado na Dieta escolhida: ");
                    double gorduras = scanner.nextDouble();

                    System.out.print("Digite a quantidade de proteínas baseado na Dieta escolhida: ");
                    double proteinas = scanner.nextDouble();

                    System.out.print("Digite o nome da Refeicao: ");
                    scanner.nextLine();
                    String nomeDieta = scanner.nextLine();

                    Refeicoes novaRefeicao = new Refeicoes(idRefeicao, idDieta, carboidratos, proteinas, gorduras, calorias, nomeDieta);
                    novaRefeicao = refeicoesController.criarNovaRefeicao(novaRefeicao);
                    if (novaRefeicao != null) {
                        System.out.println("Refeicao Cadastrado com sucesso");

                    } else {
                        System.out.println("Falha ao cadastrar Refeicao");
                    }
                    break;
                case 3:
                    mostrarRefeicoes();
                    break;
                case 4:

                    break;
                case 5:
                    Scanner scan = new Scanner(System.in);
                    ListarAlimentos();
                    System.out.print("Digite o nome do alimento que deseja adicionar a refeição: ");
                    String nomeAlimento = scan.nextLine();

                    Alimento alimento = alimentoController.buscarAlimentoPorNome(nomeAlimento);
                    System.out.println(alimento);
                    calorias = alimento.getCalorias();
                    carboidratos = alimento.getCarboidratos();
                    proteinas = alimento.getProteinas();
                    gorduras = alimento.getGorduras();
                    
                    AlimentoRefeicao novoAlimentoRefeicao = new AlimentoRefeicao(idRefeicao, idAlimento, calorias, carboidratos, proteinas, gorduras, calorias, LocalDate.now());
                    novoAlimentoRefeicao = alimentoRefeicaoController.criarNovoAlimento(novoAlimentoRefeicao);
                    if (novoAlimentoRefeicao != null) {
                        System.out.println("Alimento Cadastrado na Refeicao com sucesso");
                    } else {
                        System.out.println("Falha ao cadastrar alimento na Refeição");
                    }
                    break;
                case 6:
                    mostrarRefeicaoCompleta(idRefeicao);
                    
                    break;
                case 7:
                    System.out.println("Voltando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 6);
    }

    public void criarDieta() {

    }

    public void exibirSubMenuMensagens() {
        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=== Mensagens ===");
            System.out.println("1. Seguir Usuario");
            System.out.println("1. Lista de Usuarios Seguidos");
            System.out.println("2. Deixar de Seguir Usuario");
            System.out.println("3. Enviar Mensagem");
            System.out.println("4. Ver Mensagens Enviadas");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    Seguir();
                    break;

                case 2:
                    listarSeguidoresUsuarioLogado();
                    break;
                case 3:
                    deixarSeguir();
                    break;
                case 4:
                    EnviarMensagem();
                    break;
                case 5:
                    listarMensagensUsuarioLogado();
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 6);
    }

    public void exibirSubMenuPosts() {
        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=== Post ===");
            System.out.println("1. Criar Post");
            System.out.println("2. Ver Feed");
            System.out.println("3. Deletar Post");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    CriarPost();
                    break;
                case 2:
                    ListarPosts();
                    break;
                case 3:
                    deletarPost();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 3);
    }

    public void submenuAvalFisica() {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Preencha as informações abaixa");
        System.out.print("Digite sua Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Digite sua altura: ");
        double altura = scanner.nextDouble();
        System.out.print("Digite a circunferência da cintura: ");
        double cintura = scanner.nextDouble();
        System.out.print("Digite a circunferência do pescoço: ");
        double pescoco = scanner.nextDouble();
        System.out.print("Digite a circunferência do quadril: ");
        double quadril = scanner.nextDouble();
        System.out.print("Digite o Peso: ");
        double peso = scanner.nextDouble();
        System.out.println("Escolha o fator de taxa de atividade:");
        System.out.println("1 - Sedentário (pouco ou nenhum exercício)");
        System.out.println("2 - Levemente ativo (exercício leve 1 a 3 dias por semana)");
        System.out.println("3 - Moderadamente ativo (exercício moderado 6 a 7 dias por semana)");
        System.out.println("4 - Muito ativo (exercício intenso todos os dias ou exercício duas vezes ao dia)");
        System.out.println("5 - Extra ativo (exercício muito difícil, treinamento ou trabalho físico)");
        double fatorAtividade = scanner.nextDouble();
        if (fatorAtividade == 1) {
            fatorAtividade = 1.2;
        } else if (fatorAtividade == 2) {
            fatorAtividade = 1.375;
        } else if (fatorAtividade == 3) {
            fatorAtividade = 1.55;
        } else if (fatorAtividade == 4) {
            fatorAtividade = 1.725;
        } else if (fatorAtividade == 5) {
            fatorAtividade = 1.9;
        }

        double bf = avaliacaoController.calcularBF(getUsuarioLogado().getSexo(), altura, cintura, pescoco, peso, quadril);
        double imc = avaliacaoController.calcularIMC(peso, altura);
        double tmb = avaliacaoController.calcularTMB(getUsuarioLogado().getSexo(), altura, idade, fatorAtividade, peso);
        double massaMagra = avaliacaoController.calcularMassaMagraKg(peso, bf);
        double massaGorda = avaliacaoController.calcularMassaGordaKg(peso, bf);
        LocalDate dataCriacao = LocalDate.now();

        do {
       
            AvaliacaoFisica avaliacao = new AvaliacaoFisica(IdNext.getNextIdAvaliacoes(), getUsuarioLogado().getId(), peso, altura, idade, pescoco, cintura, quadril, imc, tmb, bf, massaGorda, massaMagra, dataCriacao);
            System.out.println("=== Avaliação física===");
            System.out.println("1. Gerar Relatório de Avaliacão Física");
            System.out.println("2. Voltar ao anterior");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    String relatorio = avaliacaoController.gerarRelatorio(avaliacao);
                    System.out.println(relatorio);
                    avaliacaoController.criarAvaliacaoFisica(avaliacao);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 2);
    }
//

    public void objetivo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual o Objetivo da sua Dieta, diminuir o peso, aumentar o peso ou manter o peso?\n");
        objetivo = scan.nextLine();

        double tmb = avaliacaoController.obterTMBDaUltimaAvaliacao(avaliacaoEscolhida);
        double calorias = tmb;

        if (objetivo.equalsIgnoreCase("diminuir o peso")) {
            calorias1 = calorias - 300;
            System.out.println("Para diminuir o peso, consuma " + calorias1 + " calorias por dia na dieta.\n");
        } else if (objetivo.equalsIgnoreCase("aumentar o peso")) {
            calorias1 = calorias + 300;

            System.out.println("Para aumentar o peso, consuma " + calorias1 + " calorias por dia na dieta.\n");
        } else if (objetivo.equalsIgnoreCase("manter o peso")) {
            // Objetivo de manter o peso (sem alterações em calorias)
            calorias1 = calorias;
            System.out.println("Para manter o peso, consuma " + calorias1 + " calorias por dia na dieta.\n");
        }
    }

    public void CriarAlimentos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do alimento: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a quantidade de carboidratos: ");
        double carboidratos = scanner.nextDouble();

        System.out.print("Digite a quantidade de gorduras: ");
        double gorduras = scanner.nextDouble();

        System.out.print("Digite a quantidade de proteínas: ");
        double proteinas = scanner.nextDouble();

        String porcao = "100g";

        double calorias = (4 * proteinas + 4 * carboidratos + 9 * gorduras);

        String tipoUsuario = "Padrao";

        Alimento novoAlimento = new Alimento(IdNext.getNextIdAlimento(), nome, carboidratos, gorduras, proteinas, porcao, calorias);
        novoAlimento = alimentoController.criarNovoAlimento(novoAlimento);
        if (novoAlimento != null) {
            System.out.println("Alimento Cadastrado com sucesso");
        } else {
            System.out.println("Falha ao cadastrar alimento");
        }

    }

    public void todosTiposDieta() {
        System.out.println("Tipos de Dieta Disponíveis:");

        TipoDieta[] tiposDeDieta = new TipoDieta[4];

        tiposDeDieta[0] = new TipoDieta(1, "Equilibrada", 40, 30, 30);
        tiposDeDieta[1] = new TipoDieta(2, "Low Carb", 30, 50, 20);
        tiposDeDieta[2] = new TipoDieta(3, "Cetogênica", 15, 15, 70);
        tiposDeDieta[3] = new TipoDieta(4, "Atleta", 0, 0, 0);

        double peso = avaliacaoController.obterPesoUltimaAvaliacao(avaliacaoEscolhida);
        double proteina = 2 * peso;
        double gordura = 0.8 * peso;

        tiposDeDieta[3].setProteina(proteina);
        tiposDeDieta[3].setGordura(gordura);
        tiposDeDieta[3].setCarboidrato(100 - (proteina + gordura));

        for (TipoDieta tipoDieta : tiposDeDieta) {
            System.out.println("ID: " + tipoDieta.getId());
            System.out.println("Nome: " + tipoDieta.getNome());
            System.out.println("Carboidrato: " + tipoDieta.getCarboidrato() + "g");
            System.out.println("Proteína: " + tipoDieta.getProteina() + "g");
            System.out.println("Gordura: " + tipoDieta.getGordura() + "g");
            System.out.println("----------------------------");
        }
        System.out.println("Selecione o tipo de Dieta pelo Id:  ");
        Scanner s = new Scanner(System.in);
        idEscolhido = s.nextInt();

        // Validar o ID inserido pelo usuário
        TipoDieta dietaEscolhida = null;
        for (TipoDieta tipoDieta : tiposDeDieta) {
            if (tipoDieta.getId() == idEscolhido) {
                dietaEscolhida = tipoDieta;
                break;
            }
        }
        if (dietaEscolhida != null) {
            System.out.println("Dieta escolhida: " + dietaEscolhida.getNome());
            TipoDieta tipoD = dietaEscolhida;
            // Faça o que for necessário com a dieta selecionada
        } else {
            System.out.println("ID de dieta inválido. Por favor, escolha um ID válido.");
        }
    }

    public void selecionaDieta() {
        Scanner scanner = new Scanner(System.in);
        if (listarDietaUsuarioLogado()
                == false) {

            return;
        }

        System.out.print(
                "Escolha o número da Dieta para adicionar a refeicao: ");
        int escolheDieta = scanner.nextInt();

        dietaSelecionada = dietaController.listarDietaPorId(escolheDieta);
//        
    }

    public void CriarPost() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("O que está pensando?: ");
        String conteudo = scanner.nextLine();

        int idPessoa = usuarioLogado.getId();

        Post novoPost = new Post(IdNext.getNextIdPost(), idPessoa, conteudo, null);
        novoPost = postController.criarNovopPost(novoPost);
        if (novoPost != null) {
            System.out.println("Post Cadastrado com sucesso");
        } else {
            System.out.println("Falha ao cadastrar Post");
        }

    }

    public void Seguir() {
        Scanner scanner = new Scanner(System.in);
        pessoaController.ListarPessoas();
        System.out.print("Selecione o id da pessoa que dejesa seguir: ");
        int idSeguir = scanner.nextInt();

        int idPessoa = usuarioLogado.getId();

        Seguir novoSeguidor = new Seguir(IdNext.getNextIdseguidores(), idPessoa, idSeguir, LocalDate.MIN);
        novoSeguidor = seguirController.criarNovoseguidor(novoSeguidor);
        if (novoSeguidor != null) {
            System.out.println("Pessoa seguida com sucesso");
        } else {
            System.out.println("Falha ao seguir Pessoa");
        }

    }

    public void EnviarMensagem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Conteudo da mensagem: ");
        String conteudo = scanner.nextLine();
        pessoaController.ListarPessoas();
        System.out.print("selecione a pessoa que deseja enviar a mensagem: ");
        int idDestino = scanner.nextInt();
        int idOrigem = usuarioLogado.getId();

        Mensagens novaMensagem = new Mensagens(IdNext.getNextIdMensagens(), idOrigem, idDestino, conteudo, null);
        novaMensagem = mensagensController.criarMensagem(novaMensagem);
        if (novaMensagem != null) {
            System.out.println("Mensagem enviada com sucesso");
        } else {
            System.out.println("Falha ao enviar Mensagem");
        }

    }

    public void deletarPost() {

        listarPostsUsuarioLogado();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o id do post que deseja deletar: ");
        int id = scanner.nextInt();
        boolean postDeletado = postController.deletarPostPorId(id);
        if (postDeletado) {
            System.out.println("Post deletado com sucesso");
        } else {
            System.out.println("Erro ao deletar post");
        }

    }

    public void deixarSeguir() {

        listarSeguidoresUsuarioLogado();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o id da pessoa que deseja deixar de seguir: ");
        int id = scanner.nextInt();
        boolean seguidorDeletado = seguirController.deletarSeguidorPorId(id);
        if (seguidorDeletado) {
            System.out.println("Deixado de seguir com sucesso");
        } else {
            System.out.println("Erro ao deixar de seguir");
        }

    }

    public void ListarPosts() {

        Post[] posts = postController.mostrarPost();
        for (Post post : posts) {
            System.out.println(post);

        }
    }

    public void mostrarRefeicoes() {

        Refeicoes[] refeicoes = refeicoesController.listarRefeicoes();
        for (Refeicoes refeicao : refeicoes) {
            System.out.println(refeicao);

        }
    }

    public void mostrarRefeicaoCompleta(int idRefeicao) {
        
        AlimentoRefeicao[] alimentoRefeicaoArray = alimentoRefeicaoController.mostrarRefeicaoCompleta(idRefeicao);
        if(alimentoRefeicaoArray == null){
            return;
        }
       
        
        for(AlimentoRefeicao alimentoRefeicao: alimentoRefeicaoArray){
            
            Alimento alimento = alimentoController.buscarAlimentoPorId(alimentoRefeicao.getIdAlimento());
            Refeicoes refeicoes = refeicoesController.buscarRefeicaoPorId(alimentoRefeicao.getIdRefeicao());
            System.out.println(alimento);
            
        }
    }
    

    public void Adicionarpreferencias() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Adicionar Preferencias ===");
            System.out.println("1. Adicionar Carboidratos");
            System.out.println("2. Adicionar proteinas");
            System.out.println("3. Adicionar gorduras");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    ListarAlimentos();
                    System.out.print("Selecione o id dos alimentos com Carboidratos como fonte principal: ");

                    int idCarb = scanner.nextInt();
                    Preferencias nomeCarbo = new Preferencias(IdNext.getNextIdpref(), usuarioLogado.getId(), idCarb, null);
                    preferenciasController.criarNovaPreferenciaCarbo(nomeCarbo);

                    break;
                case 2:
                    ListarAlimentos();
                    System.out.print("Selecione o id dos alimentos com Proteinas como fonte principal: ");
                    int idProt = scanner.nextInt();
                    Preferencias nomeProt = new Preferencias(IdNext.getNextIdpref(), usuarioLogado.getId(), idProt, null);
                    preferenciasController.criarNovaPreferenciaCarbo(nomeProt);
                    break;
                case 3:
                    ListarAlimentos();
                    System.out.print("Selecione o id dos alimentos com Gorduras como fonte principal: ");
                    int idGord = scanner.nextInt();
                    Preferencias nomeGord = new Preferencias(IdNext.getNextIdpref(), usuarioLogado.getId(), idGord, null);
                    preferenciasController.criarNovaPreferenciaCarbo(nomeGord);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 3);
    }

    public void listarPreferencias() {

        Preferencias[] preferencias = preferenciasController.listarPreferencias();
        if (preferencias == null) {
            System.out.println("Nenhum alimento Adicionado as preferencias");
        } else {
            for (Preferencias preferencia : preferencias) {
                System.out.println(preferencia);

            }
        }
    }

    public void ListarAlimentos() {

        Alimento[] alimentos = alimentoController.listarAlimentos();
        for (Alimento alimento : alimentos) {
            System.out.println(alimento);

        }
    }

    public boolean listarAvaliacoesUsuarioLogado() {

        AvaliacaoFisica[] avaliacoesFisicas = avaliacaoController.listarAvaliacoes();
        if (avaliacoesFisicas == null) {
            System.out.println("Avaliacão Física não encontrada, por favor realize uma avaliação.....");
            return false;
        }
        for (int i = 0; i < avaliacoesFisicas.length; i++) {

            if (usuarioLogado.getId() == avaliacoesFisicas[i].getIdPessoa()) {

                System.out.println("ID:  " + avaliacoesFisicas[i].getId() + "  Tmb calculada :" + avaliacoesFisicas[i].getTmb() + "Criada em :" + avaliacoesFisicas[i].getDataCriacao());

            }
        }
        return true;
    }

    public boolean listarDietaUsuarioLogado() {

        Dieta[] dietas = dietaController.listarDietas();
        if (dietas == null) {
            System.out.println("Dieta não encontrada, por favor realize uma.....");
            return false;
        }
        for (int i = 0; i < dietas.length; i++) {

            if (usuarioLogado.getId() == dietas[i].getIdPessoa()) {

                System.out.println("ID:  " + dietas[i].getId() + "  Tmb calculada :" + objetivo + "Criada em :" + LocalDate.now());

            }
        }
        return true;
    }

    public boolean listarPostsUsuarioLogado() {

        Post[] posts = postController.mostrarPost();
        if (posts == null) {
            System.out.println("Você ainda não tem posts...");
            return false;
        }
        for (int i = 0; i < posts.length; i++) {
            if (usuarioLogado.getId() == posts[i].getIdPessoa()) {
                System.out.println("ID: " + posts[i].getId() + "Criada em :" + LocalDate.now());
            }
        }
        return true;
    }

    public boolean listarSeguidoresUsuarioLogado() {

        Seguir[] seguidor = seguirController.mostrarSeguidores();
        if (seguidor == null) {
            System.out.println("Você ainda não segue ninguem...");
            return false;
        }
        for (int i = 0; i < seguidor.length; i++) {
            if (usuarioLogado.getId() == seguidor[i].getIdOrigem()) {
                System.out.println("ID:  " + seguidor[i].getId() + "  Seguido em :" + LocalDate.now());
            }
        }
        return true;
    }

    public boolean listarMensagensUsuarioLogado() {

        Mensagens[] mensagens = mensagensController.mostrarmensagens();
        if (mensagens == null) {
            System.out.println("Você ainda não tem mensagens...");
            return false;
        }
        for (int i = 0; i < mensagens.length; i++) {
            if (usuarioLogado.getId() == mensagens[i].getIdPessoaOrigem()) {
                System.out.println("ID: " + mensagens[i].getId() + "  Conteudo: " + mensagens[i].getMensagem() + "   Criada em :" + LocalDate.now());
            }
        }
        return true;
    }

    public void subMenuCriarCadastro() {

        System.out.println("Criando um novo cadastro...");
        Scanner scanner = new Scanner(System.in);
        // Solicitar informações do usuário
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        System.out.print("Data de Nascimento (DD/MM/AAAA): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Pessoa novaPessoa = new Pessoa(IdNext.getNextIdPessoa(), nome, genero, LocalDate.now(), login, senha);
        novaPessoa = pessoaController.criarCadastro(novaPessoa);

        if (novaPessoa != null) {

            System.out.println("Cadastro criado com sucesso. Faça o login para continuar.");
        } else {
            System.out.println("Erro ao criar cadastro. Tente novamente.");
        }
    }

    public void login() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Login: ");
        String login = scanner.next();
        System.out.print("Senha: ");
        String senha = scanner.next();

        // Verificar o login usando a função validaLogin
        Pessoa usuario = pessoaController.fazerLogin(login, senha);
        if (usuario != null) {
            System.out.println("Login bem-sucedido. Bem-vindo, " + usuario.getNome() + "!");
            setUsuarioLogado(usuario);

            exibirSubMenu();
        } else {
            System.out.println("Login falhou. Tente novamente ou crie um cadastro.");
        }
    }

    public void BuscarAlimentosNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do alimento que deseja buscar: ");
        String nomeAlimento = scanner.nextLine();
        Alimento alimentoEncontrado = alimentoController.buscarAlimentoPorNome(nomeAlimento);
        if (alimentoEncontrado != null) {
            System.out.println("Alimento encontrado: " + alimentoEncontrado);
        } else {
            System.out.println("Alimento não encontrado.");
        }
    }

    public void deletarAlimento() {

        ListarAlimentos();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o id do alimento que deseja deletar: ");
        int id = scanner.nextInt();
        boolean alimentoDeletado = alimentoController.deletarAlimentoporId(id);
        if (alimentoDeletado) {
            System.out.println("Alimento deletado com sucesso");
        } else {
            System.out.println("Erro ao deletar alimento");
        }

    }

    public void deletarAlimentoPreferencias() {

        listarPreferencias();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o id do alimento que deseja deletar: ");
        int id = scanner.nextInt();
        boolean alimentoDeletado = preferenciasController.deletarPreferenciaporId(id);
        if (alimentoDeletado) {
            System.out.println("Alimento deletado com sucesso");
        } else {
            System.out.println("Erro ao deletar alimento");
        }

    }

    public void deletarAvaliacaoFisica() {

        listarAvaliacoesUsuarioLogado();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o id da avaliação que deseja deletar: ");
        int id = scanner.nextInt();
        boolean avaliacaoDeletada = avaliacaoController.deletarAvaliacaoFisicaporId(id);
        if (avaliacaoDeletada) {
            System.out.println("Avaliação Físoca deletada com sucesso");
        } else {
            System.out.println("Erro ao deletar avaliação");
        }

    }

    public void MenuLogin() {
        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("=== FITHELP ===");
            System.out.println("1.  Fazer Login");
            System.out.println("2.  Cadastre-se");
            System.out.println("3.  Sair : ");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:

                    login();

                    break;

                case 2:

                    subMenuCriarCadastro();

                    break;

                case 3:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

            }
        } while (opcao != 3);

        scanner.close();

    }
}
