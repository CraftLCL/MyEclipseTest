package dao;

import entity.Good;

import java.util.List;

/**
 * Created by lcl on 2017/3/5.
 */
public interface GoodDao {
     void addGood(Good good);
     void deleteGood(String id);
     void updateGood(Good good);
     Good findById(String id);
     List<Good> findAll();
}
