package com.example.demoproject;

import com.example.demoproject.models.Comment;
import com.example.demoproject.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts(@Query("_sort") String sort,
                              @Query("_order") String order,
                              @Query("userId") Integer... userIds);

    @GET
    Call<List<Comment>> getComments(@Url String url);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id")int postId);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text);

    //completely replace all the fields, including nulls
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    //update only the containing elements within the post obj
    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
