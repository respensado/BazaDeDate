package md.convertit.bazaDeClienti.util;

import java.io.File;

import javax.swing.JFileChooser;

public class ClientFileUtil {
	
	public static String showOpenFileDialog(){
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			return file.getAbsolutePath();
		}
		return null;
	}
	
		public static String showSavenFileDialo(){
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION){
				File file = fileChooser.getSelectedFile();
				return file.getAbsolutePath();
			}
			return null;
		}

}
