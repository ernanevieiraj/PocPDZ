package com.zup.pdzrest.functions;


import com.zup.pdzrest.enums.Segmento;

public class Functions {

        public static Segmento defineSegmento(Double salario)
    {
        Segmento segmento = null;
        if (salario < 4499.99){
            segmento = Segmento.VAREJO;
        }else if (salario > 4499.99 && salario < 8999.99){
            segmento = Segmento.UNICLASS;
        }else if (salario > 8999.99){
            segmento =  Segmento.PERSONNALITE;
        }
        return segmento;
    }
}
