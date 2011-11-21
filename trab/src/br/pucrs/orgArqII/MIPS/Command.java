package br.pucrs.orgArqII.MIPS;

import java.util.HashMap;
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

	public Label execute(HashMap<Registers, String> registers) {
		// TODO complete'em all
		// and review the command format
		switch (this.op) {
		case ADD: // add reg, reg, reg
			Registers add1 = Registers.valueOf(this.params.get(0));
			Integer add2 = new Integer(registers.get(Registers.valueOf(this.params.get(1))));
			Integer add3 = new Integer(registers.get(Registers.valueOf(this.params.get(2))));
			registers.put(add1, add2 + add3 + "");
			break;
		case AND: // and reg, reg, reg
			Registers and1 = Registers.valueOf(this.params.get(0));
			Integer and2 = new Integer(registers.get(Registers.valueOf(this.params.get(1))));
			Integer and3 = new Integer(registers.get(Registers.valueOf(this.params.get(2))));
			registers.put(and1, (and2 & and3) + "");
			break;
		case ADDI: // addi reg, reg, const
			Registers addi1 = Registers.valueOf(this.params.get(0));
			Integer addi2 = new Integer(registers.get(Registers.valueOf(this.params.get(1))));
			Integer addi3 = new Integer(this.params.get(2));
			registers.put(addi1, addi2 + addi3 + "");
			break;
		case ANDI: // andi reg, reg, const
			Registers andi1 = Registers.valueOf(this.params.get(0));
			Integer andi2 = new Integer(registers.get(Registers.valueOf(this.params.get(1))));
			Integer andi3 = new Integer(this.params.get(2));
			registers.put(andi1, (andi2 & andi3) + "");
			break;
		case BEQ:
			break;
		case J:
			return new Label(params.get(0));			
		case LW:
			break;
		case NOP:
			break;
		case OR: // or reg, reg, reg
			Registers or1 = Registers.valueOf(this.params.get(0));
			Integer or2 = new Integer(registers.get(Registers.valueOf(this.params.get(1))));
			Integer or3 = new Integer(registers.get(Registers.valueOf(this.params.get(2))));
			registers.put(or1, (or2 | or3) + "");
			break;
		case ORI: // ori reg, reg, const
			Registers ori1 = Registers.valueOf(this.params.get(0));
			Integer ori2 = new Integer(registers.get(Registers.valueOf(this.params.get(1))));
			Integer ori3 = new Integer(this.params.get(2));
			registers.put(ori1, (ori2 | ori3) + "");
			break;
		case SLT: // slt reg, reg, reg
			Registers slt1 = Registers.valueOf(this.params.get(0));
			Integer slt2 = new Integer(registers.get(Registers.valueOf(this.params.get(1))));
			Integer slt3 = new Integer(registers.get(Registers.valueOf(this.params.get(2))));
			registers.put(slt1, (slt2 < slt3) ? "1" : "0");
			break;
		case SLTI: // slti reg, reg, const
			Registers slti1 = Registers.valueOf(this.params.get(0));
			Integer slti2 = new Integer(registers.get(Registers.valueOf(this.params.get(1))));
			Integer slti3 = new Integer(this.params.get(2));
			registers.put(slti1, (slti2 < slti3) ? "1" : "0");
			break;
		case SW:
			break;
		default:
			break;
		}
		// Not a branch command
		return null;
	}

}
