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

		while( !fin ){
			view.printMenu();
			int option = lector.nextInt();
			switch(option){
				
				case 1:
					view.printMessage("--------- \nCargar peliculas");
				    modelo = new Modelo();
				    modelo.cargarLista();
				    view.printMessage("--------- \nLista de peliculas cargada");
				    view.printMessage("--------- \nLa primera pelicula de la base de datos es: ");
				    modelo.ImprimirPelicula(0);
				    view.printMessage("--------- \nLa ultima pelicula de la base de datos es: ");
				    modelo.ImprimirPelicula(modelo.darTamano()-1);
				    view.printMessage("---------\nLa base de datos cuenta con " + modelo.darTamano() + " peliculas");						
					break;
				
				case 2:
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

				case 3:
					if(!modelo.darCarga()) {
						view.printMessage("No hay peliculas cargadas");
					}
					else {
						modelo.ShellSort();
					}
					break;
					
				case 4:
					view.printMessage("Hasta la proxima");
					lector.close();
					fin = true;
					break;
					
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
	}	
}
