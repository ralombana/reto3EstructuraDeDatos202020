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
			System.out.println("1. Cargar archivo de accidentes");
			System.out.println("2. Buscar accidentes por fecha");
				
		}
		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
}
