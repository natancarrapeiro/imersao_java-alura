import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class GeradoraDeFifurinhas {

   public void cria(InputStream inputStream,String nomeArquivo) throws Exception{
        //leitura da img
        //InputStream inputStream=new FileInputStream(new File("img/shawshank-redemption.jpg")); pega pelos aquivos
        //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_10.jpg").openStream(); pega pelos links
        BufferedImage imgOriginal = ImageIO.read(inputStream);

        //cria nova img com tranparencia
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        int novaAltura= altura +200;
        BufferedImage novaImg = new BufferedImage(largura, novaAltura,  BufferedImage.TRANSLUCENT);//img transparente
        
        //copiar a imagem original para a nova (em memória)
        Graphics2D graphics = (Graphics2D)novaImg.getGraphics();
        graphics.drawImage(imgOriginal,0, 0, null);

        //configura a fonte
        Font font = new Font(Font.SANS_SERIF,Font.BOLD,65);
        graphics.setColor(Color.yellow);
        graphics.setFont(font);
        //escrever uma frase na img
        graphics.drawString("topzeira ",largura/3, novaAltura - 100);
        //escrever a img num arquivo
        ImageIO.write(novaImg, "png",new File(nomeArquivo) );
    }
    /*
    para testes
     public static void main(String[] args) throws Exception {
        GeradoraDeFifurinhas geradora = new GeradoraDeFifurinhas();
        geradora.cria();
    }
     */
}
