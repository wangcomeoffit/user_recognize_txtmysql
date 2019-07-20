package user_recognize_txt;

import com.google.gson.Gson;
//import com.mongodb.MongoCredential;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import org.bson.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Iterator;

import static com.mongodb.client.model.Aggregates.limit;

public class Mongo {

//    public static String myURL="jdbc:mysql://localhost:3306/temp?useUnicode=true&amp;characterEncoding=utf-8?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";


    public static String URL = "jdbc:mysql://192.168.0.2:3306/work?useSSL=false";
    public static String USER = "root";
    public static String PASSWORD = "123";


    public static void main(String[] args) throws Exception{
        // Creating a Mongo client
        MongoCredential credential;
        credential = MongoCredential.createScramSha1Credential("root", "app_mongodb", "2014%".toCharArray());
        MongoClient mongo = new MongoClient(new ServerAddress("172.16.0.22" , 27017), Arrays.asList(credential));
        //MongoClient mongogit = new MongoClient( "172.16.13.22" , 27017 );

        // Creating Credentials
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("app_mongodb");
        System.out.println("Credentials ::"+ credential);
        //MongoDatabase databasegit = mongogit.getDatabase("app_mongodb");
        // Retieving a collection
        MongoCollection<Document> collection = database.getCollection("user_recognize_result");
        System.out.println("Collection user_recognize_result selected successfully");

        // Getting the iterable object
        Document query2 = new Document("_id", new Document("$gt", "ObjectId(\"5c1e5f800000000000000000\")"));
        //5c1e5f800000000000000000
        FindIterable<Document> iterDoc = collection.find().limit(46000000).skip(36478793);
        //.skip(2631961)之前的//结束14643966{51122759}
        //FindIterable<Document> iterDoc = collection.find().limit(2).skip(20000000);
        //find({"upd_time":{$gt:1545494400}})
        //FindIterable<Document> iterDoc = collection.find().limit(1).skip(2); //limit(140045).skip(866366)
        int i = 1;
        // Getting the iterator
        Iterator it = iterDoc.iterator();
        MongoCursor<Document> mongoCursor = iterDoc.iterator();
        //while (it.hasNext()) {

        File file = new File("D:\\recognize_restult-laxin1000wan.txt");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"gbk"));
        //追加
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true),"gbk"));
        String header = "ObjectId"+"\t"+"User_id"+"\t"+"bookNumber"+"\t"+"updtime"+"\t";
        //String sumhead=header+head_resu;



        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn= DriverManager.getConnection(URL, USER, PASSWORD);
        Statement st = conn.createStatement();
        String insertSql;
        while (mongoCursor.hasNext()) {
            //User user = mongoCursor.next();
            //System.out.println(mongoCursor.next().toJson());
            //System.out.println("string::"+mongoCursor.next().toString());
            String gStr = mongoCursor.next().toJson();
            if ((!gStr.contains("{ \"$numberLong\" : \"0\" }")) && (!gStr.contains("!doctype html><html lang"))
                    &&(!gStr.contains("\"user_id\" : null,"))&&(gStr.contains("\"user_id\""))){



            System.out.println(i+"---json::"+gStr);
            //bw.write("json::"+gStr+"\r\n");
            Gson gson = new Gson();
            Recognize recognize = gson.fromJson(gStr, Recognize.class);

            /*//正则
            String Str =gStr.replaceAll(":","=").replaceAll("\\\\","").replaceAll("\\[","{")
                    .replaceAll("\\]","}")+"\r\n";

            String oid = Str.substring(21,47);
            //System.out.println("oid**"+oid);
            //去掉objectId和time
            String Str1 = Str.substring(50,Str.length()-49).replaceAll("\\{\"key\"=\"","").
                    replaceFirst("\"}","").replaceFirst(" \"\\{","{").replaceFirst("\\}\"","}");
            String time = Str.substring(Str.length()-43,Str.length()-1);
            String time1 =time.substring(time.length()-16,time.length()-6);
            //String time2 = "\"time1\"";
            //System.out.println(time1);
            DateTest dateTest1 = new DateTest();
            String utime = dateTest1.getTimestampDate(time1);
            //System.out.println("utime"+utime);
            String strresult = "["+oid+"] = {"+Str1+"upd_time = \""+utime+"\"},\r\n";
            System.out.println(strresult);
            bw.write(strresult);
*/

            //ObjectId Format

                String ObjectId = recognize.get_id().values().toString().replace("[", "").replace("]", "");
                //System.out.println("ObjectId:"+ObjectId);
                String upd_time = recognize.getUpd_time().values().toString().replace("[", "").replace("]", "");
                String bookNumber = recognize.getContent().replace("{\"key\":", "").
                        replace("}", "").replace("\"", "");
                //1545235200
                DateTest dateTest = new DateTest();
                String uptime = dateTest.getTimestampDate(upd_time);

                //map类型的uid
                String uid =recognize.getUser_id().values().toString().replace("[", "").replace("]", "");
                System.out.println("uid:"+uid);

                String s = ObjectId + "\t" + recognize.getUser_id() + "\t" + bookNumber + "\t" + uptime + "\t";



                //判断是否是拉新
          /*  int index = Arrays.binarySearch(laxin,recognize.getUser_id());
            boolean flag = Arrays.asList(laxin).contains(recognize.getUser_id());*/
            //System.out.println("index:"+index); && (result.getConf()>0) && (result.getConf()>0)
            //System.out.println("外recognize.getResult()"+recognize.getResult());

            if(recognize.getUser_id()!=null) {
//                System.out.println("长度"+recognize.getUser_id().length());
//                System.out.println(recognize.getUser_id());
                if ((bookNumber.length() > 3) && recognize.getResult().toString().length() > 80 ) {
                    String strresutlt = recognize.getResult();
                    //System.out.println("内recognize.getResult()"+recognize.getResult());
                    Gson gson_result = new Gson();
                    Result result = gson_result.fromJson(strresutlt, Result.class);

                    //System.out.println("内recognize.getResult()"+recognize.getResult());
                    String head_resu = "conf" + "\t" + "score" + "\t" + "wpm" + "\t" + "wpmf" + "\t" + "cwpm" + "\t" + "cwpmf" + "\t" + "pps" + "\t" + "rhytm" + "\t"
                            + "fluency" + "\t" + "compl" + "\t" + "compl_ph" + "\t" + "acc" + "\t" + "misp" + "\t" + "misr" + "\t" + "mism" + "\t" + "skipped"
                            + "\t" + "words_read" + "\t" + "words_correct" + "\t" + "nativ" + "\t" + "audio_duration" + "\t";

                    String resu = result.getConf() + "\t" + result.getScore() + "\t" + result.getWpm() + "\t" + result.getWpmf()
                            + "\t" + result.getCwpm() + "\t" + result.getCwpmf() + "\t" + result.getPps() + "\t" + result.getRhytm()
                            + "\t" + result.getFluency() + "\t" + result.getCompl() + "\t" + result.getCompl_ph() + "\t" + result.getAcc()
                            + "\t" + result.getMisp() + "\t" + result.getMisr() + "\t" + result.getMism() + "\t" + result.getSkipped()
                            + "\t" + result.getWords_read() + "\t" + result.getWords_correct() + "\t" + result.getNativ() + "\t" + result.getAudio_duration() + "\t";

                    String head_audio = "volume" + "\t" + "snr" + "\t" + "clipped" + "\t" + "rms" + "\t" + "trunc" + "\r\n";

                    String head_sum = header + head_resu + head_audio;
                    //bw.write(head_sum);

                    String saudio = result.getAudio().getVolume() + "\t" + result.getAudio().getSnr() + "\t" + result.getAudio().getClipped() + "\t" +
                            result.getAudio().getRms() + "\t" + result.getAudio().getTrunc() + "\r\n";

                    //System.out.println(s + resu + saudio);
                    //bw.write(s + resu + saudio);

                    insertSql = String.format("insert into recognize2018last (ObjectId,User_id,bookNumber,updtime,conf,score,wpm,wpmf,cwpm,cwpmf,pps," +
                            "rhytm,fluency,compl,compl_ph,acc,misp,misr,mism,skipped,words_read,words_correct,nativ,audio_duration,volume,snr," +
                            "clipped,rms,trunc) " +
                            "values('%s',%d,'%s',%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
                            //recognize.getUser_id()
                            ,ObjectId,Integer.parseInt(uid), bookNumber, uptime,result.getConf(),result.getScore(),result.getWpm(),result.getWpmf()
                                    ,result.getCwpm(),result.getCwpmf(), result.getPps(),result.getRhytm(), result.getFluency() , result.getCompl(), result.getCompl_ph(),result.getAcc()
                                    , result.getMisp(), result.getMisr() , result.getMism() , result.getSkipped(),result.getWords_read() , result.getWords_correct() , result.getNativ() ,
                            result.getAudio_duration(),result.getAudio().getVolume(),result.getAudio().getSnr(),result.getAudio().getClipped(), result.getAudio().getRms(), result.getAudio().getTrunc());

                    st.executeUpdate(insertSql);


                }
                System.out.println(ObjectId+"插入完成");

            }
            }

           /* //解析拼接
            if (bookNumber.length() > 3) {
                System.out.println(recognize.getResult().length());
                if (recognize.getResult().length() > 80 && recognize.getResult() != "false") {
                    System.out.println("4454"+recognize.getResult().contains("false")+"****");
                    String s1 = "[" + ObjectId + "]={" + "time=\"" + uptime + "\"," + "bookNumber=" + bookNumber + ",result={cont="
                            + result.getConf() + ",score=" + result.getScore()
                            + ",wpm=" + result.getWpm() + ",wpmf=" + result.getWpmf()
                            + ",cwpm=" + result.getCwpm() + ",cwpmf=" + result.getCwpmf()
                            + ",pps=" + result.getPps() + ",rhytm=" + result.getRhytm()
                            + ",fluency=" + result.getFluency() + ",compl=" + result.getCompl()
                            + ",compl_ph=" + result.getCompl_ph() + ",acc=" + result.getAcc()
                            + ",misp=" + result.getMisp() + ",misr=" + result.getMisr()
                            + ",mism=" + result.getMism() + ",skipped=" + result.getSkipped()
                            + ",words_read=" + result.getWords_read() + ",words_correct=" + result.getWords_correct()
                            + ",nativ=" + result.getNativ() + ",audio_duration=" + result.getAudio_duration() + ",words={";
                    String sresult = "";
                    //System.out.println("****"+s1);
                    int m;
                    for (m = 0; m < result.getWords().toArray().length; m++) {
                        String s2 = "";
                        s2 = "{id=" + result.getWords().get(m).getId()
                                + ",text=" + "\"" + result.getWords().get(m).getText() + "\""
                                + ",score=" + result.getWords().get(m).getScore()
                                + ",post=" + result.getWords().get(m).getPost()
                                + ",conf=" + result.getWords().get(m).getConf()
                                + ",word_start=" + result.getWords().get(m).getWord_start()
                                + ",word_end=" + result.getWords().get(m).getWord_end()
                                + ",duration=" + result.getWords().get(m).getDuration()
                                + ",state=" + result.getWords().get(m).getState() + ",phon={";
                        //System.out.println("***结果***："+s2);
                        //System.out.println("***结果***："+result.getWords().get(m).getPhon().toArray().length);
                        String sphon = "";
                        if ((result.getWords().get(m).getPhon()) != null) {
                            //String phon="";

                            for (int n = 0; n < result.getWords().get(m).getPhon().toArray().length; n++) {
                                String s3;
                                s3 = "{gr=\"" + result.getWords().get(m).getPhon().get(n).getGr() + "\""
                                        + ",ph=\"" + result.getWords().get(m).getPhon().get(n).getPh() + "\""
                                        + ",s=" + result.getWords().get(m).getPhon().get(n).getS()
                                        + ",l=" + result.getWords().get(m).getPhon().get(n).getL()
                                        + ",t=\"" + result.getWords().get(m).getPhon().get(n).getT() + "\""
                                        + ",f=" + result.getWords().get(m).getPhon().get(n).getF() + "}";
                                //System.out.println(s3);
                                if (n == result.getWords().get(m).getPhon().toArray().length - 1) {
                                    //System.out.println("n="+n);
                                    sphon = sphon + s3 + "}}";
                                    //System.out.println("最后一次"+sphon);
                                } else {
                                    sphon = sphon + s3 + ",";
                                }
                                //System.out.println("倒数第二次"+sphon);
                            }
                            //System.out.println(sphon);

                        }
                        if (m == result.getWords().toArray().length - 1) {
                            sresult = sresult + s2 + sphon + "}";
                        } else {
                            sresult = sresult + s2 + sphon + ",";
                        }

                    }//sresult解析完成


                    String s_audio = "";
                    s_audio = ",audio={volume=" + result.getAudio().getVolume()
                            + ",snr=" + result.getAudio().getSnr()
                            + ",clipped=" + result.getAudio().getClipped()
                            + ",rms=" + result.getAudio().getRms()
                            + ",trunc=" + result.getAudio().getTrunc() + "}}";
                    //System.out.println("输出");

                    //System.out.println("s_audio"+s_audio);

                    //System.out.println(s1+sresult);
                    sout = s1 + sresult + s_audio + "},\r\n";
                    System.out.println(sout);
                   //bw.write(sout);
                    System.out.println(i + "写入完成");
                    i++;
                }
            }*/
            //System.out.println(i + "写入完成");
            //bw.write(s);
            i++;

        }
        bw.close();

    }
}
