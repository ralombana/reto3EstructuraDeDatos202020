package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("----------");
			System.out.println("1. Cargar lista de peliculas");
			System.out.println("2. Encontrar peliculas buenas");
			System.out.println("3. Salir");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
}
