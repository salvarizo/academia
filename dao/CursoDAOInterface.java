
package edu.ucam.rmi.academia.dao;

import edu.ucam.rmi.academia.modelo.Curso;
import java.util.ArrayList;

public interface CursoDAOInterface extends java.rmi.Remote {

    public boolean add(Curso curso) throws java.rmi.RemoteException;

    public boolean update(Curso curso) throws java.rmi.RemoteException;

    public boolean delete(Curso curso) throws java.rmi.RemoteException;

    public Curso get(String id) throws java.rmi.RemoteException;

    public int getCount() throws java.rmi.RemoteException;

    public ArrayList<Curso> getList() throws java.rmi.RemoteException;
}
