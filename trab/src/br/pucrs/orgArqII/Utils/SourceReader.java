package br.pucrs.orgArqII.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import br.pucrs.orgArqII.MIPS.AssemblyElement;
import br.pucrs.orgArqII.MIPS.Command;
import br.pucrs.orgArqII.MIPS.Label;
import br.pucrs.orgArqII.MIPS.Operations;

public class SourceReader {

	public static List<AssemblyElement> readFile(String filePath) {
		List<AssemblyElement> commands = new ArrayList<AssemblyElement>();
		List<String> parameters = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			StringTokenizer st;
			try {
				String line = null;
				int lineNum = 0;
				while ((line = in.readLine()) != null) {
					// Comments or blank line
					if (line.startsWith("#") || line.trim().isEmpty())
						continue;
					if (line.endsWith(":")) {
						commands.add(new Label(line.replace(":", "")));
						continue;
					}
					st = new StringTokenizer(line);
					try {
						Operations op = Operations.valueOf(st.nextToken().toUpperCase());
						while (st.hasMoreTokens()) {
							parameters.add(st.nextToken().replaceAll(",", "").trim().toUpperCase());
						}
						List<String> clone = new ArrayList<String>();
						clone.addAll(parameters);
						commands.add(new Command(op, clone));
						parameters.clear();
					} catch (Exception e) {
						System.out.println("Illegal operation in line " + lineNum);
					}
					lineNum++;
				}
			} finally {
				in.close();
			}
		} catch (IOException ex) {
		}

		return commands;
	}
}
