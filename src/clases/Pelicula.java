package clases;

import java.awt.List;
import java.util.ArrayList;

import model.data_structures.ArregloDinamico;

public class Pelicula implements Comparable<Pelicula>
{
	private float votosPromedio;
	private int identificador;
	private String nombreDirector;
	private float cantidadVotos;
	private ArregloDinamico<String> nombresActores;
	private String genero;
	/**
	 * Creo que los generos no se crean aquí
	 */
	private String nombresGeneros[];
	private String nombrePelicula; 

	public Pelicula(int pIdentificador, String pNombre, String pGenero, String pNombreDirector, float pCantVotos, float pVotosPromedio, String actor1,String actor2,String actor3,String actor4,String actor5)
	{
		identificador = pIdentificador; 
		nombresActores = new ArregloDinamico<String>(5);
		nombresActores.agregar(actor1);
		nombresActores.agregar(actor2);
		nombresActores.agregar(actor3);
		nombresActores.agregar(actor4);
		nombresActores.agregar(actor5);
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

	public ArregloDinamico<String> darListaNombresActores()
	{
		return nombresActores;
	}
	public String darGenero() {
		return genero;
	}
	@Override
	public int compareTo(Pelicula o) {
		return identificador - o.darIdentificador();
	}
}
