package com.dao;

import com.entity.NianjiaxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NianjiaxinxiVO;
import com.entity.view.NianjiaxinxiView;


/**
 * 年假信息
 * 
 * @author 
 * @email 
 * @date 2020-12-30 11:01:17
 */
public interface NianjiaxinxiDao extends BaseMapper<NianjiaxinxiEntity> {
	
	List<NianjiaxinxiVO> selectListVO(@Param("ew") Wrapper<NianjiaxinxiEntity> wrapper);
	
	NianjiaxinxiVO selectVO(@Param("ew") Wrapper<NianjiaxinxiEntity> wrapper);
	
	List<NianjiaxinxiView> selectListView(@Param("ew") Wrapper<NianjiaxinxiEntity> wrapper);

	List<NianjiaxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<NianjiaxinxiEntity> wrapper);
	
	NianjiaxinxiView selectView(@Param("ew") Wrapper<NianjiaxinxiEntity> wrapper);
	
}
