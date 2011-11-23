package br.pucrs.orgArqII.MIPS;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MIPS {
	private List<AssemblyElement> commands;
	private HashMap<Registers, String> registers;
	private HashMap<String, String> memory;
	private Integer actualCommand;

	public void next() {
		AssemblyElement next = moveNext();
		if (next instanceof Label) {
			this.next();
		}
		Label label = ((Command) next).execute(this);
		if (label == null) {// not a branch
			return;
		}
		for (int i = 0; i < this.commands.size(); i++) {
			AssemblyElement c = this.commands.get(i);
			if (c instanceof Label && ((Label) c).getName().equals(label.getName())) {
				actualCommand = i;
				return;
			}
		}
	}

	private AssemblyElement moveNext() {
		if (hasNext())
			return moveNext(this.actualCommand + 1);
		else
			return null;
	}

	private AssemblyElement moveNext(Integer actual) {
		this.actualCommand = actual;
		return this.commands.get(this.actualCommand);
	}

	public MIPS(List<AssemblyElement> commands) {
		this.commands = commands;
		this.actualCommand = 0;
		this.registers = new HashMap<Registers, String>();
		// Initialize all registers
		for (Registers reg : Registers.values()) {
			this.registers.put(reg, "0");
		}
		this.memory = new HashMap<String, String>();
	}

	public List<AssemblyElement> getElements() {
		return Collections.unmodifiableList(commands);
	}

	public boolean hasNext() {
		return this.commands.size() > this.actualCommand + 1;
	}

	public void restart() {
		this.actualCommand = 0;
	}

	public boolean isActualCommand(Command c) {
		return this.commands.get(actualCommand) == c;
	}

	public void setMemory(String position, String value) {
		this.memory.put(position, value);
	}

	public HashMap<Registers, String> getRegisters() {
		return this.registers;
	}

	public HashMap<String, String> getMemory() {
		return this.memory;
	}

	public String getMemoryValue(String pos) {
		if (this.memory.get(pos) == null) {
			this.memory.put(pos, "0");
		}
		return this.memory.get(pos);
	}

	public String getRegisterValue(Registers reg) {
		return this.registers.get(reg);
	}

	public void setRegValue(Registers reg, String value) {
		this.registers.put(reg, value);
	}

}
