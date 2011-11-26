package br.pucrs.orgArqII.MIPS;

public enum MIPSStatus {
	BUSCA(1), DECODIFICACAO(2), EXECUÇÃO(3), MEMORIA(4), WRITEBACK(5);

	private int index;

	private MIPSStatus(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

}
