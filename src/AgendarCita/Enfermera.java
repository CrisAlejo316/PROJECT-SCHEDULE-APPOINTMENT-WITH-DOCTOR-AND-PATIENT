package AgendarCita;

import java.security.PublicKey;
import java.util.ArrayList;

import AgendarCita.Doctor1.CitasDoctor;

public class Enfermera extends Usuarios{

	/*Metodo Constructor con parametros (name, email y phoneNumber)*/
	public Enfermera(String name1, String email1, String phoneNumber1)
	{
		
		super(name1, email1,phoneNumber1);
	}
	
	/*Clase estatica anidada*/
	public static class ConsultasMedicas 
	{
		private  String date;
		private String time;
		
		public ConsultasMedicas(String date, String time)
		{
			this.date= date;
			this.time=time;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}
		
		
	}
	
/*Consultas Medicas*/
	
	//Consulta disponible:
	
			ArrayList<ConsultasMedicas> consultasenfer = new ArrayList<>(); //Collecion de objetos de tipo CitasDoctor, Arraylist<nombre de la clase estatica anidada (CitasDoctor)> nombre de la collecion (citasdoctor), declarando e instanciando la collecion o el Arraylist
			public void agregarConsultasEnfer(String date, String time) //metodo con parametros String date, String time, que añade citas disponible y se estaran acumulando en el Arraylist<CitasDoctor>, esto es a nivel de la clase Doctor 
			{
			
				consultasenfer.add (new ConsultasMedicas(date, time));// con citasdoctors.add se le agrega o añade una nueva cita, y con new CitasDoctor(date, time) puedo estar declarando un nuevo objeto de date, time
			}
			
			// impresion del Arraylist
			public ArrayList<ConsultasMedicas> getConsultasMedicas() //metodo para obtener los valor del Arraylist<CitasDoctor> y con el getCitasDoctor se obtiene los valores 
			{
				return consultasenfer; // retorna los valores guardados osea devuelve la lista completa de las citas, en el ArrayList<CitasDoctor>
				
			}
}
