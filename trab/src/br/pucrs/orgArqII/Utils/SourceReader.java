package br.pucrs.orgArqII.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import br.pucrs.orgArqII.ULA.Command;
import br.pucrs.orgArqII.ULA.Operation;

public class SourceReader {

	public static List<Command> readFile(String filePath) {
		List<Command> commands = new ArrayList<Command>();
		List<String> parameters = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			StringTokenizer st;
			try {
				String line = null;
				int lineNum = 0;
				while ((line = in.readLine()) != null) {
					st = new StringTokenizer(line);
					try{
						Operation op = Operation.valueOf(st.nextToken());
						while(st.hasMoreTokens()){
							parameters.add(st.nextToken());
						}
						List<String> clone = new ArrayList<String>();
						clone.addAll(parameters);
						commands.add(new Command(op, clone));
						parameters.clear();
					}
					catch(Exception e){
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
