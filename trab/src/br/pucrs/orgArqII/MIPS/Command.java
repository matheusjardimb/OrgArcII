package br.pucrs.orgArqII.MIPS;

import java.util.List;

public class Command extends AssemblyElement {
	private Operations op;
	private List<String> params;

	public Command(Operations op, List<String> params) throws Exception {
		this.op = op;
		Exception exception = new Exception("Mal formed instruction");
		// TODO Complete'em all!
		switch (this.op) {
		case ADD:
			if (params.size() != 3)
				throw exception;
			break;
		case AND:
			if (params.size() != 3)
				throw exception;
			break;
		case ADDI:
			if (params.size() != 3)
				throw exception;
			break;
		case ANDI:
			if (params.size() != 3)
				throw exception;
			break;
		case BEQ:
			break;
		case J:
			break;
		case LW:
			break;
		case NOP:
			break;
		case OR:
			if (params.size() != 3)
				throw exception;
			break;
		case ORI:
			if (params.size() != 3)
				throw exception;
			break;
		case SLT:
			if (params.size() != 3)
				throw exception;
			break;
		case SLTI:
			if (params.size() != 3)
				throw exception;
			break;
		case SW:
			break;
		default:
			break;
		}
		this.params = params;
	}

	@Override
	public String toString() {
		String aux = "";
		for (String param : this.params) {
			aux += " " + param;
		}
		return this.op + " " + aux;
	}

	public Label execute(MIPS mips, MIPSStatus key) {
		switch (this.op) {
		case ADD:
			// add reg, reg, reg
			this.executeADD(mips, key);
			break;
		case AND:
			// and reg, reg, reg
			this.executeAND(mips, key);
			break;
		case ADDI:
			// addi reg, reg, const
			this.executeADDI(mips, key);
			break;
		case ANDI:
			// andi reg, reg, reg
			this.executeANDI(mips, key);
			break;
		case BEQ:
			// beq reg, reg, label
			return this.executeBEQ(mips, key);
		case J:
			// j label
			return this.executeJ(mips, key);
		case LW:
			// lw mem, reg
			this.executeLW(mips, key);
			break;
		case NOP:
			break;
		case OR:
			// or reg, reg, reg
			this.executeOR(mips, key);
			break;
		case ORI:
			// ori reg, reg, const
			this.executeORI(mips, key);
			break;
		case SLT:
			// slt reg, reg, reg
			this.executeSLT(mips, key);
			break;
		case SLTI:
			// slti reg, reg, const
			this.executeSLTI(mips, key);
			break;
		case SW:
			// sw reg, mem
			this.executeSW(mips, key);
			break;
		default:
			break;
		}
		// Not a branch command
		return null;
	}

	private void executeSW(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			String sw1 = mips.getRegisterValue(Registers.valueOf(this.params.get(0)));
			mips.setMemory(this.params.get(1), sw1);
			break;
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
	}

	private void executeLW(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			mips.setRegValue(Registers.valueOf(this.params.get(0)), mips.getMemoryValue(this.params.get(1)));
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
	}

	private Label executeJ(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			return new Label(params.get(0));
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
		return null;
	}

	private Label executeBEQ(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			return params.get(0).equals(params.get(1)) ? new Label(params.get(0)) : null;
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
		return null;
	}

	private void executeSLTI(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			Registers slti1 = Registers.valueOf(this.params.get(0));
			Integer slti2 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(1))));
			Integer slti3 = new Integer(this.params.get(2));
			mips.setRegValue(slti1, (slti2 < slti3) ? "1" : "0");
			break;
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
	}

	private void executeSLT(MIPS mips, MIPSStatus key) {

		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			Registers slt1 = Registers.valueOf(this.params.get(0));
			Integer slt2 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(1))));
			Integer slt3 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(2))));
			mips.setRegValue(slt1, (slt2 < slt3) ? "1" : "0");
			break;
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
	}

	private void executeORI(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			Registers ori1 = Registers.valueOf(this.params.get(0));
			Integer ori2 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(1))));
			Integer ori3 = new Integer(this.params.get(2));
			mips.setRegValue(ori1, String.valueOf(ori2 | ori3));
			break;
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
	}

	private void executeOR(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			Registers or1 = Registers.valueOf(this.params.get(0));
			Integer or2 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(1))));
			Integer or3 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(2))));
			mips.setRegValue(or1, String.valueOf(or2 | or3));
			break;
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
	}

	private void executeANDI(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			Registers andi1 = Registers.valueOf(this.params.get(0));
			Integer andi2 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(1))));
			Integer andi3 = new Integer(this.params.get(2));
			mips.setRegValue(andi1, String.valueOf(andi2 & andi3));
			break;
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
	}

	private void executeADDI(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			Registers addi1 = Registers.valueOf(this.params.get(0));
			Integer addi2 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(1))));
			Integer addi3 = new Integer(this.params.get(2));
			mips.setRegValue(addi1, String.valueOf(addi2 + addi3));
			break;
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
	}

	private void executeAND(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			Registers and1 = Registers.valueOf(this.params.get(0));
			Integer and2 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(1))));
			Integer and3 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(2))));
			mips.setRegValue(and1, (and2 & and3) + "");
			break;
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
	}

	private void executeADD(MIPS mips, MIPSStatus key) {
		switch (key) {
		case BUSCA:
			break;
		case DECODIFICACAO:
			break;
		case EXECUÇÃO:
			Registers add1 = Registers.valueOf(this.params.get(0));
			Integer add2 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(1))));
			Integer add3 = new Integer(mips.getRegisterValue(Registers.valueOf(this.params.get(2))));
			mips.setRegValue(add1, String.valueOf(add2 + add3));
			break;
		case MEMORIA:
			break;
		case WRITEBACK:
			break;
		}
	}

	public String getDescription(MIPSStatus status) {
		switch (status) {
		case BUSCA:
			return "busca " + this.params.toString();
		case DECODIFICACAO:
			return "decod " + this.params.toString();
		case EXECUÇÃO:
			return "exec " + this.params.toString();
		case MEMORIA:
			return "memor " + this.params.toString();
		case WRITEBACK:
			return "writb " + this.params.toString();
		default:
			return null;
		}
	}
}
