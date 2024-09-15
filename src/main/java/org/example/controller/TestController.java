package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.response.PageBaseResp;
import org.example.domain.UserFriend;
import org.example.domain.dto.UserFriendDTO;
import org.example.domain.request.PageRequest;
import org.example.mapper.UserFriendMapper;
import org.example.service.UserFriendService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Description:
 *
 * @author CZF
 * @date 2024/9/14 - 19:32
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private UserFriendMapper userFriendMapper;

    @Resource
    private UserFriendService userFriendService;

    /**
     * 单表翻页
     *
     * @param pageRequest
     * @return Page
     */
    @PostMapping("/userPage")
    @SuppressWarnings("unchecked")
    public Page<UserFriend> testUserPage(@Valid @RequestBody PageRequest pageRequest) {

        QueryWrapper<UserFriend> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "uid", "friend_uid", "delete_status", "create_time", "update_time").orderByAsc("id");
        Page<UserFriend> page = new Page<>(pageRequest.getPageNo(), pageRequest.getPageSize());
        return userFriendMapper.selectPage(page, queryWrapper);
    }

    /**
     * 多表联合查询 1
     * 原生查询
     *
     * @return Page
     */
    @PostMapping("/userPage1")
    public PageBaseResp<UserFriendDTO> testUserPage1(@RequestBody PageRequest pageRequest) {
        return userFriendService.getUserListAndUserFriendList(pageRequest);
    }

    /**
     * 多表联合查询 2
     * mybatis-plus 分页
     *
     * @return Page
     */
    @PostMapping("/userPage2")
    public PageBaseResp<UserFriendDTO> testUserPage2(@RequestBody PageRequest pageRequest) {
        return userFriendService.selectPageList(pageRequest);
    }


}
