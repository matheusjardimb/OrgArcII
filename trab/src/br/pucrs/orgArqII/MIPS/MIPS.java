package br.pucrs.orgArqII.MIPS;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class MIPS {
	private List<Command> commands;
	private HashMap<Registers, String> registers;
	private ListIterator<Command> actualCommand;

	public void next() {
		this.actualCommand.next().execute(this.registers);
	}

	public MIPS(List<Command> commands) {
		this.commands = commands;
		this.actualCommand = this.commands.listIterator();
		this.registers = new HashMap<Registers, String>();
		// Initialize all registers
		for (Registers reg : Registers.values()) {
			this.registers.put(reg, "0");
		}
	}

	public List<Command> getCommands() {
		return Collections.unmodifiableList(commands);
	}

	public String getRegisterValue(Registers reg) {
		return this.registers.get(reg);
	}

	public boolean hasNext() {
		return this.actualCommand.hasNext();
	}

	public void restart() {
		this.actualCommand = this.commands.listIterator();
	}

	public boolean isActualCommand(Command c) {
		return (this.actualCommand.nextIndex() == 0) ? false
				: this.commands.get(this.actualCommand.nextIndex() - 1) == c;
	}
}
