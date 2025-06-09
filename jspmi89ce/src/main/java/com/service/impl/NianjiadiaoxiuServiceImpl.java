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


import com.dao.NianjiadiaoxiuDao;
import com.entity.NianjiadiaoxiuEntity;
import com.service.NianjiadiaoxiuService;
import com.entity.vo.NianjiadiaoxiuVO;
import com.entity.view.NianjiadiaoxiuView;

@Service("nianjiadiaoxiuService")
public class NianjiadiaoxiuServiceImpl extends ServiceImpl<NianjiadiaoxiuDao, NianjiadiaoxiuEntity> implements NianjiadiaoxiuService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NianjiadiaoxiuEntity> page = this.selectPage(
                new Query<NianjiadiaoxiuEntity>(params).getPage(),
                new EntityWrapper<NianjiadiaoxiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NianjiadiaoxiuEntity> wrapper) {
		  Page<NianjiadiaoxiuView> page =new Query<NianjiadiaoxiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NianjiadiaoxiuVO> selectListVO(Wrapper<NianjiadiaoxiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NianjiadiaoxiuVO selectVO(Wrapper<NianjiadiaoxiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NianjiadiaoxiuView> selectListView(Wrapper<NianjiadiaoxiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NianjiadiaoxiuView selectView(Wrapper<NianjiadiaoxiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
