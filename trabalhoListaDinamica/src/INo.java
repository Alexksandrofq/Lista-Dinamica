public interface INo {
    No getProx();
    void setProx(No prox);
    Object getConteudo();
    void setConteudo(String conteudo);
    No getAnterior();
    void setAnterior(No anterior);
}