package com.example.cpu0131.tabmaterdesigner.task;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.example.cpu0131.tabmaterdesigner.callbacks.BoxOfficeMoviesLoadedListener;
import com.example.cpu0131.tabmaterdesigner.extras.MovieUtils;
import com.example.cpu0131.tabmaterdesigner.network.VolleySingleton;
import com.example.cpu0131.tabmaterdesigner.pojo.Movie;

import java.util.ArrayList;


/**
 * Created by Windows on 02-03-2015.
 */
public class TaskLoadMoviesBoxOffice extends AsyncTask<Void, Void, ArrayList<Movie>> {
    private BoxOfficeMoviesLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;


    public TaskLoadMoviesBoxOffice(BoxOfficeMoviesLoadedListener myComponent) {

        this.myComponent = myComponent;
        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
    }


    @Override
    protected ArrayList<Movie> doInBackground(Void... params) {

        ArrayList<Movie> listMovies = MovieUtils.loadBoxOfficeMovies(requestQueue);
        return listMovies;
    }

    @Override
    protected void onPostExecute(ArrayList<Movie> listMovies) {
        if (myComponent != null) {
            myComponent.onBoxOfficeMoviesLoaded(listMovies);
        }
    }


}
