package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import clases.Pelicula;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico<Pelicula>(10);
	}
	
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico<Pelicula>(capacidad);
	}
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}
	
	public void cargarListas()
	{
		String archivo = "./data/SmallMoviesDetailsCleaned.csv";
		String archivo2 = "./data/MoviesCastingRaw-small.csv";
		String linea = "";
		String linea2 = "";
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			br.readLine();
			BufferedReader br2 = new BufferedReader(new FileReader(archivo2));
			br2.readLine();
			while((linea = br.readLine()) !=null && (linea2 = br2.readLine()) !=null)
			{
				String[] valores = linea.split(";");
				String[] valores2 = linea2.split(";"); 
				if(valores[0].equals(valores2[0]))
				{
					Pelicula agregada = new Pelicula((Integer.parseInt(valores[0])), ((String)valores[5]), valores[2], valores2[12], Float.parseFloat(valores[18]), Float.parseFloat(valores[17]),valores2[1],valores2[3],valores2[5],valores2[7],valores2[9]);
					datos.agregarAlFinal(agregada);
				}
			} 
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public float[] buscarPeliculasBuenas(String director) {
		int promedio = 0;
		ArregloDinamico<Pelicula> peliculas = new ArregloDinamico<Pelicula>(10);
		for (int i=0;i<datos.darTamano();i++) {
			Pelicula actual = (Pelicula) datos.darElemento(i);
			if (actual.darNombreDirector().equals(director) && actual.darVotosPromedio()>=6){
				ImprimirPelicula(i);
				peliculas.agregar(actual);
				promedio += actual.darVotosPromedio();
			}
		}
		if (peliculas.darTamano()!=0) {
			float rta[] = new float[2];
			rta[0]=peliculas.darTamano();
			rta[1]=promedio/rta[0];
			return rta;
		}
		else {
			return null;
		}
	}
	
	public void ImprimirPelicula(int index) {
		Pelicula aImprimir = (Pelicula) datos.darElemento(index);
		System.out.println("----------");
		System.out.println("Nombre:"+aImprimir.darNombrePelicula());
		System.out.println("Genero:"+aImprimir.darGenero());
		System.out.println("Director:"+aImprimir.darNombreDirector());
	}
}
