package com.xc.shop.controller;

import com.xc.shop.bean.User;
import com.xc.shop.pojo.FavoritePo;
import com.xc.shop.service.FavoriteService;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private ControllerResult controllerResult;

    /**
     * 查询用户所有收藏的商品
     * @param session
     * @return
     */
    @GetMapping(value = "/selectAllFavorite.do")
    public ControllerResult selectAllByUser(HttpSession session){
        User user = (User) session.getAttribute(SessionKeyValue.USER_KEY);
//        查询数据
        List<FavoritePo> list = favoriteService.selectAllByUser(user.getUserId());

//        判断是否包含数据
        if(list.size()!=0) {
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            controllerResult.setMessage("查询成功！");
            controllerResult.setData(list);
        }
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
        controllerResult.setMessage("没有数据！");
        return controllerResult;
    }

    /**
     * 插入一条收藏夹
     * @param session
     * @param goodId
     * @return
     */
    @PostMapping(value = "/insertFavorite.do")
    public ControllerResult insertFavorite(HttpSession session,
                                           @RequestParam("goodId") String goodId){

        User user = (User) session.getAttribute(SessionKeyValue.USER_KEY);

//        查询所有记录
        List<FavoritePo> list = favoriteService.selectAllByUser(user.getUserId());
        for (FavoritePo favoritePo : list){
            if (favoritePo.getGoodId().equals(goodId)){
                controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
                controllerResult.setMessage("已存在该商品！");
                return controllerResult;
            }
        }

//        插入数据
        favoriteService.insertFavorite(user.getUserId(),goodId);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("收藏成功！");
        return controllerResult;
    }

    /**
     * 删除用户勾选的部分商品
     * @param list 封装的为每条收藏夹的id
     * @return
     */
    @PostMapping(value = "/DeleteFavorite.do")
    public ControllerResult DeleteFavorite(HttpSession session,List list){

        favoriteService.deleteFavorite(list);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("删除成功！");
        return controllerResult;
    }

    @PostMapping(value = "/deleteFavorite.do")
    public ControllerResult DeleteFavorite(HttpSession session,
                                           @RequestParam("favoriteId") String favoriteId){
        favoriteService.deleteFavorite(favoriteId);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("删除成功！");
        return controllerResult;
    }
}
