package edu.ucam.rmi.academia.dao;

import java.util.ArrayList;

import edu.ucam.rmi.academia.modelo.Alumno;



public interface AlumnoDAOInterface extends java.rmi.Remote {

  public boolean add(Alumno alumno) throws java.rmi.RemoteException;

  public boolean update(Alumno alumno) throws java.rmi.RemoteException;

  public boolean delete(Alumno alumno) throws java.rmi.RemoteException;

  public Alumno get(String codigo) throws java.rmi.RemoteException;

  public int getCount() throws java.rmi.RemoteException;

  public ArrayList<Alumno> getList() throws java.rmi.RemoteException;
	

}
