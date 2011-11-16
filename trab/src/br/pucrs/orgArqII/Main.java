package br.pucrs.orgArqII;

import java.util.List;

import br.pucrs.orgArqII.ULA.Command;
import br.pucrs.orgArqII.Utils.SourceReader;

public class Main {
	public static void main(String[] args) {
		List<Command> commands = SourceReader.readFile("commands.txt");		
		System.out.println(commands);
	}
}
