package com.yinlong.web;import java.io.IOException;import java.io.PrintWriter;import java.util.ArrayList;import java.util.List;import javax.annotation.Resource;import javax.servlet.http.HttpServletResponse;import org.apache.struts2.ServletActionContext;import org.json.JSONArray;import org.json.JSONObject;import org.springframework.context.annotation.Scope;import org.springframework.stereotype.Controller;import com.opensymphony.xwork2.ActionContext;import com.yinlong.entity.*;import com.yinlong.service.IUserService;import com.yinlong.util.LayuiTableData;@Controller("userAction")@Scope("prototype")public class UserAction {		@Resource(name = "userService")	private IUserService userService;		private User user;	private Company company;	private Department department;	private Section section;		private List list;	private List<User> userList;	private List<Role> roleList;		//layui table 分页 默认传入的2个参数	private int page;	// 页码	private int limit;	// 数量	private String errorInfo;		/**	 * 用户登录	 * @return	 */	public String userLogin() {		roleList = userService.userLogin(user);		if(roleList != null) {			//成功则获取该用户拥有的角色			ActionContext.getContext().getSession().put("user_role", roleList);			if (ActionContext.getContext().getSession().get("login_lose") != null) {				ActionContext.getContext().getSession().remove("login_lose");			}			return "index";		}		ActionContext.getContext().getSession().put("login_lose", "用户名或密码错误");		return "login";	}		/**	 * 添加用户	 * @return	 */	public String addUser() {		user.setSection(section);		if(userService.addUser(user)) {			errorInfo = "添加用户成功";		}		errorInfo = "添加用户失败";		return "add";	}		/**	 * 查询所有用户信息	 * @return	 */	public String findUserList() {		userList = userService.findUserList();		return "findUserList";	}		/**	 * 查询所有用户和它的角色	 * @return	 */	public String findUserAndRoleList() {		list = userService.findUserAndRoleList();		return "findUserAndRoleList";	}		/**	 * 根据用户查询该用户的角色	 * @return	 */	public String findUserAndROleByUserList() {		list = new ArrayList();		userList = userService.findUserList();		for (User user : userList) {			List l = new ArrayList();			l.add(user);			l.add(userService.findUserAndRoleByUserList(user));			list.add(l);		}		return "findUserAndROleByUserList";	}		/**	 * 科举科室ID查询该科室的所有员工	 * @return	 */	public String findUserBySectId() {		userList = userService.findUserBySectId(section);		return "findUserBySectId";	}		/**	 * layui table 表格所需数据	 * @param code		 * @param msg		 * @param count	数据总数	 * @param list		 * @throws IOException	 */	public void layuiTableUserList(int code, String msg, int count, List<User> userList) throws IOException {		JSONObject jsonObj = new JSONObject();				jsonObj.put("code", code);    		jsonObj.put("msg", msg);    		jsonObj.put("count", count);    		jsonObj.put("data",userList);    		        HttpServletResponse response = ServletActionContext.getResponse();        response.setContentType("text/json; charset=utf-8");        PrintWriter out = response.getWriter();        out.println(jsonObj.toString());        out.close();	}		/**	 * 分页查询所有员工	 * @throws IOException	 */	public void findUseListLayui() throws IOException {		userList = userService.findUserList(page, limit);		int count = userService.findUserListCount();		LayuiTableData.layuiTableUserList(0, "", count, userList);	}		/**	 * 根据科室ID查询该科室的所有员工	 * 适配sayui table 的接受数据	 * strtus2 返回的数据使用会以变量名做数据头，所以不能用strtus2返回数据	 * @return	 * @throws IOException 	 */	public void findUserBySectIdLayui() throws IOException {		userList = userService.findUserBySectId(section);		int count = userService.findUserListCount();		LayuiTableData.layuiTableUserList(0, "", count, userList);	}		/**	 * 用户信息模糊查询	 * @return	 * @throws IOException 	 */	public void findUserListLike() throws IOException {		if(user == null) { 			System.out.println("user");			user = new User(); }		if(section == null) { section = new Section(); }		if(department == null) {department = new Department(); }		if(company == null) { company = new Company(); }		userList = userService.findUserListLike(user, section, department, company);		int count = userList.size();		LayuiTableData.layuiTableUserList(0, "", count, userList);	}		public User getUser() {		return user;	}	public void setUser(User user) {		this.user = user;	}		public Company getCompany() {		return company;	}	public void setCompany(Company company) {		this.company = company;	}	public Department getDepartment() {		return department;	}	public void setDepartment(Department department) {		this.department = department;	}	public List getList() {		return list;	}	public void setList(List list) {		this.list = list;	}	public List<Role> getRoleList() {		return roleList;	}	public void setRoleList(List<Role> roleList) {		this.roleList = roleList;	}	public void setUserService(IUserService userService) {		this.userService = userService;	}	public List<User> getUserList() {		return userList;	}	public void setUserList(List<User> userList) {		this.userList = userList;	}	public String getErrorInfo() {		return errorInfo;	}	public void setErrorInfo(String errorInfo) {		this.errorInfo = errorInfo;	}	public Section getSection() {		return section;	}	public void setSection(Section section) {		this.section = section;	}	public int getPage() {		return page;	}	public void setPage(int page) {		this.page = page;	}	public int getLimit() {		return limit;	}	public void setLimit(int limit) {		this.limit = limit;	}	}