public class No implements INo {
    private String conteudo;
    private No prox;
    private No anterior;

    public No(String conteudo) {
        this.conteudo = conteudo;
        this.prox = null;
        this.anterior = null;
    }

    @Override
    public String getConteudo() {
        return conteudo;
    }

    @Override
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public No getProx() {
        return prox;
    }

    @Override
    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public No getAnterior() {
        return anterior;
    }

    @Override
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}
