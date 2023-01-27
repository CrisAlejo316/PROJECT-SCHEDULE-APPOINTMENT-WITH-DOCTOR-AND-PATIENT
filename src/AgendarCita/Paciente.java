package AgendarCita;

import java.util.ArrayList;

import AgendarCita.Doctor1.CitasDoctor;
import AgendarCita.Enfermera.ConsultasMedicas;

public class Paciente extends Usuarios {

	// con estos arreglos guardara todas la citas que el paciente agende
	private ArrayList<CitasDoctor1> citasDoctor = new ArrayList<>();
	private  ArrayList<ConsultasMedicas> consultasenf = new ArrayList<>();
	
	
	

	public ArrayList<CitasDoctor1> getCitasDoctor() {
		return citasDoctor;
	}




	public void addCitasDoctor(Doctor1 doctor1, String date, String time) {
		CitasDoctor1 citasDoctro1 = new CitasDoctor1(this, doctor1); // creación de objeto con los parametros del metodo constructor de la clase CitasDoctor1 
		citasDoctro1.schedule(date, time); // al objeto se le asigna lo de la interfaz de la clase CitasDoctor1
		citasDoctor.add(citasDoctro1); // a este arreglo se le pasa el objeto que se creo
	}




	public ArrayList<ConsultasMedicas> getConsultasenf() {
		return consultasenf;
	}




	public void setConsultasenf(ArrayList<ConsultasMedicas> consultasenf) {
		this.consultasenf = consultasenf;
	}




	/*Metodo Constructor con parametros (name, email y phoneNumber)*/
	public Paciente(String name1, String email1, String phoneNumber1)
	{
	
		super(name1,email1,phoneNumber1);
	}

	
	
	
}
