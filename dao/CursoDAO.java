
package edu.ucam.rmi.academia.dao;

import edu.ucam.rmi.academia.modelo.Curso;
import java.util.ArrayList;

public class CursoDAO extends java.rmi.server.UnicastRemoteObject implements CursoDAOInterface
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static CursoDAO controlCurso = null;
    private final ArrayList<Curso> listCursos;   
    
    private CursoDAO() throws java.rmi.RemoteException
    {
        super();
        listCursos = new ArrayList<>();
    }
    
    public static CursoDAO getInstancia() throws java.rmi.RemoteException
    {
        if (controlCurso == null)
            controlCurso = new CursoDAO();
        return controlCurso;
    }
    
    @Override
    public boolean add(Curso curso) throws java.rmi.RemoteException
    {
        if (get(curso.getId()) == null)
        {
            listCursos.add(curso);
            return true;
        }
        else
            return false;
    }
    
    @Override
    public boolean update(Curso curso) throws java.rmi.RemoteException
    {
        Curso tempCurso = get(curso.getId());
        if (tempCurso == null)
            return false;
        else
        {
            tempCurso.setDescripcion(curso.getDescripcion());
            return true;
        }
    }
    
    @Override
    public boolean delete(Curso curso) throws java.rmi.RemoteException
    {
        return listCursos.remove(curso);
    }
    
    @Override
    public Curso get(String id) throws java.rmi.RemoteException
    {
        Curso curso = null;
    for (Curso temp : listCursos) { 
      if (temp.getId().equals(id)) {
        curso = temp; 
      }
    }
    return curso;
    }
    
    /**
     *
     * @return
     * @throws java.rmi.RemoteException
     */
    @Override
    public int getCount() throws java.rmi.RemoteException
    {
        return listCursos.size();
    }
    
    /**
     *
     * @return
     * @throws java.rmi.RemoteException
     */
    @Override
    public ArrayList<Curso> getList() throws java.rmi.RemoteException
    {
        return listCursos;
    }    
}
