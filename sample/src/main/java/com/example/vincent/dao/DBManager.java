package com.example.vincent.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.vincent.bean.DaoMaster;
import com.example.vincent.bean.DaoSession;
import com.example.vincent.bean.User;
import com.example.vincent.bean.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * @name Example
 * @class name：com.example.vincent.dao
 * @class describe
 * @anthor Vincent QQ:1032006226
 * @time 2016/11/8 9:40
 * @change
 * @chang time
 * @class describe
 */
public class DBManager {
    private final static String dbName = "test_db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }
    /**
     * 获得可读的数据库实例
     *
     */
    private SQLiteDatabase getReadableDatabase(){
        if(openHelper==null){
            openHelper=new DaoMaster.DevOpenHelper(context,dbName,null);
        }
        SQLiteDatabase db=openHelper.getReadableDatabase();
        return db;
    }
    /**
     * 获取可写的数据库
     *
     */
    private SQLiteDatabase getWriteableDatebase(){
        if(openHelper==null){
            openHelper=new DaoMaster.DevOpenHelper(context,dbName,null);
        }
        SQLiteDatabase db=openHelper.getWritableDatabase();
        return db;
    }
    /**
     * 插入一条记录
     */
    public void insertUser(User user){
        DaoMaster daoMaster=new DaoMaster(getWriteableDatebase());
        DaoSession daoSession=daoMaster.newSession();
        UserDao userDao=daoSession.getUserDao();
        userDao.insert(user);
    }
    /**
     * 插入用户集合
     */
    public void insertUserList(List<User> users){
        if(users==null||users.isEmpty()){
            return;
        }
        DaoMaster daoMaster=new DaoMaster(getWriteableDatebase());
        DaoSession daoSession=daoMaster.newSession();
        UserDao userDao=daoSession.getUserDao();
        userDao.insertInTx(users);
    }
    /**
     * 删除一条记录
     */
    public void deleteUser(User user){
        DaoMaster daoMaster=new DaoMaster(getWriteableDatebase());
        DaoSession daoSession=daoMaster.newSession();
        UserDao userDao=daoSession.getUserDao();
        userDao.delete(user);
    }
    /**
     * 更新一条记录
     */
    public void updateUser(User user){
        DaoMaster daoMaster=new DaoMaster(getWriteableDatebase());
        DaoSession daoSession=daoMaster.newSession();
        UserDao userDao=daoSession.getUserDao();
        userDao.update(user);
    }
    /**
     * 查询用户列表
     */
    public List<User> queryUserList() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        List<User> list = qb.list();
        return list;
    }

    /**
     * 查询用户列表
     */
    public List<User> queryUserList(int age) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        qb.where(UserDao.Properties.Age.gt(age)).orderAsc(UserDao.Properties.Age);
        List<User> list = qb.list();
        return list;
    }
}
