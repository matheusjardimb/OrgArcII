package br.pucrs.orgArqII.MIPS;

import java.util.List;

public class Command {
	private Operations op;
	private List<String> params;

	public Command(Operations op, List<String> params) {
		this.op = op;
		this.params = params;
	}

	public String calculate() {
		return null;
	}

	@Override
	public String toString() {
		String aux = "";
		for (String param : params) {
			aux += " " + param;
		}
		return op +" "+ aux;
	}

}
