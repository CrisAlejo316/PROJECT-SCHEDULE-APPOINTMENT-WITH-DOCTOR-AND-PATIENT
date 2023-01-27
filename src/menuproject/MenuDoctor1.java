package menuproject;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Scanner;

import AgendarCita.Doctor1;

public class MenuDoctor1 {

	public static ArrayList<Doctor1> doctorsCitasMedicas = new ArrayList<>(); // variable estatica arreglo 
	
	/*Metodo estatico*/
	public static void showDoctorMenu1()
	{
		// Este metodo mostrara la logica del menu del doctor
		
		int respuesta=0;
		do
		{
			System.out.println("\n \n");
			System.out.println("Doctor \n");
			System.out.println("Bienvenido" +"\t"+ "Doc." +Menu.doctor1loged.getName1()+ "\t"+Menu.doctor1loged.getEmail1() + "\n");
			System.out.println("1. Agregar Cita Medica");
			System.out.println("2. Mi Horario De Cita");
			System.out.println("0. Cerrar Sesión");
			
			
			Scanner opcionDoc= new Scanner(System.in);
			respuesta = Integer.valueOf(opcionDoc.nextLine());
			
			switch (respuesta)
			{
			case 1: 
				showCitasMedicasMenu();
				break;
			case 2:
				
				break;
			case 0:
				Menu.showMenu1();
				break;
			}
			
		}while(respuesta!=0);
	}
	
	private static void showCitasMedicasMenu()
	{
		int respuesta=0;
		do
		{
			System.out.println();
			System.out.println("-----> Agregar Citas Medicas <-----");
			System.out.println("----> Selecciona Un Mes <----");
			
			
			for (int i = 3; i < 6; i++) {
				int j= i; // se le asigna el valor a la variable j y esta variable viene siendo el indicador de cada mes
				System.out.println(j+"."+Menu.MONTHS1[i]); // muestra el indicador del mes y el mes que le corresponde
			}
			
			System.out.println("0. Return");
			
			Scanner sc= new Scanner(System.in);
			respuesta = Integer.valueOf(sc.nextLine());
			
			if(respuesta > 2 && respuesta <6)// con este if es para indicar a que mes selecciono y se encuentra
			{
				// 3,4,5
				int mesSeleccionado= respuesta;
				System.out.println(mesSeleccionado + "."+ Menu.MONTHS1[mesSeleccionado]); // muestra el mes donde se encuentra
				
				System.out.println("Inserte la Fecha de la cita: [dd/mm/yyyy]");
				String date= sc.nextLine();// escribir Fecha

				System.out.println();// genera espacio
				
				//confirmar cita
				System.out.println("Su cita es: " + date);
				System.out.println("1. Correcto");
				System.out.println("2. Cambiar fecha");

				int respuestaDate= Integer.valueOf(sc.nextLine()); // respuestaDate contendra el valor asignado por el usuario sc.nextLine(), por ende convierte la fecha de tipo cadena a tipo de entero con el integer.valueof
				
				if(respuestaDate==1)
				{
					System.out.println("Su Fecha fue asignada: " + date);
				}else if(respuestaDate==2){
					continue;
				}
				
			    System.out.println(); // genera espacio
			    
				int respuestaTiempo=0;
				String time="";
				do
				{
					System.out.println("Inserte el tiempo disponible para la Fecha: " + date + " [20:00]");
					time= sc.nextLine();// escribe hora
				
					System.out.println(); // genera espacio
					
					//confirmar hora
					System.out.println("Su hora de cita es: " + time);
					System.out.println("1. Correcto");
					System.out.println("2. Cambiar hora");
					
					respuestaTiempo=Integer.valueOf(sc.nextLine());
					
					
				}while(respuestaTiempo==2); // si la respuestaTiempo es igual 2 repite el ciclo do while, si es diferente de 2 sale del ciclo 
				System.out.println(); // genera espacio
				System.out.println("Su hora de la cita quedo asignada: " + time);

				
				// Se le asigna al doctor la fecha y la hora
				Menu.doctor1loged.agregarCitasdoctor(date,time);
				// se le pasa la informacion del doctor del metodo check al doctor logeado
				checkDoctorCitasMedicas(Menu.doctor1loged); 
				
			}else if(respuesta == 0){
			 showDoctorMenu1();	
			}
		}while(respuesta !=0);
	}
	
	/*Metodo privado para delegar responsabilidades*/
	
	// metodo que solo estara aca en esta clase y recibe un objeto de tipo Doctor1 doctor1
	private static void checkDoctorCitasMedicas(Doctor1 doctor1)
	{
		// validación 
		if(doctor1.getCitasDoctor().size() > 0 && !doctorsCitasMedicas.contains(doctor1)) // primero se evalua si el doctor que esta recibiendo tiene citas medicas osea mayor a 0 citas y además el doctor no existe o no esta contenido previamente en la variable public de arreglo de doctores 
		{
			// si cumple el if, agregare al doctor que me estan pasando
			doctorsCitasMedicas.add(doctor1);
		}
	}
}
