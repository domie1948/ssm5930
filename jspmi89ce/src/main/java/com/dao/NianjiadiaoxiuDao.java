package com.dao;

import com.entity.NianjiadiaoxiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NianjiadiaoxiuVO;
import com.entity.view.NianjiadiaoxiuView;


/**
 * 年假调休
 * 
 * @author 
 * @email 
 * @date 2020-12-30 11:01:17
 */
public interface NianjiadiaoxiuDao extends BaseMapper<NianjiadiaoxiuEntity> {
	
	List<NianjiadiaoxiuVO> selectListVO(@Param("ew") Wrapper<NianjiadiaoxiuEntity> wrapper);
	
	NianjiadiaoxiuVO selectVO(@Param("ew") Wrapper<NianjiadiaoxiuEntity> wrapper);
	
	List<NianjiadiaoxiuView> selectListView(@Param("ew") Wrapper<NianjiadiaoxiuEntity> wrapper);

	List<NianjiadiaoxiuView> selectListView(Pagination page,@Param("ew") Wrapper<NianjiadiaoxiuEntity> wrapper);
	
	NianjiadiaoxiuView selectView(@Param("ew") Wrapper<NianjiadiaoxiuEntity> wrapper);
	
}
