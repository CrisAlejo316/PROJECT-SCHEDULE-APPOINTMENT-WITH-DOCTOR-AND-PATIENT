package AgendarCita;

import java.util.Date;



public class CitasDoctor1 implements Iprogramable {

	private int id;
	private Paciente paciente;
	private Doctor1 doctor1;
	private String date;
	private String time;
	
	
	
	public CitasDoctor1(Paciente paciente, Doctor1 doctor1) {
		super();
		this.paciente = paciente;
		this.doctor1 = doctor1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Doctor1 getDoctor1() {
		return doctor1;
	}
	public void setDoctor1(Doctor1 doctor1) {
		this.doctor1 = doctor1;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time + "hrs. ";
	}
	public void setTime(String time) {
		this.time = time;
	}

	// implementar metodo con alt+shif+s, seleccionar implement methods
	@Override
	public void schedule(String date, String time) {
		this.date=date;
		this.time=time;
		
	}
	
 

	
	
	
}
