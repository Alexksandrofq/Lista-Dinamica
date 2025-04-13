import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaDinamica lista = new ListaDinamica("Lista:");
        int opcao = 0;
        while (opcao != 19) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Inserir um elemento");
            System.out.println("2. Inserir uma sequência de elementos");
            System.out.println("3. Remover um elemento");
            System.out.println("4. Remover uma sequência de elementos");
            System.out.println("5. Remover todas as ocorrências");
            System.out.println("6. Verificar se a lista está vazia");
            System.out.println("7. Buscar um elemento");
            System.out.println("8. Ordenar a lista em ordem crescente");
            System.out.println("9. Ordenar a lista em ordem decrescente");
            System.out.println("10. Mostrar quantidade de elementos");
            System.out.println("11. Editar um elemento");
            System.out.println("12. Limpar a lista");
            System.out.println("13. Exibir todos os elementos");
            System.out.println("14. Obter primeiro elemento");
            System.out.println("15. Obter último elemento");
            System.out.println("16. Verificar se a lista está cheia");
            System.out.println("17. Verificar elemento");
            System.out.println("18. Verificar elementos");
            System.out.println("19. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    String conteudo1 = sc.nextLine();
                    lista.inserirElemento(conteudo1);
                    break;
                case 2:
                    System.out.print("Digite os elementos a serem inseridos (separados por espaço): ");
                    String[] conteudos = sc.nextLine().split(" ");
                    lista.inserirSequencia(conteudos);
                    break;
                case 3:
                    System.out.print("Digite o elemento a ser removido: ");
                    String conteudo2 = sc.nextLine();
                    lista.removerElemento(conteudo2);
                    break;
                case 4:
                    System.out.print("Digite os elementos a serem removidos (separados por espaço): ");
                    String[] conteudosRemover = sc.nextLine().split(" ");
                    lista.removerSequencia(conteudosRemover);
                    break;
                case 5:
                    System.out.print("Digite os elementos a serem removidos (separados por espaço): ");
                    String[] conteudosOcorrencias = sc.nextLine().split(" ");
                    lista.removerTodasOcorrencias(conteudosOcorrencias);
                    break;
                case 6:
                    System.out.println("A lista está vazia? " + lista.estaVazia());
                    break;
                case 7:
                    System.out.print("Digite o elemento a ser buscado: ");
                    String conteudoBusca = sc.nextLine();
                    lista.buscarElemento(conteudoBusca);
                    break;
                case 8:
                    lista.ordenarCrescente();
                    System.out.println("Lista foi ordenada em ordem crescente.");
                    break;
                case 9:
                    lista.ordenarDecrescente();
                    System.out.println("Lista foi ordenada em ordem decrescente.");
                    break;
                case 10:
                    lista.quantiadeElementos();
                    break;
                case 11:
                    System.out.print("Digite o elemento antigo: ");
                    String elementoAntigo = sc.nextLine();
                    System.out.print("Digite o elemento novo: ");
                    String elementoNovo = sc.nextLine();
                    lista.editarElemento(elementoAntigo, elementoNovo);
                    break;
                case 12:
                    lista.limpar();
                    System.out.println("A lista foi limpa com sucesso2.");
                    break;
                case 13:
                    lista.exibir();
                    break;
                case 14:
                    lista.obterPrimeiroElemento();
                    break;
                case 15:
                    lista.obterUltimoElemento();
                    break;
                case 16:
                    System.out.println("A lista está cheia? " + lista.estaCheia());
                    break;
                case 17:
                    System.out.print("Digite o elemento a ser verificado: ");
                    String conteudoVerificar = sc.nextLine();
                    lista.verificarElemento(conteudoVerificar);
                    break;

                case 18:
                    System.out.print("Digite os elementos a serem verificados (separados por espaço): ");
                    String[] conteudosVerificar = sc.nextLine().split(" ");
                    lista.verificarElementos(conteudosVerificar);
                    break;

                case 19:
                    System.out.println("Bye Bye");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        sc.close();
    }
}
