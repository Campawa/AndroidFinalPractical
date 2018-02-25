package com.example.chelsi.androidfinalpractical;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chelsi on 2/25/2018.
 */

public interface DogsService {

    @GET("api/breed/{breed_name}/images")
    Call<DogModel> getDogBreed(@Path("breed_name") String breedName);
}
