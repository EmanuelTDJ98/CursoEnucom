package auto;

public class Principal {

	public static void main(String[] args) {
		
		auto auto1 = new auto();
		auto auto2 = new auto("Suzuki","Negro", 2020,"1000km");
		
		
		//Asignacion de valores mediante el Metodo Set
		auto1.setModelo("Nissan");
		auto1.setColor("Azul");
		auto1.setAño(2012);
		auto1.setKilometraje("10000km");
		
		System.out.println(auto2);
		
		
	}
}
