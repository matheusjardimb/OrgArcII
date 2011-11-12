package br.pucrs.orgArqII.Utils;

import java.util.List;
import java.io.*;

public class Utils {
	/*
	public static List<String> readFile(String filePath) {
		return null;
	}
	*/
	public List<String> readFile(String filePath) {
		StringBuilder contents = new StringBuilder();

		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			try {
				String line = null;
				while ((line = in.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			} finally {
				in.close();
			}
		} catch (IOException ex) {
		}

		return contents.toString();
	}
}
