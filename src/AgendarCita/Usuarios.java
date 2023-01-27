package AgendarCita;

public abstract class Usuarios // esta sera la SUPERclase que contendra los datos que se utilizaran en las subclases(Paciente, Doctor1 y Enfermera) o demas clases
                               // además al ser un clase abstract no puede ser instanciada en otra clase ya que tiene la palabra abstract,en cambio las clases que no tiene esa plabra abstract si se le puede crear un instanciador
{
	private int id1;
	private String name1;
	private String email1;
	private String address1;
	private String phoneNumber1;
		
	
	public Usuarios(String name1, String email1, String phoneNumber1)
	{
		this.name1=name1;
		this.email1=email1;
		this.phoneNumber1=phoneNumber1;
	}


	public int getId1() {
		return id1;
	}


	public void setId1(int id1) {
		this.id1 = id1;
	}


	public String getName1() {
		return name1;
	}


	public void setName1(String name1) {
		this.name1 = name1;
	}


	public String getEmail1() {
		return email1;
	}


	public void setEmail1(String email1) {
		this.email1 = email1;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getPhoneNumber1() {
		return phoneNumber1;
	}


	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}
	
	
}
