package org.example.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.UserFriendDao;
import org.example.domain.User;
import org.example.domain.UserFriend;
import org.example.domain.response.PageBaseResp;
import org.example.domain.dto.UserFriendDTO;
import org.example.domain.request.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author CZF
 * @date 2024/9/14 - 19:36
 */
@Service
@Slf4j
public class UserFriendServiceImpl implements UserFriendService {

    @Resource
    private UserFriendDao userFriendDao;

    /**
     * 原生查询
     *
     * @param pageRequest
     * @return
     */
    @Override
    public PageBaseResp<UserFriendDTO> getUserListAndUserFriendList(PageRequest pageRequest) {
        // 偏移量
        int pageNo = (pageRequest.getPageNo() - 1) * pageRequest.getPageSize();
        List<UserFriendDTO> resultList = userFriendDao.selectUserFriendsWithPagination(pageNo, pageRequest.getPageSize());
        // 获取总记录数
        Long totalRecords = userFriendDao.countListTotal();
        PageBaseResp<UserFriendDTO> response = new PageBaseResp<>();
        response.setPageNo(pageRequest.getPageNo());
        response.setPageSize(pageRequest.getPageSize());
        response.setTotalRecords(totalRecords);
        response.setList(resultList);
        return response;
    }

    /**
     * mybatis-plus查询
     *
     * @param pageRequest
     * @return
     */
    @Override
    public PageBaseResp<UserFriendDTO> selectPageList(PageRequest pageRequest) {
        Page<UserFriendDTO> page = new Page<>(pageRequest.getPageNo(), pageRequest.getPageSize());
        IPage<UserFriendDTO> pageResult = userFriendDao.selectPageList(page);
        PageBaseResp<UserFriendDTO> response = new PageBaseResp<>();
        response.setPageNo(pageRequest.getPageNo());
        response.setPageSize(pageRequest.getPageSize());
        response.setTotalRecords(pageResult.getTotal());
        response.setList(pageResult.getRecords());
        return response;
    }

}
