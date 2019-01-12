package cn.xdlr.tl.controller;


import cn.xdlr.tl.dto.ExhibitionDTO;
import cn.xdlr.tl.service.UserService;
import cn.xdlr.tl.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exhibition")
public class ExhibitionController {
    @Autowired
    private UserService userService;

    // 展厅数据  用户总人数，在展厅人数，在展厅用户列表, 块高
    @RequestMapping("/getData")
    public ExhibitionDTO userInfo(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        if (pageNum < 0 || pageSize < 0) {
            return new ExhibitionDTO(ResultCode.PARAMETER_ERROR, 0, 0, null, null);
        }
        return userService.getExhibitionData(pageNum, pageSize);
    }


}
