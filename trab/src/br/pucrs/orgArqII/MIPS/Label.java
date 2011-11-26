package br.pucrs.orgArqII.MIPS;


public class Label extends AssemblyElement {

	private String name;

	public Label(String name) {
		super();
		this.name = name.toUpperCase();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + ":";
	}

}
