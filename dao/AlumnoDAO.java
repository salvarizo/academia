package edu.ucam.rmi.academia.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.ucam.rmi.academia.modelo.Alumno;

/**
 * 
 * @author Salva Rizo
 */

public class AlumnoDAO extends java.rmi.server.UnicastRemoteObject implements AlumnoDAOInterface {
	
	private static AlumnoDAO controlAlumno;
	private final ArrayList<Alumno> listAlumnos;

	private AlumnoDAO() throws RemoteException {
		super();
		listAlumnos = new ArrayList<>();
	}

	public static AlumnoDAO getInstancia() throws RemoteException {
		if (controlAlumno == null)
			controlAlumno = new AlumnoDAO();
		return controlAlumno;
	}

	public boolean add(Alumno alumno) throws java.rmi.RemoteException {
		if (get(alumno.getCodigo()) == null) {
			listAlumnos.add(alumno);
			return true;
		} else
			return false;
	}

	public boolean update(Alumno alumno) throws java.rmi.RemoteException {
		Alumno tempAlumno = get(alumno.getCodigo());
		if (tempAlumno == null)
			return false;
		else {
			tempAlumno.setNombre(alumno.getNombre());
			tempAlumno.setApellido(alumno.getApellido());
			return true;
		}
	}

	public boolean delete(Alumno alumno) throws java.rmi.RemoteException {
		return listAlumnos.remove(alumno);
	}

	public Alumno get(String codigo) throws java.rmi.RemoteException {
		Alumno alumno = null;
		for (Alumno temp : listAlumnos) {
			if (temp.getCodigo().equals(codigo))
				alumno = temp;
		}
		return alumno;
	}

	public int getCount() throws java.rmi.RemoteException {
		return listAlumnos.size();
	}

	public ArrayList<Alumno> getList() throws java.rmi.RemoteException {
		return listAlumnos;
	}
}
