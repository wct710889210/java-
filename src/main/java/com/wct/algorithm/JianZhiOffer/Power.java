package com.wct.algorithm.JianZhiOffer;

/**
 * 数值的整数次方
 */
public class Power {
    public double Power(double base, int exponent) throws Exception{
        //负面情况
        Double zero = new Double(0);
        if(zero.equals(base) && exponent<0)
            throw new Exception("无法计算");
        //边界情况
        if(zero.equals(base))
            return 0;
        if(exponent == 0)
            return 1;

        boolean isNegative = false;
        if(exponent < 0){
            exponent = -exponent;
            isNegative = true;
        }
        double result = upPower(base, exponent);
        if (isNegative){
            result = 1/result;
        }
        return result;
    }

    public double upPower(double base, int exponent){
        if (exponent == 1)
            return base;
        double result = upPower(base*base,exponent>>1);
        if((exponent&1) != 0){
            result = result*base;
        }
        return result;
    }

}
