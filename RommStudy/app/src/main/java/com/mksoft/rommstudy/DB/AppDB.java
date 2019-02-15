package com.mksoft.rommstudy.DB;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.mksoft.rommstudy.dataType.User;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDB extends RoomDatabase {
    public abstract UserDao userDao();
    private static volatile AppDB INSTANCE;//volatile 메모리에 접근 가능

    static AppDB getDatabase(final Context context){
        if(INSTANCE == null){

            synchronized (AppDB.class){
                //아래의 방법은 콜백을 부르고 원하는 초기에 원하는 행동을 뒤로 넘긴다.addCallback(roomDatabaseCallback) 콜백을 불러서 원하는 행동을
                //에이싱크에서 돌려준다.
                /*
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                           AppDB.class, "testDB").fallbackToDestructiveMigration().addCallback(roomDatabaseCallback).build();
                */
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                           AppDB.class, "test_db").fallbackToDestructiveMigration().build();

            }

        }

        return INSTANCE;
    }
    private  static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new BackgroundDB(INSTANCE).execute();
        }
    };
    private static class BackgroundDB extends AsyncTask<Void, Void, Void>{

        private final UserDao userDao;
        BackgroundDB(AppDB dp){
            userDao = dp.userDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            //처음시작 행동을 뒤로 미룸....
            User user = new User();
            user.userName = "fe";
            user.userMajor = "fe";
            user.age = 11;
            userDao.insertUser(user);
            return null;
        }
    }
}
