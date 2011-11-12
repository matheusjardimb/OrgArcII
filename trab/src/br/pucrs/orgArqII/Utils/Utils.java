package br.pucrs.orgArqII.Utils;

import java.util.List;
import java.io.*;

import br.pucrs.orgArqII.ULA.Command;

public class Utils {
<<<<<<< HEAD
	/*
	public static List<String> readFile(String filePath) {
=======
	public static List<Command> readFile(String filePath) {
>>>>>>> b24df79f09e3bd3a076e1d0bf6cd2d0418453f3f
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
