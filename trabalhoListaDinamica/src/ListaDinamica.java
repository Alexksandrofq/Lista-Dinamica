public class ListaDinamica {
    private No primeiroElemento;

    public ListaDinamica(String conteudo){
        this.primeiroElemento = new No(conteudo);
    }

    public void inserirElemento(String conteudo){
        No novo = new No(conteudo);
        if(estaVazia()) {
            this.primeiroElemento = novo;
        } else {
            No aux = this.primeiroElemento;
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novo);
            novo.setAnterior(aux);
        }
    }

    public void inserirSequencia(String... conteudos) {
        for (String nome : conteudos) {
            No novo = new No(nome);
            if (estaVazia()) {
                this.primeiroElemento = novo;
            } else {
                No aux = this.primeiroElemento;
                while (aux.getProx() != null) {
                    aux = aux.getProx();
                }
                aux.setProx(novo);
                novo.setAnterior(aux);
            }
        }
    }

    public boolean removerElemento(String conteudo){
        if(estaVazia()) {
            System.out.println("A lista está vazia");
        } else if (verificarElemento(conteudo)) {
            if(this.primeiroElemento.getConteudo().equals(conteudo)) {
                this.primeiroElemento = this.primeiroElemento.getProx();
                if (this.primeiroElemento != null) {
                    this.primeiroElemento.setAnterior(null);
                }
                return true;
            } else {
                No aux = this.primeiroElemento;
                while(!aux.getProx().getConteudo().equals(conteudo)) {
                    aux = aux.getProx();
                }
                No remover = aux.getProx();
                aux.setProx(remover.getProx());
                if (remover.getProx() != null) {
                    remover.getProx().setAnterior(aux);
                }
                return true;
            }
        } else {
            System.out.println("Não existe este elemento");
        }
        return false;
    }

    public void removerSequencia(String... conteudos) {
        if (estaVazia()) {
            System.out.println("A lista está vazia");
            return;
        }
        for (String nome : conteudos) {
            boolean removido = removerElemento(nome);
            if (!removido) {
                System.out.println("Não foi possível remover: " + nome);
            }
        }
    }

    public void removerTodasOcorrencias(String... conteudos) {
        if (estaVazia()) {
            System.out.println("A lista está vazia");
            return;
        }
        for (String nome : conteudos) {
            No atual = this.primeiroElemento;
            while (atual != null) {
                No proximo = atual.getProx();
                if (atual.getConteudo().equals(nome)) {
                    if (atual.getAnterior() != null) {
                        atual.getAnterior().setProx(proximo);
                    } else {
                        this.primeiroElemento = proximo;
                    }
                    if (proximo != null) {
                        proximo.setAnterior(atual.getAnterior());
                    }
                }
                atual = proximo;
            }
        }
    }

    public boolean estaVazia() {
        return this.primeiroElemento == null;
    }

    public boolean estaCheia() {
        System.out.println("Não é possível encher uma lista dinâmmica");
        return false;
    }

    public boolean buscarElemento(String conteudo) {
        if(estaVazia()) {
            System.out.println("A lista esta vazia");
        } else {
            No aux = this.primeiroElemento;
            while(aux != null) {
                if(aux.getConteudo().equals(conteudo)) {
                    String proximo = (aux.getProx() != null) ? aux.getProx().getConteudo() : "null (último elemento)";
                    System.out.println("O " + conteudo + " existe na lista e seu próximo nó é: " + proximo);
                    return true;
                }
                aux = aux.getProx();
            }
        }
        return false;
    }

    public void ordenarCrescente() {
        if (estaVazia()) {
            System.out.println("A lista está vazia");
        } else {
            No atual = this.primeiroElemento;
            while (atual != null) {
                No atual2 = this.primeiroElemento;
                while (atual2 != null && atual2.getProx() != null) {
                    No proximo = atual2.getProx();
                    if (atual2.getConteudo().compareTo(proximo.getConteudo()) > 0) {
                        String aux = atual2.getConteudo();
                        atual2.setConteudo(proximo.getConteudo());
                        proximo.setConteudo(aux);
                    }
                    atual2 = atual2.getProx();
                }
                atual = atual.getProx();
            }
        }
    }

    public void ordenarDecrescente() {
        if (estaVazia()) {
            System.out.println("Não existem elementos para serem ordenados.");
        } else {
            No atual = this.primeiroElemento;
            while (atual != null) {
                No atual2 = this.primeiroElemento;
                while (atual2 != null) {
                    No proximo = atual2.getProx();
                    String aux;
                    if (proximo != null && atual2.getConteudo().compareTo(proximo.getConteudo()) < 0) {
                        aux = atual2.getConteudo();
                        atual2.setConteudo(proximo.getConteudo());
                        proximo.setConteudo(aux);
                    }
                    atual2 = atual2.getProx();
                }
                atual = atual.getProx();
            }
        }
    }

    public int quantiadeElementos(){
        int contador = 0;
        No aux = this.primeiroElemento;
        if(estaVazia()) {
            System.out.println("Está vazia");
        }
        while(aux != null){
            contador++;
            aux = aux.getProx();
        }
        System.out.println("Existem " + contador + " elementos.");
        return contador;
    }

    public void editarElemento(String elementoAntigo, String elementoNovo){
        No aux = this.primeiroElemento;
        while(aux != null){
            if(aux.getConteudo().equals(elementoAntigo)){
                aux.setConteudo(elementoNovo);
            }
            aux = aux.getProx();
        }
    }

    public void limpar(){
        this.primeiroElemento = null;
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("A Lista está vazia");
        } else {
            No aux = this.primeiroElemento;
            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }

    public No obterPrimeiroElemento() {
        if (this.primeiroElemento != null) {
            System.out.println("Primeiro elemento: " + this.primeiroElemento.getConteudo());
        } else {
            System.out.println("A lista está vazia.");
        }
        return this.primeiroElemento;
    }

    public No obterUltimoElemento() {
        if (this.primeiroElemento == null) {
            System.out.println("A lista está vazia.");
            return null;
        } else {
            No atual = this.primeiroElemento;
            while (atual.getProx() != null) {
                atual = atual.getProx();
            }
            System.out.println("Último elemento: " + atual.getConteudo());
            return atual;
        }
    }

    public boolean verificarElementos(String... conteudos) {
        boolean todosEncontrados = true;
        for (String nome : conteudos) {
            boolean encontrado = false;
            No aux = this.primeiroElemento;
            while (aux != null) {
                if (aux.getConteudo().equals(nome)) {
                    System.out.println("O " + nome + " está na lista.");
                    encontrado = true;
                    break;
                }
                aux = aux.getProx();
            }
            if (!encontrado) {
                System.out.println("O " + nome + " NÃO está na lista.");
                todosEncontrados = false;
            }
        }
        return todosEncontrados;
    }

    public boolean verificarElemento(String conteudo){
        No aux = this.primeiroElemento;
        while(aux != null) {
            if(aux.getConteudo().equals(conteudo)) {
                System.out.println("O " + conteudo + " está na lista");
                return true;
            }
            aux = aux.getProx();
        }
        System.out.println("O " + conteudo + " NÃO está na lista");
        return false;
    }
}
