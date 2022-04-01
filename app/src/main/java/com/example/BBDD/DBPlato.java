package com.example.BBDD;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Plato.class}, version = 1, exportSchema = false)
    public abstract class DBPlato extends RoomDatabase {
        public abstract PlatoDAO platoDAO();

        private static volatile DBPlato INSTANCE;

        public static DBPlato getDatabase(final Context context) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DBPlato.class, "restaurante").allowMainThreadQueries().build();

            }
            return INSTANCE;

        }
    }

