package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.NianjiaxinxiDao;
import com.entity.NianjiaxinxiEntity;
import com.service.NianjiaxinxiService;
import com.entity.vo.NianjiaxinxiVO;
import com.entity.view.NianjiaxinxiView;

@Service("nianjiaxinxiService")
public class NianjiaxinxiServiceImpl extends ServiceImpl<NianjiaxinxiDao, NianjiaxinxiEntity> implements NianjiaxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NianjiaxinxiEntity> page = this.selectPage(
                new Query<NianjiaxinxiEntity>(params).getPage(),
                new EntityWrapper<NianjiaxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NianjiaxinxiEntity> wrapper) {
		  Page<NianjiaxinxiView> page =new Query<NianjiaxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NianjiaxinxiVO> selectListVO(Wrapper<NianjiaxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NianjiaxinxiVO selectVO(Wrapper<NianjiaxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NianjiaxinxiView> selectListView(Wrapper<NianjiaxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NianjiaxinxiView selectView(Wrapper<NianjiaxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
