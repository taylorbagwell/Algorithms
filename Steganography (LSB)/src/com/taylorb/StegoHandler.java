package com.taylorb;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class StegoHandler {
	public StegoHandler() {
	}

	public void encode(String payloadPath, String imagePath) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(payloadPath));
			String line;
			String input = "";
			BufferedImage bi = ImageIO.read(new File(imagePath));

			while ((line = bf.readLine()) != null) {
				input += line;
			}

			bf.close();

			input = input.length() + input;
			byte[] payload = input.getBytes();

			int i = 0;
			int j = 0;

			for (byte b : payload) {
				for (int k = 7; k >= 0; k -= 3) {
					Color color = new Color(bi.getRGB(j, i));

					int red = color.getRed();
					int green = color.getGreen();
					int blue = color.getBlue();

					int bitR = (b >> k) & 1;
					int bitG = (b >> (k - 1)) & 1;
					int bitB = (b >> (k - 2)) & 1;

					if (k == 1) {
						red = (byte) ((red & 0xFE) | bitR);
						green = (byte) ((green & 0xFE) | bitG);
					}

					else {
						red = (byte) ((red & 0xFE) | bitR);
						green = (byte) ((green & 0xFE) | bitG);
						blue = (byte) ((blue & 0xFE) | bitB);
					}

					Color newColor = new Color((red & 0xFF), (green & 0xFF), (blue & 0xFF));
					bi.setRGB(j, i, newColor.getRGB());

					j++;
				}

				i++;
			}

			File file = new File("encoded.png");
			file.createNewFile();
			ImageIO.write(bi, "png", file);
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void decode(String imagePath) {
		try {
			BufferedImage encodedImg = ImageIO.read(new File(imagePath));

			byte[] payloadBytes = GetByteArray(encodedImg, 0, 0, 2);
			int payloadSize = Integer.parseInt(new String(payloadBytes));
			byte[] hiddenBytes = GetByteArray(encodedImg, 2, 6, payloadSize);

			System.out.println(new String(hiddenBytes));
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private byte[] GetByteArray(BufferedImage bi, int i, int j, int arrSize) {
		byte[] bytes = new byte[arrSize];

		for (int a = 0; a < arrSize; a++) {
			for (int b = 0; b < 8; b += 3) {
				Color c = new Color(bi.getRGB(j, i));
				byte red = (byte) c.getRed();
				byte green = (byte) c.getGreen();
				byte blue = (byte) c.getBlue();

				bytes[a] = (byte) ((bytes[a] << 1) | (red & 1));
				bytes[a] = (byte) ((bytes[a] << 1) | (green & 1));

				if (b != 6) {
					bytes[a] = (byte) ((bytes[a] << 1) | (blue & 1));
				}

				j++;
			}

			i++;
		}

		return bytes;
	}
}