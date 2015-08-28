

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bullhorn;
import customTools.DBUtil;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		//model.Bullhorn bull = new model.Bullhorn();
		model.Accinfo acc = new model.Accinfo();
		
		try {
			
			//String id = request.getParameter("id");
			//bull.setId(Integer.parseInt(id));
			//System.out.println("2");
			String username = request.getParameter("username");
			acc.setUsername(username);
			String password = request.getParameter("password");
			acc.setUsername(password);
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
		} 
			String q="select b from accInfo b where b.username= '" +username +"' and b.password = '" +password+ "'";

			TypedQuery<Bullhorn>bq =em.createQuery(q,Bullhorn.class);

			List<Bullhorn> list=bq.getResultList();

			for(Bullhorn temp:list)
			
			
		getServletContext().getRequestDispatcher("/post.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
