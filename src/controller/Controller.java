package controller;

import java.util.Scanner;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		try {
			while( !fin ){
				view.printMenu();
				int option = lector.nextInt();
				switch(option){

				case 1:
					view.printMessage("--------- \nCargar peliculas");
					modelo = new Modelo();
					modelo.cargarArreglo();
					view.printMessage("--------- \nLista de peliculas cargada");
					view.printMessage("--------- \nLa primera pelicula de la base de datos es: ");
					modelo.ImprimirPelicula(0);
					view.printMessage("--------- \nLa ultima pelicula de la base de datos es: ");
					modelo.ImprimirPelicula(modelo.darTamano()-1);
					view.printMessage("---------\nLa base de datos cuenta con " + modelo.darTamano() + " peliculas");						
					break;

				case 2:
					if(!modelo.darCarga()) {
						view.printMessage("No hay peliculas cargadas, por favor cargar las peliculas");
					}
					else {
						view.printMessage("--------- \nEscriba el nombre del director en el que esta interesado");
						String nombreDirector = lector.next(); 
						String apellidoDirector = lector.next(); 
						view.printMessage("Buscando peliuclas de buena calificacion dirigidas por " + nombreDirector + " " + apellidoDirector);
						float[] rta = modelo.buscarPeliculasBuenas(nombreDirector + " " + apellidoDirector);
						if (rta==null) {
							view.printMessage("--------- \nNo hay peliculas dirigidas por la persona dada");
						}
						else {
							view.printMessage("--------- \nEl director posee "+ (int) rta[0] + " peliculas con buena calificacion");
							view.printMessage("--------- \nSu promedio de calificacion es de "+ rta[1]);
						}
					}
					break;

				case 3:
					if(!modelo.darCarga()) {
						view.printMessage("No hay peliculas cargadas, por favor cargar las peliculas");
					}
					else {
						view.printMessage("--------- \nEscriba el tipo de ranking que desea");
						view.printMessage("1. Peliculas mas votadas");
						view.printMessage("2. Peliculas menos votadas");
						view.printMessage("3. Peliculas mejor calificadas");
						view.printMessage("4. Peliculas peor calificadas");
						short ranking = lector.nextShort();
						switch(ranking) {
							case 1:
								
								break;
							case 2:
								
								break;
							case 3:
	
								break;
							case 4:
	
								break;
						}
					}
					break;

				case 4:

					break;

				case 5:
					if(!modelo.darCarga()) {
						view.printMessage("No hay peliculas cargadas");
					}
					else {
						view.printMessage("--------- \nEscriba el nombre del actor que desea conocer");
						String nombreActor = lector.next(); 
						String apellidoActor = lector.next(); 
						view.printMessage("El actor que quieres conocer es " + nombreActor + " " + apellidoActor);
						modelo.darPeliculasActor(nombreActor + " " + apellidoActor);	
					}
					break;

				case 6:
					if(!modelo.darCarga()) {
						view.printMessage("No hay peliculas cargadas");
					}
					else {
						view.printMessage("--------- \nEscriba el nombre del género que desea conocer ");
						String nombreGenero = lector.next(); 
						view.printMessage("El género que quieres conocer es " + nombreGenero );
						modelo.darPeliculasGenero(nombreGenero);	
						break;
					}

					break;

				case 7:

					break;

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
				}
			}
		}
		catch(Exception e) {
			view.printMessage("--------- \n Opcion Invalida !! \n---------");
			run();
		}
	}
}
