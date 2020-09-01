package clases;

public class ShellSort {

	public static void sort(Comparable[] array,int tamano) {
		int salto, i;
		Comparable aux;
        boolean cambios;
  
        for (salto = tamano / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento                                         
                cambios = false;
                for (i = salto; i < tamano; i++)   // se da una pasada
                {
                    if (array[i - salto].compareTo(array[i])>0) {       // y si están desordenados
                        aux = array[i];                  // se reordenan
                        array[i] = array[i - salto];
                        array[i - salto] = aux;
                        cambios = true;  
                    }
                }
            }
        }
	}
}
