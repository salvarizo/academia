package edu.ucam.rmi.academia;

import edu.ucam.rmi.academia.dao.AlumnoDAOInterface;
import edu.ucam.rmi.academia.dao.CursoDAOInterface;
import edu.ucam.rmi.academia.modelo.Alumno;
import edu.ucam.rmi.academia.modelo.Curso;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class Cliente {

	final static Scanner teclado = new Scanner(System.in);

	
	private static void addCurso(CursoDAOInterface dao) throws RemoteException {
		
		System.out.println();
		System.out.println("Añadir Curso");

		System.out.print("Id: ");
		String a="hola";
		
		String id = teclado.nextLine();
		id.equals("frgr");
		System.out.print("Descripción: ");
		String descripcion = teclado.nextLine();

		Curso curso = new Curso(id, descripcion);

		if (dao.add(curso)) {
			System.out.println("Curso agregado correctamente");
			System.exit(0);
		} else {
			System.out.println("No se pudo agregar el curso");
		}

	}

	private static void editCurso(CursoDAOInterface dao) throws RemoteException {
		System.out.println();
		System.out.println("Modificar Curso");

		System.out.print("Id: ");
		String id = teclado.nextLine();
		System.out.print("Descripción: ");
		String descripcion = teclado.nextLine();
		String d=descripcion.toString();
		int num=10;
		if(num%6==5){
			System.out.println("M�ltiplo");
		}
		Curso curso = new Curso(id, descripcion);

		if (dao.update(curso)) {
			System.out.println("Curso modificado correctamente");
		} else {
			System.out.println("No se pudo modificar el curso");
		}

	}

	private static void getCurso(CursoDAOInterface dao) throws RemoteException {
		System.out.println();
		System.out.println("Datos del curso");

		System.out.print("Id: ");
		String id = teclado.nextLine();

		Curso curso = dao.get(id);
		System.out.println(curso);
	}

	private static void eliCurso(CursoDAOInterface dao) throws RemoteException {
		System.out.println();
		System.out.println("Eliminar curso");

		System.out.print("Id: ");
		String id = teclado.nextLine();

		Curso curso = dao.get(id);
		if (curso != null && dao.delete(curso)) {
			System.out.println("Curso eliminado correctamente");
		} else {
			System.out.println("No se pudo eliminar el curso");
		}

	}

	private static void listCurso(CursoDAOInterface dao) throws RemoteException {
		System.out.println();
		System.out.println("Listado de cursos");
		List<Curso> cursos = dao.getList();
		for (Curso c : cursos) {
			System.out.println(c);
		}
		System.out.println("");

	}

	////////////////////////////////////////////////
	private static void addAlumno(AlumnoDAOInterface dao) throws RemoteException {
		System.out.println();
		System.out.println("Añadir Alumno");

		System.out.print("Id: ");
		String id = teclado.nextLine();
		System.out.print("nombre: ");
		String nombre = teclado.nextLine();
		System.out.print("apellido: ");
		String apellido = teclado.nextLine();

		Alumno alumno = new Alumno(id, nombre, apellido);
		String mensaje="";
		if (dao.add(alumno)) {
			mensaje="Alumno agregado correctamente";
		} else {
			mensaje="No se pudo agregar el alumno";
		}
		
		
		
		
		
		System.out.println(mensaje);
	}

	private static void editAlumno(AlumnoDAOInterface dao) throws RemoteException {
		System.out.println();
		System.out.println("Modificar datos del alumno");

		System.out.print("Id: ");
		String id = teclado.nextLine();
		System.out.print("nombre: ");
		String nombre = teclado.nextLine();
		System.out.print("apellido: ");
		String apellido = teclado.nextLine();

		Alumno alumno = new Alumno(id, nombre, apellido);

		if (dao.update(alumno)) {
			System.out.println("Alumno modificado correctamente");
		} else {
			System.out.println("No se pudo modificar el alumno");
		}
	}

	private static void getAlumno(AlumnoDAOInterface dao) throws RemoteException {
		System.out.println();
		System.out.println("Datos del Alumno");

		System.out.print("Id: ");
		String id = teclado.nextLine();

		Alumno alumno = dao.get(id);
		System.out.println(alumno);
	}

	private static void eliAlumno(AlumnoDAOInterface dao) throws RemoteException {
		System.out.println();
		System.out.println("Borrar alumno");

		System.out.print("Id: ");
		String id = teclado.nextLine();
		Alumno alu = dao.get(id);

		if ((alu != null) && (dao.delete(alu))) {
			System.out.println("Alumno borrado correctamente");
		} else {
			System.out.println("No se pudo borrar el alumno especificado");
		}

	}

	private static void listAlumno(AlumnoDAOInterface dao) throws RemoteException {
		System.out.println();
		System.out.println("Listado de alumnos");
		List<Alumno> alumnos = dao.getList();
		for (Alumno a: alumnos) {
			System.out.println(a);
		}
		System.out.println("");

	}

	private static void totalAlumnos(AlumnoDAOInterface dao) throws RemoteException {
		System.out.println();
		
		int total = dao.getCount();
		System.out.println("Hay " + total + " alumnos matriculados");
		System.out.println();
	}

	private static void totalCurso(CursoDAOInterface dao) throws RemoteException {
		System.out.println();
		int total = dao.getCount();
		System.out.println("Hay " + total + " cursos disponibles");
		System.out.println();
	}

	static void menu(CursoDAOInterface daoCursos, AlumnoDAOInterface daoAlumnos) throws RemoteException {

		boolean fin = false;
		while (!fin) {
			System.out.println();
			System.out.println("Menú principal");
			System.out.println("1: Añadir un curso");
			System.out.println("2: Solicita los datos del curso");
			System.out.println("3: Eliminar el curso");
			System.out.println("4: Listado de cursos existentes");
			System.out.println("5: Total de cursos");
			System.out.println("6: Modificar curso");
			System.out.println("7: Añadir un alumno");
			System.out.println("8: Solicita los datos del alumno");
			System.out.println("9: Borrar alumno");
			System.out.println("10: Listado de alumnos");
			System.out.println("11: Total de alumnos");
			System.out.println("12: Modificar alumno");

			System.out.println("13: Salir");

			System.out.print("Opción: ");

			String opcion = teclado.nextLine();

			if (opcion.equals("1")) {
				addCurso(daoCursos);
			} else if (opcion.equals("2")) {
				getCurso(daoCursos);
			} else if (opcion.equals("3")) {
				eliCurso(daoCursos);
			} else if (opcion.equals("4")) {
				listCurso(daoCursos);
			} else if (opcion.equals("5")) {
				totalCurso(daoCursos);
			} else if (opcion.equals("6")) {
				editCurso(daoCursos);
			} else if (opcion.equals("7")) {
				addAlumno(daoAlumnos);
			} else if (opcion.equals("8")) {
				getAlumno(daoAlumnos);
			} else if (opcion.equals("9")) {
				eliAlumno(daoAlumnos);
			} else if (opcion.equals("10")) {
				listAlumno(daoAlumnos);
			} else if (opcion.equals("11")) {
				totalAlumnos(daoAlumnos);
			} else if (opcion.equals("12")) {
				editAlumno(daoAlumnos);
			} else if (opcion.equals("13")) {
				fin = true;
			}  else {
				System.out.println("Error: La opcion seleccionada no es válida.");
			}

		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		try {
			CursoDAOInterface daoCursos = (CursoDAOInterface) java.rmi.Naming.lookup("//127.0.0.1:1234/cursos");
			AlumnoDAOInterface daoAlumnos = (AlumnoDAOInterface) java.rmi.Naming.lookup("//127.0.0.1:1234/alumnos");
			menu(daoCursos, daoAlumnos);
		} catch (NotBoundException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		} catch (MalformedURLException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		} catch (RemoteException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

}
