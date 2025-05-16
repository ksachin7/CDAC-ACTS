package eclipse_workspace.day7.student;

public enum Course {
	PG_DAC("Diploma in Advanced Computing"),
	PG_DESD("Diploma in ESD"),
	PG_VLSI("Diploma in VLSI");
	
	private String str;
	private Course(String str) {
		this.str=str;
	}
	
	public String getValue() {
		return str;
	}
}
