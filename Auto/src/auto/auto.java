package auto;

public class auto {
	
	//Atributos del objeto
	
	private String Modelo;
	private String Color;
	private int Año;
	private String Kilometraje;
	
	public auto() {
		
	}

	public auto(String Modelo, String Color, int Año, String Kilometraje) {
		this.Modelo = Modelo;
		this.Color = Color;
		this.Año = Año;
		this.Kilometraje = Kilometraje;
	}

	@Override
	public String toString() {
		return "auto [Modelo=" + Modelo + ", Color=" + Color + ", Año=" + Año + ", Kilometraje=" + Kilometraje + "]";
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getAño() {
		return Año;
	}

	public void setAño(int año) {
		Año = año;
	}

	public String getKilometraje() {
		return Kilometraje;
	}

	public void setKilometraje(String kilometraje) {
		Kilometraje = kilometraje;
	}
	
	
	
	
}