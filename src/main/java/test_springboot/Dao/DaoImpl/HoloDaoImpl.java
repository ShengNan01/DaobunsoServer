//package test_springboot.Dao.DaoImpl;
//
//import java.util.List;
//
//import javax.websocket.Session;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import test_springboot.Holo;
//import test_springboot.Holo_interface;
//import test_springboot.Dao.HoloDao;
//@Repository
//public class HoloDaoImpl implements HoloDao{
//	SessionFactory factory;
//	
//	@Autowired
//	public HoloDaoImpl(SessionFactory factory) {
//		this.factory = factory;
//	}
//	@Override
//	public List<Holo> getallHolos() {
//		
//		Session session = factory.getCurrentSession();
//		String hql = "FROM Holo";
//		List<Holo> list session.createQuery(hql,Holo.class).getResultList();
//		
//		return list;
//	}
//
//}
