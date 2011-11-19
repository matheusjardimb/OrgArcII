package br.pucrs.orgArqII.MIPS;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MIPS {
	private List<Command> commands;
	private HashMap<Registers, String> registers;
	private Iterator<Command> actualCommand;

	public void next() {
		this.actualCommand.next();
	}

	public MIPS(List<Command> commands) {
		this.commands = commands;
		this.actualCommand = this.commands.iterator();
		this.registers = new HashMap<Registers, String>();
		for (Registers reg : Registers.values()) {
			this.registers.put(reg, "");
		}
	}

	public List<Command> getCommands() {
		return Collections.unmodifiableList(commands);
	}

	public Map<Registers, String> getRegisters() {
		return Collections.unmodifiableMap(registers);
	}

	public Command getActualCommand() {
		return ((Command) actualCommand);
	}
}
