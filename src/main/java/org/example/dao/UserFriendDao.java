package org.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.domain.User;
import org.example.domain.UserFriend;
import org.example.domain.dto.UserFriendDTO;
import org.example.mapper.UserFriendMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 *
 * @author CZF
 * @date 2024/9/14 - 20:26
 */
@Repository
public class UserFriendDao extends ServiceImpl<UserFriendMapper, UserFriend> {
    public Long countListTotal() {
        return baseMapper.countListTotal();
    }

    public List<UserFriendDTO> selectUserFriendsWithPagination(long pageNo, long pageSize) {
        return baseMapper.selectUserFriendsWithPagination(pageNo, pageSize);
    }

    public IPage<UserFriendDTO> selectPageList(Page<UserFriendDTO> page) {
        return baseMapper.selectPageList(page);
    }
}
