package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.NianjiaxinxiEntity;
import com.entity.view.NianjiaxinxiView;

import com.service.NianjiaxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 年假信息
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-30 11:01:17
 */
@RestController
@RequestMapping("/nianjiaxinxi")
public class NianjiaxinxiController {
    @Autowired
    private NianjiaxinxiService nianjiaxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NianjiaxinxiEntity nianjiaxinxi, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			nianjiaxinxi.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<NianjiaxinxiEntity> ew = new EntityWrapper<NianjiaxinxiEntity>();
    	PageUtils page = nianjiaxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nianjiaxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NianjiaxinxiEntity nianjiaxinxi, HttpServletRequest request){
        EntityWrapper<NianjiaxinxiEntity> ew = new EntityWrapper<NianjiaxinxiEntity>();
    	PageUtils page = nianjiaxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nianjiaxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NianjiaxinxiEntity nianjiaxinxi){
       	EntityWrapper<NianjiaxinxiEntity> ew = new EntityWrapper<NianjiaxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nianjiaxinxi, "nianjiaxinxi")); 
        return R.ok().put("data", nianjiaxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NianjiaxinxiEntity nianjiaxinxi){
        EntityWrapper< NianjiaxinxiEntity> ew = new EntityWrapper< NianjiaxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nianjiaxinxi, "nianjiaxinxi")); 
		NianjiaxinxiView nianjiaxinxiView =  nianjiaxinxiService.selectView(ew);
		return R.ok("查询年假信息成功").put("data", nianjiaxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        NianjiaxinxiEntity nianjiaxinxi = nianjiaxinxiService.selectById(id);
        return R.ok().put("data", nianjiaxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        NianjiaxinxiEntity nianjiaxinxi = nianjiaxinxiService.selectById(id);
        return R.ok().put("data", nianjiaxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NianjiaxinxiEntity nianjiaxinxi, HttpServletRequest request){
    	nianjiaxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nianjiaxinxi);

        nianjiaxinxiService.insert(nianjiaxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NianjiaxinxiEntity nianjiaxinxi, HttpServletRequest request){
    	nianjiaxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nianjiaxinxi);

        nianjiaxinxiService.insert(nianjiaxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NianjiaxinxiEntity nianjiaxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nianjiaxinxi);
        nianjiaxinxiService.updateById(nianjiaxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nianjiaxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<NianjiaxinxiEntity> wrapper = new EntityWrapper<NianjiaxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			wrapper.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = nianjiaxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
