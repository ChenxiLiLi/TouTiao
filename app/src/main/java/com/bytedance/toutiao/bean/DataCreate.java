package com.bytedance.toutiao.bean;

import com.bytedance.toutiao.R;

import java.util.ArrayList;
import java.util.List;

public class DataCreate {
    public static List<VideoModel> getVideoList(){
        List<VideoModel> videoModels = new ArrayList<>();
        {
            VideoModel videoModel1 = new VideoModel();
            VideoModel videoModel2 = new VideoModel();
            VideoModel videoModel3 = new VideoModel();

            videoModel1.setVideoId("1");
            videoModel1.setAuthorName("@四川观察");
            videoModel1.setImgId(R.mipmap.local_pic1);
            videoModel1.setVideoUrl("local_video1.mp4");
            videoModel1.setEventName("四川富顺灭门案");
            videoModel1.setTitle("四川富顺灭门案告破");
            videoModel1.setContent("四川富顺灭门案告破！");
            videoModel1.setCommentNum("233");
            videoModel1.setLoveNum("1.7w");

            videoModel2.setVideoId("2");
            videoModel2.setAuthorName("@北京警方");
            videoModel2.setImgId(R.mipmap.local_pic2);
            videoModel2.setVideoUrl("local_video2.mp4");
            videoModel2.setTitle("玛莎拉蒂撞人案新进展！");
            videoModel2.setEventName("玛莎拉蒂撞人案");
            videoModel2.setContent("玛莎拉蒂撞人案有了新进展， 被害人坚持以命偿命 ！");
            videoModel2.setCommentNum("2333");
            videoModel2.setLoveNum("7.7w");

            videoModel3.setVideoId("3");
            videoModel3.setAuthorName("@新疆媒体");
            videoModel3.setImgId(R.mipmap.local_pic3);
            videoModel3.setTitle("南昌杀妻抛尸案判决");
            videoModel3.setEventName("南昌杀妻抛尸案");
            videoModel3.setVideoUrl("local_video3.mp4");
            videoModel3.setContent("南昌杀妻抛尸案判决 ！ 凶手被判死刑！");
            videoModel3.setCommentNum("233");
            videoModel3.setLoveNum("1.7w");

            videoModels.add(videoModel1);
            videoModels.add(videoModel2);
            videoModels.add(videoModel3);
            videoModels.add(videoModel1);
        }
        return videoModels;
    }

    public static VideoModel getVideoById(String id){
        VideoModel videoModel1 = new VideoModel();
        VideoModel videoModel2 = new VideoModel();
        VideoModel videoModel3 = new VideoModel();

        videoModel1.setVideoId("1");
        videoModel1.setAuthorName("@四川观察");
        videoModel1.setImgId(R.mipmap.local_pic1);
        videoModel1.setVideoUrl("local_video1.mp4");
        videoModel1.setEventName("四川富顺灭门案");
        videoModel1.setTitle("四川富顺灭门案告破");
        videoModel1.setContent("四川富顺灭门案告破！");
        videoModel1.setCommentNum("233");
        videoModel1.setLoveNum("1.7w");

        videoModel2.setVideoId("2");
        videoModel2.setAuthorName("@北京警方");
        videoModel2.setImgId(R.mipmap.local_pic2);
        videoModel2.setVideoUrl("local_video2.mp4");
        videoModel2.setTitle("玛莎拉蒂撞人案新进展！");
        videoModel2.setEventName("玛莎拉蒂撞人案");
        videoModel2.setContent("玛莎拉蒂撞人案有了新进展， 被害人坚持以命偿命 ！");
        videoModel2.setCommentNum("2333");
        videoModel2.setLoveNum("7.7w");

        videoModel3.setVideoId("3");
        videoModel3.setAuthorName("@新疆媒体");
        videoModel3.setImgId(R.mipmap.local_pic3);
        videoModel3.setTitle("南昌杀妻抛尸案判决");
        videoModel3.setEventName("南昌杀妻抛尸案");
        videoModel3.setVideoUrl("local_video3.mp4");
        videoModel3.setContent("南昌杀妻抛尸案判决 ！ 凶手被判死刑！");
        videoModel3.setCommentNum("233");
        videoModel3.setLoveNum("1.7w");

        if("1".equals(id)) return videoModel1;
        else if("2".equals(id)) return videoModel2;
        else return videoModel3;
    }

}
