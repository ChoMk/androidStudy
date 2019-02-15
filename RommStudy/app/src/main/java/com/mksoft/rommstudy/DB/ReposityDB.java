package com.mksoft.rommstudy.DB;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.mksoft.rommstudy.dataType.User;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ReposityDB {
    private UserDao userDao;
    private List<User> users;

    public ReposityDB(Application application){
        AppDB appDB = AppDB.getDatabase(application);
        this.userDao = appDB.userDao();



    }
    public List<User> getUsers(){

        try {
            users = new getAllAsyncTask(userDao).execute().get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void insertUser(User user){
        new insertAsyncTask(userDao).execute(user);
    }
    private static class insertAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDao asyncUserDao;
        insertAsyncTask(UserDao dao){
            asyncUserDao = dao;
        }

        @Override
        protected Void doInBackground(User... users) {
            asyncUserDao.insertUser(users[0]);
            return null;
        }
    }
    private static class getAllAsyncTask extends AsyncTask<Void, Void, List<User>>{
        private UserDao asyncUserDao;

        getAllAsyncTask(UserDao dao){
            asyncUserDao = dao;
        }

        @Override
        protected List<User> doInBackground(Void... voids) {

            return asyncUserDao.getAll();
        }
    }
}
