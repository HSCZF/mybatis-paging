package org.example.domain.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author CZF
 * @date 2024/9/15 - 9:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFriendDTO {

    /**
     * uid
     */
    private Long uid;

    /**
     * 好友uid
     */
    private Long friendUid;

}
