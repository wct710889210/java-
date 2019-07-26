package com.wct.javaBasic;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        System.out.println(new BigDecimal(1333.6).setScale(0,BigDecimal.ROUND_HALF_UP).toPlainString());
    }
}
