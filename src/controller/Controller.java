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
				    modelo.cargarListas();
				    view.printMessage("--------- \nLista de peliculas cargada");
				    view.printMessage("--------- \nLa primera pelicula de la base de datos es: ");
				    modelo.ImprimirPelicula(0);
				    view.printMessage("--------- \nLa ultima pelicula de la base de datos es: ");
				    modelo.ImprimirPelicula(modelo.darTamano()-1);
				    view.printMessage("La base de datos cuenta con " + modelo.darTamano() + " peliculas\n---------");						
					break;

				case 2:
					view.printMessage("--------- \nIngresar nombre del director: ");
					String nombre = lector.next();
					view.printMessage("--------- \nIngresar apellido del director: ");
					String apellido = lector.next();
					float rta[] = modelo.buscarPeliculasBuenas(nombre+" "+apellido);
					if (rta != null) {
						view.printMessage("---------\nEl director tiene asosciadas "+(int)rta[0]+" peliculas con buena calificacion");
						view.printMessage("---------\nEl promedio del director es de "+rta[1]);						
					}
					else {
						view.printMessage("----------\nNo se encontro registro del director dado");
					}
					break;
					
				case 3:
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
