

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
import javax.servlet.http.HttpSession;

import model.Accinfo;
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
		
	//	username = request.getParameter("username");
		String[] strs = new String[2];
		String table = "";
		
		
		
		
		
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		model.Accinfo acc = new model.Accinfo();
		String username = "";
		String password = "";
		String message = "";
		HttpSession session = request.getSession();

			//String id = request.getParameter("id");
			//bull.setId(Integer.parseInt(id));
			//System.out.println("2");
			username = request.getParameter("username"); 
			password = request.getParameter("password");
//			acc.setUsername(password);
			session.setAttribute("username", username);
			String q="select a from Accinfo a where a.fName = '"+username+"'";
			System.out.println(""+q);
			TypedQuery<Accinfo>aq =em.createQuery(q,Accinfo.class);
			System.out.println(""+aq);
			List<Accinfo> list1=aq.getResultList();
			System.out.println("query reult:"+aq.getResultList());
			if (list1 == null || list1.isEmpty())
			{
				message = "Incorrect username or password";
				response.setContentType("text/html");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
			}
			else	
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
