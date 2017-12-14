package es.altair.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.omg.CORBA.PRIVATE_MEMBER;

import es.altair.bean.Usuario;
import es.altair.util.SessionProvider;

public class UsuarioDAOImplHibernate implements UsuarioDAO {

	private String pass = "libros123$%";

	public Usuario comprobarUsuario(String login, String password) {
		
		
		Usuario usu = null;
		
		Session sesion = SessionProvider.getSession();
		
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();

		//Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			usu = (Usuario) sesion.createQuery("select u from Usuario u "
					+ "where login=:l and password=:AES ENCRYPT(p, :passphrase)")
					.setParameter("l", login)
					.setParameter("p", password).uniqueResult();
			
			sesion.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			//sf.close();
		}
		
			
		return usu;
	}

}
