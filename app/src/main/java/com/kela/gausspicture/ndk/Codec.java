package com.kela.gausspicture.ndk;

import android.graphics.Bitmap;

/**
 * Created by Administrato
 * r on 2017/11/7 0007.
 */

public class Codec {

    static {

        System.loadLibrary("codec");
    }


    //分别在x轴 和 y轴方向上进行高斯模糊
    public static Bitmap gaussBlurUseGauss(Bitmap bitmap, int radius) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        //生成一张新的图片
        Bitmap outBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

        //定义一个临时数组存储原始图片的像素 值
        int[] pix = new int[w * h];

        //将图片像素值写入数组
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);

        //进行模糊
        initCBlur1(pix, w, h, radius);

        //将数据写入到 图片
        outBitmap.setPixels(pix, 0, w, 0, 0, w, h);

        //返回结果
        return outBitmap;
    }

    //利用均值模糊 逼近 高斯模糊
    public static Bitmap gaussBlurUseAvg(Bitmap bitmap, int radius) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        //生成一张新的图片
        Bitmap outBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

        //定义一个临时数组存储原始图片的像素 值
        int[] pix = new int[w * h];

        //将图片像素值写入数组
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);

        //进行模糊
        initCBlur2(pix, w, h, radius);

        //将数据写入到 图片
        outBitmap.setPixels(pix, 0, w, 0, 0, w, h);

        //返回结果
        return outBitmap;
    }

    //原始的高斯模糊 方法
    private static native void initCBlur1(int[] pix, int w, int h, int r);

    //利用均值模糊进行拟合 高斯模糊
    private static native void initCBlur2(int[] pix, int w, int h, int r);




}

