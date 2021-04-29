package dayOne;

import java.util.Date;

/**
 * @ClassName ShortAnswer
 * @Description TODO
 * @Author 程方园
 * @CreateDate 2021/2/26 14:01
 */
public class ShortAnswerPeriodical {
    /**
     * 版期主键
     */
    private Integer id;

    /**
     * 简答题id
     */
    private Integer shortAnswerId;


    /**
     * 版期顺序 (在一期内的顺序)
     */
    private Integer periodicalOrder;

    /**
     * 答案
     */
    private String answer;

    /**
     * 版期开始时间
     */
    private Date startTime;
    /**
     * 版期结束时间
     */
    private Date endTime;

}
