package com.entity.model;

import com.entity.GongzixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 工资信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2020-12-30 11:01:17
 */
public class GongzixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 工号
	 */
	
	private String gonghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 基本工资
	 */
	
	private Integer jibengongzi;
		
	/**
	 * 加班工资
	 */
	
	private Integer jiabangongzi;
		
	/**
	 * 补贴
	 */
	
	private Integer butie;
		
	/**
	 * 社保
	 */
	
	private Integer shebao;
		
	/**
	 * 伙食
	 */
	
	private Integer huoshi;
		
	/**
	 * 其他扣费
	 */
	
	private Integer qitakoufei;
		
	/**
	 * 实发工资
	 */
	
	private Integer shifagongzi;
		
	/**
	 * 日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date riqi;
				
	
	/**
	 * 设置：工号
	 */
	 
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：基本工资
	 */
	 
	public void setJibengongzi(Integer jibengongzi) {
		this.jibengongzi = jibengongzi;
	}
	
	/**
	 * 获取：基本工资
	 */
	public Integer getJibengongzi() {
		return jibengongzi;
	}
				
	
	/**
	 * 设置：加班工资
	 */
	 
	public void setJiabangongzi(Integer jiabangongzi) {
		this.jiabangongzi = jiabangongzi;
	}
	
	/**
	 * 获取：加班工资
	 */
	public Integer getJiabangongzi() {
		return jiabangongzi;
	}
				
	
	/**
	 * 设置：补贴
	 */
	 
	public void setButie(Integer butie) {
		this.butie = butie;
	}
	
	/**
	 * 获取：补贴
	 */
	public Integer getButie() {
		return butie;
	}
				
	
	/**
	 * 设置：社保
	 */
	 
	public void setShebao(Integer shebao) {
		this.shebao = shebao;
	}
	
	/**
	 * 获取：社保
	 */
	public Integer getShebao() {
		return shebao;
	}
				
	
	/**
	 * 设置：伙食
	 */
	 
	public void setHuoshi(Integer huoshi) {
		this.huoshi = huoshi;
	}
	
	/**
	 * 获取：伙食
	 */
	public Integer getHuoshi() {
		return huoshi;
	}
				
	
	/**
	 * 设置：其他扣费
	 */
	 
	public void setQitakoufei(Integer qitakoufei) {
		this.qitakoufei = qitakoufei;
	}
	
	/**
	 * 获取：其他扣费
	 */
	public Integer getQitakoufei() {
		return qitakoufei;
	}
				
	
	/**
	 * 设置：实发工资
	 */
	 
	public void setShifagongzi(Integer shifagongzi) {
		this.shifagongzi = shifagongzi;
	}
	
	/**
	 * 获取：实发工资
	 */
	public Integer getShifagongzi() {
		return shifagongzi;
	}
				
	
	/**
	 * 设置：日期
	 */
	 
	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}
	
	/**
	 * 获取：日期
	 */
	public Date getRiqi() {
		return riqi;
	}
			
}
