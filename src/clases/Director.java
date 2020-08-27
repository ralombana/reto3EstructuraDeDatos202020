package clases;

import java.util.ArrayList;

import model.data_structures.ArregloDinamico;

public class Director
{
	private ArrayList<Pelicula> susPeliculas;
	private int cantidadPeliculas;
	private float promedioPeliculas;
	
	public Director(ArrayList<Pelicula> pListaPeliculas)
	{
		cantidadPeliculas = pListaPeliculas.size();
		for (int i = 0; i < pListaPeliculas.size(); i++) 
		{
			Pelicula act = pListaPeliculas.get(i);
			act.darVotosPromedio();
		}
	}
	
	
}
