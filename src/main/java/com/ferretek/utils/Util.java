package com.ferretek.utils;

import com.ferretek.dto.Producto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Util {
    public static Map<Integer, Integer> mapPedido;
    public static Map<Integer, Integer> mapStocks;

    public static Iterable<Producto> productos;

    public static double redondearDecimales(double valorInicial, int numeroDecimales) {

        BigDecimal numeroTemp = BigDecimal.valueOf(valorInicial).setScale(numeroDecimales, RoundingMode.HALF_UP);
        return numeroTemp.doubleValue();

    }


}
