package br.pucrs.orgArqII.MIPS;

import java.util.HashMap;
import java.util.List;

public class Command {
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
			break;
		case ADDI:
			break;
		case ANDI:
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
			break;
		case ORI:
			break;
		case SLT:
			break;
		case SLTI:
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

	public void execute(HashMap<Registers, String> registers) {
		// TODO complete'em all
		// and review the command format
		switch (this.op) {
		case ADD: // add reg, reg, reg
			Registers add1 = Registers.valueOf(this.params.get(0));
			Integer add2 = new Integer(registers.get(Registers.valueOf(this.params.get(1))));
			Integer add3 = new Integer(registers.get(Registers.valueOf(this.params.get(2))));
			registers.put(add1, add2 + add3 + "");
			break;
		case AND:
			break;
		case ADDI:// addi reg, reg, const
			Registers addi1 = Registers.valueOf(this.params.get(0));
			Integer addi2 = new Integer(registers.get(Registers.valueOf(this.params.get(1))));
			Integer addi3 = new Integer(this.params.get(2));
			registers.put(addi1, addi2 + addi3 + "");
			break;
		case ANDI:
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
			break;
		case ORI:
			break;
		case SLT:
			break;
		case SLTI:
			break;
		case SW:
			break;
		default:
			break;
		}
	}

}
