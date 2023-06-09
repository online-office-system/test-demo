package cdu.zch.payload;

import lombok.Data;

/**
 * @author Zch
 **/
@Data
public class JoinRequest {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 群名称
     */
    private String groupId;

}
