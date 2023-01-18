package LiuJin;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

class   LJ{
    private BufferedImage bi;//属性

    //构造方法与获得属性的方法
    public BufferedImage getBi() {
        return bi;
    }

    public void setBi(BufferedImage bi) {
        this.bi = bi;
    }

    public LJ(BufferedImage bi) {
        super();
        this.bi = bi;
    }
    public LJ() {
    }
    //判断方法
    public int panduan (int r) {
        if(r>255) {
            r = 255;
        }
        if(r<0) {
            r = 0;
        }
        return r;
    }
    //灰度滤镜算法实现
    public BufferedImage fanxiang(BufferedImage bi){
        int w = bi.getWidth();
        int h = bi.getHeight();
        BufferedImage nbi = new BufferedImage(w,h,BufferedImage.TYPE_3BYTE_BGR);
        for(int i = 0 ; i < w ; i ++){
            for(int j = 0 ; j < h ; j ++){
                Color c = new Color(bi.getRGB(i,j));
                int r = 255-c.getRed();
                int g = 255-c.getGreen();
                int b = 255-c.getBlue();
                r = panduan(r);
                g = panduan(g);
                b = panduan(b);
                Color nc = new Color(r,g,b);
                int rgb = nc.getRGB();
                nbi.setRGB(i,j,rgb);
            }
        }
        return nbi;
    }
    public BufferedImage huidu(BufferedImage bi) {
        int w = bi.getWidth();
        int h = bi.getHeight();
        BufferedImage nbi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        for(int x=0;x<w;x++) {
            for(int y=0;y<h;y++) {
                int pix = bi.getRGB(x, y);
                Color c= new Color(pix);
                int r = (int) (0.3*c.getRed()+0.59*c.getGreen()+0.11*c.getBlue());
                int g = (int) (0.3*c.getRed()+0.59*c.getGreen()+0.11*c.getBlue());
                int b = (int) (0.3*c.getRed()+0.59*c.getGreen()+0.11*c.getBlue());
                Color nc = new Color(r, g, b);
                int rgb = nc.getRGB();
                nbi.setRGB(x, y, rgb);
            }
        }
        return nbi;
    }
    //怀旧算法实现
    public BufferedImage huaijiu(BufferedImage bi) {
        int w = bi.getWidth();
        int h = bi.getHeight();
        BufferedImage nbi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        for(int x=0;x<w;x++) {
            for(int y=0;y<h;y++) {
                int pix = bi.getRGB(x, y);
                Color c= new Color(pix);
                int r = (int) (0.393*c.getRed()+0.769*c.getGreen()+0.189*c.getBlue());
                int g = (int) (0.349*c.getRed()+0.686*c.getGreen()+0.168*c.getBlue());
                int b = (int) (0.272*c.getRed()+0.534*c.getGreen()+0.131*c.getBlue());
                r = panduan(r);
                g = panduan(g);
                b = panduan(b);
                Color nc = new Color(r, g, b);
                int rgb = nc.getRGB();
                nbi.setRGB(x, y, rgb);
            }
        }
        return nbi;
    }
    //熔铸算法实现
    public BufferedImage rongzhu(BufferedImage bi) {
        int w = bi.getWidth();
        int h = bi.getHeight();
        BufferedImage nbi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        for(int x=0;x<w;x++) {
            for(int y=0;y<h;y++) {
                int pix = bi.getRGB(x, y);
                Color c= new Color(pix);
                int r = (int) (c.getRed()*128/(c.getGreen()+c.getBlue()+1));
                int g = (int) (c.getGreen()*128/(c.getBlue()+c.getRed()+1));
                int b = (int) (c.getBlue()*128/(c.getGreen()+c.getRed()+1));
                r = panduan(r);
                g = panduan(g);
                b = panduan(b);
                Color nc = new Color(r, g, b);
                int rgb = nc.getRGB();
                nbi.setRGB(x, y, rgb);
            }
        }
        return nbi;
    }
    //冰冻算法实现
    public BufferedImage bingdong(BufferedImage bi) {
        int w = bi.getWidth();
        int h = bi.getHeight();
        BufferedImage nbi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        for(int x=0;x<w;x++) {
            for(int y=0;y<h;y++) {
                int pix = bi.getRGB(x, y);
                Color c= new Color(pix);
                int r = (int) ((c.getRed()-c.getGreen()-c.getBlue())*3/2);
                int g = (int) ((c.getGreen()-c.getBlue()-c.getRed())*3/2);
                int b = (int) ((c.getBlue()-c.getGreen()-c.getRed())*3/2);
                r = panduan(r);
                g = panduan(g);
                b = panduan(b);
                Color nc = new Color(r, g, b);
                int rgb = nc.getRGB();
                nbi.setRGB(x, y, rgb);
            }
        }
        return nbi;
    }
    //连环画算法实现
    public BufferedImage lianhuanhua(BufferedImage bi) {
        int w = bi.getWidth();
        int h = bi.getHeight();
        BufferedImage nbi = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        for(int x=0;x<w;x++) {
            for(int y=0;y<h;y++) {
                int pix = bi.getRGB(x, y);
                Color c= new Color(pix);
                int r = (int)(Math.abs(c.getGreen()-c.getBlue()+c.getGreen()+c.getRed())*c.getRed()/256);
                int g = (int)(Math.abs(c.getBlue()-c.getGreen()+c.getBlue()+c.getRed())*c.getRed()/256);
                int b = (int)(Math.abs(c.getBlue()-c.getGreen()+c.getBlue()+c.getRed())*c.getGreen()/256);
                r = panduan(r);
                g = panduan(g);
                b = panduan(b);
                Color nc = new Color(r, g, b);
                int rgb = nc.getRGB();
                nbi.setRGB(x, y, rgb);
            }
        }
        return nbi;
    }
}
/**
 * 测试函数
 * */
public class Test_LJ {

    public static void main(String[] args) throws Exception {
// TODO Auto-generated method stub
        BufferedImage bi = ImageIO.read(new File("input/3.jpg"));//读取图像
        LJ x = new LJ(bi); //实例化LJ类
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch (a){
            case 1:
                BufferedImage nbi = x.huaijiu(bi);
                ImageIO.write(nbi, "jpg", new File("output/3b.jpg"));//输出图像
                break;
            case 2:
                BufferedImage nbi_2 = x.bingdong(bi);
                ImageIO.write(nbi_2, "jpg", new File("output/3b.jpg"));//输出图像
                break;
            case 3:
                BufferedImage nbi_3 = x.rongzhu(bi);
                ImageIO.write(nbi_3, "jpg", new File("output/3b.jpg"));//输出图像
                break;
            case 4:
                BufferedImage nbi_4 = x.lianhuanhua(bi);
                ImageIO.write(nbi_4, "jpg", new File("output/3b.jpg"));//输出图像
                break;
            case 5:
                BufferedImage nbi_5 = x.huidu(bi);
                ImageIO.write(nbi_5, "jpg", new File("output/3b.jpg"));//输出图像
                break;
            case 6:
                BufferedImage nbi_6 = x.fanxiang(bi);
                ImageIO.write(nbi_6,"jpg",new File("output/3b.jpg"));
        }
       //imageIO.write(nbi, "jpg", new File("output/3b.jpg"));//输出图像
    }

}

