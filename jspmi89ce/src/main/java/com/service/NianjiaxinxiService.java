package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NianjiaxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NianjiaxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NianjiaxinxiView;


/**
 * 年假信息
 *
 * @author 
 * @email 
 * @date 2020-12-30 11:01:17
 */
public interface NianjiaxinxiService extends IService<NianjiaxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NianjiaxinxiVO> selectListVO(Wrapper<NianjiaxinxiEntity> wrapper);
   	
   	NianjiaxinxiVO selectVO(@Param("ew") Wrapper<NianjiaxinxiEntity> wrapper);
   	
   	List<NianjiaxinxiView> selectListView(Wrapper<NianjiaxinxiEntity> wrapper);
   	
   	NianjiaxinxiView selectView(@Param("ew") Wrapper<NianjiaxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NianjiaxinxiEntity> wrapper);
   	
}

