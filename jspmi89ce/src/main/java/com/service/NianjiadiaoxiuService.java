package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NianjiadiaoxiuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NianjiadiaoxiuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NianjiadiaoxiuView;


/**
 * 年假调休
 *
 * @author 
 * @email 
 * @date 2020-12-30 11:01:17
 */
public interface NianjiadiaoxiuService extends IService<NianjiadiaoxiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NianjiadiaoxiuVO> selectListVO(Wrapper<NianjiadiaoxiuEntity> wrapper);
   	
   	NianjiadiaoxiuVO selectVO(@Param("ew") Wrapper<NianjiadiaoxiuEntity> wrapper);
   	
   	List<NianjiadiaoxiuView> selectListView(Wrapper<NianjiadiaoxiuEntity> wrapper);
   	
   	NianjiadiaoxiuView selectView(@Param("ew") Wrapper<NianjiadiaoxiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NianjiadiaoxiuEntity> wrapper);
   	
}

