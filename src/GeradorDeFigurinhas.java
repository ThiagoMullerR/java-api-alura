import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		// Leitura da imagem
//		InputStream inputStream = new FileInputStream("entrada/filme-maior.jpg");
//		InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// cria imagem em memoria com transparencia e tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
	
		// copiar a imagem original para a nova imagem (em memoria)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// configurar a afonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setFont(fonte);
		
		// escrever uma frase na imagem
		graphics.setColor(Color.YELLOW);
		graphics.drawString("TOPZERA", 100, novaAltura - 100);
		
		// escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));
	}
	
}
