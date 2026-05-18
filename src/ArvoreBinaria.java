public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);
        //inserirRecursivo(novoNo, this.raiz);
        inserirIterativo(novoNo);
    }
    private void inserirRecursivo(No no, No atual) {
        if(estaVazia()) {
            this.raiz = no;
            return;
        }
        if(no.getConteudo() > atual.getConteudo()) {
            if(atual.getDireita() == null) {
                atual.setDireita(no);
                return;
            } else {
                inserirRecursivo(no, atual.getDireita());
            }
        } else {
            if(atual.getEsquerda() == null) {
                atual.setEsquerda(no);
                return;
            } else {
                inserirRecursivo(no, atual.getEsquerda());
            }
        }
    }

    private void inserirIterativo(No no) {
        if(estaVazia()) {
            this.raiz = no;
            return;
        } else {
            No aux = this.raiz;
            while(aux != null) {
                if(no.getConteudo() > aux.getConteudo()) {
                    if(aux.getDireita() == null) {
                        aux.setDireita(no);
                        return;
                    } else {
                        aux = aux.getDireita();
                    }
                } else {
                    if(aux.getEsquerda() == null) {
                        aux.setEsquerda(no);
                        return;
                    } else {
                        aux = aux.getEsquerda();
                    }
                }
            }
        }

    }

    public void removerFolhas(Integer conteudo) {
        No atual = this.raiz;
        No noPai = null;

        if (estaVazia()) {
            return;
        } else {
            while (atual != null) {
                if (atual.getConteudo().equals(conteudo)) {
                    break;
                } else if (conteudo.compareTo(atual.getConteudo()) == -1) { // atual é menor que o elemento que estou procurando
                    noPai = atual;
                    atual = atual.getEsquerda();
                } else {
                    noPai = atual;
                    atual = atual.getDireita();
                }
            }
        }
        if (atual != null) {
            // elemento tem 2 filhos
            if (atual.getDireita() != null) {
                No aux = atual.getDireita();
                No auxPai = atual;
                while (aux.getEsquerda() != null) {
                    auxPai = aux;
                    aux = aux.getEsquerda();
                }
                if (noPai != null) {
                    if (conteudo.compareTo(atual.getConteudo()) == -1) {
                        noPai.setEsquerda(aux);
                    } else {
                        noPai.setDireita(aux);
                    }
                } else {
                    this.raiz = aux;
                }
                if (conteudo.compareTo(atual.getConteudo()) == -1) {
                    noPai.setEsquerda(aux);
                } else {
                    noPai.setDireita(aux);
                }
                if (conteudo.compareTo(atual.getConteudo()) == -1) {
                    auxPai.setEsquerda(null);
                } else {
                    auxPai.setDireita(null);
                }
            } else if (atual.getEsquerda() != null) { // tem filho so a esquerda
                No aux = atual.getEsquerda();
                No auxPai = atual;
                while (aux.getDireita() != null) {
                    auxPai = aux;
                    aux = aux.getDireita();
                }
                if (noPai != null) {
                    if (aux.getConteudo().compareTo(auxPai.getConteudo()) == -1) {
                        auxPai.setEsquerda(null);
                    } else {
                        auxPai.setDireita(null);
                    }
                } else {
                    this.raiz = aux;
                }
            } else { // nao tem filho
                if (noPai != null) {
                    if (atual.getConteudo().compareTo(noPai.getConteudo()) == -1) {
                        noPai.setEsquerda(null);
                    } else {
                        noPai.setDireita(null);
                    }
                } else {
                    this.raiz = null;
                }
            }
        }
    }

    public boolean estaVazia() {
        if(this.raiz.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void exibir(String percurso) {
        switch(percurso){
            case("Pre"):
                preOrdem(this.raiz);
                break;
            case("Em"):
                emOrdem(this.raiz);
                break;
            case("Pos"):
                posOrdem(this.raiz);
                break;
        }

    }

    private void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }
}