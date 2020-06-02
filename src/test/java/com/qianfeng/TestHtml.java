package com.qianfeng;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestHtml {
    public static String readHtml(String path) {
        StringBuffer buff = new StringBuffer();
        // 建立一个对象，它把文件内容转成计算机能读懂的语言
        try (FileReader reader = new FileReader(path); BufferedReader br = new BufferedReader(reader)) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                buff.append(line);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buff.toString();
    }

    public static void main(String[] args) {
        try {
            // 本地html存放路径
//            String file_path = "D:\\\\User\\\\UserShellFolder\\\\Documents\\\\WeChat Files\\\\wangxiaoxia6060\\\\FileStorage\\\\File\\\\2020-05\\test.html";
//            // 读取html获取文档
//            String html = readHtml(file_path);
            String html = "<p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590548897147_91.jpg?r=0.8092590990406456\" width=\"100%\" height=\"auto\"/></p><p><span style=\"color: rgb(51, 51, 51); font-family: Arial, 宋体; background-color: rgb(255, 255, 255);\">5月26日下午，习近平出席十三届全国人大三次会议解放军和武警部队代表团全体会议。这是他今年两会第四次“下团组”。2013年以来，习近平每年的“下团组”活动都是以这个代表团“压轴”。习近平为这支刚刚在战“疫”大考中交出圆满答卷的英雄军队“点赞”，并为国防和军队建设工作“划重点”。</span></p><p><span style=\"color: rgb(51, 51, 51); font-family: Arial, 宋体; background-color: rgb(255, 255, 255);\"></span></p><p id=\"guidVideoCode\" style=\"text-align:center;\"><video src=\"http://vod.cctv.cn/cms/2020-05-27/CCTV2_850k_582c6684f16546f887c2de8f7bbd9f9a-1590547102480_15-001.mp4\" controls=\"controls\" class=\"videoplay http://vod.cctv.cn/cms/2020-05-27/CCTV2_450k_582c6684f16546f887c2de8f7bbd9f9a-1590547102480_15-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_850k_582c6684f16546f887c2de8f7bbd9f9a-1590547102480_15-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_2m_582c6684f16546f887c2de8f7bbd9f9a-1590547102480_15-001.mp4\" poster=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590547180214_278_300x223.png\">http://vod.cctv.cn/cms/2020-05-27/CCTV2_450k_582c6684f16546f887c2de8f7bbd9f9a-1590547102480_15-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_850k_582c6684f16546f887c2de8f7bbd9f9a-1590547102480_15-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_2m_582c6684f16546f887c2de8f7bbd9f9a-1590547102480_15-001.mp4</video></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(127, 127, 127); font-size: 14px;\">△联播视频：习近平出席解放军和武警部队代表团全体会议</span><br></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255); text-align: center;\"><strong><span style=\"background-color: rgb(192, 0, 0); color: rgb(255, 255, 255);\">&nbsp;8位代表发言，关注这些议题&nbsp;</span></strong></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">解放军和武警部队代表团共有289名全国人大代表，是人数最多的团组。当天，共有8位代表发言。《时政新闻眼》发现，除2017年安排9人发言外，其他年份也都是8位代表发言。</p><p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590549031092_312_1080x1642.jpg\" width=\"100%\" height=\"auto\"/></p><p style=\"text-align: left;\"><span style=\"color: rgb(51, 51, 51); font-family: Arial, 宋体; background-color: rgb(255, 255, 255);\">8位发言代表中，黎火辉、崔玉玲、王辉青三位代表是第二次在这个场合发言。2018年习主席下团时，军委训练管理部部长黎火辉、军委战略规划办公室主任王辉青分别就开展新时代大练兵活动、加快推进军民融合深度发展提出意见和建议。今年，这两位代表分别围绕提高疫情防控常态化条件下军事训练实战化水平、推进“十三五”规划落实和做好“十四五”规划编制作了发言。</span></p><p><span style=\"color: rgb(51, 51, 51); font-family: Arial, 宋体; background-color: rgb(255, 255, 255);\"></span></p><p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590549020883_261.jpg?r=0.000807804871786777\" width=\"100%\" height=\"auto\"/></p><p><span style=\"color: rgb(127, 127, 127); font-family: Arial, 宋体; font-size: 14px; background-color: rgb(255, 255, 255);\">△这是黎火辉代表在发言。（摄影：李刚）</span></p><p><span style=\"color: rgb(127, 127, 127); font-family: Arial, 宋体; font-size: 14px; background-color: rgb(255, 255, 255);\"></span></p><p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590549138771_899.jpg?r=0.31233302110814165\" width=\"100%\" height=\"auto\"/></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(127, 127, 127); font-size: 14px;\">△这是王辉青代表在发言。（摄影：李刚）</span></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255); text-align: center;\"><strong><span style=\"background-color: rgb(192, 0, 0); color: rgb(255, 255, 255); font-size: 18px;\">&nbsp;习主席为英雄军队“点赞”</span></strong></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">在三年前的庆祝中国人民解放军建军90周年大会上，习近平以“英雄的人民军队”称呼这支诞生九十载的军队。疫情暴发后，人民军队闻令而动，在疫情防控斗争中作出突出贡献。4月中旬，习近平曾签署通令、予以嘉奖。在26日的会议现场，习近平说，实践再次证明，人民军队始终是党和人民完全可以信赖的英雄军队。</p><p id=\"guidVideoCode\" style=\"text-align:center;\"><video src=\"http://vod.cctv.cn/cms/2020-05-27/CCTV2_850k_377f525d1c4e40f89b929c1bad32548b-1590548333895_155-001.mp4\" controls=\"controls\" class=\"videoplay http://vod.cctv.cn/cms/2020-05-27/CCTV2_450k_377f525d1c4e40f89b929c1bad32548b-1590548333895_155-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_850k_377f525d1c4e40f89b929c1bad32548b-1590548333895_155-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_2m_377f525d1c4e40f89b929c1bad32548b-1590548333895_155-001.mp4\" poster=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590548374546_51_224x165.png\">http://vod.cctv.cn/cms/2020-05-27/CCTV2_450k_377f525d1c4e40f89b929c1bad32548b-1590548333895_155-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_850k_377f525d1c4e40f89b929c1bad32548b-1590548333895_155-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_2m_377f525d1c4e40f89b929c1bad32548b-1590548333895_155-001.mp4</video></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(127, 127, 127); font-size: 14px;\">△独家视频丨习主席为英雄军队“点赞”</span></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">征袍未洗，战鼓已催。习近平在会上用“<span style=\"color: rgb(0, 32, 96);\"><strong>两个深刻影响</strong></span>”分析了当前形势：这场疫情对世界格局产生了深刻影响，对我国安全和发展也产生了深刻影响。他要求在疫情防控常态化前提下扎实推进军队各项工作，做到“<strong><span style=\"color: rgb(0, 32, 96);\">两个坚决</span></strong>”：坚决实现国防和军队建设2020年目标任务，坚决完成党和人民赋予的各项任务。</p><p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590550630112_974.jpg?r=0.47854395703905905\" width=\"100%\" height=\"auto\"/></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(127, 127, 127); font-size: 14px;\">△这是十三届全国人大三次会议开幕会前，军队人大代表走向会场。（摄影：冯凯旋）</span><br></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255); text-align: center;\"><strong><span style=\"background-color: rgb(192, 0, 0); color: rgb(255, 255, 255);\">&nbsp;国防和军队建设重点要做好四篇文章&nbsp;</span></strong></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">在当天的会议上，习近平结合做好疫情防控工作，就国防和军队建设重点工作提出要求，强调做好四篇文章。</p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><strong><span style=\"color: rgb(0, 32, 96);\">第一篇文章：练兵备战</span></strong></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">人民军队永远是战斗队，人民军队的生命力在于战斗力。在党的十九大报告中，习近平郑重强调：“军队是要准备打仗的，一切工作都必须坚持战斗力标准，向能打仗、打胜仗聚焦。”在26日的全体会议上，他要求坚持底线思维，全面加强练兵备战工作。</p><p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590550654019_58.jpg?r=0.11105542344604191\" width=\"100%\" height=\"auto\"/></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(127, 127, 127); font-size: 14px;\">△十三届全国人大三次会议开幕会上，代表们热烈鼓掌欢迎总书记。（摄影：冯凯旋）</span><br></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">疫情不可避免会给练兵备战带来影响。习近平为此提出，要探索疫情防控常态化条件下练兵备战方式方法，因时因势搞好科学调控，加紧推进军事斗争准备，灵活开展实战化军事训练，全面提高我军遂行军事任务能力。</p><p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590550674939_125.jpg?r=0.936481487452798\" width=\"100%\" height=\"auto\"/></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(127, 127, 127); font-size: 14px;\">△400米障碍训练中的飞跃矮墙。</span><br></p><p><span style=\"font-family: 宋体; background-color: rgb(255, 255, 255); color: rgb(127, 127, 127); font-size: 14px;\"></span><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 12px; background-color: rgb(255, 255, 255);\"></span><span style=\"color: rgb(51, 51, 51); font-family: 宋体; font-size: 12px; background-color: rgb(255, 255, 255);\"></span></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><strong><span style=\"color: rgb(0, 32, 96);\">第二篇文章：改革创新</span></strong></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">2015年11月，中央军委改革工作会议发出深化国防和军队改革的动员令。几年间，国防和军队改革取得了历史性突破，人民军队全面重塑、浴火重生。在26日的全体会议上，习近平说，这场疫情防控斗争对国防和军队改革是一次实际检验。他强调，对疫情防控工作中暴露出的新情况新问题，<strong><span style=\"color: rgb(0, 32, 96);\">要注重用改革创新的思路和办法加以解决</span></strong>。</p><p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590550880224_336.jpg?r=0.3132554047049234\" width=\"100%\" height=\"auto\"/></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(127, 127, 127); font-size: 14px;\">△武警战士在天安门广场执勤。</span><br></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">习近平还指出，要发挥我军医学科研优势，加快新冠肺炎药物和疫苗研发，<span style=\"color: rgb(0, 32, 96);\"><strong>拿出更多硬核产品</strong></span>。这是习近平再谈“硬核产品”。今年3月在军事医学研究院考察时，他就曾指出，最终战胜疫情，关键要靠科技。要通过打这场硬仗，掌握更多具有自主知识产权的核心科技，拿出更多硬核产品。</p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><strong><span style=\"color: rgb(0, 32, 96);\">第三篇文章：规划为先</span></strong></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">去年到解放军和武警部队代表团下团时，习近平谈的主题就是打好我军建设发展“十三五”规划落实攻坚战。今年正是我军建设发展“十三五”规划收官之年。习近平要求，要采取超常措施，克服疫情影响，集中力量打好规划落实攻坚战。</p><p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590550908467_660.jpg?r=0.1180922445219319\" width=\"100%\" height=\"auto\"/></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(127, 127, 127); font-size: 14px;\">△25日，全国人大代表、海军某导弹驱逐舰舰长赵岩泉在“代表通道”上讲述自己在索马里护航的经历。（总台国广记者李晋拍摄）</span><br></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">今年也是继往开来的一年。习近平要求，编制好我军建设“十四五”规划。如何既算好经济账，又算好安全账？习主席叮嘱，要科学安排，精打细算，把军费管理好、使用好，使每一分钱都花出最大效益。</p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><strong><span style=\"color: rgb(0, 32, 96);\">第四篇文章：军政军民团结</span></strong></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">习近平在26日的全体会议上说，军政军民团结是我们党和国家的显著政治优势，这场疫情防控斗争充分彰显了这一点。他对军政、军地双方都提出要求，其中就包括人民军队要支持打赢脱贫攻坚战。当天，解放军和武警部队代表团新闻发言人吴谦在接受媒体采访时说，人民军队共定点帮扶4100个贫困村、92.4万贫困群众，成为脱贫攻坚特殊战场上的一支重要力量。</p><p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590550938571_604.jpg?r=0.38007365638552537\" width=\"100%\" height=\"auto\"/></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(127, 127, 127); font-size: 14px;\">△5月25日，十三届全国人大三次会议第二次全体会议结束后，代表们走出人民大会堂。（总台国广记者李晋拍摄）</span></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">7年多前，正是在这个会场，面对解放军代表团全体代表，习主席庄重宣布：建设一支听党指挥、能打胜仗、作风优良的人民军队，是<span style=\"color: rgb(0, 32, 96);\"><strong>党在新形势下的强军目标</strong></span>。此后6年，年年三月东风回。会场之上，习主席与代表们倾心交流，擘画国防和军队建设的诸多大事。征途如虹，人民军队在中国特色强军之路上迈出坚实步伐。今年，疫情让见面延期，情更殷殷，风雨过后，步履更铿锵。</p><p style=\"text-align: center;\"><img src=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590550963551_196.jpg?r=0.027557787895832853\" width=\"100%\" height=\"auto\"/></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><span style=\"color: rgb(127, 127, 127); font-size: 14px;\">△2019年国庆阅兵仪式上，仪仗方队护卫党旗、国旗、军旗走在徒步方队的最前方。</span><br></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">2017年8月1日，习主席在庆祝中国人民解放军建军90周年大会上引用了革命战争年代人民军队“三个不相信”的英雄宣言：“不相信有完不成的任务，不相信有克服不了的困难，不相信有战胜不了的敌人！”</p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\"><strong><span style=\"color: rgb(0, 32, 96);\">经历战“疫”洗礼，人民军队更无敌。</span></strong></p><p id=\"guidVideoCode\" style=\"text-align:center;\"><video src=\"http://vod.cctv.cn/cms/2020-05-27/CCTV2_850k_d7a972d224b442ada5a4e9743bc9216b-1590548413795_451-001.mp4\" controls=\"controls\" class=\"videoplay http://vod.cctv.cn/cms/2020-05-27/CCTV2_450k_d7a972d224b442ada5a4e9743bc9216b-1590548413795_451-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_850k_d7a972d224b442ada5a4e9743bc9216b-1590548413795_451-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_2m_d7a972d224b442ada5a4e9743bc9216b-1590548413795_451-001.mp4\" poster=\"http://pic.cctv.cn/photoAlbum/page/performance/img/2020/5/27/1590548445657_744_300x167.png\">http://vod.cctv.cn/cms/2020-05-27/CCTV2_450k_d7a972d224b442ada5a4e9743bc9216b-1590548413795_451-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_850k_d7a972d224b442ada5a4e9743bc9216b-1590548413795_451-001.mp4,http://vod.cctv.cn/cms/2020-05-27/CCTV2_2m_d7a972d224b442ada5a4e9743bc9216b-1590548413795_451-001.mp4</video></p><p style=\"margin-bottom: 28px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 1.75em; font-family: Arial, 宋体; color: rgb(51, 51, 51); white-space: normal; background-color: rgb(255, 255, 255);\">\u200B<span style=\"color: rgb(127, 127, 127); font-family: Arial, 宋体; font-size: 14px; background-color: rgb(255, 255, 255);\">△视频日记丨今年两会不平凡（5月26日）</span></p>";
            Document document = Jsoup.parse(html);
            System.out.println("document = " + document.body().text());

//            Elements div = document.select("p\n");// 外层部分区域标签内的数据
//            div.select("video").html("");
//            Elements title = div.select("p");// 真正需要标签内的数据
////            System.out.println("打印最终结果：" + title.text());
//            String str = title.text();
//            if(str.length() <= 200){
//                System.out.println("str = " + str);
//            } else {
//
//            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  System.out.println("args = " + TestHtml.html2Str("D:\\User\\UserShellFolder\\Documents\\WeChat Files\\wangxiaoxia6060\\FileStorage\\File\\2020-05\test.html"));;
    }
}
