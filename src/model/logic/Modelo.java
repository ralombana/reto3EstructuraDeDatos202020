package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import clases.Pelicula;
import clases.ShellSort;
import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.IListaEncadenada;
import model.data_structures.ListaEncadenada;
import model.data_structures.ListaEncadenada.Nodo;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	
	private ShellSort shellsort;
	
	private boolean hayPeliculas;
	/**
	 * Atributos del modelo del mundo
	 */
	private IListaEncadenada datos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		hayPeliculas = false;
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.contarDatos();
	}
	
	public boolean darCarga() {
		return hayPeliculas;
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.insert(dato);
	}
	
	public void cargarLista() {
		datos = new ListaEncadenada();
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
					Pelicula pelicula = new Pelicula((Integer.parseInt(valores[0])), ((String)valores[5]), valores[2], valores2[12], Float.parseFloat(valores[18]), Float.parseFloat(valores[17]),valores2[1],valores2[3],valores2[5],valores2[7],valores2[9]);
					((ListaEncadenada) datos).insert(pelicula);
				}
			} 
			hayPeliculas = true;
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
	
	public void cargarArreglo()
	{
		datos = new ArregloDinamico(10);
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
					agregada.ordenarActores();
					datos.agregarAlFinal(agregada);
				}
			} 
			hayPeliculas = true;
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
		for (int i=0;i<datos.contarDatos();i++) {
			Pelicula actual = (Pelicula) datos.darElemento(i);
			if (actual.darNombreDirector().equals(director) && actual.darVotosPromedio()>=6){
				ImprimirPelicula(i);
				peliculas.insert(actual);
				promedio += actual.darVotosPromedio();
			}
		}
		if (peliculas.contarDatos()>0) {
			float rta[] = new float[2];
			rta[0]=peliculas.contarDatos();
			rta[1]=promedio/rta[0];
			return rta;
		}
		else {
			return null;
		}
	}
	
	public void ShellSortCount(boolean tipo) {
		Comparable[] peliculas = datos.elementos();
		shellsort.sortCount(peliculas,datos.contarDatos(),tipo);
		for (short i=0;i<10;i++) {
			ImprimirPelicula((Pelicula)peliculas[i]);
		}
	}
	
	public void ShellSortAverage(boolean tipo) {
		Comparable[] peliculas = datos.elementos();
		shellsort.sortAverage(peliculas,datos.contarDatos(),tipo);
		for (short i=0;i<10;i++) {
			ImprimirPelicula((Pelicula)peliculas[i]);
		}
	}
	
	public void ImprimirPelicula(int index) {
		Pelicula aImprimir = (Pelicula) datos.darElemento(index);
		if (aImprimir != null) {
			System.out.println("----------");
			System.out.println("ID:"+aImprimir.darIdentificador());
			System.out.println("Nombre:"+aImprimir.darNombrePelicula());
			System.out.println("Votos:"+(int)aImprimir.darCantidadVotos());
			System.out.println("Promedio de Votacion:"+aImprimir.darVotosPromedio());
			System.out.println("Genero:"+aImprimir.darGenero());
			System.out.println("Actores:");
			String[] actores = aImprimir.darListaNombresActores();
			for (int i =0;i<5;i++) {
				System.out.println(actores[i]);
			}
		}
		else {
			System.out.println("Ocurrio un errror, revise que el indice dado sea menor al tamaño de la lista");
		}
	}
	
	public void ImprimirPelicula(Pelicula aImprimir) {
		if (aImprimir != null) {
			System.out.println("----------");
			System.out.println("ID:"+aImprimir.darIdentificador());
			System.out.println("Nombre:"+aImprimir.darNombrePelicula());
			System.out.println("Votos:"+(int)aImprimir.darCantidadVotos());
			System.out.println("Promedio de Votacion:"+aImprimir.darVotosPromedio());
			System.out.println("Genero:"+aImprimir.darGenero());
			System.out.println("Actores:");
			String[] actores = aImprimir.darListaNombresActores();
			for (int i =0;i<5;i++) {
				System.out.println(actores[i]);
			}
		}
		else {
			System.out.println("Ocurrio un errror, revise que el indice dado sea menor al tamaño de la lista");
		}
	}
	
	public void darPeliculasGenero(String genero)
	{
		ArregloDinamico<String> pelis = new ArregloDinamico<String>(1000);
		float promedio = 0; 
		
		for (int i = 0; i < datos.contarDatos(); i++) 
		{
			Pelicula act = (Pelicula) datos.darElemento(i);
			if(act.darGenero().equalsIgnoreCase(genero))
			{
				pelis.agregarAlFinal(act.darNombrePelicula());
				promedio += act.darVotosPromedio(); 
			}
		}
		promedio = promedio/pelis.contarDatos(); 
		System.out.println("----------");
		System.out.println("Hay " + pelis.contarDatos() + " películas de ese género");
		if (pelis.contarDatos()>0){
			System.out.println("Las películas de ese género son: ");
			for(int i=0;i<pelis.contarDatos();i++) {
				System.out.println(pelis.darElemento(i));	
			}
			System.out.println("----------");
			System.out.println("El promedio de votación en esas peliculas es de " + promedio);
		}
	}
	
	public void darPeliculasActor(String pActor)
	{
		ArregloDinamico<String> pelis = new ArregloDinamico<String>(10);
		ArregloDinamico<String> directores = new ArregloDinamico<String>(10);
		String directorMasRepetido = null; 
		int numeroDirectoMasRepetido = 0; 
		float promedio = 0; 
		
		for (int i = 0; i < datos.contarDatos(); i++) 
		{
			Pelicula act = (Pelicula) datos.darElemento(i); 
			if(act.estaElActorEnLista(pActor)==true)
			{
				pelis.agregarAlFinal(act.darNombrePelicula());
				directores.agregarAlFinal(act.darNombreDirector());
				promedio+= act.darVotosPromedio(); 
			}
		};
		
		for (int i = 0; i < directores.contarDatos(); i++) 
		{
			int cantidadDeVecesRepetido = 1; 
			for (int j = i+1; j < directores.contarDatos(); j++) 
			{
				if(directores.darElemento(i).equalsIgnoreCase(directores.darElemento(j)))
				{
					cantidadDeVecesRepetido++; 
				}
			}
			if(cantidadDeVecesRepetido> numeroDirectoMasRepetido)
			{
				numeroDirectoMasRepetido = cantidadDeVecesRepetido;
				directorMasRepetido = directores.darElemento(i);
			}
		} 
		
		
		if (pelis.contarDatos()>0){
			System.out.println("----------");
			System.out.println("La cantidad de peliculas en las que ha actuado es de " + pelis.contarDatos());
			System.out.println("Las películas en las que actua son: ");
			for(int i=0;i<pelis.contarDatos();i++) {
				System.out.println(pelis.darElemento(i));	
			}
			System.out.println("----------");
			System.out.println("El promedio de votación de las peliculas en las que actua es de " + promedio/pelis.contarDatos());
			System.out.println("El director con el qué se han hecho más colaboraciones es " + directorMasRepetido);
		}
		else {
			System.out.println("----------");
			System.out.println("La persona dada no ha actuado en ninguna pelicula");
		}
	}
	
	public void darPeliculasDirector(String pDirector) {
		ArregloDinamico<String> pelis = new ArregloDinamico<String>(10);
		float promedio = 0; 
		for (int i = 0; i < datos.contarDatos(); i++) 
		{
			Pelicula act = (Pelicula) datos.darElemento(i); 
			if(act.darNombreDirector().compareToIgnoreCase(pDirector)==0)
			{
				pelis.agregarAlFinal(act.darNombrePelicula());
				promedio+= act.darVotosPromedio(); 
			}
		}
		if (pelis.contarDatos()>0){
			System.out.println("----------");
			System.out.println("El director ha dirigido " + pelis.contarDatos()+ " peliculas.");
			System.out.println("Las películas que ha dirigido son: ");
			for(int i=0;i<pelis.contarDatos();i++) {
				System.out.println(pelis.darElemento(i));	
			}
			System.out.println("----------");
			System.out.println("El promedio de votación de las peliculas en las que ha dirigido es de " + promedio/pelis.contarDatos());
		}
		else {
			System.out.println("----------");
			System.out.println("La persona dada no ha dirigido ninguna pelicula");
		}
	}
}
