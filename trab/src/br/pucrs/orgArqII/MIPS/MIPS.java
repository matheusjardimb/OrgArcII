package br.pucrs.orgArqII.MIPS;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MIPS {
	private List<AssemblyElement> commands;
	private HashMap<Registers, String> registers;
	private HashMap<String, String> memory;
	private HashMap<MIPSStatus, Integer> status;
	private List<MIPSStatus> asList = Arrays.asList(MIPSStatus.BUSCA, MIPSStatus.DECODIFICACAO, MIPSStatus.EXECUÇÃO,
			MIPSStatus.MEMORIA, MIPSStatus.WRITEBACK);

	public MIPS(List<AssemblyElement> commands) {
		this.restart();
		this.commands = commands;
	}

	public void next() {
		for (MIPSStatus key : this.asList) {
			Integer i = this.status.get(key);
			if (i >= 0 && i < this.commands.size()) {
				AssemblyElement assemblyElement = this.commands.get(i);
				if (!(assemblyElement instanceof Label)) {
					Label label = ((Command) assemblyElement).execute(this, key);
					if (label != null) { // jump!
						this.status.put(key, getLabel(label));
					}
				}
			}
			this.status.put(key, i + 1);
		}
	}

	private Integer getLabel(Label label) {
		for (int i = 0; i < this.commands.size(); i++) {
			AssemblyElement ae = this.commands.get(i);
			if (ae instanceof Label) {
				if (((Label) ae).equals(label)) {
					return i;
				}
			}
		}
		return null;
	}

	public void restart() {
		this.registers = new HashMap<Registers, String>();
		// Initialize all registers
		for (Registers reg : Registers.values()) {
			this.registers.put(reg, "0");
		}
		this.memory = new HashMap<String, String>();
		this.status = new HashMap<MIPSStatus, Integer>();
		this.status.put(MIPSStatus.WRITEBACK, -4);
		this.status.put(MIPSStatus.MEMORIA, -3);
		this.status.put(MIPSStatus.EXECUÇÃO, -2);
		this.status.put(MIPSStatus.DECODIFICACAO, -1);
		this.status.put(MIPSStatus.BUSCA, 0);
	}

	public String getMemoryValue(String pos) {
		if (this.memory.get(pos) == null) {
			this.memory.put(pos, "0");
		}
		return this.memory.get(pos);
	}

	public List<AssemblyElement> getElements() {
		return Collections.unmodifiableList(commands);
	}

	public String getRegisterValue(Registers reg) {
		return this.registers.get(reg);
	}

	public void setRegValue(Registers reg, String value) {
		this.registers.put(reg, value);
	}

	public boolean isActualCommand(MIPSStatus mipsStatus, Command c) {
		Integer integer = this.status.get(mipsStatus);
		if (this.commands.size() - 1 < integer || integer < 0)
			return false;
		return this.commands.get(integer) == c;
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

	public String getCommandDescriptions(MIPSStatus status) {
		int index = this.status.get(status);
		if (index < 0 || index > this.commands.size() - 1)
			return null;
		AssemblyElement command = this.commands.get(index);
		while (!(command instanceof Command)) {
			command = this.commands.get(index++);
		}
		return ((Command) command).getDescription(status);
	}
}
