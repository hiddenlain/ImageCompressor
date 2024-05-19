package ImageCompressor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImageCompressorApp extends JFrame {
	
	public ImageCompressorApp() {
		//main window config
		super("Awes0me Image Compressor!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		
		//create button and jpanel
		JPanel panel = new JPanel();
		JButton btnSelectImage = new JButton ("Select Image");
		
		//add action button
		btnSelectImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Select an Image to Compress");
				int result = fileChooser.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					File inputFile = fileChooser.getSelectedFile();
					JFileChooser saveFileChooser = new JFileChooser();
					saveFileChooser.setDialogTitle("Where do you want to save the image?");
					result = saveFileChooser.showSaveDialog(null);
					
					if (result == JFileChooser.APPROVE_OPTION) {
						File outputFile = saveFileChooser.getSelectedFile();
						compressImage(inputFile, outputFile);
						JOptionPane.showMessageDialog(null, "Image compressed and saved!");
					}
					
				}
				
			}


		});
		
		// add button to panel
		panel.add(btnSelectImage);
		
		// add panel to window
		add(panel);
		
		// visible window
		setVisible(true);
		
	}
	
	private void compressImage(File inputFile, File outputFile) {
		// TODO Auto-generated method stub
		try {
		BufferedImage image = ImageIO.read(inputFile);
		ImageIO.write(image, "jpg", outputFile);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		new ImageCompressorApp();

	}

}
