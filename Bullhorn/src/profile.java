

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
 * Servlet implementation class profile
 */
@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session1 = request.getSession();
		String username = request.getParameter("user");
		session1.setAttribute("u_name", username);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		model.Accinfo acc = new model.Accinfo();
	
		String message = "";
		String q="select a from Accinfo a where a.fName = '"+username+"'";
		System.out.println(""+q);
		TypedQuery<Accinfo>aq =em.createQuery(q,Accinfo.class);
		System.out.println(""+aq);
		List<Accinfo> list1=aq.getResultList();
		System.out.println("query reult:"+aq.getResultList());
		for(Accinfo temp:list1)
		{	
			message= "<div class=\"container\"><table class=\"table table-striped\"><thead><tr><th>Name</th><th>Moto</th><th>Join Date</th></tr></thead><tbody>";
			message+="<tr><td>"+temp.getFName()+"</td><td>"+temp.getMoto()+"</td><td>"+temp.getDates()+"</td></tr>";
			message+= "</tbody> </table></div>";
		
		}
		
		
		
		model.Bullhorn bull = new model.Bullhorn();
		 q="select b from Bullhorn b where b.username= '"+username+"'";

		TypedQuery<Bullhorn>bq =em.createQuery(q,Bullhorn.class);

		List<Bullhorn> list=bq.getResultList();
		String posts= "<div class=\"container\"><table class=\"table table-striped\"><thead><tr><th>Posts</th></tr></thead><tbody>";
		for(Bullhorn temp:list)
		{	
		if(temp.getPost() != null)
		{
			posts += "<tr><td>"+temp.getPost()+"</td></tr>\n";
		}
		}
		posts+= "</tbody> </table></div>";
			response.setContentType("text/html");
			request.setAttribute("profile", message);
		request.setAttribute("posts", posts);
			getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
