package menuproject;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import AgendarCita.Doctor1;

public class MenuPaciente {
	
	public static void showPacienteMenu() // metodo estatico
	{
		int responder=0;
		do
		{
			System.out.println("\n \n");
			System.out.println("Paciente");
			System.out.println("Bienvenido: " + "\t"+ "Pac." + Menu.pacienteloged.getName1());
			System.out.println("1. Reserva Su Cita Medica");
			System.out.println("2. Mis Citas Reservadas");
			System.out.println("0. Cerra Sesión");
			
			Scanner opcionPac= new Scanner(System.in);
			responder = Integer.valueOf(opcionPac.nextLine());
			
			switch(responder)
			{
			case 1:
				showReservarCitaMedicaMEnu();
				break;
			case 2:
				showMisCitasReservadas();
				break;
			case 0:
				Menu.showMenu1();
				break;
				
			}
			
		}while(responder!=0);
	}
	
	private static void showReservarCitaMedicaMEnu() // metodo estatico

	{
		int responder=0;
		do
		{
			System.out.println();
			System.out.println("-----> Reservar Citas Medicas <-----");
			System.out.println("----> Selecciona Un Mes <----");
			
			//El primer Integer del primer Map llevara la numeración de la lista de fechas de los doctores
			// El segundo Integer del segundo Map llevara el indice de la fecha que seleccione nuestro paciente
			//[Doctores]
			//1. doctor1
			    // - 1 fecha1
			    // - 2 fecha2
			//2. doctor2
			//3. doctor3
			
			
			// El objeto Doctor1 sera el que tendra tendra la información completa del Doctor 
			Map<Integer, Map<Integer,Doctor1>> doctors= new TreeMap<>();// siempre tendra un Integer para objetos
			int k=0;
			//con este for se recorre los doctores 
			for (int i = 0; i < MenuDoctor1.doctorsCitasMedicas.size() ; i++) // i tiene que ser menor que el arreglo de doctorsCitasMedicas.size(), que con este doctorsCitasMedicas.size() hace recorrer el i hasta que llegue al tamaño del arreglo doctorsCitasMedicas, y ya con todo esto es para extraer sus citas 
			{
				// con este arreglo capturamos unicamente las citas, por medio de la clase anidada CitasDoctor, con MenuDoctor1.doctorsCitasMedicas.get(i), estaremos accediendo y con get(i) estaremos recorriendo el arreglo doctorsCitasMedicas, por ultimo con getCitasDoctor() solicita las citas disponibles con las fechas y se le asignan al objeto citasdoc 
				ArrayList<Doctor1.CitasDoctor> citasdoc = MenuDoctor1.doctorsCitasMedicas.get(i).getCitasDoctor();
				
				// con este for se va a recorrer las fechas que tiene cada doctor
				Map<Integer,Doctor1> doctorCitas= new TreeMap<>();
				for (int j = 0; j < citasdoc.size(); j++) // j tiene que ser menor que el arreglo de citasdoc.size(), ya que con este citasdoc().size() hace recorrer la j hasta que llegue al tamaño del arreglo citasdoc, y ya con todo esto es para extraer las fechas de las citas del doctor 
				{
					// capturar los numeros de cada doctor (1. doctor1, 2. doctor2....etc) en el primer Integer del primer Map
					k++; // es el indice de cada doctor
					System.out.println(k+"."+citasdoc.get(j).getDate());
					// utilizaremos doctorCitas para que por un lado capturemos  el indice de la fecha [- 1 fecha1] y por otro lado el objeto [doctor1] de la fecha seleccionada
					doctorCitas.put(Integer.valueOf(j), MenuDoctor1.doctorsCitasMedicas.get(i));
					
					doctors.put(Integer.valueOf(k), doctorCitas);
				}
				
			}
			Scanner opcionPac= new Scanner(System.in);
			int responderDateSelec = Integer.valueOf(opcionPac.nextLine());
			
			Map<Integer,Doctor1> doctorCitasSeleccionada = doctors.get(responderDateSelec); // con este Map y en el Integer obtendra la lista del Map doctors y se obtendra con la opcion que se escriba en responderDateSelec 
			Integer indexDate=0; // con Integer se guardar una variable el indice de la fecha
			Doctor1 doctorSelec = new Doctor1 ("", "",""); // Variable que contendra lo de la clase Doctor1
			
			for (Map.Entry<Integer, Doctor1> doc: doctorCitasSeleccionada.entrySet()) {
				indexDate=doc.getKey(); // con este obtiene este Integer
				doctorSelec=doc.getValue(); // con este obtiene este Doctor1 qu es el valor 
			}
			
			System.out.println(doctorSelec.getName1() + ". Fecha: "+ doctorSelec.getCitasDoctor().get(indexDate).getDate() + ". Hora: " + doctorSelec.getCitasDoctor().get(indexDate).getTime());
			System.out.println("Confirma tu Cita Medica:  \n1. Si \n2. Cambiar Datos");
			responder=Integer.valueOf(opcionPac.nextLine());
			
			if(responder==1)
			{
				// con 1 se agenda la cita
				Menu.pacienteloged.addCitasDoctor(doctorSelec, doctorSelec.getCitasDoctor().get(indexDate).getDate(), doctorSelec.getCitasDoctor().get(indexDate).getTime());
				showPacienteMenu();
			}
		}while(responder!=0);
	}

	private static void showMisCitasReservadas()
	{
		int responder=0;
		do 
		{
		
			System.out.println("Mis Citas Reservadas \n");
			if(Menu.pacienteloged.getCitasDoctor().size() == 0)
			{
				System.out.println(" No tienes Citas Reservadas");
				break;
			}
			
			for (int i = 0; i < Menu.pacienteloged.getCitasDoctor().size(); i++)// recorre el for para ver cuantas citas reservadas tiene 
			{
				
				int j= i +1; // indicador de citas
				System.out.println(j + ". " + "Date: "+Menu.pacienteloged.getCitasDoctor().get(i).getDate() + " Hora: " + Menu.pacienteloged.getCitasDoctor().get(i).getTime() + "\n Doctor: " + Menu.pacienteloged.getCitasDoctor().get(i).getDoctor1().getName1()); // mustra la fecha, la hora del paciente y el nombre del doctor al cual fue asignado
				
			}
			
			System.out.println("0. Return");
		}while(responder!=0);
	}
}
