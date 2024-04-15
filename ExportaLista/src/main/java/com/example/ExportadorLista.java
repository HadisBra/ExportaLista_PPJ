package com.example;

import java.util.List;
import java.util.function.Function;

public interface ExportadorLista<T> {

    String abrirTabela();

    String fecharTabela();

    String abrirLinha();

    String fecharLinha();

    String abrirLinhaTitulos();

    String fecharLinhaTitulos();

    String exportar();

    Coluna<T> newColuna(Function<T, String> funcaoValorColuna, String titulo);

    void addColuna(Coluna<T> coluna);

    static <T> ExportadorLista <T> newInstance(List<T> lista, String extensao) {
        return switch (extensao.toLowerCase()) {
            case "html" -> new ExportadorListaHtml(lista);
            case "md" -> new ExportadorListaMarkdown(lista);
            default -> throw new IllegalArgumentException("Formato não suportado: " + extensao);
        };
    }
    static <T> ExportadorLista <T> newInstance(List<T> lista) {
        return newInstance(lista, "html");
    }
}

