package view;

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
			System.out.println("2. Encontrar buenas peliculas");
			System.out.println("3. Crear Ranking de peliculas");
			System.out.println("4. Conocer a un director");
			System.out.println("5. Conocer a un actor");
			System.out.println("6. Entender un género cinematográfico");
			System.out.println("7. Crear Ranking del genero");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
}
