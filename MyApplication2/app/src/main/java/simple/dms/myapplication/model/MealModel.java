package simple.dms.myapplication.model;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import simple.dms.myapplication.model.callback.LoadMealListener;
import simple.dms.myapplication.model.data.Meal;
import simple.dms.myapplication.model.data.MealData;
import simple.dms.myapplication.model.service.MealService;

public class MealModel {

    private final MealService mealService;

    public MealModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.dsm-dms.com/meal/")
                .build();
        mealService = retrofit.create(MealService.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void getMeal(LoadMealListener loadMealListener) {
        Call<Meal> call = mealService.getMeal("2021-01-10");
        call.enqueue(new Callback<Meal>() {
            @Override
            public void onResponse(Call<Meal> call, Response<Meal> response) {
                if(response.isSuccessful()) {
                    loadMealListener.loadMeal(response.body());
                }
            }

            @Override
            public void onFailure(Call<Meal> call, Throwable t) {

            }
        });
    }
}
