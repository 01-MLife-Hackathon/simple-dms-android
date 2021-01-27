package simple.dms.myapplication.model.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import simple.dms.myapplication.model.data.Meal;

public interface MealService {
    @GET("{date}")
    Call<Meal> getMeal(
            @Path("date") String date
    );
}
