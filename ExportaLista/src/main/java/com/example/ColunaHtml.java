package com.example;

import java.util.function.Function;

public class ColunaHtml<T> extends AbstractColuna<T> {


    public ColunaHtml(String titulo, Function<T, String> funcaoValorColuna) {
        super(titulo, funcaoValorColuna);
    }

    @Override
    public String abrir() {
        return "<td>";
    }

    @Override
    public String fechar() {
        return "</td>";
    }
}
