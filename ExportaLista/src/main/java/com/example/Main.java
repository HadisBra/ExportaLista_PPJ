package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> listProdutos = List.of(
                new Produto("1", "SmartTv", "LG"),
                new Produto("2", "TV Best", "Samsung"),
                new Produto("3", "TV Big", "Apple")
        );
        var exportador = ExportadorLista.newInstance(listProdutos, "html");
        exportador.addColuna(exportador.newColuna(Produto::getId, "Identifier"));
        exportador.addColuna(exportador.newColuna(Produto::getNome, "Nome"));
        exportador.addColuna(exportador.newColuna(Produto::getMarca, "Marca"));

        String resultado = exportador.exportar();
        System.out.println(resultado);
    }
}
