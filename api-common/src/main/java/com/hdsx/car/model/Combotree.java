package com.hdsx.car.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * easy ui 的下拉树
 */
public class Combotree implements Serializable {
    //ID
    private String code;
    //资源名称
    private String text;
    //是否展开，open或closed
    private String state = "open";
    //父节点ID
    private String pid;
    //图标
    private String iconCls;
    //子节点
    private List<Combotree> children = new ArrayList<Combotree>();
    //附加属性（有什么需要都可以再下边这个类里边添加新的参数，记得要加备注哦）
    private Attributes attributes = new Attributes();
    //启用状态：后台管理 - 部门模块使用
    private String qyzt;
    //某节点下的子节点的数量（后台管理工料机 - 用于判断能不能“删除”）
    private int childNum;
    //车经度
    private String lon;
    //车纬度
    private String lat;

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Combotree() {
        super();
    }

	/*public Combotree(String id, String text) {
        super();
		this.id = id;
		this.text = text;
	}

	public Combotree(String id, String text, Attributes attributes) {
		super();
		this.id = id;
		this.text = text;
		this.attributes = attributes;
	}

	public Combotree(String id, String text, String pid) {
		super();
		this.id = id;
		this.text = text;
		this.pid = pid;
	}

	public Combotree(String id, String text, String pid, Attributes attributes) {
		super();
		this.id = id;
		this.text = text;
		this.pid = pid;
		this.attributes = attributes;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}*/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<Combotree> getChildren() {
        return children;
    }

    public void setChildren(List<Combotree> children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getQyzt() {
        return qyzt;
    }

    public void setQyzt(String qyzt) {
        this.qyzt = qyzt;
    }

    public int getChildNum() {
        return childNum;
    }

    public void setChildNum(int childNum) {
        this.childNum = childNum;
    }
}
