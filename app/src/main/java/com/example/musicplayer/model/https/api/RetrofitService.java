package com.example.musicplayer.model.https.api;

import com.example.musicplayer.app.Api;
import com.example.musicplayer.entiy.Album;
import com.example.musicplayer.entiy.AlbumSong;
import com.example.musicplayer.entiy.SearchSong;
import com.example.musicplayer.entiy.SingerImg;
import com.example.musicplayer.entiy.SongUrl;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/07/15
 *     desc   :
 * </pre>
 */

public interface RetrofitService {
    @GET("album?")
    Observable<AlbumSong> getAlbumSong(@Query("id")String id);

    /**
     *  搜索歌曲
     */
    @GET(Api.SEARCH)
    Observable<SearchSong> search(@Query("w") String seek, @Query("p")int offset);

    @GET("search?type=album")
    Observable<Album> searchAlbum(@Query("w") String seek, @Query("p")int offset);

    /**
     * 搜索歌词
     * @param seek
     * @return
     */
    @GET(Api.SEARCH)
    Observable<SearchSong> search(@Query("w") String seek);

    /**
     *
     * @param id 歌曲id
     * @return
     */
    @GET("lrc?")
    Observable<String> getLrc(@Query("id") String id);

    @POST("web?csrf_token=&type=100")
    @FormUrlEncoded
    Observable<SingerImg> getSingerImg(@Field("s")String singer);

    /**
     * 得到歌曲的播放地址，变化的只有songmid，即{}所示
     * https://u.y.qq.com/cgi-bin/musicu.fcg?format=json&data=%7B%22req_0%22%3A%7B%22module%22%3A%22vkey.GetVkeyServer%22%2C%22method%22%3A%22CgiGetVkey%22%2C%22param%22%3A%7B%22guid%22%3A%22358840384%22%2C%22       +
     * songmid%22%3A%5B%22{003wFozn3V3Ra0} +
     * %22%5D%2C%22songtype%22%3A%5B0%5D%2C%22uin%22%3A%221443481947%22%2C%22loginflag%22%3A1%2C%22platform%22%3A%2220%22%7D%7D%2C%22comm%22%3A%7B%22uin%22%3A%221443481947%22%2C%22format%22%3A%22json%22%2C%22ct%22%3A24%2C%22cv%22%3A0%7D%7D
      */
    @GET(Api.SONG_URL)
    Observable<SongUrl> getSongUrl(@Query("data") String data);
}
