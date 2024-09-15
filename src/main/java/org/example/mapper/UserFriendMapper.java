package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.domain.UserFriend;
import org.example.domain.dto.UserFriendDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Description:
 *
 * @author CZF
 * @date 2024/9/14 - 19:21
 */
public interface UserFriendMapper extends BaseMapper<UserFriend> {

    /**
     * 原生，带参数
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<UserFriendDTO> selectUserFriendsWithPagination(@Param("pageNo") long pageNo, @Param("pageSize") long pageSize);

    /**
     * 计数
     *
     * @return
     */
    Long countListTotal();

    /**
     * mybatis-plus 分页，前面传了page对象，包含pageNo和pageSize，UserFriendMapper.xml就不需要写 limit 和 offset了
     *
     * @param page
     * @return
     */
    IPage<UserFriendDTO> selectPageList(@RequestParam IPage<UserFriendDTO> page);
}
