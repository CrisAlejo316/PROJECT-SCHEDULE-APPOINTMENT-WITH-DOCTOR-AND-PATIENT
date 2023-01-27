package menuproject;

import java.util.ArrayList;
import java.util.Scanner;

import AgendarCita.Doctor1;
import AgendarCita.Enfermera;
import AgendarCita.Paciente;

public class Menu {

	/* Variable Constante MONTHS*/
	public static final String[] MONTHS1= { 
			"Enero", "Febero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
			};
	
	
	//variables logeadas
	public static Doctor1 doctor1loged;
	public static Paciente pacienteloged;
	public static Enfermera enfermeraloged;
	
	 /*METODOS TIPO ESTATICOS*/
		public static void showMenu1() {
			
			System.out.println("\n");
			System.out.println("Selecciona la opción deseada" + "\n");
			
			int response=0;
			
			do
			{
				System.out.println("1. Doctor");
				System.out.println("2. Paciente");
				System.out.println("3. Enfermera");
				System.out.println("0. Salir");
				
				Scanner oPcion= new Scanner(System.in);
				response = Integer.valueOf(oPcion.nextLine());
				
				switch (response) {
				case 1:
					System.out.println("Doctores");
					authUser(1);
					response=0;
					break;
				case 2:
	                System.out.println("Pacientes");
	                authUser(2);
	                response=0;
					//showPacienteMenu1();
					break;
				case 3:
					System.out.println("Enfermeras");
					authUser(3);
					response=0;
					//showEnferMenu1();
					break;
				case 0:
					System.out.println("Gracias por visitarnos");
					break;
				default:
					System.out.println("Por favor seleccione una opcion valida");
				
				}
			}while (response !=0);
		}
		
		/*Es un metodo estatico de autenticación de usuarios*/
		private static void authUser(int userType) // recibe un parametro que va a indica de que tipo es ese usuario
		{
			//userType = 1 Doctor
			//userType = 2 Paciente
			//UserType = 3 Enfermera
			
			//Creación de lista de doctores y pacientes registrados
			
			ArrayList<Doctor1>doctores=new ArrayList<>();
			doctores.add(new Doctor1("Victor Salasar","Victor321@gmail.com","3167892454"));
			doctores.add(new Doctor1("Diego Corona","DieCorona67@gmail.com","3107342135"));
			doctores.add(new Doctor1("Andrea Valvuena","AndreVal45@hotmail.com","3218906753"));
			doctores.add(new Doctor1("Fabian Urrego","FabianU88@hotmail.com","3205467341"));
			doctores.add(new Doctor1("Valeria Naranjo","ValeNa09@hotmail.com","3004822143"));
			
			ArrayList<Paciente>pacientes=new ArrayList<>();
			pacientes.add(new Paciente("Oswaldo Gonzalez", "Oswal312@gmail.com","3123677861"));
			pacientes.add(new Paciente("Ana Suarez", "Analu86596@gmail.com","3208984450"));
			pacientes.add(new Paciente("Luis Avila", "Luisavila310@gmail.com","3105654481"));
			pacientes.add(new Paciente("Lorena Gonzalez", "lorena.gonzalez,castellanos@gmail.com","3157557006"));
			pacientes.add(new Paciente("Maria Barrera", "mariaba474@hotmail.com","4744230"));
			
			ArrayList<Enfermera>enfermeras=new ArrayList<>();
			enfermeras.add(new Enfermera("Valentina Salgado","Valen345@gmail.com","3005678923"));
			enfermeras.add(new Enfermera("Daniela Moreno","DaniMore7@gmail.com","3220876541"));
			enfermeras.add(new Enfermera("Carla Morrison","CarlaMo@hotmail.com","3019876542"));
			
			boolean emailCorrecto= false; // estara en falso hasta que no haga la verificación
			
			do
			{
				System.out.println();
				
				//si el email es falso estara mostrando cada vez el correo electronico
				System.out.println("Inserte su correo:[a@gmail.com]");
				// solicitar los datos con scanner
				Scanner sc= new Scanner(System.in);
				//recibir dato del scanner
				String email1=sc.nextLine();
				if(userType==1) 
				{
					for(Doctor1 doc: doctores) // con el foreach recorre el ArrayList
					{
						if(doc.getEmail1().equals(email1))// compara si el correo de los doctores son iguales a los del arreglo y se obtiene del get.Email1
						{
						 emailCorrecto=true;
						 // obtener el usuario logeado
						 doctor1loged=doc;
						 MenuDoctor1.showDoctorMenu1();
						 
						}
					}
				}
				
				if(userType==2)
				{
					for(Paciente pac: pacientes)
					{
						if(pac.getEmail1().equals(email1))
						{
						emailCorrecto=true;
						// obtener el usuario logeado
						pacienteloged=pac;
						MenuPaciente.showPacienteMenu();;
						}
					}
				}
				
				if(userType==3)
				{
					for(Enfermera enf: enfermeras)
					{
						if(enf.getEmail1().equals(email1))
						{
						emailCorrecto=true;
						// obtener el usuario logeado
						enfermeraloged=enf;
						showEnfermeraMenu1();
						}
					}
				}
				
			}while(!emailCorrecto);
		}
		
		
		
		public static void showEnfermeraMenu1()
		{
			
		}

}
