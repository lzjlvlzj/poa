package org.lzj.poa.web.action;

import java.util.Date;
import java.util.List;

import org.lzj.poa.entity.Department;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4332492385285325147L;
	private int parentId;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String list() {
		//List<Department> list = departmentServiceImpl.findAll();
		Department parent = departmentServiceImpl.findById(parentId);
		List<Department> list = departmentServiceImpl.findSub(parent);
		ActionContext.getContext().put("deptList", list);
		return "list";
	}

	public String delete() {
		departmentServiceImpl.delete(model);
		return "toList";
	}

	/** 添加页面 */
	public String addUI() {
		//get all departments
		List<Department> list = departmentServiceImpl.findAll();
		ActionContext.getContext().put("deptList", list);
		return "saveUI";
	}

	/** 添加 */
	public String add() {
		//取得上级部门id,并根据id查询出上级部门
		Department dept = departmentServiceImpl.findById(parentId);
		model.setParent(dept);
		Date date = new Date();
		model.setCreateTime(date);
		departmentServiceImpl.save(model);
		return "toList";
	}

	/** 修改页面 */
	public String editUI() {
		//查询要修改的数据的数据
		Department dept = departmentServiceImpl.findById(model.getDeptId());
		ActionContext.getContext().getValueStack().push(dept);
		//查询部门
		List<Department> list = departmentServiceImpl.findAll();
		ActionContext.getContext().put("deptList", list);
		//回显所在部门
		if(null != dept.getParent()){//如果存在上级部门
			parentId = dept.getParent().getDeptId();
		}
		return "saveUI";
	}

	/** 修改 */
	public String edit() {
		Department dept = departmentServiceImpl.findById(model.getDeptId());
		if(null != dept){
			encapsulateDepartment(dept);
			
			departmentServiceImpl.update(dept);
		}
		return "toList";
	}

	private void encapsulateDepartment(Department dept) {
		dept.setDeptName(model.getDeptName());
		dept.setDeptValue(model.getDeptValue());
		dept.setDescription(model.getDescription());
		dept.setCreateTime(new Date());
		
		//set parentId dept.setParent(model.getParent());
		Department parent = new Department();
		parent.setDeptId(parentId);
		dept.setParent(parent);
		//TODO set childern
		//TODO set User
		
	}

}
