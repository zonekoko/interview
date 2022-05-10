package com.zyp.interview.demo.myself;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/4 16:47
 * @Description 将文本转换成二维码
 */
public class QrCodeDemo {
    public static void main(String[] args) throws WriterException, IOException {
        String path = "/Users/zhangyanping/Documents/wendang/MyQRCode.png";
        BitMatrix bitMatrix = new MultiFormatWriter().encode(new String("我爱我的洋宝宝".getBytes(), "iso-8859-1"),
                BarcodeFormat.QR_CODE, 300, 300);
        File file = new File(path);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                bufferedImage.setRGB(i, j, bitMatrix.get(i, j) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        if(!ImageIO.write(bufferedImage,"png",file)){
            throw new IOException("IO EXCEPTION");
        }
    }
}
