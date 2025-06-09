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

import com.entity.NianjiadiaoxiuEntity;
import com.entity.view.NianjiadiaoxiuView;

import com.service.NianjiadiaoxiuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 年假调休
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-30 11:01:17
 */
@RestController
@RequestMapping("/nianjiadiaoxiu")
public class NianjiadiaoxiuController {
    @Autowired
    private NianjiadiaoxiuService nianjiadiaoxiuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NianjiadiaoxiuEntity nianjiadiaoxiu, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			nianjiadiaoxiu.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<NianjiadiaoxiuEntity> ew = new EntityWrapper<NianjiadiaoxiuEntity>();
    	PageUtils page = nianjiadiaoxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nianjiadiaoxiu), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NianjiadiaoxiuEntity nianjiadiaoxiu, HttpServletRequest request){
        EntityWrapper<NianjiadiaoxiuEntity> ew = new EntityWrapper<NianjiadiaoxiuEntity>();
    	PageUtils page = nianjiadiaoxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nianjiadiaoxiu), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NianjiadiaoxiuEntity nianjiadiaoxiu){
       	EntityWrapper<NianjiadiaoxiuEntity> ew = new EntityWrapper<NianjiadiaoxiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nianjiadiaoxiu, "nianjiadiaoxiu")); 
        return R.ok().put("data", nianjiadiaoxiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NianjiadiaoxiuEntity nianjiadiaoxiu){
        EntityWrapper< NianjiadiaoxiuEntity> ew = new EntityWrapper< NianjiadiaoxiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nianjiadiaoxiu, "nianjiadiaoxiu")); 
		NianjiadiaoxiuView nianjiadiaoxiuView =  nianjiadiaoxiuService.selectView(ew);
		return R.ok("查询年假调休成功").put("data", nianjiadiaoxiuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        NianjiadiaoxiuEntity nianjiadiaoxiu = nianjiadiaoxiuService.selectById(id);
        return R.ok().put("data", nianjiadiaoxiu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        NianjiadiaoxiuEntity nianjiadiaoxiu = nianjiadiaoxiuService.selectById(id);
        return R.ok().put("data", nianjiadiaoxiu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NianjiadiaoxiuEntity nianjiadiaoxiu, HttpServletRequest request){
    	nianjiadiaoxiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nianjiadiaoxiu);

        nianjiadiaoxiuService.insert(nianjiadiaoxiu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NianjiadiaoxiuEntity nianjiadiaoxiu, HttpServletRequest request){
    	nianjiadiaoxiu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nianjiadiaoxiu);

        nianjiadiaoxiuService.insert(nianjiadiaoxiu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NianjiadiaoxiuEntity nianjiadiaoxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nianjiadiaoxiu);
        nianjiadiaoxiuService.updateById(nianjiadiaoxiu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nianjiadiaoxiuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<NianjiadiaoxiuEntity> wrapper = new EntityWrapper<NianjiadiaoxiuEntity>();
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

		int count = nianjiadiaoxiuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
