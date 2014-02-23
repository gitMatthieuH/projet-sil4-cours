package napp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;

import fr.iut2.sil4.data.Student;
import fr.iut2.sil4.data.StudentPeer;
import fr.iut2.sil4.data.User;
import fr.iut2.sil4.data.UserPeer;
import fr.iut2.sil4.data.Usergroup;


@SuppressWarnings("serial")
public class Controller  extends HttpServlet {
	
	private String urlNapp;
	private static final String TORQUE_PROPS = new String("/torque.properties");
	private List<Student> studentsList;
	
	public void init() throws ServletException {
		super.init();
		urlNapp = getServletConfig().getInitParameter("urlNapp");
		
		if (!Torque.isInit()) {
			try {
				PropertiesConfiguration pc = new PropertiesConfiguration();
				pc.load(this.getClass().getClassLoader().getResourceAsStream(TORQUE_PROPS));
				Torque.init(pc);

			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {

			/*if (StudentPeer.doSelectAll().size() == 0) {
				// Create Student
				Usergroup miam = new Usergroup();
				miam.setGroupName("miam");
				miam.save();
				
				
				Student addison = new Student();
				addison.setFirstname("matthieu");
				addison.setName("Hostache");
				addison.setAbsences(15);
				addison.setGroupId(miam.getGroupId());
				addison.
				addison.save();

			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// POST
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// on passe la main au GET
		doGet(request, response);
	}
	
	// GET
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		listStudents();
		request.setAttribute("listStudents", studentsList);
		
		

		
		// On récupère la méthode d'envoi de la requête
		String methode = request.getMethod().toLowerCase();
		
		// On récupère l'action à exécuter
		String action = request.getPathInfo();
		
		if (action == null) {
			action = "/napp";
			System.out.println("action == null");
		}
		
		switch (action) 
		{ 
		case "/connect": 
			try {
				doConnect(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break; 
		case "/deconnect": 
			request.getSession().removeAttribute("token");
			loadJSP("/napp1/accueil.jsp", request, response);
			break;
		case "/add_group": 
			try {
				addGroup(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/add_student": 
			try {
				addStudent(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break; 
		default: 
			System.out.println("token " + request.getSession().getAttribute("token"));
			if (null == request.getSession().getAttribute("token")) {
				System.out.println("not connected");
				loadJSP("/napp1/accueil.jsp", request, response);
			} else {
				System.out.println("connected " + "/napp1"+action+".jsp");
				loadJSP("/napp1"+action+".jsp", request, response);
			}
		}
	}
	
	/*private void doNapp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(urlNapp.toString());
		loadJSP(urlNapp, request, response);
	}*/
	
	private void doConnect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String username = request.getParameter("user");
		String passwd = request.getParameter("passwd");
		/*System.out.print("username : " + username);
		System.out.print("passwd : " + passwd);*/
		Boolean connectState =  UserPeer.doConnect(username, passwd);
		/*System.out.print("doConnect");
		System.out.print(connectState.toString());*/
		if (connectState) {
			request.getSession().setAttribute("token", username);
			System.out.println("username " + username);
			boolean isAdmin = false;
			try {
				isAdmin = UserPeer.isAdminisitrator(username);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (isAdmin) {
				loadJSP("/napp1/index_admin.jsp", request, response);
			} else {
				loadJSP("/napp1/index.jsp", request, response);
			}
		} else {
			loadJSP("/napp1/accueil.jsp", request, response);
		}
		
		
	}
	
	private void addStudent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Student new_student = new Student();
		new_student.setFirstname(request.getParameter("name"));
		new_student.setName(request.getParameter("firstname"));
		int group_id = Integer.parseInt(request.getParameter("groupid"));
		new_student.setGroupId(group_id);
		new_student.save();
		
		System.out.println("studentId " + new_student.getStudentId());
		
		User new_user = new User();
		new_user.setUserName(request.getParameter("username"));
		new_user.setPassword(request.getParameter("passwd"));
		new_user.setStudentId(new_student.getStudentId());
		new_user.save();
		
		
		loadJSP("/napp1/index_admin.jsp", request, response);
	}
	
	private void addGroup(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String group_name = request.getParameter("name");
		System.out.println("group_name " + group_name);
		Usergroup new_group = new Usergroup();
		new_group.setGroupName(group_name);
		new_group.save();
		
		loadJSP("/napp1/index_admin.jsp", request, response);
	}
	
	public void loadJSP(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	private void listStudents() {
		try {
			studentsList = StudentPeer.doSelectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
