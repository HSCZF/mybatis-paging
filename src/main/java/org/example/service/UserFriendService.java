package org.example.service;

import org.example.domain.response.PageBaseResp;
import org.example.domain.dto.UserFriendDTO;
import org.example.domain.request.PageRequest;

/**
 * Description:
 *
 * @author CZF
 * @date 2024/9/14 - 19:35
 */
public interface UserFriendService {
    PageBaseResp<UserFriendDTO> getUserListAndUserFriendList(PageRequest pageRequest);

    PageBaseResp<UserFriendDTO> selectPageList(PageRequest pageRequest);
}
