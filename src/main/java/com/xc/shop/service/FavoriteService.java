package com.xc.shop.service;

import com.xc.shop.bean.Favorite;
import com.xc.shop.dao.FavoriteMapper;
import com.xc.shop.util.TimeUtil;
import com.xc.shop.vo.FavoritePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;


    /**
     * 查询所有收藏夹内容
     * 按时间排序，最新时间在最前
     * @param userId
     * @return
     */
    public List<FavoritePo> selectAllByUser(String userId) {
        List<FavoritePo> list = favoriteMapper.selectByUser(userId);
        return list;
    }

    /**
     * 插入一条收藏商品
     * 先判断是否存在该商品，不存在则插入，存在返回信息
     * @param userId
     * @param goodId
     * @return
     */
    public boolean insertFavorite(String userId, String goodId) {
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setGoodId(goodId);
        Favorite haveFavorite = favoriteMapper.selectByUserAndGood(favorite);
        if(haveFavorite==null){
            TimeUtil timeUtil = new TimeUtil();
            favorite.setTime(timeUtil.toString());
            favoriteMapper.insert(favorite);
            return true;
        }
        return false;
    }

    /**
     * 删除用户勾选的部分商品
     * @param list 封装的为每条收藏夹的id
     */
    public void deleteFavorite(List list) {
        favoriteMapper.deleteFavorite(list);
    }

    public void deleteFavorite(String favoriteId){
        favoriteMapper.deleteByPrimaryKey(favoriteId);
    }
}
