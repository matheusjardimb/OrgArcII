package br.pucrs.orgArqII.MIPS;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MIPS {
	private List<AssemblyElement> commands;
	private HashMap<Registers, String> registers;
	private Integer actualCommand;

	// private ListIterator<AssemblyElement> actualCommand;

	public void next() {
		AssemblyElement next = moveNext();
		if (next instanceof Label) {
			this.next();
		}
		Label label = ((Command) next).execute(this.registers);
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
		// this.actualCommand = this.commands.listIterator();
		this.actualCommand = 0;
		this.registers = new HashMap<Registers, String>();
		// Initialize all registers
		for (Registers reg : Registers.values()) {
			this.registers.put(reg, "0");
		}
	}

	public List<AssemblyElement> getElements() {
		return Collections.unmodifiableList(commands);
	}

	public String getRegisterValue(Registers reg) {
		return this.registers.get(reg);
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
}
