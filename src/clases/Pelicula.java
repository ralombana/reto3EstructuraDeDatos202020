package clases;

public class Pelicula implements Comparable<Pelicula>
{
	private float votosPromedio;
	private int identificador;
	private String nombreDirector;
	private float cantidadVotos;
	private String[] actores;
	private String genero;
	/**
	 * Creo que los generos no se crean aquÃ­
	 */
	private String nombrePelicula; 

	public Pelicula(int pIdentificador, String pNombre, String pGenero, String pNombreDirector, float pCantVotos, float pVotosPromedio, String actor1,String actor2,String actor3,String actor4,String actor5)
	{
		identificador = pIdentificador; 
		actores = new String[5];
		actores[0] = actor1;
		actores[1] = actor2;
		actores[2] = actor3;
		actores[3] = actor4;
		actores[4] = actor5;
		ordenarActores();
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

	public String[] darListaNombresActores()
	{
		return actores;
	}
	
	public String darGenero() {
		return genero;
	}
	
	public int compareTo(Pelicula o) {
		return (int) (votosPromedio - o.darVotosPromedio());
	}
	
	public void ordenarActores() {
		int salto, i;
		String aux;
        boolean cambios;
  
        for (salto = (int)actores.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento                                         
                cambios = false;
                for (i = salto; i < actores.length; i++)   // se da una pasada
                {
                    if (actores[i - salto].compareTo(actores[i])>0) {       // y si están desordenados
                        aux = actores[i];                  // se reordenan
                        actores[i] = actores[i - salto];
                        actores[i - salto] = aux;
                        cambios = true;  
                    }
                }
            }
        }
	}
	
	public boolean estaElActorEnLista(String actor)
	{
		String actual = actores[0];
		for (int i=1;actor.compareTo(actual)>=0 && i < actores.length;i++)
		{
			if (actual.compareToIgnoreCase(actor)==0) {
				return true;
			}
			actual = actores[i];
		}
		return false; 
	}
}
