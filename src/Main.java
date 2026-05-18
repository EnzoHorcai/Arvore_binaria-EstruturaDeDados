public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(8);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(18);
        arvoreBinaria.inserir(13);
        arvoreBinaria.inserir(20);
        arvoreBinaria.exibir("Em");
        arvoreBinaria.removerFolhas(20);
        arvoreBinaria.exibir("Em");
    }
}