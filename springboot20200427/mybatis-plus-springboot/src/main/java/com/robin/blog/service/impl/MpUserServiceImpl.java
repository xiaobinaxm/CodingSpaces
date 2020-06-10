package com.robin.blog.service.impl;

import com.robin.blog.entity.MpUser;
import com.robin.blog.mapper.MpUserMapper;
import com.robin.blog.service.MpUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 肖斌
 * @since 2020-04-27
 */
@Service
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUser> implements MpUserService {

}
