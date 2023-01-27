package AgendarCita;

import java.util.ArrayList;
import java.util.Date;

public class Doctor1 extends Usuarios 
{

	/*Metodo Constructor con parametros (name, email y phoneNumber)*/
	public Doctor1(String name1, String email1, String phoneNumber1)
	{
		super(name1,email1,phoneNumber1);
		
	}
	
	/*Clase estatica anidada*/
	public static class CitasDoctor {
		
		private  String date;
		private String time;
		
		public CitasDoctor(String date, String time) // metodo constructor 
		{
			
			this.date=date;
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
	
	/*Citas Medicas*/
	
	//Cita disponible:
	
			ArrayList<CitasDoctor> citasdoctor = new ArrayList<>(); //Collecion de objetos de tipo CitasDoctor, Arraylist<nombre de la clase estatica anidada (CitasDoctor)> nombre de la collecion (citasdoctor), declarando e instanciando la collecion o el Arraylist
			public void agregarCitasdoctor(String date, String time) //metodo con parametros String date, String time, que añade citas disponible y se estaran acumulando en el Arraylist<CitasDoctor>, esto es a nivel de la clase Doctor 
			{
			
				citasdoctor.add (new CitasDoctor(date, time));// con citasdoctors.add se le agrega o añade una nueva cita, y con new CitasDoctor(date, time) puedo estar declarando un nuevo objeto de date, time
			}
			
			// impresion del Arraylist
			public ArrayList<CitasDoctor> getCitasDoctor() //metodo para obtener los valor del Arraylist<CitasDoctor> y con el getCitasDoctor se obtiene los valores 
			{
				return citasdoctor; // retorna los valores guardados osea devuelve la lista completa de las citas, en el ArrayList<CitasDoctor>
				
			}
  }
	
	

