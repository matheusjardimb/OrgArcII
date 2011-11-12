package br.pucrs.orgArqII.ULA;

import java.util.List;

public abstract class Command {
	private Operation op;
	private List<String> params;

	public Command(Operation op, List<String> params) {
		super();
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
			aux += param;
		}
		return op + aux;
	}

}
