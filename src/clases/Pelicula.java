package clases;

public class Pelicula implements Comparable<Pelicula>
{
	private float votosPromedio;
	private int identificador;
	private String nombreDirector;
	private float cantidadVotos;
	private String[] actores;
	private String genero;
	/**
	 * Creo que los generos no se crean aquí
	 */
	private String nombrePelicula; 

	public Pelicula(int pIdentificador, String pNombre, String pGenero, String pNombreDirector, float pCantVotos, float pVotosPromedio, String actor1,String actor2,String actor3,String actor4,String actor5)
	{
		identificador = pIdentificador; 
		actores = new String[5];
		actores[0] = actor1;
		actores[1] = actor2;
		actores[2] = actor3;
		actores[3] = actor4;
		actores[4] = actor5;
		nombrePelicula = pNombre;
		genero = pGenero;
		nombreDirector = pNombreDirector;
		cantidadVotos = pCantVotos;
		votosPromedio = pVotosPromedio;
	}

	public int darIdentificador()
	{
		return identificador;
	}
	
	public String darNombrePelicula()
	{
		return nombrePelicula;
	}

	public String darNombreDirector()
	{
		return nombreDirector;
	}

	public float darCantidadVotos()
	{
		return cantidadVotos;
	}

	public float darVotosPromedio()
	{
		return votosPromedio;
	}

	public String[] darListaNombresActores()
	{
		return actores;
	}
	
	public String darGenero() {
		return genero;
	}
	
	public int compareTo(Pelicula o) {
		return (int) (votosPromedio - o.darVotosPromedio());
	}
}
